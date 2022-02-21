/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : spring_test

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2022-02-21 14:18:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `name` char(50) NOT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单纯测试表. ';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('lucy', '5000');
INSERT INTO `account` VALUES ('tom', '5000');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='spring_test数据库下面的sys_role, sys_user,sys_user_role三张表是springMVC阶段和spring整合时的三张表. 有前端的那个. ';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '院长', '负责全面工作T');
INSERT INTO `sys_role` VALUES ('2', '研究员', '课程研发工作S');
INSERT INTO `sys_role` VALUES ('3', '讲师', '授课工作');
INSERT INTO `sys_role` VALUES ('4', '助教', '协助解决学生的问题test');
INSERT INTO `sys_role` VALUES ('5', '班主任', '负责生活问题');
INSERT INTO `sys_role` VALUES ('6', 'asd', 'asdas');
INSERT INTO `sys_role` VALUES ('7', 'asd', 'asdas');
INSERT INTO `sys_role` VALUES ('8', 'testName', 'testDesc');
INSERT INTO `sys_role` VALUES ('9', 'testName', 'testDesc');
INSERT INTO `sys_role` VALUES ('10', 'test01', 'test0122');
INSERT INTO `sys_role` VALUES ('11', 'test01', 'test0122');
INSERT INTO `sys_role` VALUES ('12', 'lit', 'lit');
INSERT INTO `sys_role` VALUES ('13', 'aaa', 'sss');
INSERT INTO `sys_role` VALUES ('14', 'å°±ä¸æå¯¼', 'è´è´£å­¦çæ¯ä¸ä¹åçå°±ä¸æå¯¼å·¥ä½');
INSERT INTO `sys_role` VALUES ('15', '就业指导', '负责学生毕业之后的就业指导工作');
INSERT INTO `sys_role` VALUES ('16', '测试角色', '测试角色');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zhangsan', 'zhangsan@itcast.cn', '123', '13888888888');
INSERT INTO `sys_user` VALUES ('2', 'lisi', 'lisi@itcast.cn', '123', '13999999999');
INSERT INTO `sys_user` VALUES ('3', 'wangwu', 'wangwu@itcast.cn', '123', '18599999999');
INSERT INTO `sys_user` VALUES ('4', '测试数据', '123@123.123', '123', '138888866623');
INSERT INTO `sys_user` VALUES ('5', '测试lit', '123@123.123', '123', '13523164462');

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
INSERT INTO `sys_user_role` VALUES ('4', '1');
INSERT INTO `sys_user_role` VALUES ('5', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('4', '2');
INSERT INTO `sys_user_role` VALUES ('2', '3');
INSERT INTO `sys_user_role` VALUES ('4', '15');
INSERT INTO `sys_user_role` VALUES ('5', '15');
INSERT INTO `sys_user_role` VALUES ('4', '16');
INSERT INTO `sys_user_role` VALUES ('5', '16');
