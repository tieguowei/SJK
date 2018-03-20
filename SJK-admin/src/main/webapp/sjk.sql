/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : sjk

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-20 17:16:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_agency
-- ----------------------------
DROP TABLE IF EXISTS `t_agency`;
CREATE TABLE `t_agency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '代理人姓名',
  `code` varchar(20) NOT NULL COMMENT '代理人编码（A开头+5位随机码 例如： A98789）',
  `password` varchar(50) NOT NULL COMMENT '代理人登录密码（Md5加密 默认： 000000）',
  `id_card` varchar(20) NOT NULL COMMENT '代理人身份证号码',
  `phone` varchar(20) NOT NULL COMMENT '代理人手机号码',
  `bank_card` varchar(30) DEFAULT NULL COMMENT '代理人银行卡号码',
  `wechat` varchar(50) DEFAULT NULL COMMENT '代理人微信号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二级代理表';

-- ----------------------------
-- Records of t_agency
-- ----------------------------

-- ----------------------------
-- Table structure for t_app_user
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user`;
CREATE TABLE `t_app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '手机号（唯一性约束）',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `openId` varchar(50) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL COMMENT '微信头像路径',
  `account_balance` decimal(20,2) DEFAULT NULL COMMENT '账户余额',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '用户状态(1:正常,2:禁用,3删除)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前台用户表';

-- ----------------------------
-- Records of t_app_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_app_user_address
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user_address`;
CREATE TABLE `t_app_user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `user_address` varchar(100) NOT NULL COMMENT '用户收货地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前台用户地址表';

-- ----------------------------
-- Records of t_app_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '购物车所属用户',
  `merchant_code` varchar(20) NOT NULL COMMENT '购物车所属商户编码',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别id（当id=0时说明是根节点，一级类别）',
  `status` char(1) DEFAULT '1' COMMENT '类别状态（1：正常 2：删除）',
  `name` varchar(50) NOT NULL COMMENT '类别名称',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_commission
-- ----------------------------
DROP TABLE IF EXISTS `t_commission`;
CREATE TABLE `t_commission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agency_num` decimal(20,2) DEFAULT NULL COMMENT '代理人佣金提成比例 存储 3 表示3% 最多保留两位小数',
  `admin_num` decimal(20,2) DEFAULT NULL COMMENT '管理员佣金比例 存储8 表示8% 最多保留两位小数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='佣金设置表';

-- ----------------------------
-- Records of t_commission
-- ----------------------------

-- ----------------------------
-- Table structure for t_deregulation
-- ----------------------------
DROP TABLE IF EXISTS `t_deregulation`;
CREATE TABLE `t_deregulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchat_name` varchar(50) NOT NULL COMMENT '商户名称',
  `merchat_code` varchar(20) NOT NULL COMMENT '商户编码',
  `detail` varchar(255) DEFAULT NULL COMMENT '举报内容',
  `informer_phone` varchar(20) DEFAULT NULL COMMENT '举报人联系电话',
  `user_id` int(11) NOT NULL COMMENT '举报人用户id',
  `status` char(1) NOT NULL COMMENT '处理状态（1：已处理 2：未处理）',
  `amount_deducted` decimal(20,0) DEFAULT NULL COMMENT '每次扣除金额（商户详情表中的总押金要减少相应金额）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `creator_id` int(20) DEFAULT NULL COMMENT '操作人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家违反规定记录表';

-- ----------------------------
-- Records of t_deregulation
-- ----------------------------

-- ----------------------------
-- Table structure for t_headline
-- ----------------------------
DROP TABLE IF EXISTS `t_headline`;
CREATE TABLE `t_headline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '头条滚动字幕内容',
  `status` char(1) NOT NULL COMMENT '状态（1：正常播放 2：关闭本条消息）',
  `merchant_code` varchar(50) DEFAULT NULL COMMENT '商户编码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='头条表';

-- ----------------------------
-- Records of t_headline
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_en` varchar(50) DEFAULT NULL COMMENT '菜单英文名称',
  `name_zh` varchar(50) DEFAULT NULL COMMENT '菜单中文名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `permission` varchar(50) NOT NULL COMMENT '权限标识',
  `menu_type` varchar(20) NOT NULL COMMENT '菜单类型 (button:menu)',
  `menu_status` char(1) NOT NULL COMMENT '菜单状态（1：正常 2：禁用 3：删除）',
  `parent_id` int(11) DEFAULT NULL COMMENT '上一级id',
  `menu_sort` int(11) DEFAULT NULL COMMENT '排序方式',
  `remark` varchar(50) DEFAULT NULL COMMENT '菜单描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator_id` int(11) NOT NULL COMMENT '创建人id',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '', '系统管理', '', 'fa fa-cog', 'userInfo:view', 'menu', '1', '0', '1', null, '2018-03-19 15:10:35', '1', '2018-03-19 15:10:35');
