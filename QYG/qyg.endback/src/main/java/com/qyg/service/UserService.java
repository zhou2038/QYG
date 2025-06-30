package com.qyg.service;

import com.qyg.entity.User;
import com.qyg.common.Result;

import java.util.Map;

/**
 * 用户Service接口
 */
public interface UserService {
    
    /**
     * 用户注册
     */
    Result<Map<String, Object>> register(User user);
    
    /**
     * 用户登录
     */
    Result<Map<String, Object>> login(String username, String password);
    
    /**
     * 用户登出
     */
    Result<Void> logout(String token);
    
    /**
     * 获取用户信息
     */
    Result<User> getUserInfo(Long userId);
    
    /**
     * 更新用户信息
     */
    Result<Void> updateUserInfo(User user);
    
    /**
     * 修改密码
     */
    Result<Void> changePassword(Long userId, String oldPassword, String newPassword);
    
    /**
     * 重置密码
     */
    Result<Void> resetPassword(Long userId);
    
    /**
     * 获取用户列表（管理员）
     */
    Result<Map<String, Object>> getUserList(String keyword, Integer userType, 
                                          Integer status, Integer page, Integer size);
    
    /**
     * 更新用户状态（管理员）
     */
    Result<Void> updateUserStatus(Long userId, Integer status);
    
    /**
     * 删除用户（管理员）
     */
    Result<Void> deleteUser(Long userId);
} 