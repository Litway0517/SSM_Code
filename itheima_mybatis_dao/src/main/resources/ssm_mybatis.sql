/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : ssm_mybatis

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2022-02-21 14:18:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordertime` date DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='ssm_mybaits数据库是学习MyBatis框架时用的. 所有表都要用到. \r\norder表和user表, 是为了实现一对一查询. 一个订单只隶属于一个用户. \r\n反过来, order表和user表也是一对多查询, 一个用户拥有多个订单. \r\nsys_role, sys_user, sys_user_role三张表格是, 多对多查询时候用的. ';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '2022-02-18', '2089', '3');
INSERT INTO `order` VALUES ('2', '2022-02-22', '5531', '1');
INSERT INTO `order` VALUES ('3', '2022-02-18', '3312', '4');
INSERT INTO `order` VALUES ('4', '2022-02-02', '245', '7');
INSERT INTO `order` VALUES ('5', '2022-02-19', '32', '8');
INSERT INTO `order` VALUES ('6', '2022-02-08', '78', '1');
INSERT INTO `order` VALUES ('7', '2022-02-15', '32', '1');
INSERT INTO `order` VALUES ('8', '2022-02-10', '25', '1');
INSERT INTO `order` VALUES ('9', '2022-02-10', '25', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '院长', '负责全面工作');
INSERT INTO `sys_role` VALUES ('2', '研究员', '课程研发工作');
INSERT INTO `sys_role` VALUES ('3', '讲师', '授课工作');
INSERT INTO `sys_role` VALUES ('4', '助教', '协助解决学生的问题');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zhangsan', '123', '2022-02-23');
INSERT INTO `sys_user` VALUES ('2', 'lisi', '123', '2022-02-03');
INSERT INTO `sys_user` VALUES ('3', 'wangwu', '123', '2022-01-19');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('2', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'lucy', '123');
INSERT INTO `user` VALUES ('4', 'zhangsan', '123');
INSERT INTO `user` VALUES ('5', 'lisi', '123456');
INSERT INTO `user` VALUES ('6', 'wangwu', '123');
INSERT INTO `user` VALUES ('7', 'lit', '39915');
INSERT INTO `user` VALUES ('11', 'lucy', '5678');
INSERT INTO `user` VALUES ('12', 'alien', '5678');
INSERT INTO `user` VALUES ('13', 'alien', '5678');
INSERT INTO `user` VALUES ('14', 'alien', '5678');
INSERT INTO `user` VALUES ('15', 'alien', '5678');

-- ----------------------------
-- Table structure for user2
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user2
-- ----------------------------
INSERT INTO `user2` VALUES ('1', 'zhangsan', '123', null);
INSERT INTO `user2` VALUES ('2', 'lisi', '123', null);
INSERT INTO `user2` VALUES ('3', 'tom', '12345', null);
INSERT INTO `user2` VALUES ('4', 'lucy', '12396', null);
INSERT INTO `user2` VALUES ('5', 'lucy', '12396', null);
INSERT INTO `user2` VALUES ('7', 'jim', '123', '1645194862272');
INSERT INTO `user2` VALUES ('8', 'jim', '123', '1645194907443');
INSERT INTO `user2` VALUES ('9', 'jim', '123', '1645194911422');
INSERT INTO `user2` VALUES ('10', 'tom', '123', null);
INSERT INTO `user2` VALUES ('11', 'tom', '123', null);

-- ----------------------------
-- Table structure for user3
-- ----------------------------
DROP TABLE IF EXISTS `user3`;
CREATE TABLE `user3` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user3
-- ----------------------------
INSERT INTO `user3` VALUES ('1', 'zhangsan', '123', '2022-02-16');
INSERT INTO `user3` VALUES ('2', 'lisi', '123', '2022-02-06');
INSERT INTO `user3` VALUES ('3', 'tom', '12345', '2022-02-02');
INSERT INTO `user3` VALUES ('4', 'jack', '123', '2022-02-19');
INSERT INTO `user3` VALUES ('5', 'lucy', '12396', '2022-02-17');
INSERT INTO `user3` VALUES ('10', 'jim', '456', '2022-02-19');
INSERT INTO `user3` VALUES ('11', 'tom', '123', '2022-02-19');
INSERT INTO `user3` VALUES ('14', 'lihua', '123', '2022-02-20');
INSERT INTO `user3` VALUES ('15', 'tom', '123', '2022-02-19');
INSERT INTO `user3` VALUES ('16', 'tom', '123', '2022-02-20');