INSERT INTO `t_menu` VALUES ('2', '', '菜单管理', 'menu/goMenuPage', 'fa fa-th-large', 'menuManager:list', 'menu', '1', '1', '2', null, '2018-03-11 08:52:04', '1', '2018-03-11 08:52:08');
INSERT INTO `t_menu` VALUES ('3', null, '角色管理', 'role/goRolePage', 'fa fa-th-large', 'roleManager:list', 'menu', '1', '1', '3', null, '2018-03-11 08:52:25', '1', '2018-03-11 08:52:29');
INSERT INTO `t_menu` VALUES ('4', null, '用户管理', null, 'fa fa-user', 'userInfo:view', 'menu', '1', '1', '4', null, '2018-03-11 08:54:31', '1', '2018-03-11 08:54:35');
INSERT INTO `t_menu` VALUES ('5', null, '商户管理', 'merchant/goMerchantPage', 'fa fa-user', 'merchantManager:list', 'menu', '1', '1', '5', null, '2018-03-11 08:56:58', '1', '2018-03-19 15:29:10');
INSERT INTO `t_menu` VALUES ('6', null, '我的地盘', null, 'fa fa-home', 'userInfo:view', 'menu', '1', '0', '8', null, '2018-03-11 08:57:36', '1', '2018-03-11 08:57:40');
INSERT INTO `t_menu` VALUES ('7', null, '品类管理', null, 'fa fa-th-large', 'userInfo:view', 'menu', '1', '6', '9', null, '2018-03-11 08:58:28', '1', '2018-03-11 08:58:31');
INSERT INTO `t_menu` VALUES ('8', null, '商品管理', null, 'fa fa-th-large', 'userInfo:view', 'menu', '1', '6', '10', null, '2018-03-11 08:59:10', '1', '2018-03-11 08:59:14');
INSERT INTO `t_menu` VALUES ('9', null, '订单管理', null, 'fa fa-globe', 'userInfo:view', 'menu', '1', '6', '11', null, '2018-03-11 09:08:29', '1', '2018-03-11 09:08:42');
INSERT INTO `t_menu` VALUES ('10', null, '经营分析', null, 'fa fa-home', 'userInfo:view', 'menu', '1', '6', '12', null, '2018-03-11 09:10:19', '1', '2018-03-11 09:10:22');
INSERT INTO `t_menu` VALUES ('11', null, '佣金设置', null, 'fa fa-th-large', 'userInfo:view', 'menu', '1', '1', '6', null, '2018-03-11 09:14:59', '1', '2018-03-11 09:15:01');
INSERT INTO `t_menu` VALUES ('12', null, '头条管理', null, 'fa fa-globe', 'userInfo:view', 'menu', '1', '1', '7', null, '2018-03-11 09:15:17', '1', '2018-03-11 09:15:20');
INSERT INTO `t_menu` VALUES ('13', null, '菜单添加', 'menu/saveMenu', null, 'menuManager:add', 'button', '1', '2', null, '菜单管理 - 添加菜单 - 保存按钮', '2018-03-19 09:11:19', '1', '2018-03-19 09:11:27');
INSERT INTO `t_menu` VALUES ('14', null, '菜单修改', 'menu/updateMenu', null, 'menuManager:update', 'button', '1', '2', null, '菜单管理 - 修改菜单 - 保存按钮', '2018-03-19 09:33:10', '1', '2018-03-19 09:33:16');
INSERT INTO `t_menu` VALUES ('15', null, '菜单删除', 'menu/deleteMenu', null, 'menuManager:delete', 'button', '1', '2', null, '菜单管理 - 删除按钮', '2018-03-19 09:34:33', '1', '2018-03-19 09:34:36');
INSERT INTO `t_menu` VALUES ('19', null, '角色添加', 'role/saveRole', null, 'roleManager:add', 'button', '1', '3', null, '角色管理 - 添加角色 - 保存按钮', '2018-03-19 13:56:38', '1', '2018-03-19 13:56:41');
INSERT INTO `t_menu` VALUES ('20', null, '角色修改', 'role/updateRole', null, 'roleManager:update', 'button', '1', '3', null, '角色管理 - 修改角色 - 保存按钮', '2018-03-19 14:47:54', '1', '2018-03-19 14:47:57');
INSERT INTO `t_menu` VALUES ('21', null, '角色删除', 'role/deleteRole', null, 'roleManager:delete', 'button', '1', '3', null, '角色管理 - 删除角色', '2018-03-19 14:53:49', '1', '2018-03-19 14:53:52');
INSERT INTO `t_menu` VALUES ('22', null, '角色授权', 'role/updateRoleAuth', null, 'roleManager:updateRoleAuth', 'button', '1', '3', null, '角色管理 - 点击权限- 保存按钮', '2018-03-20 11:35:42', '1', '2018-03-20 11:35:45');
INSERT INTO `t_menu` VALUES ('25', null, '商户添加', 'merchant/saveMerchant', null, 'merchantManager:add', 'button', '1', '5', null, '商户管理 - 添加商户', '2018-03-20 14:59:43', '1', '2018-03-20 14:59:47');
INSERT INTO `t_menu` VALUES ('26', null, '商户修改', 'merchant/updateMerchant', null, 'merchantManager:update', 'button', '1', '5', null, '商户管理 - 修改商户 - 保存按钮', '2018-03-20 15:00:41', '1', '2018-03-20 15:00:44');
INSERT INTO `t_menu` VALUES ('27', null, '商户删除', 'merchant/deleteMerchant', null, 'merchantManager:delete', 'button', '1', '5', null, '商户管理 - 删除商户 ', '2018-03-20 15:01:58', '1', '2018-03-20 15:02:00');
INSERT INTO `t_menu` VALUES ('28', null, '商户角色', 'merchant/updateRole', null, 'merchantManager:updateRole', 'button', '1', '5', null, '商户管理 - 修改所属角色 - 保存按钮', '2018-03-20 15:10:29', '1', '2018-03-20 15:10:32');

