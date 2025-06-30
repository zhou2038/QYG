package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 视频实体类
 */
@Data
public class Video {
    
    private Long id;
    
    /**
     * 视频标题
     */
    private String title;
    
    /**
     * 视频描述
     */
    private String description;
    
    /**
     * 视频分类：1-运动视频，2-饮食视频
     */
    private Integer category;
    
    /**
     * 视频类型：1-全身运动，2-腹部运动，3-腿部运动，4-手臂运动，5-减肥餐制作等
     */
    private Integer type;
    
    /**
     * 视频封面
     */
    private String cover;
    
    /**
     * 视频文件路径
     */
    private String videoPath;
    
    /**
     * 视频时长（秒）
     */
    private Integer duration;
    
    /**
     * 视频大小（MB）
     */
    private BigDecimal fileSize;
    
    /**
     * 播放次数
     */
    private Integer playCount;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 收藏数
     */
    private Integer collectCount;
    
    /**
     * 视频状态：0-下架，1-上架
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