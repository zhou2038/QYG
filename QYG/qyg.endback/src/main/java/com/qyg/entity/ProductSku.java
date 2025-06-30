package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品SKU实体类
 */
@Data
public class ProductSku {
    
    private Long id;
    
    /**
     * 商品ID
     */
    private Long productId;
    
    /**
     * 规格名称
     */
    private String skuName;
    
    /**
     * 规格值
     */
    private String skuValue;
    
    /**
     * 价格
     */
    private BigDecimal price;
    
    /**
     * 库存数量
     */
    private Integer stock;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
} 