-- ----------------------------
-- Table structure for t_merchant
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_name` varchar(50) DEFAULT NULL COMMENT '商户名称(或者管理员姓名)',
  `merchant_code` varchar(20) NOT NULL COMMENT '商家编码（M+随机五位数：M24675）',
  `password` varchar(50) NOT NULL COMMENT '商户密码（默认000000）',
  `salt` varchar(50) NOT NULL COMMENT 'shiro 需要，通过用户名加salt 确保用户信息更安全',
  `merchant_status` char(1) NOT NULL COMMENT '商户状态（1：正常 2：删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商户表';

-- ----------------------------
-- Records of t_merchant
-- ----------------------------
INSERT INTO `t_merchant` VALUES ('1', '管理员', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '2018-03-11 08:00:31', '2018-03-19 09:16:48');
INSERT INTO `t_merchant` VALUES ('2', '开发商户', 'merchant', '5a89872623d7b339603790201e3673c3', '8d78869f470951332959580424d4bf4f', '1', '2018-03-19 09:18:43', '2018-03-19 09:18:46');

-- ----------------------------
-- Table structure for t_merchant_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant_detail`;
CREATE TABLE `t_merchant_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `merchant_name` varchar(50) NOT NULL COMMENT '商户名称',
  `merchant_code` varchar(20) NOT NULL COMMENT '商户编码',
  `invitation_code` varchar(20) DEFAULT NULL COMMENT '商户邀请码（对应二级代理的账号）',
  `is_commission` char(1) NOT NULL COMMENT '是否开启佣金计算（1：开启 2：未开启）',
  `telephone` varchar(20) DEFAULT NULL COMMENT '商户座机（或者备用手机号码）',
  `operating_status` char(1) NOT NULL COMMENT '营业状态（1：正常 2：休息）',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `opening_time` datetime NOT NULL COMMENT '开始营业时间',
  `close_time` datetime NOT NULL COMMENT '结束营业时间',
  `floor_price` decimal(10,2) DEFAULT NULL COMMENT '起送价',
  `shipping_fee` decimal(10,2) DEFAULT NULL COMMENT '配送费',
  `task_time` varchar(10) DEFAULT NULL COMMENT '大约多长时间送达',
  `is_personage` char(1) NOT NULL COMMENT '是否是个人（1：个人 2：超市）',
  `id_card` varchar(20) NOT NULL COMMENT '商户身份证号码',
  `id_card_url` varchar(100) DEFAULT NULL COMMENT '商户身份证号码正反面图片路径',
  `business_license_url` varchar(100) DEFAULT NULL COMMENT '商户营业执照url',
  `margin` decimal(10,0) DEFAULT NULL COMMENT '保证金剩余金额（初始300）',
  `margin_status` char(1) DEFAULT NULL COMMENT '保证金状态（1：正常 2：已退还 ）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户详情表';

-- ----------------------------
-- Records of t_merchant_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_merchant_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant_role_relation`;
CREATE TABLE `t_merchant_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL COMMENT '商户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商户角色中间表';

-- ----------------------------
-- Records of t_merchant_role_relation
-- ----------------------------
INSERT INTO `t_merchant_role_relation` VALUES ('1', '1', '1', '2018-03-11 09:20:56', '2018-03-11 09:20:59');
INSERT INTO `t_merchant_role_relation` VALUES ('5', '2', '3', '2018-03-20 17:14:44', '2018-03-20 17:14:44');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) NOT NULL COMMENT '订单号（UUID）',
  `user_id` int(11) NOT NULL COMMENT '订单所属用户id',
  `merchant_code` varchar(20) NOT NULL COMMENT '所属商户编码',
  `invitation_code` varchar(20) DEFAULT NULL COMMENT '邀请码',
  `repayment_amount` decimal(20,2) DEFAULT NULL COMMENT '应付金额',
  `actually_money` decimal(20,2) NOT NULL COMMENT '实际支付金额（后期除去红包，优惠等）',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型（1：微信支付2：支付宝支付）',
  `status` char(1) NOT NULL COMMENT '订单状态（1：未付款 2：已付款 3：已发货 4：交易成功 5：删除）',
  `payment_time` datetime NOT NULL COMMENT '支付时间',
  `end_time` datetime NOT NULL COMMENT '交易完成时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `order_no` int(20) NOT NULL COMMENT '订单编号',
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_name` varchar(100) NOT NULL COMMENT '商品名称',
  `product_image_url` varchar(100) DEFAULT NULL COMMENT '商品图片路径',
  `quantity` int(10) NOT NULL COMMENT '商品数量',
  `total_price` decimal(20,2) NOT NULL COMMENT '商品总价单位元 ',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `merchant_code` varchar(20) NOT NULL COMMENT '添加的商品所属哪个商户',
  `product_image_url` varchar(255) NOT NULL COMMENT '商品图片路径',
  `price` decimal(20,2) NOT NULL COMMENT '价格单位-元，保留两位小数',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '原价单位-元，保留两位小数',
  `stock` int(11) DEFAULT NULL COMMENT '库存数量',
  `status` char(1) NOT NULL COMMENT '商品状态（1：在售 2：下架 3：删除）',
  `sold_num` int(100) DEFAULT NULL COMMENT '已售笔数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `role_status` char(1) DEFAULT NULL COMMENT '角色状态（1：正常 2：删除）',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人编号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'ROLE_ADMIN', '1', '拥有管理员权限', '1', '2018-03-11 08:31:35', '2018-03-11 08:31:38');
