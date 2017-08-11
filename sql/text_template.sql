/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:31:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for text_template
-- ----------------------------
DROP TABLE IF EXISTS `text_template`;
CREATE TABLE `text_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `param_num` int(11) DEFAULT NULL,
  `text` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of text_template
-- ----------------------------
INSERT INTO `text_template` VALUES ('1', '3', 'hello{1}, please join interview at {2} , this message value {3} days.');
INSERT INTO `text_template` VALUES ('2', '2', 'hi{1}, please join interview at {2},this message value days.');
INSERT INTO `text_template` VALUES ('3', '1', 'hi?please join interview at {1},this message value days.');
INSERT INTO `text_template` VALUES ('4', '1', 'hi?please join interview at {1},this message value days.');
