package com.qyg.controller;

import com.qyg.common.Result;
import com.qyg.entity.Product;
import com.qyg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 商品Controller
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    /**
     * 获取商品详情
     */
    @GetMapping("/{productId}")
    public Result<Product> getProductDetail(@PathVariable Long productId) {
        return productService.getProductDetail(productId);
    }
    
    /**
     * 获取商品列表
     */
    @GetMapping("/list")
    public Result<Map<String, Object>> getProductList(@RequestParam(required = false) String keyword,
                                                     @RequestParam(required = false) Integer category,
                                                     @RequestParam(required = false) Integer type,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer size) {
        return productService.getProductList(keyword, category, type, page, size);
    }
    
    /**
     * 添加商品（管理员）
     */
    @PostMapping
    public Result<Void> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    /**
     * 更新商品（管理员）
     */
    @PutMapping
    public Result<Void> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    
    /**
     * 删除商品（管理员）
     */
    @DeleteMapping("/{productId}")
    public Result<Void> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }
    
    /**
     * 上架商品（管理员）
     */
    @PutMapping("/{productId}/on-sale")
    public Result<Void> putOnSale(@PathVariable Long productId) {
        return productService.putOnSale(productId);
    }
    
    /**
     * 下架商品（管理员）
     */
    @PutMapping("/{productId}/off-sale")
    public Result<Void> putOffSale(@PathVariable Long productId) {
        return productService.putOffSale(productId);
    }
    
    /**
     * 修改商品价格（管理员）
     */
    @PutMapping("/{productId}/price")
    public Result<Void> updatePrice(@PathVariable Long productId,
                                  @RequestParam String price) {
        return productService.updatePrice(productId, price);
    }
} 