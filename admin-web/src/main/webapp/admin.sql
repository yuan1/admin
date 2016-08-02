/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-08-02 21:18:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_department
-- ----------------------------
DROP TABLE IF EXISTS `admin_department`;
CREATE TABLE `admin_department` (
  `DEPARTMENT_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `NAME_EN` varchar(50) DEFAULT NULL COMMENT '英文',
  `BIANMA` varchar(50) DEFAULT NULL COMMENT '编码',
  `PARENT_ID` varchar(100) DEFAULT NULL COMMENT '上级ID',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `HEADMAN` varchar(30) DEFAULT NULL COMMENT '负责人',
  `TEL` varchar(50) DEFAULT NULL COMMENT '电话',
  `FUNCTIONS` varchar(255) DEFAULT NULL COMMENT '部门职能',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_department
-- ----------------------------
INSERT INTO `admin_department` VALUES ('0956d8c279274fca92f4091f2a69a9ad', '销售会计', 'xiaokuai', '05896', 'd41af567914a409893d011aa53eda797', '', '', '', '', '');
INSERT INTO `admin_department` VALUES ('3e7227e11dc14b4d9e863dd1a1fcedf6', '成本会计', 'chengb', '03656', 'd41af567914a409893d011aa53eda797', '', '', '', '', '');
INSERT INTO `admin_department` VALUES ('5cccdb7c432449d8b853c52880058140', 'B公司', 'b', '002', '0', '冶铁', '李四', '112', '冶铁', '河北');
INSERT INTO `admin_department` VALUES ('83a25761c618457cae2fa1211bd8696d', '销售B组', 'xiaob', '002365', 'cbbc84eddde947ba8af7d509e430eb70', '', '李四', '', '', '');
INSERT INTO `admin_department` VALUES ('8f8b045470f342fdbc4c312ab881d62b', '销售A组', 'xiaoA', '0326', 'cbbc84eddde947ba8af7d509e430eb70', '', '张三', '0201212', '', '');
INSERT INTO `admin_department` VALUES ('a0982dea52554225ab682cd4b421de47', '1队', 'yidui', '02563', '8f8b045470f342fdbc4c312ab881d62b', '', '小王', '12356989', '', '');
INSERT INTO `admin_department` VALUES ('a6c6695217ba4a4dbfe9f7e9d2c06730', 'A公司', 'a', '001', '0', '挖煤', '张三', '110', '洼煤矿', '山西');
INSERT INTO `admin_department` VALUES ('cbbc84eddde947ba8af7d509e430eb70', '销售部', 'xiaoshoubu', '00201', '5cccdb7c432449d8b853c52880058140', '推销商品', '小明', '11236', '推销商品', '909办公室');
INSERT INTO `admin_department` VALUES ('d41af567914a409893d011aa53eda797', '财务部', 'caiwubu', '00101', 'a6c6695217ba4a4dbfe9f7e9d2c06730', '负责发工资', '王武', '11236', '管理财务', '308办公室');

-- ----------------------------
-- Table structure for admin_dict
-- ----------------------------
DROP TABLE IF EXISTS `admin_dict`;
CREATE TABLE `admin_dict` (
  `id` int(11) DEFAULT NULL,
  `dict_id` int(11) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_dict
-- ----------------------------

-- ----------------------------
-- Table structure for admin_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `admin_dictionary`;
CREATE TABLE `admin_dictionary` (
  `DICTIONARIES_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `NAME_EN` varchar(50) DEFAULT NULL COMMENT '英文',
  `BIANMA` varchar(50) DEFAULT NULL COMMENT '编码',
  `ORDER_BY` int(11) NOT NULL COMMENT '排序',
  `PARENT_ID` varchar(100) DEFAULT NULL COMMENT '上级ID',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TBSNAME` varchar(100) DEFAULT NULL COMMENT '排查表',
  PRIMARY KEY (`DICTIONARIES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_dictionary
-- ----------------------------
INSERT INTO `admin_dictionary` VALUES ('096e4ec8986149d994b09e604504e38d', '黄浦区', 'huangpu', '0030201', '1', 'f1ea30ddef1340609c35c88fb2919bee', '黄埔', '');
INSERT INTO `admin_dictionary` VALUES ('12a62a3e5bed44bba0412b7e6b733c93', '北京', 'beijing', '00301', '1', 'be4a8c5182c744d28282a5345783a77f', '北京', '');
INSERT INTO `admin_dictionary` VALUES ('507fa87a49104c7c8cdb52fdb297da12', '宣武区', 'xuanwuqu', '0030101', '1', '12a62a3e5bed44bba0412b7e6b733c93', '宣武区', '');
INSERT INTO `admin_dictionary` VALUES ('8994f5995f474e2dba6cfbcdfe5ea07a', '语文', 'yuwen', '00201', '1', 'fce20eb06d7b4b4d8f200eda623f725c', '语文', '');
INSERT INTO `admin_dictionary` VALUES ('8ea7c44af25f48b993a14f791c8d689f', '分类', 'fenlei', '001', '1', '0', '分类', '');
INSERT INTO `admin_dictionary` VALUES ('be4a8c5182c744d28282a5345783a77f', '地区', 'diqu', '003', '3', '0', '地区', '');
INSERT INTO `admin_dictionary` VALUES ('d428594b0494476aa7338d9061e23ae3', '红色', 'red', '00101', '1', '8ea7c44af25f48b993a14f791c8d689f', '红色', '');
INSERT INTO `admin_dictionary` VALUES ('de9afadfbed0428fa343704d6acce2c4', '绿色', 'green', '00102', '2', '8ea7c44af25f48b993a14f791c8d689f', '绿色', '');
INSERT INTO `admin_dictionary` VALUES ('f1ea30ddef1340609c35c88fb2919bee', '上海', 'shanghai', '00302', '2', 'be4a8c5182c744d28282a5345783a77f', '上海', '');
INSERT INTO `admin_dictionary` VALUES ('fce20eb06d7b4b4d8f200eda623f725c', '课程', 'kecheng', '002', '2', '0', '课程', '');

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
INSERT INTO `admin_menu` VALUES ('39', '按钮管理', 'system/button/', '1', '4', 'menu-icon fa fa-download orange', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('40', '其他管理', '#', '0', '2', 'menu-icon fa fa-users blue', '2', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('41', '用户管理', '/admin/user/list.do', '1', '1', 'menu-icon fa fa-users green', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('42', '会员管理', 'happuser/listUsers.do', '40', '2', 'menu-icon fa fa-users orange', '1', '1', null, null, null, null);
INSERT INTO `admin_menu` VALUES ('43', '数据字典', 'system/dictionary/', '1', '4', 'menu-icon fa fa-book purple', '1', '1', null, null, null, null);
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
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '系统管理组', '2251798773489606', '0', '1', '1', '1', '1');
INSERT INTO `admin_role` VALUES ('115b386ff04f4352b060dffcd2b5d1da', '中级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('1b67fc82ce89457a8347ae53e43a347e', '初级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('2', '会员组', '498', '0', '0', '0', '0', '1');
INSERT INTO `admin_role` VALUES ('3264c8e83d0248bb9e3ea6195b4c0216', '一级管理员', '2251798773489606', '1', '2251798773489606', '2251798773489606', '1125898866646982', '2251798773489606');
INSERT INTO `admin_role` VALUES ('46294b31a71c4600801724a6eb06bb26', '职位组', '', '0', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('5466347ac07044cb8d82990ec7f3a90e', '主管', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('68f8e4a39efe47c7bb869e9d15ab925d', '二级管理员', '2251798773489606', '1', '0', '0', '2251798773489606', '0');
INSERT INTO `admin_role` VALUES ('856849f422774ad390a4e564054d8cc8', '经理', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('8b70a7e67f2841e7aaba8a4d92e5ff6f', '高级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('c21cecf84048434b93383182b1d98cba', '组长', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('d449195cd8e7491080688c58e11452eb', '总监', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `admin_role` VALUES ('de9de2f006e145a29d52dfadda295353', '三级管理员', '2251798773489606', '1', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(15) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', '系统管理员', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2016-07-02 23:03:48', '0:0:0:0:0:0:0:1', '0', '最高统治者', 'default', 'QQ313596790@main.com', '001', '18788888888');
INSERT INTO `admin_user` VALUES ('69177258a06e4927b4639ab1684c3320', 'san', '47c4a8dc64ac2f0bb46bbd8813b037c9718f9349', '三', '', '3264c8e83d0248bb9e3ea6195b4c0216', '2016-01-25 16:25:36', '192.168.1.102', '0', '111', 'default', '978336446@qq.com', '333', '13562202556');
INSERT INTO `admin_user` VALUES ('9991f4d7782a4ccfb8a65bd96ea7aafa', 'lisi', '2612ade71c1e48cd7150b5f4df152faa699cedfe', '李四', '', '3264c8e83d0248bb9e3ea6195b4c0216', '2016-01-06 01:24:26', '127.0.0.1', '0', '小李', 'default', '313596790@qq.com', '1102', '13566233663');
INSERT INTO `admin_user` VALUES ('e29149962e944589bb7da23ad18ddeed', 'zhangsan', 'c2da1419caf053885c492e10ebde421581cdc03f', '张三', '', '3264c8e83d0248bb9e3ea6195b4c0216', '', '', '0', '小张', 'default', 'zhangsan@www.com', '1101', '2147483647');

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
