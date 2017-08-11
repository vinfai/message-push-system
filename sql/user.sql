/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:31:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '10524782571', 'ljh2', '123');
INSERT INTO `user` VALUES ('3', '95955542783', 'abc', '123');
INSERT INTO `user` VALUES ('4', '95955542780', 'abc', '123');
INSERT INTO `user` VALUES ('10', '11914977704', 'abcd', '123');
INSERT INTO `user` VALUES ('11', '10191291000', 'a', 'a');
