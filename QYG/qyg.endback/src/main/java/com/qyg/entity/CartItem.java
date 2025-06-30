package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车项实体类
 */
@Data
public class CartItem {
    
    private Long id;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 商品ID
     */
    private Long productId;
    
    /**
     * 商品SKU ID
     */
    private Long skuId;
    
    /**
     * 商品名称
     */
    private String productName;
    
    /**
     * 商品图片
     */
    private String productImage;
    
    /**
     * 规格信息
     */
    private String skuInfo;
    
    /**
     * 单价
     */
    private BigDecimal price;
    
    /**
     * 数量
     */
    private Integer quantity;
    
    /**
     * 是否选中：0-未选中，1-选中
     */
    private Integer selected;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
} 