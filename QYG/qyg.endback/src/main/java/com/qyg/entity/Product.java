package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品实体类
 */
@Data
public class Product {
    
    private Long id;
    
    /**
     * 商品名称
     */
    private String name;
    
    /**
     * 商品描述
     */
    private String description;
    
    /**
     * 商品分类：1-运动衣物，2-运动器材
     */
    private Integer category;
    
    /**
     * 商品类型：1-上衣，2-裤子，3-鞋子，4-哑铃，5-跑步机，6-瑜伽垫等
     */
    private Integer type;
    
    /**
     * 商品图片，多个图片用逗号分隔
     */
    private String images;
    
    /**
     * 商品视频
     */
    private String video;
    
    /**
     * 基础价格
     */
    private BigDecimal basePrice;
    
    /**
     * 当前价格
     */
    private BigDecimal currentPrice;
    
    /**
     * 库存数量
     */
    private Integer stock;
    
    /**
     * 销量
     */
    private Integer sales;
    
    /**
     * 商品状态：0-下架，1-上架
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