/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : spring_jdbc

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2022-02-21 14:18:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `money` decimal(12,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='account表格是学习sping_jdbc模板的时候的练习表. ';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('2', 'tom', '10000');
INSERT INTO `account` VALUES ('3', 'lily', '5000');
