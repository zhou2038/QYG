#!/bin/bash

echo "正在启动轻易管后端系统..."
echo

# 检查Java环境
if ! command -v java &> /dev/null; then
    echo "错误：未找到Java环境，请先安装JDK 8或更高版本"
    exit 1
fi

# 检查Maven环境
if ! command -v mvn &> /dev/null; then
    echo "错误：未找到Maven环境，请先安装Maven 3.6或更高版本"
    exit 1
fi

echo "环境检查通过，开始编译项目..."
echo

# 清理并编译项目
mvn clean compile
if [ $? -ne 0 ]; then
    echo "错误：项目编译失败"
    exit 1
fi

echo "编译成功，启动项目..."
echo

# 启动项目
mvn spring-boot:run 