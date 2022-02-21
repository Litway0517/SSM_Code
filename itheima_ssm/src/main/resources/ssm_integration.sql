/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : ssm_integration

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2022-02-21 14:18:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='ssm框架的最后整合阶段的数据库. ';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zhangsan', '10000');
INSERT INTO `account` VALUES ('2', 'zhangsan', '10000');
INSERT INTO `account` VALUES ('3', 'wnagwu', '10000');
INSERT INTO `account` VALUES ('4', '张三', '15000');
INSERT INTO `account` VALUES ('5', '风清扬', '32232');
INSERT INTO `account` VALUES ('6', '左冷禅', '56112');
INSERT INTO `account` VALUES ('7', '岳不群', '32561');
INSERT INTO `account` VALUES ('8', 'litway', '999999999');
INSERT INTO `account` VALUES ('9', 'litway', '5000000');
INSERT INTO `account` VALUES ('10', 'litway', '5000000');
INSERT INTO `account` VALUES ('11', 'xmw', '6666665');
