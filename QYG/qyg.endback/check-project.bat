@echo off
echo 检查轻易管后端系统项目结构...
echo.

echo 检查核心文件是否存在：
echo.

if exist "pom.xml" (
    echo ✓ pom.xml - Maven配置文件
) else (
    echo ✗ pom.xml - 缺失
)

if exist "src\main\java\com\qyg\QygApplication.java" (
    echo ✓ QygApplication.java - 启动类
) else (
    echo ✗ QygApplication.java - 缺失
)

if exist "src\main\resources\application.yml" (
    echo ✓ application.yml - 配置文件
) else (
    echo ✗ application.yml - 缺失
)

if exist "src\main\java\com\qyg\common\Result.java" (
    echo ✓ Result.java - 统一响应类
) else (
    echo ✗ Result.java - 缺失
)

if exist "src\main\java\com\qyg\entity\User.java" (
    echo ✓ User.java - 用户实体类
) else (
    echo ✗ User.java - 缺失
)

if exist "src\main\java\com\qyg\entity\Product.java" (
    echo ✓ Product.java - 商品实体类
) else (
    echo ✗ Product.java - 缺失
)

if exist "src\main\java\com\qyg\mapper\UserMapper.java" (
    echo ✓ UserMapper.java - 用户Mapper接口
) else (
    echo ✗ UserMapper.java - 缺失
)

if exist "src\main\java\com\qyg\mapper\ProductMapper.java" (
    echo ✓ ProductMapper.java - 商品Mapper接口
) else (
    echo ✗ ProductMapper.java - 缺失
)

if exist "src\main\java\com\qyg\service\UserService.java" (
    echo ✓ UserService.java - 用户服务接口
) else (
    echo ✗ UserService.java - 缺失
)

if exist "src\main\java\com\qyg\service\ProductService.java" (
    echo ✓ ProductService.java - 商品服务接口
) else (
    echo ✗ ProductService.java - 缺失
)

if exist "src\main\java\com\qyg\service\impl\UserServiceImpl.java" (
    echo ✓ UserServiceImpl.java - 用户服务实现
) else (
    echo ✗ UserServiceImpl.java - 缺失
)

if exist "src\main\java\com\qyg\service\impl\ProductServiceImpl.java" (
    echo ✓ ProductServiceImpl.java - 商品服务实现
) else (
    echo ✗ ProductServiceImpl.java - 缺失
)

if exist "src\main\java\com\qyg\controller\UserController.java" (
    echo ✓ UserController.java - 用户控制器
) else (
    echo ✗ UserController.java - 缺失
)

if exist "src\main\java\com\qyg\controller\ProductController.java" (
    echo ✓ ProductController.java - 商品控制器
) else (
    echo ✗ ProductController.java - 缺失
)

if exist "src\main\java\com\qyg\util\JwtUtil.java" (
    echo ✓ JwtUtil.java - JWT工具类
) else (
    echo ✗ JwtUtil.java - 缺失
)

if exist "src\main\java\com\qyg\util\PasswordUtil.java" (
    echo ✓ PasswordUtil.java - 密码工具类
) else (
    echo ✗ PasswordUtil.java - 缺失
)

if exist "src\main\resources\mapper\UserMapper.xml" (
    echo ✓ UserMapper.xml - 用户Mapper XML
) else (
    echo ✗ UserMapper.xml - 缺失
)

if exist "src\main\resources\mapper\ProductMapper.xml" (
    echo ✓ ProductMapper.xml - 商品Mapper XML
) else (
    echo ✗ ProductMapper.xml - 缺失
)

if exist "src\main\resources\sql\init.sql" (
    echo ✓ init.sql - 数据库初始化脚本
) else (
    echo ✗ init.sql - 缺失
)

echo.
echo 项目结构检查完成！
echo.
echo 下一步：
echo 1. 安装JDK 8+和Maven 3.6+
echo 2. 配置MySQL数据库并执行init.sql脚本
echo 3. 配置Redis服务
echo 4. 运行 mvn spring-boot:run 启动项目
echo.

pause 