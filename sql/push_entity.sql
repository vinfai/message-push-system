/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test1

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-11 16:30:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for push_entity
-- ----------------------------
DROP TABLE IF EXISTS `push_entity`;
CREATE TABLE `push_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `push_address` varchar(255) DEFAULT NULL,
  `request_code` varchar(255) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `template_id` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of push_entity
-- ----------------------------
INSERT INTO `push_entity` VALUES ('1', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '13822777045', '4', '1', 'CVTE', '1', '1', null);
INSERT INTO `push_entity` VALUES ('2', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '15084849034', '4', '1', 'CVTE', '1', '1', null);
INSERT INTO `push_entity` VALUES ('3', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559', '4', '1', 'CVTE', '1', '1', null);
INSERT INTO `push_entity` VALUES ('4', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762', '4', '1', 'CVTE', '1', '1', null);
INSERT INTO `push_entity` VALUES ('5', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559', '6', '1', 'shirui', '1', '1', '2017-08-01 05:03:44');
INSERT INTO `push_entity` VALUES ('6', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '15084849034', '6', '1', 'shirui', '1', '1', '2017-08-01 05:03:44');
INSERT INTO `push_entity` VALUES ('7', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '15773114762', '6', '1', 'shirui', '1', '1', '2017-08-01 05:03:44');
INSERT INTO `push_entity` VALUES ('8', '10191291000', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '13822777045', '6', '1', 'shirui', '1', '1', '2017-08-01 05:03:44');
INSERT INTO `push_entity` VALUES ('9', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '13822777045', 'null', '1', 'shirui', '1', '1', '2017-08-03 07:25:50');
INSERT INTO `push_entity` VALUES ('10', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559', 'null', '1', 'shirui', '1', '1', '2017-08-03 07:25:50');
INSERT INTO `push_entity` VALUES ('11', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '13822777045', 'null', '1', 'shirui', '1', '1', '2017-08-04 11:22:03');
INSERT INTO `push_entity` VALUES ('12', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18627588559', 'null', '1', 'shirui', '1', '1', '2017-08-04 11:22:03');
INSERT INTO `push_entity` VALUES ('13', '10191291000', 'hello{1},zai{2},{3}day.', '[\"subject\",\"ljh\",\"2017-3-27\",\"3\"]', '1388@mail.com', '10', '1', '554@mail.com', '1', '1', '2017-08-04 11:48:28');
INSERT INTO `push_entity` VALUES ('14', '10191291000', 'hello{1},zai{2},{3}day.', '[\"subject\",\"ljh\",\"2017-3-27\",\"3\"]', '1888@mail.com', '10', '1', '554@mail.com', '1', '1', '2017-08-04 11:48:28');
INSERT INTO `push_entity` VALUES ('15', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18822777045', '11', '1', 'shirui', '1', '1', '2017-08-04 04:59:31');
INSERT INTO `push_entity` VALUES ('16', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18827588559', '11', '1', 'shirui', '1', '1', '2017-08-04 04:59:31');
INSERT INTO `push_entity` VALUES ('17', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18822777045', '12', '1', 'shirui', '1', '1', '2017-08-09 03:53:48');
INSERT INTO `push_entity` VALUES ('18', '10524782571', 'hello{1},zai{2},{3}day.', '[\"ljh\",\"2017-3-27\",\"3\"]', '18827588559', '12', '1', 'shirui', '1', '1', '2017-08-09 03:53:48');
