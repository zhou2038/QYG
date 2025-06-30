package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 饮食实体类
 */
@Data
public class Diet {
    
    private Long id;
    
    /**
     * 饮食标题
     */
    private String title;
    
    /**
     * 饮食描述
     */
    private String description;
    
    /**
     * 饮食类型：1-早餐，2-午餐，3-晚餐，4-加餐
     */
    private Integer type;
    
    /**
     * 卡路里
     */
    private Integer calories;
    
    /**
     * 蛋白质(g)
     */
    private BigDecimal protein;
    
    /**
     * 脂肪(g)
     */
    private BigDecimal fat;
    
    /**
     * 碳水化合物(g)
     */
    private BigDecimal carbohydrate;
    
    /**
     * 食材
     */
    private String ingredients;
    
    /**
     * 制作步骤
     */
    private String steps;
    
    /**
     * 图片，多个图片用逗号分隔
     */
    private String images;
    
    /**
     * 视频ID
     */
    private Long videoId;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 收藏数
     */
    private Integer collectCount;
    
    /**
     * 状态：0-下架，1-上架
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