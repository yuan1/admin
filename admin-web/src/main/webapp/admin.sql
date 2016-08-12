/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-08-11 22:11:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_department
-- ----------------------------
DROP TABLE IF EXISTS `admin_department`;
CREATE TABLE `admin_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `depart_id` bigint(20) DEFAULT NULL,
  `depart_name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_department
-- ----------------------------

-- ----------------------------
-- Table structure for admin_dict
-- ----------------------------
DROP TABLE IF EXISTS `admin_dict`;
CREATE TABLE `admin_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_id` int(11) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_dict
-- ----------------------------

-- ----------------------------
-- Table structure for admin_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `admin_dictionary`;
CREATE TABLE `admin_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_id` bigint(20) DEFAULT NULL COMMENT '名称',
  `dic_name` varchar(100) DEFAULT NULL COMMENT '英文',
  `dic_value` varchar(50) DEFAULT NULL COMMENT '编码',
  `dic_id` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '上级ID',
  `create_by` bigint(20) DEFAULT NULL COMMENT '备注',
  `update_by` bigint(20) DEFAULT NULL COMMENT '排查表',
  `update_time` datetime DEFAULT NULL,
  `yn` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` bigint(20) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `parent_id` varchar(100) DEFAULT NULL,
  `menu_order` varchar(100) DEFAULT NULL,
  `menu_icon` varchar(60) DEFAULT NULL,
  `menu_type` tinyint(10) DEFAULT NULL,
  `yn` int(1) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES ('1', '系统管理', '#', '0', '1', 'menu-icon fa fa-desktop blue', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('2', '角色管理', 'system/role/', '1', '2', 'menu-icon fa fa-lock black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('6', '信息管理', '#', '0', '5', 'menu-icon fa fa-credit-card green', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('7', '图片管理', 'pictures/list.do', '6', '1', 'menu-icon fa fa-folder-o pink', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('8', '性能监控', 'druid/index.html', '9', '1', 'menu-icon fa fa-tachometer red', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('9', '系统工具', '#', '0', '3', 'menu-icon fa fa-cog black', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('10', '接口测试', 'tool/interfaceTest.do', '9', '2', 'menu-icon fa fa-exchange green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('11', '发送邮件', 'tool/goSendEmail.do', '9', '3', 'menu-icon fa fa-envelope-o green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('12', '置二维码', 'tool/goTwoDimensionCode.do', '9', '4', 'menu-icon fa fa-barcode green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('14', '地图工具', 'tool/map.do', '9', '6', 'menu-icon fa fa-globe black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('15', '微信管理', '#', '0', '4', 'menu-icon fa fa-comments purple', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('16', '文本回复', 'textmsg/list.do', '15', '2', 'menu-icon fa fa-comment green', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('17', '应用命令', 'command/list.do', '15', '4', 'menu-icon fa fa-comment grey', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('18', '图文回复', 'imgmsg/list.do', '15', '3', 'menu-icon fa fa-comment pink', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('19', '关注回复', 'textmsg/goSubscribe.do', '15', '1', 'menu-icon fa fa-comment orange', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('20', '在线管理', 'onlinemanager/list.do', '1', '6', 'menu-icon fa fa-laptop green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('21', '打印测试', 'tool/printTest.do', '9', '7', 'menu-icon fa fa-hdd-o grey', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('22', '一级菜单', '#', '0', '6', 'menu-icon fa fa-fire orange', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('23', '二级菜单', '#', '22', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('24', '三级菜单', '#', '23', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('30', '四级菜单', '#', '24', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('31', '五级菜单1', '#', '30', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('32', '五级菜单2', '#', '30', '2', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('33', '六级菜单', '#', '31', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('34', '六级菜单2', 'login_default.do', '31', '2', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('35', '四级菜单2', 'login_default.do', '24', '2', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('36', '角色(基础权限)', 'role.do', '2', '1', 'menu-icon fa fa-key orange', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('37', '按钮权限', 'buttonrights/list.do', '2', '2', 'menu-icon fa fa-key green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('38', '菜单管理', '/admin/menu/list.do', '1', '3', 'menu-icon fa fa-folder-open-o brown', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('39', '字典类型', '/admin/dict/list.do', '1', '4', 'menu-icon fa fa-download orange', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('40', '其他管理', '#', '0', '2', 'menu-icon fa fa-users blue', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('41', '用户管理', '/admin/user/list.do', '1', '1', 'menu-icon fa fa-users green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('42', '会员管理', 'happuser/listUsers.do', '40', '2', 'menu-icon fa fa-users orange', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('43', '数据字典', '/admin/dictary/list.do', '1', '4', 'menu-icon fa fa-book purple', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('44', '代码生成', 'createCode/list.do', '9', '0', 'menu-icon fa fa-cogs brown', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('45', '七级菜单1', '#', '33', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('46', '七级菜单2', '#', '33', '2', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('47', '八级菜单', 'login_default.do', '45', '1', 'menu-icon fa fa-leaf black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('48', '图表报表', ' tool/fusionchartsdemo.do', '9', '5', 'menu-icon fa fa-bar-chart-o black', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('49', '组织机构', 'system/org/', '1', '5', 'menu-icon fa fa-users blue', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('50', '站内信', 'fhsms/list.do', '6', '2', 'menu-icon fa fa-envelope green', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for admin_parameter
-- ----------------------------
DROP TABLE IF EXISTS `admin_parameter`;
CREATE TABLE `admin_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(255) DEFAULT NULL,
  `param_value` varchar(255) DEFAULT NULL,
  `param_type` tinyint(1) DEFAULT NULL COMMENT '1系统参数2业务参数',
  `note` varchar(255) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(128) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user_status` tinyint(1) unsigned zerofill DEFAULT '1' COMMENT '1正常 2 禁用',
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `yn` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', '11', null, '122', '12', '11', '1', '2016-08-05 20:53:55', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('2', '222', null, '22', '22', '222', '1', '2016-08-05 20:55:32', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('3', '333', null, '333', '333', '333', '1', '2016-08-05 20:56:26', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('4', '444', null, '44', '444', '44', '1', '2016-08-05 20:57:13', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('5', '55', null, '55', '55', '55', '1', '2016-08-05 20:57:42', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('6', '123', null, '3123123', '123213', '21312312', '1', '2016-08-05 20:59:00', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('7', 'ccc', null, '3213', 'sadf314123', '21312', '1', '2016-08-05 20:59:11', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('8', '1111', null, '23', '111', '12', '1', '2016-08-05 20:59:19', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('9', 'cc', null, '213', 'cc', '213', '1', '2016-08-05 21:00:36', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('10', '21321', null, '3123', '321', '3213', '1', '2016-08-05 21:00:58', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('11', 'ccc', null, 'ccc', 'ccc', 'cc', '1', '2016-08-05 21:01:03', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('12', '111', null, '66', '3', '5435', '1', '2016-08-05 21:01:10', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('13', '11', null, '455', '123213', '231312', '1', '2016-08-05 21:01:15', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('14', '111', null, '1111', '111', '111', '1', '2016-08-05 21:01:20', '1', null, null, '1');
INSERT INTO `admin_user` VALUES ('15', 'fang', null, 'fangli123', 'fangl', 'fangli', '1', '2016-08-05 21:01:28', '1', null, null, '1');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `yn` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for weixin_message
-- ----------------------------
DROP TABLE IF EXISTS `weixin_message`;
CREATE TABLE `weixin_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(300) DEFAULT NULL COMMENT '昵称',
  `head_img_url` varchar(300) DEFAULT NULL COMMENT '微信头像ur',
  `content` text COMMENT '回复的消息',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_message
-- ----------------------------

-- ----------------------------
-- Table structure for weixin_token
-- ----------------------------
DROP TABLE IF EXISTS `weixin_token`;
CREATE TABLE `weixin_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(200) DEFAULT NULL COMMENT 'access_token',
  `expires_in` int(4) DEFAULT NULL COMMENT '过期时间（秒）',
  `token_time` timestamp NULL DEFAULT NULL COMMENT '获取token的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_token
-- ----------------------------
