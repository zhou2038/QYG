package com.qyg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 轻易管后端系统启动类
 */
@SpringBootApplication
@MapperScan("com.qyg.mapper")
public class QygApplication {

    public static void main(String[] args) {
        SpringApplication.run(QygApplication.class, args);
        System.out.println("轻易管后端系统启动成功！");
    }
} 