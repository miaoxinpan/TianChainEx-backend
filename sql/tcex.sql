
-- ----------------------------
-- 1、用户表
-- ----------------------------
CREATE TABLE `users` (
                         `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                         `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                         `email` VARCHAR(100) NOT NULL COMMENT '邮箱',
                         `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
                         `password_hash` CHAR(60) NOT NULL COMMENT '密码哈希(bcrypt)',
                         `status` ENUM('ACTIVE', 'FROZEN', 'CLOSED') NOT NULL DEFAULT 'ACTIVE' COMMENT '账户状态',
                         `google_auth_secret` VARCHAR(32) DEFAULT NULL COMMENT '谷歌验证密钥',
                         `last_login_at` DATETIME(6) DEFAULT NULL COMMENT '最后登录时间',
                         `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
                         `updated_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `idx_username` (`username`),
                         UNIQUE KEY `idx_email` (`email`),
                         KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户主表';

-- ----------------------------
-- 2、用户资产账户表
-- ----------------------------
CREATE TABLE `accounts` (
                            `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账户ID',
                            `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
                            `currency` VARCHAR(10) NOT NULL COMMENT '币种(BTC,ETH,USDT)',
                            `balance` DECIMAL(36,18) NOT NULL DEFAULT 0.000000000000000000 COMMENT '可用余额',
                            `frozen` DECIMAL(36,18) NOT NULL DEFAULT 0.000000000000000000 COMMENT '冻结金额',
                            `version` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
                            `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
                            `updated_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_user_currency` (`user_id`, `currency`),
                            KEY `idx_currency` (`currency`),
                            CONSTRAINT `fk_account_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户资产账户';

-- ----------------------------
-- 3、用户资金流水表
-- ----------------------------

CREATE TABLE `transactions` (
                                `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '流水ID',
                                `tx_id` CHAR(36) NOT NULL COMMENT '全局唯一交易ID(UUID)',
                                `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
                                `account_id` BIGINT UNSIGNED NOT NULL COMMENT '账户ID',
                                `type` ENUM('DEPOSIT','WITHDRAW','TRADE_BUY','TRADE_SELL','FEE','TRANSFER') NOT NULL COMMENT '交易类型',
                                `currency` VARCHAR(10) NOT NULL COMMENT '币种',
                                `amount` DECIMAL(36,18) NOT NULL COMMENT '金额',
                                `balance_after` DECIMAL(36,18) NOT NULL COMMENT '操作后余额',
                                `related_order_id` CHAR(36) DEFAULT NULL COMMENT '关联订单ID',
                                `description` VARCHAR(255) DEFAULT NULL COMMENT '描述',
                                `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `idx_tx_id` (`tx_id`),
                                KEY `idx_user_type` (`user_id`,`type`),
                                KEY `idx_created_at` (`created_at`),
                                CONSTRAINT `fk_tx_account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
                                CONSTRAINT `fk_tx_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资金流水表';


-- ----------------------------
-- 4、用户订单表
-- ----------------------------

CREATE TABLE `orders` (
                          `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                          `order_id` CHAR(36) NOT NULL COMMENT '订单ID(UUID)',
                          `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
                          `symbol` VARCHAR(20) NOT NULL COMMENT '交易对(BTCUSDT)',
                          `type` ENUM('LIMIT','MARKET','STOP_LIMIT') NOT NULL COMMENT '订单类型',
                          `side` ENUM('BUY','SELL') NOT NULL COMMENT '买卖方向',
                          `price` DECIMAL(36,18) DEFAULT NULL COMMENT '价格(MARKET单为空)',
                          `quantity` DECIMAL(36,18) NOT NULL COMMENT '数量',
                          `filled_quantity` DECIMAL(36,18) NOT NULL DEFAULT 0.000000000000000000 COMMENT '已成交数量',
                          `avg_price` DECIMAL(36,18) DEFAULT NULL COMMENT '平均成交价',
                          `status` ENUM('NEW','PARTIALLY_FILLED','FILLED','CANCELED','REJECTED') NOT NULL DEFAULT 'NEW' COMMENT '订单状态',
                          `time_in_force` ENUM('GTC','IOC','FOK') NOT NULL DEFAULT 'GTC' COMMENT '时效策略',
                          `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
                          `updated_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `idx_order_id` (`order_id`),
                          KEY `idx_user_symbol` (`user_id`,`symbol`),
                          KEY `idx_symbol_status` (`symbol`,`status`),
                          KEY `idx_created_at` (`created_at`),
                          CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单主表';


-- ----------------------------
-- 5、订单历史表
-- ----------------------------

CREATE TABLE `order_history` (
                                 `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                 `order_id` CHAR(36) NOT NULL COMMENT '订单ID',
                                 `event_type` ENUM('CREATED','UPDATED','CANCELED','FILLED') NOT NULL COMMENT '事件类型',
                                 `event_data` JSON NOT NULL COMMENT '事件数据快照',
                                 `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '事件时间',
                                 PRIMARY KEY (`id`),
                                 KEY `idx_order_id` (`order_id`),
                                 KEY `idx_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单变更历史';

-- ----------------------------
-- 5、成交记录表
-- ----------------------------

CREATE TABLE `trades` (
                          `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                          `trade_id` CHAR(36) NOT NULL COMMENT '成交ID(UUID)',
                          `symbol` VARCHAR(20) NOT NULL COMMENT '交易对',
                          `taker_order_id` CHAR(36) NOT NULL COMMENT 'Taker订单ID',
                          `maker_order_id` CHAR(36) NOT NULL COMMENT 'Maker订单ID',
                          `price` DECIMAL(36,18) NOT NULL COMMENT '成交价格',
                          `quantity` DECIMAL(36,18) NOT NULL COMMENT '成交数量',
                          `taker_side` ENUM('BUY','SELL') NOT NULL COMMENT 'Taker方向',
                          `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '成交时间',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `idx_trade_id` (`trade_id`),
                          KEY `idx_symbol_time` (`symbol`,`created_at`),
                          KEY `idx_taker_order` (`taker_order_id`),
                          KEY `idx_maker_order` (`maker_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='成交记录表';