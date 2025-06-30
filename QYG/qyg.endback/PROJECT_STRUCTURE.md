# 轻易管后端系统项目结构

## 目录结构

```
qyg.endback/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── qyg/
│   │   │           ├── QygApplication.java          # 启动类
│   │   │           ├── common/                      # 公共类
│   │   │           │   ├── Result.java             # 统一响应结果
│   │   │           │   └── exception/              # 异常处理
│   │   │           │       ├── BusinessException.java
│   │   │           │       └── GlobalExceptionHandler.java
│   │   │           ├── config/                      # 配置类
│   │   │           │   └── WebConfig.java          # Web配置
│   │   │           ├── controller/                  # 控制器层
│   │   │           │   ├── TestController.java     # 测试控制器
│   │   │           │   ├── UserController.java     # 用户控制器
│   │   │           │   ├── ProductController.java  # 商品控制器
│   │   │           │   └── ...                     # 其他控制器
│   │   │           ├── service/                     # 服务层
│   │   │           │   ├── UserService.java        # 用户服务接口
│   │   │           │   ├── ProductService.java     # 商品服务接口
│   │   │           │   └── impl/                   # 服务实现
│   │   │           │       ├── UserServiceImpl.java
│   │   │           │       ├── ProductServiceImpl.java
│   │   │           │       └── ...                 # 其他服务实现
│   │   │           ├── mapper/                      # 数据访问层
│   │   │           │   ├── UserMapper.java         # 用户Mapper
│   │   │           │   ├── ProductMapper.java      # 商品Mapper
│   │   │           │   └── ...                     # 其他Mapper
│   │   │           ├── entity/                      # 实体类
│   │   │           │   ├── User.java               # 用户实体
│   │   │           │   ├── Product.java            # 商品实体
│   │   │           │   ├── ProductSku.java         # 商品SKU实体
│   │   │           │   ├── Order.java              # 订单实体
│   │   │           │   ├── OrderItem.java          # 订单项实体
│   │   │           │   ├── CartItem.java           # 购物车项实体
│   │   │           │   ├── Video.java              # 视频实体
│   │   │           │   ├── Diet.java               # 饮食实体
│   │   │           │   ├── Moment.java             # 活力圈动态实体
│   │   │           │   └── Comment.java            # 评论实体
│   │   │           └── util/                        # 工具类
│   │   │               ├── JwtUtil.java            # JWT工具类
│   │   │               └── PasswordUtil.java       # 密码工具类
│   │   └── resources/
│   │       ├── application.yml                     # 主配置文件
│   │       ├── mapper/                             # MyBatis映射文件
│   │       │   ├── UserMapper.xml                  # 用户Mapper XML
│   │       │   ├── ProductMapper.xml               # 商品Mapper XML
│   │       │   └── ...                             # 其他Mapper XML
│   │       └── sql/                                # SQL脚本
│   │           └── init.sql                        # 数据库初始化脚本
│   └── test/                                       # 测试代码
├── pom.xml                                         # Maven配置文件
├── README.md                                       # 项目说明文档
├── PROJECT_STRUCTURE.md                            # 项目结构说明
├── start.bat                                       # Windows启动脚本
└── start.sh                                        # Linux/Mac启动脚本
```

## 核心模块说明

### 1. 用户模块 (User)
- **功能**: 用户注册、登录、信息管理、权限控制
- **核心类**: 
  - `UserController`: 用户相关接口
  - `UserService`: 用户业务逻辑
  - `UserMapper`: 用户数据访问
  - `User`: 用户实体类

### 2. 商品模块 (Product)
- **功能**: 商品管理、分类、SKU、价格管理
- **核心类**:
  - `ProductController`: 商品相关接口
  - `ProductService`: 商品业务逻辑
  - `ProductMapper`: 商品数据访问
  - `Product`: 商品实体类
  - `ProductSku`: 商品SKU实体类

