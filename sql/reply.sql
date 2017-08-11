/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:31:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL,
  `request_code` int(255) DEFAULT NULL,
  `push_address` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `type` int(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '10524782571', '6', '18627588559', 'ss', '1', '23213');
INSERT INTO `reply` VALUES ('2', '10191291000', '6', '18627588559', 'ok,ok.haode.', '2', '2017-08-03 09:22:16');
INSERT INTO `reply` VALUES ('3', '10191291000', '6', '18627588559', 'hello', '1', '2017-08-04 12:36:52');
INSERT INTO `reply` VALUES ('4', '10191291000', '6', '18627588559', 'nice to meet you.', '2', '2017-08-04 12:39:03');
INSERT INTO `reply` VALUES ('5', '10191291000', '6', '18627588559', 'hi', '1', '2017-08-04 12:41:27');
INSERT INTO `reply` VALUES ('6', '10191291000', '6', '18627588559', 'zai ma.', '1', '2017-08-04 12:42:40');
INSERT INTO `reply` VALUES ('7', '10191291000', '10', '1388@mail.comsubject=subject', 'ilovehhh', '2', '2017-08-04 11:49:12');
INSERT INTO `reply` VALUES ('8', '10524782571', '11', '18822777045', 'ilovehhh', '2', '2017-08-04 05:02:57');
INSERT INTO `reply` VALUES ('9', '10524782571', '11', '18822777045', 'nice to meet you.', '2', '2017-08-04 05:12:15');
INSERT INTO `reply` VALUES ('10', '10524782571', '12', '18822777045', 'ilovehhh', '2', '2017-08-09 03:55:00');
