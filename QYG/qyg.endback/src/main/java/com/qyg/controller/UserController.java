package com.qyg.controller;

import com.qyg.common.Result;
import com.qyg.entity.User;
import com.qyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户Controller
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result<Map<String, Object>> register(@RequestBody User user) {
        return userService.register(user);
    }
    
    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestParam String username, 
                                           @RequestParam String password) {
        return userService.login(username, password);
    }
    
    /**
     * 用户登出
     */
    @PostMapping("/logout")
    public Result<Void> logout(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return userService.logout(token);
    }
    
    /**
     * 获取用户信息
     */
    @GetMapping("/info")
    public Result<User> getUserInfo(@RequestParam Long userId) {
        return userService.getUserInfo(userId);
    }
    
    /**
     * 更新用户信息
     */
    @PutMapping("/info")
    public Result<Void> updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }
    
    /**
     * 修改密码
     */
    @PutMapping("/password")
    public Result<Void> changePassword(@RequestParam Long userId,
                                     @RequestParam String oldPassword,
                                     @RequestParam String newPassword) {
        return userService.changePassword(userId, oldPassword, newPassword);
    }
    
    /**
     * 获取用户列表（管理员）
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getUserList(@RequestParam(required = false) String keyword,
                                                  @RequestParam(required = false) Integer userType,
                                                  @RequestParam(required = false) Integer status,
                                                  @RequestParam(defaultValue = "1") Integer page,
                                                  @RequestParam(defaultValue = "10") Integer size) {
        return userService.getUserList(keyword, userType, status, page, size);
    }
    
    /**
     * 更新用户状态（管理员）
     */
    @PutMapping("/{userId}/status")
    public Result<Void> updateUserStatus(@PathVariable Long userId,
                                       @RequestParam Integer status) {
        return userService.updateUserStatus(userId, status);
    }
    
    /**
     * 重置用户密码（管理员）
     */
    @PutMapping("/{userId}/reset-password")
    public Result<Void> resetPassword(@PathVariable Long userId) {
        return userService.resetPassword(userId);
    }
    
    /**
     * 删除用户（管理员）
     */
    @DeleteMapping("/{userId}")
    public Result<Void> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
} 