### 3. 订单模块 (Order)
- **功能**: 订单创建、状态管理、物流跟踪
- **核心类**:
  - `Order`: 订单实体类
  - `OrderItem`: 订单项实体类

### 4. 购物车模块 (Cart)
- **功能**: 购物车管理、商品添加、结算
- **核心类**:
  - `CartItem`: 购物车项实体类

### 5. 视频模块 (Video)
- **功能**: 运动视频、饮食视频管理
- **核心类**:
  - `Video`: 视频实体类

### 6. 饮食模块 (Diet)
- **功能**: 减肥餐介绍、营养成分管理
- **核心类**:
  - `Diet`: 饮食实体类

### 7. 活力圈模块 (Moment)
- **功能**: 动态发布、社交互动
- **核心类**:
  - `Moment`: 活力圈动态实体类
  - `Comment`: 评论实体类

## 技术架构

### 分层架构
1. **Controller层**: 接收HTTP请求，参数校验，返回响应
2. **Service层**: 业务逻辑处理，事务管理
3. **Mapper层**: 数据访问，SQL执行
4. **Entity层**: 数据模型，数据库表映射

### 核心组件
1. **Spring Boot**: 应用框架
2. **MyBatis**: ORM框架
3. **MySQL**: 关系型数据库
4. **Redis**: 缓存数据库
5. **JWT**: 身份认证
6. **Maven**: 项目管理

### 设计模式
1. **MVC模式**: 模型-视图-控制器
2. **DAO模式**: 数据访问对象
3. **单例模式**: 工具类
4. **工厂模式**: 对象创建

## 数据库设计

### 主要数据表
1. **user**: 用户表
2. **product**: 商品表
3. **product_sku**: 商品SKU表
4. **order**: 订单表
5. **order_item**: 订单项表
6. **cart_item**: 购物车表
7. **video**: 视频表
8. **diet**: 饮食表
9. **moment**: 活力圈动态表
10. **comment**: 评论表

### 表关系
- 用户与订单：一对多
- 商品与SKU：一对多
- 订单与订单项：一对多
- 用户与动态：一对多
- 动态与评论：一对多

## 开发规范

### 命名规范
1. **类名**: 大驼峰命名法 (PascalCase)
2. **方法名**: 小驼峰命名法 (camelCase)
3. **变量名**: 小驼峰命名法 (camelCase)
4. **常量名**: 全大写加下划线 (UPPER_SNAKE_CASE)
5. **包名**: 全小写 (lowercase)

### 代码规范
1. **注释**: 类、方法、复杂逻辑必须添加注释
2. **异常处理**: 统一异常处理，避免异常泄露
3. **参数校验**: 接口参数必须进行校验
4. **日志记录**: 关键操作必须记录日志
5. **事务管理**: 涉及多表操作必须使用事务

### 接口规范
1. **统一响应格式**: 使用Result类包装响应
2. **状态码规范**: 200成功，400参数错误，401未授权，500服务器错误
3. **版本控制**: 接口版本号管理
4. **文档规范**: 接口必须有详细文档

## 部署说明

### 环境要求
- JDK 8+
- Maven 3.6+
- MySQL 5.7+
- Redis 5.0+

### 部署步骤
1. 克隆项目代码
2. 执行数据库初始化脚本
3. 修改配置文件
4. 编译打包项目
5. 启动应用

### 配置文件
- `application.yml`: 主配置文件
- `application-dev.yml`: 开发环境配置
- `application-prod.yml`: 生产环境配置

## 扩展计划

### 功能扩展
1. 支付集成 (微信支付、支付宝)
2. 文件上传 (图片、视频)
3. 消息推送 (短信、邮件)
4. 数据统计 (用户行为分析)
5. 推荐系统 (商品推荐)

### 技术优化
1. 缓存优化 (Redis缓存策略)
2. 性能优化 (数据库优化、索引优化)
3. 安全加固 (XSS防护、SQL注入防护)
4. 监控告警 (系统监控、异常告警)
5. 容器化部署 (Docker、Kubernetes) 