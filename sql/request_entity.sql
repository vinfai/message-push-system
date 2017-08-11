/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:31:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for request_entity
-- ----------------------------
DROP TABLE IF EXISTS `request_entity`;
CREATE TABLE `request_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `is_tongbu` int(11) DEFAULT NULL,
  `needreply` int(11) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `push` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `template_id` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of request_entity
-- ----------------------------
INSERT INTO `request_entity` VALUES ('1', '10524782571', '??{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559', 'CVTE', '1', null);
INSERT INTO `request_entity` VALUES ('2', '10524782571', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559,13822777045,15084849034', 'CVTE', '1', null);
INSERT INTO `request_entity` VALUES ('3', '10524782571', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559,13822777045,15084849034', 'CVTE', '1', null);
INSERT INTO `request_entity` VALUES ('4', '10191291000', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559,13822777045,15084849034', 'CVTE', '1', null);
INSERT INTO `request_entity` VALUES ('5', '10191291000', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559,13822777045,15084849034', 'shirui', '1', '2017-08-01 05:01:24');
INSERT INTO `request_entity` VALUES ('6', '10191291000', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762,18627588559,13822777045,15084849034', 'shirui', '1', '2017-08-01 05:03:44');
INSERT INTO `request_entity` VALUES ('7', '10191291000', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559,13822777045', 'shirui', '1', '2017-08-01 10:32:39');
INSERT INTO `request_entity` VALUES ('8', '10191291000', 'hello{1},zai{2},{3}day.', '0', '0', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559,13822777045', 'shirui', '1', '2017-08-02 09:25:10');
INSERT INTO `request_entity` VALUES ('9', '10524782571', 'hello{1},zai{2},{3}day.', '0', '1', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559,13822777045', 'shirui', '1', '2017-08-03 05:02:47');
INSERT INTO `request_entity` VALUES ('10', '10191291000', 'hello{1},zai{2},{3}day.', '0', '1', '[\"subject\",\"ljh\",\"2017-3-27\",\"3\"]', '1888@mail.com,1388@mail.com', '554@mail.com', '1', '2017-08-04 11:48:25');
INSERT INTO `request_entity` VALUES ('11', '10524782571', 'hello{1},zai{2},{3}day.', '0', '1', '[\"ljh\",\"2017-3-27\",\"3\"]', '18827588559,18822777045', 'shirui', '1', '2017-08-04 04:59:29');
INSERT INTO `request_entity` VALUES ('12', '10524782571', 'hello{1},zai{2},{3}day.', '0', '1', '[\"ljh\",\"2017-3-27\",\"3\"]', '18827588559,18822777045', 'shirui', '1', '2017-08-09 03:53:45');
