package com.qyg.service;

import com.qyg.common.Result;
import com.qyg.entity.Product;

import java.util.Map;

/**
 * 商品Service接口
 */
public interface ProductService {
    
    /**
     * 获取商品详情
     */
    Result<Product> getProductDetail(Long productId);
    
    /**
     * 获取商品列表
     */
    Result<Map<String, Object>> getProductList(String keyword, Integer category, 
                                             Integer type, Integer page, Integer size);
    
    /**
     * 添加商品（管理员）
     */
    Result<Void> addProduct(Product product);
    
    /**
     * 更新商品（管理员）
     */
    Result<Void> updateProduct(Product product);
    
    /**
     * 删除商品（管理员）
     */
    Result<Void> deleteProduct(Long productId);
    
    /**
     * 上架商品（管理员）
     */
    Result<Void> putOnSale(Long productId);
    
    /**
     * 下架商品（管理员）
     */
    Result<Void> putOffSale(Long productId);
    
    /**
     * 修改商品价格（管理员）
     */
    Result<Void> updatePrice(Long productId, String price);
} 