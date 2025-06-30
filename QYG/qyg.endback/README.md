# 轻易管后端系统

这是一个基于Spring Boot、MyBatis和MySQL的轻易管后端项目。

## 项目介绍

本系统是一个综合性的健康体重管理平台，包含以下主要功能模块：

### 后台管理
- 商品管理（上架商品，下架商品，改价商品）
- 订单管理（订单信息，物流，退货处理）
- 消息管理（评价满意度）
- 视频管理（上架视频，配与文字说明）
- 饮食管理（上传图文，视频介绍减肥餐的制作）
- 日志管理（展示各类管理的数据日志）
- 用户管理（展示与编辑后台账户信息，包括后台账户和客户账户）

### 客户端
- 运动衣物（有不同种类的筛选，尺寸的选择，不同种类、尺寸有着不同价格，客户对商品评价）
- 运动器材（有不同种类、尺寸，重量的选择，评价系统）
- 购物车（商品管理，支付功能）
- 活力圈（减肥动态分享，可以发照片并配上文字，评论点赞）
- 运动视频（各种减肥的运动视频，可以筛选不同部位的减肥的视频，可以下载到本地观看）
- 运动饮食（有减肥食物的介绍，并由详细的菜品制作视频观看，可下载到本地观看）
- 订单（查看购买物品信息，物流跟踪，订单评价）
- 个人中心（个人信息管理，收货地址，视频缓存，退出登录）

## 技术栈

- Spring Boot 2.7.5
- MyBatis
- MySQL
- JWT
- Redis
- Maven

## 环境要求

- JDK 8+
- Maven 3.6+
- MySQL 5.7+
- Redis 5.0+

## 快速开始

### 1. 克隆项目

```bash
git clone <项目地址>
cd qyg.endback
```

### 2. 配置数据库

1. 创建MySQL数据库
2. 执行 `src/main/resources/sql/init.sql` 脚本初始化数据库
3. 修改 `src/main/resources/application.yml` 中的数据库连接信息

### 3. 配置Redis

确保Redis服务已启动，或修改 `application.yml` 中的Redis配置

### 4. 运行项目

```bash
# 编译项目
mvn clean compile

# 运行项目
mvn spring-boot:run
```

或者直接在IDE中运行 `QygApplication.java`

### 5. 访问接口

项目启动后，访问地址：`http://localhost:8080/api`

## 项目结构

```
src/main/java/com/qyg/
├── QygApplication.java          # 启动类
├── common/                      # 公共类
│   ├── Result.java             # 统一响应结果
│   └── exception/              # 异常处理
│       ├── BusinessException.java
│       └── GlobalExceptionHandler.java
├── controller/                  # 控制器层
│   ├── UserController.java
│   ├── ProductController.java
│   └── ...
├── service/                     # 服务层
│   ├── UserService.java
│   ├── ProductService.java
│   └── impl/                   # 服务实现
│       ├── UserServiceImpl.java
│       ├── ProductServiceImpl.java
│       └── ...
├── mapper/                      # 数据访问层
│   ├── UserMapper.java
│   ├── ProductMapper.java
│   └── ...
├── entity/                      # 实体类
│   ├── User.java
│   ├── Product.java
│   └── ...
└── util/                        # 工具类
    ├── JwtUtil.java
    └── PasswordUtil.java
```

## 主要功能

### 用户管理
- 用户注册/登录
- 用户信息管理
- 密码修改
- 用户状态管理

### 商品管理
- 商品增删改查
- 商品上下架
- 商品价格管理
- 商品分类管理

### 订单管理
- 订单创建
- 订单状态跟踪
- 物流信息管理
- 订单评价

### 购物车
- 添加商品到购物车
- 购物车商品管理
- 结算功能

### 视频管理
- 运动视频管理
- 饮食视频管理
- 视频分类筛选

### 饮食管理
- 减肥餐介绍
- 营养成分管理
- 制作步骤管理

### 活力圈
- 动态发布
- 评论点赞
- 社交互动

## API文档

### 用户相关接口

#### 用户注册
```
POST /api/user/register
Content-Type: application/json

{
    "username": "test",
    "password": "123456",
    "nickname": "测试用户",
    "phone": "13800138000"
}
```

#### 用户登录
```
POST /api/user/login
Content-Type: application/x-www-form-urlencoded

username=test&password=123456
```

#### 获取用户信息
```
GET /api/user/info
Authorization: Bearer <token>
```

### 商品相关接口

#### 获取商品列表
```
GET /api/product/list?page=1&size=10&category=1
```

#### 获取商品详情
```
GET /api/product/{productId}
```

#### 添加商品（管理员）
```
POST /api/product
Authorization: Bearer <token>
Content-Type: application/json

{
    "name": "运动T恤",
    "description": "舒适透气的运动T恤",
    "category": 1,
    "type": 1,
    "basePrice": 99.00
}
```

## 默认账号

- 管理员账号：admin
- 管理员密码：123456

## 注意事项

1. 首次运行需要先执行数据库初始化脚本
2. 确保Redis服务正常运行
3. 文件上传功能需要配置正确的文件存储路径
4. JWT密钥请在生产环境中修改

## 开发计划

- [ ] 完善订单管理功能
- [ ] 添加支付集成
- [ ] 实现文件上传功能
- [ ] 添加缓存优化
- [ ] 完善权限控制
- [ ] 添加日志记录
- [ ] 性能优化
- [ ] 单元测试

## 贡献

欢迎提交Issue和Pull Request

## 许可证

MIT License 