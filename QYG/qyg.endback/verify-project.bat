@echo off
echo 验证轻易管后端系统项目完整性...
echo.

set "PROJECT_ROOT=%~dp0"
set "ERROR_COUNT=0"

echo 检查核心配置文件...
if not exist "%PROJECT_ROOT%pom.xml" (
    echo ✗ pom.xml 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ pom.xml 存在
)

if not exist "%PROJECT_ROOT%src\main\resources\application.yml" (
    echo ✗ application.yml 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ application.yml 存在
)

echo.
echo 检查Java源文件...

REM 检查启动类
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\QygApplication.java" (
    echo ✗ QygApplication.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ QygApplication.java 存在
)

REM 检查公共组件
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\common\Result.java" (
    echo ✗ Result.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ Result.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\common\exception\BusinessException.java" (
    echo ✗ BusinessException.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ BusinessException.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\common\exception\GlobalExceptionHandler.java" (
    echo ✗ GlobalExceptionHandler.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ GlobalExceptionHandler.java 存在
)

REM 检查实体类
echo.
echo 检查实体类...
set "ENTITIES=User Product ProductSku Order OrderItem CartItem Video Diet Moment Comment"
for %%e in (%ENTITIES%) do (
    if not exist "%PROJECT_ROOT%src\main\java\com\qyg\entity\%%e.java" (
        echo ✗ %%e.java 缺失
        set /a ERROR_COUNT+=1
    ) else (
        echo ✓ %%e.java 存在
    )
)

REM 检查Mapper接口
echo.
echo 检查Mapper接口...
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\mapper\UserMapper.java" (
    echo ✗ UserMapper.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ UserMapper.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\mapper\ProductMapper.java" (
    echo ✗ ProductMapper.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ ProductMapper.java 存在
)

REM 检查Service接口和实现
echo.
echo 检查Service层...
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\service\UserService.java" (
    echo ✗ UserService.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ UserService.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\service\ProductService.java" (
    echo ✗ ProductService.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ ProductService.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\service\impl\UserServiceImpl.java" (
    echo ✗ UserServiceImpl.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ UserServiceImpl.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\service\impl\ProductServiceImpl.java" (
    echo ✗ ProductServiceImpl.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ ProductServiceImpl.java 存在
)

REM 检查Controller
echo.
echo 检查Controller层...
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\controller\UserController.java" (
    echo ✗ UserController.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ UserController.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\controller\ProductController.java" (
    echo ✗ ProductController.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ ProductController.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\controller\TestController.java" (
    echo ✗ TestController.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ TestController.java 存在
)

REM 检查工具类
echo.
echo 检查工具类...
if not exist "%PROJECT_ROOT%src\main\java\com\qyg\util\JwtUtil.java" (
    echo ✗ JwtUtil.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ JwtUtil.java 存在
)

if not exist "%PROJECT_ROOT%src\main\java\com\qyg\util\PasswordUtil.java" (
    echo ✗ PasswordUtil.java 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ PasswordUtil.java 存在
)

REM 检查配置文件
echo.
echo 检查配置文件...
if not exist "%PROJECT_ROOT%src\main\resources\mapper\UserMapper.xml" (
    echo ✗ UserMapper.xml 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ UserMapper.xml 存在
)

if not exist "%PROJECT_ROOT%src\main\resources\mapper\ProductMapper.xml" (
    echo ✗ ProductMapper.xml 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ ProductMapper.xml 存在
)

if not exist "%PROJECT_ROOT%src\main\resources\sql\init.sql" (
    echo ✗ init.sql 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ init.sql 存在
)

echo.
echo 检查文档文件...
if not exist "%PROJECT_ROOT%README.md" (
    echo ✗ README.md 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ README.md 存在
)

if not exist "%PROJECT_ROOT%PROJECT_STRUCTURE.md" (
    echo ✗ PROJECT_STRUCTURE.md 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ PROJECT_STRUCTURE.md 存在
)

if not exist "%PROJECT_ROOT%PROJECT_SUMMARY.md" (
    echo ✗ PROJECT_SUMMARY.md 缺失
    set /a ERROR_COUNT+=1
) else (
    echo ✓ PROJECT_SUMMARY.md 存在
)

echo.
echo ========================================
echo 项目验证完成！
echo.

if %ERROR_COUNT% EQU 0 (
    echo ✅ 所有文件检查通过，项目结构完整！
    echo.
    echo 下一步操作：
    echo 1. 确保已安装JDK 8+和Maven 3.6+
    echo 2. 配置MySQL数据库并执行init.sql脚本
    echo 3. 配置Redis服务
    echo 4. 运行 mvn spring-boot:run 启动项目
) else (
    echo ❌ 发现 %ERROR_COUNT% 个问题，请检查上述缺失的文件
)

echo.
pause 