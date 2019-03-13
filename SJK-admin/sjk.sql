/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : sjk

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2019-03-13 13:30:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_dict
-- ----------------------------
DROP TABLE IF EXISTS `system_dict`;
CREATE TABLE `system_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_type` varchar(30) DEFAULT NULL COMMENT '字典类别',
  `dict_type_name` varchar(30) DEFAULT NULL COMMENT '字典类别名称',
  `dict_name` varchar(30) DEFAULT NULL COMMENT '字典名称',
  `dict_code` varchar(15) DEFAULT NULL COMMENT '字典代码',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类',
  `order_id` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='系统字典';

-- ----------------------------
-- Records of system_dict
-- ----------------------------
INSERT INTO `system_dict` VALUES ('1', 'SEX', '性别', '男', '1', '1', null, null, '1', '2015-08-24 10:27:10');
INSERT INTO `system_dict` VALUES ('2', 'SEX', '性别', '女', '0', '1', null, null, '2', '2015-08-24 10:27:12');
INSERT INTO `system_dict` VALUES ('5', 'CARD', '证件类型', '港澳通行证', '2', '1', null, null, null, null);
INSERT INTO `system_dict` VALUES ('6', 'MARITAL_STATUS', '婚姻状况', '已婚', '1', '1', null, null, null, '2018-10-30 16:39:52');
INSERT INTO `system_dict` VALUES ('7', 'MARITAL_STATUS', '婚姻状况', '未婚', '0', '1', null, null, null, '2018-10-30 16:41:05');
INSERT INTO `system_dict` VALUES ('8', 'CUSTOMER_STATUS', '客户状态', '启用', '2', '1', null, null, null, '2018-10-30 16:42:25');
INSERT INTO `system_dict` VALUES ('9', 'CUSTOMER_STATUS', '客户状态', '停用', '1', '1', null, null, null, '2018-10-30 16:42:31');
INSERT INTO `system_dict` VALUES ('10', 'CHANNEL', '注册渠道', '通汇宝', 'THB', '1', null, null, null, '2018-10-30 16:43:38');
INSERT INTO `system_dict` VALUES ('11', 'CHANNEL', '注册渠道', '汇中网', 'HZW', '1', null, null, null, '2018-10-30 16:44:02');
INSERT INTO `system_dict` VALUES ('12', 'CHANNEL', '注册渠道', '汇中贷', 'HZD', '1', null, null, null, '2018-10-30 16:44:28');
INSERT INTO `system_dict` VALUES ('13', 'BANK', '银行', '中国银行', '1', '1', null, null, null, '2018-11-01 10:39:06');
INSERT INTO `system_dict` VALUES ('14', 'BANK', '银行', '农业银行', '2', '1', null, null, null, null);
INSERT INTO `system_dict` VALUES ('15', 'BANk', '银行', '建设银行', '3', '1', null, null, null, null);
INSERT INTO `system_dict` VALUES ('16', 'BANk', '银行', '浦发银行', '4', '1', null, null, null, null);
INSERT INTO `system_dict` VALUES ('17', 'CARD', '证件类型', '身份证', '1', '1', '', null, null, '2018-11-20 17:21:46');
INSERT INTO `system_dict` VALUES ('18', 'CARD', '证件类型', '护照', '3', '1', '', null, null, '2018-11-20 17:22:18');
INSERT INTO `system_dict` VALUES ('19', 'EMPLOYEE_STATUS', '后台员工状态', '禁用', '3', '1', '', null, null, '2018-11-21 10:40:44');
INSERT INTO `system_dict` VALUES ('20', 'MENU_STATUS', '菜单状态', '正常', '1', '1', '', null, null, '2018-11-21 10:40:46');
INSERT INTO `system_dict` VALUES ('21', 'MENU_STATUS', '菜单状态', '禁用', '2', '1', '', null, null, '2018-11-21 10:40:47');
INSERT INTO `system_dict` VALUES ('22', 'MENU_STATUS', '菜单状态', '删除', '3', '1', '', null, null, '2018-11-21 10:40:49');
INSERT INTO `system_dict` VALUES ('23', 'ACCOUNT_STATUS', '现金账户状态', '异常', '0', '1', '', null, null, '2018-11-21 10:40:51');
INSERT INTO `system_dict` VALUES ('24', 'ACCOUNT_STATUS', '现金账户状态', '正常', '1', '1', '', null, null, '2018-11-21 10:35:28');
INSERT INTO `system_dict` VALUES ('25', 'EMPLOYEE_STATUS', '后台员工状态', '正常', '1', '1', '', null, null, '2018-11-21 10:40:40');
INSERT INTO `system_dict` VALUES ('26', 'EMPLOYEE_STATUS', '后台员工状态', '删除', '2', '1', '', null, null, '2018-11-21 10:40:42');
INSERT INTO `system_dict` VALUES ('27', 'TRANS_STATUS', '现金账户交易状态', '失败', '3', '1', '', null, null, '2018-11-21 10:52:43');
INSERT INTO `system_dict` VALUES ('28', 'TRANS_STATUS', '现金账户交易状态', '处理中', '1', '1', '', null, null, '2018-11-21 10:47:06');
INSERT INTO `system_dict` VALUES ('29', 'DETAIL_TYPE', '现金账户明细类别', '充值', '1', '1', '', null, null, '2018-11-21 10:48:27');
INSERT INTO `system_dict` VALUES ('30', 'DETAIL_TYPE', '现金账户明细类别', '提现', '2', '1', '', null, null, '2018-11-21 10:48:27');
INSERT INTO `system_dict` VALUES ('31', 'DETAIL_TYPE', '现金账户明细类别', '出借', '3', '1', '', null, null, '2018-11-21 10:48:27');
INSERT INTO `system_dict` VALUES ('32', 'DETAIL_TYPE', '现金账户明细类别', '回款', '4', '1', '', null, null, '2018-11-21 10:48:27');
INSERT INTO `system_dict` VALUES ('33', 'DETAIL_TYPE', '现金账户明细类别', '奖励', '5', '1', '', null, null, '2018-11-21 10:48:27');
INSERT INTO `system_dict` VALUES ('34', 'TRANS_STATUS', '现金账户交易状态', '成功', '2', '1', '', null, null, '2018-11-21 10:52:45');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(30) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上一级ID',
  `levels` int(11) DEFAULT NULL COMMENT '部门层级',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '理财咨询事业部', '0', '1', null, '', '2019-03-13 13:29:14', null, '1');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `card_no` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` char(1) DEFAULT NULL COMMENT '性别（参考字典表）',
  `employee_no` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码（默认000000）',
  `salt` varchar(50) DEFAULT NULL COMMENT 'shiro专用',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(30) DEFAULT NULL COMMENT '固定电话',
  `dept_id` int(11) DEFAULT NULL COMMENT '所属部门（最低级别id）',
  `dept_no` varchar(30) DEFAULT NULL COMMENT '当前部门编号',
  `dept_id_one` int(11) DEFAULT NULL COMMENT '所属一级部门',
  `dept_id_two` int(11) DEFAULT NULL COMMENT '所属二级部门',
  `dept_id_three` int(11) DEFAULT NULL COMMENT '所属三级部门',
  `dept_id_four` int(11) DEFAULT NULL COMMENT '所属四级部门',
  `dept_id_five` int(11) DEFAULT NULL COMMENT '所属五级部门',
  `dept_id_six` int(11) DEFAULT NULL COMMENT '所属六级部门',
  `activated_state` char(1) DEFAULT NULL COMMENT '用户状态（1：正常 2：删除 3：禁用）',
  `entry_time` date DEFAULT NULL COMMENT '入职时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', '333', 'admin', '0', 'admin', '110@qq.com', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '13783153333', '010-3333', '1', null, null, null, null, null, null, null, '1', '2018-11-09', null, '2018-08-07 14:58:25', '2018-11-22 00:59:21', '1');
INSERT INTO `t_employee` VALUES ('2', '', 'wang', '0', '201702210001', null, 'e2d8b7a90a19d751fb8610d93a54dbed', 'aacd6b211e8a431faca425731c23592d', '', null, null, null, null, null, null, null, null, null, '1', '2019-03-13', null, '2019-03-13 12:42:38', '2019-03-13 12:42:53', '1');

-- ----------------------------
-- Table structure for t_employee_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_role_relation`;
CREATE TABLE `t_employee_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL COMMENT '商户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COMMENT='员工角色中间表';

-- ----------------------------
-- Records of t_employee_role_relation
-- ----------------------------
INSERT INTO `t_employee_role_relation` VALUES ('164', '1', '1', '2019-03-12 17:33:22', '2019-03-12 17:33:32');

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
  `menu_sort` int(11) DEFAULT NULL COMMENT '排序号',
  `remark` varchar(50) DEFAULT NULL COMMENT '菜单描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator_id` int(11) NOT NULL COMMENT '创建人id',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '', '系统管理', '', 'fa fa-cog', 'userInfo:view', 'menu', '1', '0', '1', '111', '2018-11-20 07:52:58', '1', '2018-11-20 07:52:58');
