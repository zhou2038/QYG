-- 创建数据库
CREATE DATABASE IF NOT EXISTS qyg_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE qyg_db;

-- 用户表
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `nickname` VARCHAR(50) COMMENT '昵称',
    `phone` VARCHAR(20) COMMENT '手机号',
    `email` VARCHAR(100) COMMENT '邮箱',
    `avatar` VARCHAR(255) COMMENT '头像',
    `gender` TINYINT DEFAULT 0 COMMENT '性别：0-未知，1-男，2-女',
    `age` INT COMMENT '年龄',
    `height` DECIMAL(5,2) COMMENT '身高(cm)',
    `weight` DECIMAL(5,2) COMMENT '体重(kg)',
    `target_weight` DECIMAL(5,2) COMMENT '目标体重(kg)',
    `user_type` TINYINT DEFAULT 1 COMMENT '用户类型：1-普通用户，2-管理员',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-禁用，1-正常',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_phone` (`phone`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 商品表
CREATE TABLE IF NOT EXISTS `product` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `name` VARCHAR(100) NOT NULL COMMENT '商品名称',
    `description` TEXT COMMENT '商品描述',
    `category` TINYINT NOT NULL COMMENT '商品分类：1-运动衣物，2-运动器材',
    `type` TINYINT COMMENT '商品类型：1-上衣，2-裤子，3-鞋子，4-哑铃，5-跑步机，6-瑜伽垫等',
    `images` TEXT COMMENT '商品图片，多个图片用逗号分隔',
    `video` VARCHAR(255) COMMENT '商品视频',
    `base_price` DECIMAL(10,2) NOT NULL COMMENT '基础价格',
    `current_price` DECIMAL(10,2) NOT NULL COMMENT '当前价格',
    `stock` INT DEFAULT 0 COMMENT '库存数量',
    `sales` INT DEFAULT 0 COMMENT '销量',
    `status` TINYINT DEFAULT 0 COMMENT '商品状态：0-下架，1-上架',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_category` (`category`),
    KEY `idx_type` (`type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- 商品SKU表
CREATE TABLE IF NOT EXISTS `product_sku` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'SKU ID',
    `product_id` BIGINT NOT NULL COMMENT '商品ID',
    `sku_name` VARCHAR(50) NOT NULL COMMENT '规格名称',
    `sku_value` VARCHAR(50) NOT NULL COMMENT '规格值',
    `price` DECIMAL(10,2) NOT NULL COMMENT '价格',
    `stock` INT DEFAULT 0 COMMENT '库存数量',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品SKU表';

-- 订单表
CREATE TABLE IF NOT EXISTS `order` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `order_no` VARCHAR(50) NOT NULL COMMENT '订单号',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `total_amount` DECIMAL(10,2) NOT NULL COMMENT '订单总金额',
    `status` TINYINT DEFAULT 0 COMMENT '订单状态：0-待支付，1-已支付，2-已发货，3-已完成，4-已取消，5-退款中，6-已退款',
    `receiver_name` VARCHAR(50) COMMENT '收货人姓名',
    `receiver_phone` VARCHAR(20) COMMENT '收货人电话',
    `receiver_address` TEXT COMMENT '收货地址',
    `tracking_no` VARCHAR(50) COMMENT '物流单号',
    `logistics_company` VARCHAR(50) COMMENT '物流公司',
    `pay_method` TINYINT COMMENT '支付方式：1-微信，2-支付宝，3-银行卡',
    `pay_time` TIMESTAMP NULL COMMENT '支付时间',
    `ship_time` TIMESTAMP NULL COMMENT '发货时间',
    `complete_time` TIMESTAMP NULL COMMENT '完成时间',
    `remark` TEXT COMMENT '备注',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_no` (`order_no`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- 订单项表
CREATE TABLE IF NOT EXISTS `order_item` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单项ID',
    `order_id` BIGINT NOT NULL COMMENT '订单ID',
    `product_id` BIGINT NOT NULL COMMENT '商品ID',
    `sku_id` BIGINT COMMENT '商品SKU ID',
    `product_name` VARCHAR(100) NOT NULL COMMENT '商品名称',
    `product_image` VARCHAR(255) COMMENT '商品图片',
    `sku_info` VARCHAR(100) COMMENT '规格信息',
    `price` DECIMAL(10,2) NOT NULL COMMENT '单价',
    `quantity` INT NOT NULL COMMENT '数量',
    `subtotal` DECIMAL(10,2) NOT NULL COMMENT '小计金额',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_order_id` (`order_id`),
    KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单项表';

