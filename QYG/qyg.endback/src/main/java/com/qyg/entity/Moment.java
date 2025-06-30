package com.qyg.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 活力圈动态实体类
 */
@Data
public class Moment {
    
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
     * 动态内容
     */
    private String content;
    
    /**
     * 图片，多个图片用逗号分隔
     */
    private String images;
    
    /**
     * 视频
     */
    private String video;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 评论数
     */
    private Integer commentCount;
    
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