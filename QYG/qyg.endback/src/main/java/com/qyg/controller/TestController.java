package com.qyg.controller;

import com.qyg.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public Result<Map<String, Object>> health() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", "UP");
        data.put("message", "轻易管后端系统运行正常");
        data.put("timestamp", System.currentTimeMillis());
        return Result.success("系统正常", data);
    }
    
    /**
     * 测试接口
     */
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello, 轻易管后端系统！");
    }
} 