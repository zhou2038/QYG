package com.qyg.mapper;

import com.qyg.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品Mapper接口
 */
@Mapper
public interface ProductMapper {
    
    /**
     * 根据ID查询商品
     */
    Product selectById(@Param("id") Long id);
    
    /**
     * 查询商品列表
     */
    List<Product> selectList(@Param("keyword") String keyword,
                           @Param("category") Integer category,
                           @Param("type") Integer type,
                           @Param("status") Integer status,
                           @Param("offset") Integer offset,
                           @Param("limit") Integer limit);
    
    /**
     * 查询商品总数
     */
    int selectCount(@Param("keyword") String keyword,
                   @Param("category") Integer category,
                   @Param("type") Integer type,
                   @Param("status") Integer status);
    
    /**
     * 插入商品
     */
    int insert(Product product);
    
    /**
     * 更新商品
     */
    int update(Product product);
    
    /**
     * 删除商品
     */
    int deleteById(@Param("id") Long id);
    
    /**
     * 更新商品状态
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    /**
     * 更新商品价格
     */
    int updatePrice(@Param("id") Long id, @Param("currentPrice") String currentPrice);
    
    /**
     * 更新商品库存
     */
    int updateStock(@Param("id") Long id, @Param("stock") Integer stock);
    
    /**
     * 更新商品销量
     */
    int updateSales(@Param("id") Long id, @Param("sales") Integer sales);
} 