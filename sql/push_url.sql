/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:30:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for push_url
-- ----------------------------
DROP TABLE IF EXISTS `push_url`;
CREATE TABLE `push_url` (
  `type` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of push_url
-- ----------------------------
INSERT INTO `push_url` VALUES ('mail', 'http://mail/api');
INSERT INTO `push_url` VALUES ('sms', 'http://sms.api');
