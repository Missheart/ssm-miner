
DROP TABLE IF EXISTS contract;
CREATE TABLE contract /*矿机租赁合约表*/
(
  id             BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  user_id        BIGINT                              NOT NULL, /*矿机租赁合约用户 ID */
  order_id       BIGINT                              NOT NULL, /*矿机租赁合约订单 ID */
  machine_id     BIGINT                              NOT NULL, /*矿机租赁合约订单 ID */
  quantity       Integer                             NOT NULL, /*矿机租赁合约订单 ID */
  start_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*矿机租赁合约开始执行时间 */
  end_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*矿机租赁合约结束执行时间 */
  deposit        DECIMAL(36,10)                             NULL, /*矿机租赁合约押金 */
  contract_state INT                                 NULL, /*矿机租赁合约状态  OTHER(0, "OTHER"),WAITING(1, "WAITING"),RUNNING(2, "RUNNING"),EXPIRE(3, "EXPIRE"),DELETE(4, "DELETE"); */
  created        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE contract
  ADD INDEX idx_user_id(user_id);
ALTER TABLE contract
  ADD INDEX idx_order_id(order_id);
ALTER TABLE contract
  ADD INDEX idx_machine_id(machine_id);


DROP TABLE IF EXISTS goods_category;
CREATE TABLE goods_category /*商品分类表*/
(
  id            BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  category_name VARCHAR(128)                        NOT NULL, /*商品分类名称*/
  parent        BIGINT DEFAULT '0'                  NOT NULL, /*父级商品分类*/
  idx           INT DEFAULT '0'                     NULL, /*商品分类显示排序，值大优先*/
  created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


DROP TABLE IF EXISTS machine;
CREATE TABLE machine   /*共享矿机（商品）信息表，注意，同一个ID的共享矿机的数量可能有很多，可以理解为一类共享矿机（商品）*/
(
  id             BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  machine_name   VARCHAR(256)                        NOT NULL, /*共享矿机（商品）名称*/
  category_id    BIGINT                              NULL, /*共享矿机（商品）分类*/
  original_price DECIMAL(36,10)                             NULL, /*共享矿机（商品）原价*/
  current_price  DECIMAL(36,10)                             NULL, /*共享矿机（商品）现价*/
  currency_type  INT                                 NULL, /*共享矿机挖矿币种 OTHER(0, "OTHER"),BTC(1, "BTC"),ETH(2, "ETH"),RMB(3, "RMB");*/
  icon           VARCHAR(20)                         NULL, /*共享矿机（商品）icon */
  pic_uri        TEXT                                NULL, /*共享矿机（商品）展示图片，逗号分隔的uri */
  machine_state  INT                                 NULL, /*共享矿机（商品）状态 OTHER(0, "OTHER"),OPEN(1, "OPEN"),CLOSED(2, "CLOSED"); */
  description    TEXT                                NULL, /*共享矿机（商品）描述信息（商品详情）*/
  loan_limit     INT                                 NULL, /*共享矿机（商品）最大台数限制 */
  compute_share  FLOAT                               NULL, /*共享矿机（商品）算力 */
  contract_span  INT                                 NULL, /*共享矿机（商品）最小租期限制 */
  miner_id       BIGINT                              NOT NULL, /*共享矿机（商品）所属的物理矿机 */
  created        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE machine
  ADD INDEX idx_miner_id(miner_id);


DROP TABLE IF EXISTS miner;
CREATE TABLE miner /*物理矿机信息表（B 端资产）*/
(
  id            BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  miner_name    VARCHAR(256)                        NULL, /*物理矿机名称*/
  total_compute INT                                 NULL, /*物理矿机总算力*/
  description   TEXT                                NULL, /*物理矿机描述信息*/
  created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


DROP TABLE IF EXISTS miner_log;
CREATE TABLE miner_log /*物理矿机挖矿日志*/
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  machine_id  BIGINT                              NULL, /*共享矿机 ID*/
  contract_id BIGINT                              NULL, /*共享矿机租赁合约 ID*/
  miner_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*挖矿日期*/
  profit      DECIMAL                             NULL, /*物理矿机总利润*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE miner_log
  ADD INDEX idx_machine_id(machine_id);
ALTER TABLE miner_log
  ADD INDEX idx_contract_id(contract_id);


DROP TABLE IF EXISTS orders;
CREATE TABLE orders /*共享矿机租赁订单*/
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  total_price DECIMAL(36,10)                             NOT NULL, /*订单总价格*/
  order_state INT DEFAULT '0'                     NULL, /*订单状态
    OTHER(0, "OTHER"),
    INIT(1, "INIT"),
    PLACED(2, "PLACED"),
    WAITING_PAY(3, "WAITING_PAY"),
    TIME_OUT(9, "TIME_OUT"),
    PAYED(10, "PAYED"),
    DELIVERING(11, "DELIVERING"),
    DEAL(20, "DEAL"),
    RETURN_INIT(30, "RETURN_INIT"),
    RETURN_WAITING_APPROVED(31, "RETURN_WAITING_APPROVED"),
    RETURN_APPROVED(32, "RETURN_APPROVED"),
    RETURN_COMPLETE(33, "RETURN_COMPLETE"),
    CLOSED(40, "CLOSED"),
    DELETE(41, "DELETE");
  */
  user_id     BIGINT                              NOT NULL, /*订单下单人ID*/
  description VARCHAR(512)                        NULL, /*订单备注*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE orders
  ADD INDEX idx_order_state(order_state);
ALTER TABLE orders
  ADD INDEX idx_user_id(user_id);


DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item /*订单项（行），目前默认单行订单，保留扩展能力*/
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  order_id    BIGINT                              NOT NULL, /*所属订单ID*/
  machine_id  BIGINT                              NOT NULL, /*共享矿机ID*/
  quantity    INT DEFAULT '1'                     NULL, /*订单行数量*/
  price       DECIMAL(36,10) DEFAULT '0'                 NULL, /*订单行单价*/
  total_price DECIMAL(36,10) DEFAULT '0'                 NULL, /*订单行合计价格*/
  lease_days  INT DEFAULT '1'                     NULL, /*租期*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE order_item
  ADD INDEX idx_order_id(order_id);
ALTER TABLE order_item
  ADD INDEX idx_machine_id(machine_id);


DROP TABLE IF EXISTS payment;
CREATE TABLE payment /*支付表*/
(
  id             BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  external_id    VARCHAR(128)                        NULL, /*展示ID，不暴露内部支付ID*/
  method         INT DEFAULT '0'                     NULL, /*支付方式*/
  amount         DECIMAL(36,10)                             NULL, /*支付金额*/
  direction      INT DEFAULT '0'                     NULL, /*支付方向 OTHER(0, "OTHER"),IN(1, "IN"),OUT(2, "OUT");*/
  transaction_id BIGINT                              NULL, /*所属交易ID*/
  third_party_id VARCHAR(1024)                       NULL, /*第三方支付流水ID*/
  state          INT                                 NULL, /*支付状态 OTHER(0, "OTHER"),WAITING_PAY(1, "WAITING_PAY"),PAYED(2, "PAYED"),CLOSED(3, "CLOSED"),DELETE(4, "DELETE");*/
  result         VARCHAR(1024)                       NULL, /*支付结果*/
  order_id       BIGINT                              NULL, /*支付的订单ID*/
  created        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


DROP TABLE IF EXISTS stock_record;
CREATE TABLE stock_record /*共享矿机库存表*/
(
  id               BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  machine_id       BIGINT                              NOT NULL, /*共享矿机ID*/
  quantity         INT                                 NULL, /*总数量*/
  locked_in_order  INT                                 NULL, /*订单中锁定的数量*/
  locked_by_system INT                                 NULL, /*系统锁定的数量，保留，未使用*/
  sold             INT                                 NULL, /*已经售卖（租赁）的数量*/
  available        INT                                 NULL, /*可用数量*/
  created          TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated          TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  version          INT       DEFAULT 0                 NOT NULL, /*数据库乐观锁版本号*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE stock_record
  ADD INDEX idx_machine_id(machine_id);

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  external_id VARCHAR(128)                        NULL, /*自增主键*/
  from_id     BIGINT                              NOT NULL, /*源地址*/
  to_id       BIGINT                              NOT NULL, /*目的地址*/
  value       DECIMAL(36,10)                      NULL, /*转账金额*/
  state       INT                                 NULL, /*转账状态 OTHER(0, "OTHER"),INIT(1, "INIT"),LOCKED(2, "LOCKED"),COMPLETE(3, "COMPLETE"),FAIL_BY_SOURCE(4, "FAIL_BY_SOURCE"),FAIL_BY_DEST(5, "FAIL_BY_DEST");*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


ALTER TABLE transactions
  ADD INDEX idx_from_id(from_id);
ALTER TABLE transactions
  ADD INDEX idx_to_id(to_id);

DROP TABLE IF EXISTS users;
CREATE TABLE users /*资产账户表*/
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  nick_name   VARCHAR(64)                         NULL, /*昵称*/
  openid      VARCHAR(256)                        NULL, /*微信OpenID*/
  session_key VARCHAR(256)                        NULL, /*微信SessionKey，保留，未使用*/
  new_user    TINYINT(1)                          NULL, /*是否新用户，营销专用*/
  phone       VARCHAR(64)                         NULL, /*手机号*/
  pwd         VARCHAR(512)                        NULL, /*密码sha256*/
  kyc_info    TEXT                                NULL, /*KYC信息，保留，未使用*/
  avatar_url  TEXT                                NULL, /*头像url*/
  city        VARCHAR(32)                         NULL, /*微信城市*/
  province    VARCHAR(32)                         NULL, /*微信省份*/
  country     VARCHAR(64)                         NULL, /*微信国家*/
  lang        VARCHAR(32)                         NULL, /*微信语言*/
  gender      INT                                 NULL, /*微信性别*/
  token       VARCHAR(256)                        NULL, /*微信Token*/
  wallet_id   BIGINT                              NULL, /*用户钱包 ID*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  bank_account varchar(50) DEFAULT NULL,                /*记录用户银行账号*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE users
  ADD INDEX idx_phone(phone);


DROP TABLE IF EXISTS user_account;
CREATE TABLE user_account /*资产账户表*/
(
  id            BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  currency_type INT                                 NULL, /*资产账户币种*/
  balance       DECIMAL(36,10)                             NULL, /*资产账户余额*/
  address       VARCHAR(256)                        NULL, /*资产账户数字货币提币地址*/
  wallet_id      BIGINT                              NOT NULL, /*资产账户所属账户 ID*/
  created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE user_account
  ADD INDEX idx_wallet_id(wallet_id);


DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet /*钱包表*/
(
  id       BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  owner_id BIGINT                              NOT NULL, /*主人User ID*/
  created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE wallet
  ADD INDEX idx_owner_id(owner_id);


DROP TABLE IF EXISTS notice;
CREATE TABLE notice /*公告表*/
(
  id                BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  title             VARCHAR(128)                        NOT NULL, /*公告标题*/
  content           TEXT                                NOT NULL, /*公告内容*/
  post_date         TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*公告发布时间*/
  contentStateValue INT DEFAULT '0'                     NULL, /*公告状态 OTHER(0, "OTHER"),RECOMMENDED(1, "RECOMMENDED"),NORMAL(2, "NORMAL"),DELETED(3, "DELETED");*/
  created           TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated           TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


DROP TABLE IF EXISTS banner;
CREATE TABLE banner /*Banner表*/
(
  id                BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  title             VARCHAR(128)                        NOT NULL, /*Banner标题*/
  image             VARCHAR(1024)                       NOT NULL, /*Banner图片 URI*/
  link              VARCHAR(1024)                       NOT NULL, /*Banner外链 URI*/
  post_date         TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*Banner发布时间*/
  content_state_value INT DEFAULT '0'                     NULL, /*公告状态 OTHER(0, "OTHER"),RECOMMENDED(1, "RECOMMENDED"),NORMAL(2, "NORMAL"),DELETED(3, "DELETED");*/
  created           TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated           TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';


DROP TABLE IF EXISTS config;
CREATE TABLE config
(
  id      BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  k       VARCHAR(128)                        NOT NULL, /* key */
  v       TEXT                                NOT NULL, /* value */
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

DROP TABLE IF EXISTS contract_profit;
CREATE TABLE contract_profit /*合约收益记录*/
(
  id          BIGINT AUTO_INCREMENT PRIMARY KEY, /*自增主键*/
  contract_id BIGINT                              NULL, /*共享矿机租赁合约 ID*/
  machine_id  BIGINT                              NOT NULL, /*共享矿机ID*/
  quantity    INT                                 NULL, /*本合约订单中租赁的machine_id这类共享矿机的总数量*/
  miner_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, /*挖矿日期*/
  profit      DECIMAL(36,10)                             NULL, /*物理矿机总利润*/
  created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录创建时间*/
  updated     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL, /*记录修改时间*/
  CONSTRAINT uniq_id UNIQUE (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET 'utf8';

ALTER TABLE contract_profit
  ADD INDEX idx_contract_id(contract_id);
  
-- 2018-06-04
-- 管理员表
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `nickname` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(10) NOT NULL DEFAULT '' COMMENT '盐',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `supper_master` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为超级管理员：0-否，1-是',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可用：0-不可用，1-可用',
  `create_time` int(10) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `last_login_time` int(10) NOT NULL DEFAULT '0' COMMENT '上次登陆时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '0', '慢慢', 'mine', '11fa0081096f48bf8c9e2fc6fc10b0d0', '6609', '15928803350', '1', '1', '0', '1527730771');

-- 管理员角色表 
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(64) NOT NULL DEFAULT '' COMMENT '角色',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '角色描述',
  `auth_access` text NOT NULL COMMENT '权限',
  `create_time` int(10) NOT NULL,
  `update_time` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员角色';

-- 优惠券表（运营需求，待java使用确定）
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `discount` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '折扣力度',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单ID',
  `state` int(10) NOT NULL DEFAULT '0' COMMENT '优惠券状态（0-未使用，1-订单锁定，2-已使用，3-已过期）',
  `user_time` timestamp NULL DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `isremove` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除（0-未删除， 1-已删除）',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;