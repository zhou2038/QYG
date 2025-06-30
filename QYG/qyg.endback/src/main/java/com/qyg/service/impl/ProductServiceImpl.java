package com.qyg.service.impl;

import com.qyg.common.Result;
import com.qyg.entity.Product;
import com.qyg.mapper.ProductMapper;
import com.qyg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品Service实现类
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public Result<Product> getProductDetail(Long productId) {
        if (productId == null) {
            return Result.error("商品ID不能为空");
        }
        
        Product product = productMapper.selectById(productId);
        if (product == null) {
            return Result.error("商品不存在");
        }
        
        return Result.success(product);
    }
    
    @Override
    public Result<Map<String, Object>> getProductList(String keyword, Integer category, 
                                                     Integer type, Integer page, Integer size) {
        // 分页参数
        if (page == null || page < 1) page = 1;
        if (size == null || size < 1) size = 10;
        int offset = (page - 1) * size;
        
        // 只查询上架的商品
        Integer status = 1;
        
        // 查询数据
        List<Product> products = productMapper.selectList(keyword, category, type, status, offset, size);
        int total = productMapper.selectCount(keyword, category, type, status);
        
        // 返回结果
        Map<String, Object> data = new HashMap<>();
        data.put("list", products);
        data.put("total", total);
        data.put("page", page);
        data.put("size", size);
        
        return Result.success(data);
    }
    
    @Override
    public Result<Void> addProduct(Product product) {
        // 参数校验
        if (!StringUtils.hasText(product.getName())) {
            return Result.error("商品名称不能为空");
        }
        if (product.getCategory() == null) {
            return Result.error("商品分类不能为空");
        }
        if (product.getBasePrice() == null) {
            return Result.error("商品价格不能为空");
        }
        
        // 设置默认值
        product.setCurrentPrice(product.getBasePrice());
        product.setStatus(0); // 默认下架
        product.setSales(0);
        
        int result = productMapper.insert(product);
        if (result <= 0) {
            return Result.error("添加失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> updateProduct(Product product) {
        if (product.getId() == null) {
            return Result.error("商品ID不能为空");
        }
        
        // 检查商品是否存在
        Product existProduct = productMapper.selectById(product.getId());
        if (existProduct == null) {
            return Result.error("商品不存在");
        }
        
        int result = productMapper.update(product);
        if (result <= 0) {
            return Result.error("更新失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> deleteProduct(Long productId) {
        if (productId == null) {
            return Result.error("商品ID不能为空");
        }
        
        int result = productMapper.deleteById(productId);
        if (result <= 0) {
            return Result.error("删除失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> putOnSale(Long productId) {
        if (productId == null) {
            return Result.error("商品ID不能为空");
        }
        
        int result = productMapper.updateStatus(productId, 1);
        if (result <= 0) {
            return Result.error("上架失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> putOffSale(Long productId) {
        if (productId == null) {
            return Result.error("商品ID不能为空");
        }
        
        int result = productMapper.updateStatus(productId, 0);
        if (result <= 0) {
            return Result.error("下架失败");
        }
        
        return Result.success();
    }
    
    @Override
    public Result<Void> updatePrice(Long productId, String price) {
        if (productId == null) {
            return Result.error("商品ID不能为空");
        }
        if (!StringUtils.hasText(price)) {
            return Result.error("价格不能为空");
        }
        
        try {
            new BigDecimal(price);
        } catch (NumberFormatException e) {
            return Result.error("价格格式不正确");
        }
        
        int result = productMapper.updatePrice(productId, price);
        if (result <= 0) {
            return Result.error("修改失败");
        }
        
        return Result.success();
    }
} 