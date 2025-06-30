package com.qyg.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 评论实体类
 */
@Data
public class Comment {
    
    private Long id;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 用户昵称
     */
    private String userNickname;
    
    /**
     * 用户头像
     */
    private String userAvatar;
    
    /**
     * 评论类型：1-商品评论，2-动态评论，3-视频评论
     */
    private Integer type;
    
    /**
     * 关联ID（商品ID、动态ID、视频ID等）
     */
    private Long targetId;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 评分（1-5星）
     */
    private Integer rating;
    
    /**
     * 图片，多个图片用逗号分隔
     */
    private String images;
    
    /**
     * 父评论ID（回复评论时使用）
     */
    private Long parentId;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 状态：0-删除，1-正常
     */
    private Integer status;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
} 