INSERT INTO `t_role` VALUES ('2', '商户', 'ROLE_MERCHANT', '1', '拥有商户权限', '1', '2018-03-19 09:21:18', '2018-03-19 09:21:21');
INSERT INTO `t_role` VALUES ('3', '开发23', 'ROLE_CODECODE3', '1', '开发人员23', '1', '2018-03-19 14:51:35', '2018-03-19 16:06:41');

-- ----------------------------
-- Table structure for t_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu_relation`;
CREATE TABLE `t_role_menu_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `creator_id` int(11) NOT NULL COMMENT '创建人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of t_role_menu_relation
-- ----------------------------
INSERT INTO `t_role_menu_relation` VALUES ('37', '3', '13', '1', '2018-03-20 11:31:18', '2018-03-20 11:31:18');
INSERT INTO `t_role_menu_relation` VALUES ('66', '2', '1', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('67', '2', '2', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('68', '2', '13', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('69', '2', '14', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('70', '2', '15', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('71', '2', '3', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('72', '2', '4', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('73', '2', '5', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('74', '2', '11', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('75', '2', '12', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('76', '2', '6', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('77', '2', '7', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('78', '2', '8', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('79', '2', '9', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('80', '2', '10', '1', '2018-03-20 11:47:37', '2018-03-20 11:47:37');
INSERT INTO `t_role_menu_relation` VALUES ('81', '1', '1', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('82', '1', '2', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('83', '1', '13', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('84', '1', '14', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('85', '1', '15', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('86', '1', '3', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('87', '1', '19', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('88', '1', '20', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('89', '1', '21', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('90', '1', '22', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('91', '1', '4', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('92', '1', '5', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('93', '1', '11', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('94', '1', '12', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('95', '1', '6', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('96', '1', '7', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('97', '1', '8', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('98', '1', '9', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('99', '1', '10', '1', '2018-03-20 14:16:49', '2018-03-20 14:16:49');
INSERT INTO `t_role_menu_relation` VALUES ('100', '1', '25', '1', '2018-03-20 15:08:29', '2018-03-20 15:08:31');
INSERT INTO `t_role_menu_relation` VALUES ('101', '1', '26', '1', '2018-03-20 15:08:39', '2018-03-20 15:08:41');
INSERT INTO `t_role_menu_relation` VALUES ('102', '1', '27', '1', '2018-03-20 15:08:49', '2018-03-20 15:08:52');
INSERT INTO `t_role_menu_relation` VALUES ('103', '1', '28', '1', '2018-03-20 15:10:47', '2018-03-20 15:10:49');