INSERT INTO `t_menu` VALUES ('2', '', '菜单管理', 'menu/goMenuPage', 'fa fa-th-large', 'menuManager:list', 'menu', '1', '1', '2', '', '2018-03-11 08:52:04', '1', '2018-08-22 14:07:21');
INSERT INTO `t_menu` VALUES ('3', null, '角色管理', 'role/goRolePage', 'fa fa-th-large', 'roleManager:list', 'menu', '1', '1', '3', null, '2018-03-11 08:52:25', '1', '2018-03-11 08:52:29');
INSERT INTO `t_menu` VALUES ('4', null, '员工管理', 'employee/goEmployeePage', 'fa fa-user', 'employeeManager:list', 'menu', '1', '1', '4', null, '2018-03-11 08:56:58', '1', '2018-03-19 15:29:10');
INSERT INTO `t_menu` VALUES ('5', null, '添加菜单', 'menu/saveMenu', null, 'menuManager:add', 'button', '1', '2', null, '菜单管理 - 添加菜单 - 保存按钮', '2018-03-19 09:11:19', '1', '2018-03-19 09:11:27');
INSERT INTO `t_menu` VALUES ('6', null, '修改菜单', 'menu/updateMenu', null, 'menuManager:update', 'button', '1', '2', null, '菜单管理 - 修改菜单 - 保存按钮', '2018-03-19 09:33:10', '1', '2018-03-19 09:33:16');
INSERT INTO `t_menu` VALUES ('7', null, '删除菜单', 'menu/deleteMenu', null, 'menuManager:delete', 'button', '1', '2', null, '菜单管理 - 删除按钮', '2018-03-19 09:34:33', '1', '2018-03-19 09:34:36');
INSERT INTO `t_menu` VALUES ('8', null, '添加角色', 'role/saveRole', null, 'roleManager:add', 'button', '1', '3', null, '角色管理 - 添加角色 - 保存按钮', '2018-03-19 13:56:38', '1', '2018-03-19 13:56:41');
INSERT INTO `t_menu` VALUES ('9', null, '修改角色', 'role/updateRole', null, 'roleManager:update', 'button', '1', '3', null, '角色管理 - 修改角色 - 保存按钮', '2018-03-19 14:47:54', '1', '2018-03-19 14:47:57');
INSERT INTO `t_menu` VALUES ('10', null, '删除角色', 'role/deleteRole', null, 'roleManager:delete', 'button', '1', '3', null, '角色管理 - 删除角色', '2018-03-19 14:53:49', '1', '2018-03-19 14:53:52');
INSERT INTO `t_menu` VALUES ('11', null, '角色授权', 'role/updateRoleAuth', null, 'roleManager:updateRoleAuth', 'button', '1', '3', null, '角色管理 - 点击权限- 保存按钮', '2018-03-20 11:35:42', '1', '2018-03-20 11:35:45');
INSERT INTO `t_menu` VALUES ('12', null, '添加员工', 'employee/saveEmployee', null, 'employeeManager:add', 'button', '1', '4', null, '商户管理 - 添加员工', '2018-03-20 14:59:43', '1', '2018-03-20 14:59:47');
INSERT INTO `t_menu` VALUES ('13', null, '修改员工', 'employee/updateEmployee', null, 'employeeManager:update', 'button', '1', '4', null, '员工管理 - 修改员工 - 保存按钮', '2018-03-20 15:00:41', '1', '2018-03-20 15:00:44');
INSERT INTO `t_menu` VALUES ('14', null, '删除员工', 'employee/deleteEmployee', null, 'employeeManager:delete', 'button', '1', '4', null, '员工管理 - 删除商员工', '2018-03-20 15:01:58', '1', '2018-08-06 15:50:58');
INSERT INTO `t_menu` VALUES ('15', null, '设置角色', 'employee/updateEmployeeRole', null, 'employeeManager:updateRole', 'button', '1', '4', null, '员工管理 - 角色修改 - 保存按钮', '2018-08-08 10:00:11', '1', '2018-08-08 10:00:13');
INSERT INTO `t_menu` VALUES ('16', null, '部门管理', 'dept/goDeptPage', 'fa fa-th-large', 'deptManager:list', 'menu', '1', '1', null, '', '2018-10-23 15:26:42', '1', '2018-10-23 15:26:42');
INSERT INTO `t_menu` VALUES ('18', null, '添加部门', 'dept/saveDept', '', 'departmentManager:add', 'button', '1', '16', null, '', '2018-10-25 15:19:34', '1', '2018-10-25 15:19:34');
INSERT INTO `t_menu` VALUES ('19', null, '修改部门', 'dept/updateDept', '', 'departmentManager:update', 'button', '1', '16', null, '', '2018-10-25 19:30:14', '1', '2018-10-25 19:30:14');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'ROLE_ADMIN', '1', '拥有管理员权限2224444', '1', '2018-03-11 08:31:35', '2018-11-16 06:58:16');

-- ----------------------------
-- Table structure for t_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu_relation`;
CREATE TABLE `t_role_menu_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=931 DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of t_role_menu_relation
-- ----------------------------
INSERT INTO `t_role_menu_relation` VALUES ('912', '1', '1', '1', '2019-03-12 17:34:09', '2019-03-12 17:34:13');
INSERT INTO `t_role_menu_relation` VALUES ('913', '1', '2', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('914', '1', '3', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('915', '1', '4', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('916', '1', '5', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('917', '1', '6', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('918', '1', '7', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('919', '1', '8', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('920', '1', '9', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('921', '1', '10', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('922', '1', '11', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('923', '1', '12', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('924', '1', '13', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('925', '1', '14', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('926', '1', '15', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('927', '1', '16', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('928', '1', '17', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('929', '1', '18', null, null, null);
INSERT INTO `t_role_menu_relation` VALUES ('930', '1', '19', null, null, null);
