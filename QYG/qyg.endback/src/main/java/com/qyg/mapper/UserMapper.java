package com.qyg.mapper;

import com.qyg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper接口
 */
@Mapper
public interface UserMapper {
    
    /**
     * 根据ID查询用户
     */
    User selectById(@Param("id") Long id);
    
    /**
     * 根据用户名查询用户
     */
    User selectByUsername(@Param("username") String username);
    
    /**
     * 根据手机号查询用户
     */
    User selectByPhone(@Param("phone") String phone);
    
    /**
     * 根据邮箱查询用户
     */
    User selectByEmail(@Param("email") String email);
    
    /**
     * 查询用户列表
     */
    List<User> selectList(@Param("keyword") String keyword, 
                         @Param("userType") Integer userType,
                         @Param("status") Integer status,
                         @Param("offset") Integer offset,
                         @Param("limit") Integer limit);
    
    /**
     * 查询用户总数
     */
    int selectCount(@Param("keyword") String keyword,
                   @Param("userType") Integer userType,
                   @Param("status") Integer status);
    
    /**
     * 插入用户
     */
    int insert(User user);
    
    /**
     * 更新用户
     */
    int update(User user);
    
    /**
     * 删除用户
     */
    int deleteById(@Param("id") Long id);
    
    /**
     * 更新用户状态
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    /**
     * 更新用户密码
     */
    int updatePassword(@Param("id") Long id, @Param("password") String password);
} 