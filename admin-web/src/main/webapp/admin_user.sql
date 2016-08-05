/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-08-05 21:02:43
*/

SET FOREIGN_KEY_CHECKS=0;

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