-- 购物车表
CREATE TABLE IF NOT EXISTS `cart_item` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '购物车项ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `product_id` BIGINT NOT NULL COMMENT '商品ID',
    `sku_id` BIGINT COMMENT '商品SKU ID',
    `product_name` VARCHAR(100) NOT NULL COMMENT '商品名称',
    `product_image` VARCHAR(255) COMMENT '商品图片',
    `sku_info` VARCHAR(100) COMMENT '规格信息',
    `price` DECIMAL(10,2) NOT NULL COMMENT '单价',
    `quantity` INT NOT NULL DEFAULT 1 COMMENT '数量',
    `selected` TINYINT DEFAULT 1 COMMENT '是否选中：0-未选中，1-选中',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车表';

-- 视频表
CREATE TABLE IF NOT EXISTS `video` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '视频ID',
    `title` VARCHAR(100) NOT NULL COMMENT '视频标题',
    `description` TEXT COMMENT '视频描述',
    `category` TINYINT NOT NULL COMMENT '视频分类：1-运动视频，2-饮食视频',
    `type` TINYINT COMMENT '视频类型：1-全身运动，2-腹部运动，3-腿部运动，4-手臂运动，5-减肥餐制作等',
    `cover` VARCHAR(255) COMMENT '视频封面',
    `video_path` VARCHAR(255) NOT NULL COMMENT '视频文件路径',
    `duration` INT COMMENT '视频时长（秒）',
    `file_size` DECIMAL(10,2) COMMENT '视频大小（MB）',
    `play_count` INT DEFAULT 0 COMMENT '播放次数',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `collect_count` INT DEFAULT 0 COMMENT '收藏数',
    `status` TINYINT DEFAULT 1 COMMENT '视频状态：0-下架，1-上架',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_category` (`category`),
    KEY `idx_type` (`type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频表';

-- 饮食表
CREATE TABLE IF NOT EXISTS `diet` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '饮食ID',
    `title` VARCHAR(100) NOT NULL COMMENT '饮食标题',
    `description` TEXT COMMENT '饮食描述',
    `type` TINYINT COMMENT '饮食类型：1-早餐，2-午餐，3-晚餐，4-加餐',
    `calories` INT COMMENT '卡路里',
    `protein` DECIMAL(5,2) COMMENT '蛋白质(g)',
    `fat` DECIMAL(5,2) COMMENT '脂肪(g)',
    `carbohydrate` DECIMAL(5,2) COMMENT '碳水化合物(g)',
    `ingredients` TEXT COMMENT '食材',
    `steps` TEXT COMMENT '制作步骤',
    `images` TEXT COMMENT '图片，多个图片用逗号分隔',
    `video_id` BIGINT COMMENT '视频ID',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `collect_count` INT DEFAULT 0 COMMENT '收藏数',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-下架，1-上架',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_type` (`type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='饮食表';

-- 活力圈动态表
CREATE TABLE IF NOT EXISTS `moment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '动态ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `user_nickname` VARCHAR(50) COMMENT '用户昵称',
    `user_avatar` VARCHAR(255) COMMENT '用户头像',
    `content` TEXT COMMENT '动态内容',
    `images` TEXT COMMENT '图片，多个图片用逗号分隔',
    `video` VARCHAR(255) COMMENT '视频',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `comment_count` INT DEFAULT 0 COMMENT '评论数',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-删除，1-正常',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活力圈动态表';

-- 评论表
CREATE TABLE IF NOT EXISTS `comment` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '评论ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `user_nickname` VARCHAR(50) COMMENT '用户昵称',
    `user_avatar` VARCHAR(255) COMMENT '用户头像',
    `type` TINYINT NOT NULL COMMENT '评论类型：1-商品评论，2-动态评论，3-视频评论',
    `target_id` BIGINT NOT NULL COMMENT '关联ID（商品ID、动态ID、视频ID等）',
    `content` TEXT NOT NULL COMMENT '评论内容',
    `rating` TINYINT COMMENT '评分（1-5星）',
    `images` TEXT COMMENT '图片，多个图片用逗号分隔',
    `parent_id` BIGINT COMMENT '父评论ID（回复评论时使用）',
    `like_count` INT DEFAULT 0 COMMENT '点赞数',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-删除，1-正常',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_type_target` (`type`, `target_id`),
    KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- 插入管理员用户
INSERT INTO `user` (`username`, `password`, `nickname`, `user_type`, `status`) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', '管理员', 2, 1);

-- 插入测试商品数据
INSERT INTO `product` (`name`, `description`, `category`, `type`, `base_price`, `current_price`, `stock`, `status`) VALUES
('运动T恤', '舒适透气的运动T恤，适合各种运动场合', 1, 1, 99.00, 99.00, 100, 1),
('运动裤', '弹性运动裤，提供良好的运动体验', 1, 2, 129.00, 129.00, 80, 1),
('跑步鞋', '专业跑步鞋，减震效果好', 1, 3, 299.00, 299.00, 50, 1),
('哑铃套装', '可调节重量哑铃，适合家庭健身', 2, 4, 199.00, 199.00, 30, 1),
('瑜伽垫', '防滑瑜伽垫，厚度适中', 2, 6, 89.00, 89.00, 60, 1); 