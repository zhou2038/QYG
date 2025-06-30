package com.qyg.service.impl;

import com.qyg.common.Result;
import com.qyg.entity.User;
import com.qyg.mapper.UserMapper;
import com.qyg.service.UserService;
import com.qyg.util.JwtUtil;
import com.qyg.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    public Result<Map<String, Object>> register(User user) {
        // 参数校验
        if (!StringUtils.hasText(user.getUsername()) || !StringUtils.hasText(user.getPassword())) {
            return Result.error("用户名和密码不能为空");
        }
        
        // 检查用户名是否已存在
        User existUser = userMapper.selectByUsername(user.getUsername());
        if (existUser != null) {
            return Result.error("用户名已存在");
        }
        
        // 检查手机号是否已存在
        if (StringUtils.hasText(user.getPhone())) {
            existUser = userMapper.selectByPhone(user.getPhone());
            if (existUser != null) {
                return Result.error("手机号已存在");
            }
        }
        
        // 检查邮箱是否已存在
        if (StringUtils.hasText(user.getEmail())) {
            existUser = userMapper.selectByEmail(user.getEmail());
            if (existUser != null) {
                return Result.error("邮箱已存在");
            }
        }
        
        // 加密密码
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        
        // 设置默认值
        user.setUserType(1); // 普通用户
        user.setStatus(1); // 正常状态
        
        // 保存用户
        int result = userMapper.insert(user);
        if (result <= 0) {
            return Result.error("注册失败");
        }
        
        return Result.success("注册成功", null);
    }
    
    @Override
    public Result<Map<String, Object>> login(String username, String password) {
        // 参数校验
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return Result.error("用户名和密码不能为空");
        }
        
        // 查询用户
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return Result.error("用户不存在");
        }
        
        // 校验密码
        if (!PasswordUtil.matches(password, user.getPassword())) {
            return Result.error("密码错误");
        }
        
        // 校验状态
        if (user.getStatus() == 0) {
            return Result.error("账户已被禁用");
        }
        
        // 生成token
        String token = jwtUtil.generateToken(user.getId(), user.getUsername());
        
        // 将token存入Redis，设置过期时间
        redisTemplate.opsForValue().set("token:" + user.getId(), token, 24, TimeUnit.HOURS);
        
        // 返回用户信息和token
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        user.setPassword(null); // 不返回密码
        data.put("user", user);
        
        return Result.success("登录成功", data);
    }
    
    @Override
    public Result<Void> logout(String token) {
        if (StringUtils.hasText(token)) {
            try {
                Long userId = jwtUtil.getUserIdFromToken(token);
                redisTemplate.delete("token:" + userId);
            } catch (Exception e) {
                // token无效，忽略
            }
        }
        return Result.success();
    }
    
    @Override
    public Result<User> getUserInfo(Long userId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            return Result.error("用户不存在");
        }
        user.setPassword(null); // 不返回密码
        return Result.success(user);
    }
    
    @Override
    public Result<Void> updateUserInfo(User user) {
        if (user.getId() == null) {
            return Result.error("用户ID不能为空");
        }
        
        // 检查用户是否存在
        User existUser = userMapper.selectById(user.getId());
        if (existUser == null) {
            return Result.error("用户不存在");
        }
        
        // 不更新敏感字段
        user.setPassword(null);
        user.setUserType(null);
        user.setStatus(null);
        
        int result = userMapper.update(user);
        if (result <= 0) {
            return Result.error("更新失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> changePassword(Long userId, String oldPassword, String newPassword) {
        // 参数校验
        if (!StringUtils.hasText(oldPassword) || !StringUtils.hasText(newPassword)) {
            return Result.error("密码不能为空");
        }
        
        // 查询用户
        User user = userMapper.selectById(userId);
        if (user == null) {
            return Result.error("用户不存在");
        }
        
        // 校验旧密码
        if (!PasswordUtil.matches(oldPassword, user.getPassword())) {
            return Result.error("原密码错误");
        }
        
        // 更新密码
        String encryptedPassword = PasswordUtil.encrypt(newPassword);
        int result = userMapper.updatePassword(userId, encryptedPassword);
        if (result <= 0) {
            return Result.error("修改失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> resetPassword(Long userId) {
        // 查询用户
        User user = userMapper.selectById(userId);
        if (user == null) {
            return Result.error("用户不存在");
        }
        
        // 重置为默认密码
        String defaultPassword = PasswordUtil.encrypt("123456");
        int result = userMapper.updatePassword(userId, defaultPassword);
        if (result <= 0) {
            return Result.error("重置失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Map<String, Object>> getUserList(String keyword, Integer userType, 
                                                  Integer status, Integer page, Integer size) {
        // 分页参数
        if (page == null || page < 1) page = 1;
        if (size == null || size < 1) size = 10;
        int offset = (page - 1) * size;
        
        // 查询数据
        List<User> users = userMapper.selectList(keyword, userType, status, offset, size);
        int total = userMapper.selectCount(keyword, userType, status);
        
        // 清除密码
        users.forEach(user -> user.setPassword(null));
        
        // 返回结果
        Map<String, Object> data = new HashMap<>();
        data.put("list", users);
        data.put("total", total);
        data.put("page", page);
        data.put("size", size);
        
        return Result.success(data);
    }
    
    @Override
    public Result<Void> updateUserStatus(Long userId, Integer status) {
        if (userId == null || status == null) {
            return Result.error("参数不能为空");
        }
        
        int result = userMapper.updateStatus(userId, status);
        if (result <= 0) {
            return Result.error("更新失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> deleteUser(Long userId) {
        if (userId == null) {
            return Result.error("用户ID不能为空");
        }
        
        int result = userMapper.deleteById(userId);
        if (result <= 0) {
            return Result.error("删除失败");
        }
        
        return Result.success();
    }
} 