@echo off
echo 正在启动轻易管后端系统...
echo.

REM 检查Java环境
java -version >nul 2>&1
if errorlevel 1 (
    echo 错误：未找到Java环境，请先安装JDK 8或更高版本
    pause
    exit /b 1
)

REM 检查Maven环境
mvn -version >nul 2>&1
if errorlevel 1 (
    echo 错误：未找到Maven环境，请先安装Maven 3.6或更高版本
    pause
    exit /b 1
)

echo 环境检查通过，开始编译项目...
echo.

REM 清理并编译项目
mvn clean compile
if errorlevel 1 (
    echo 错误：项目编译失败
    pause
    exit /b 1
)

echo 编译成功，启动项目...
echo.

REM 启动项目
mvn spring-boot:run

pause 