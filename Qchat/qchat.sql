/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : qchat

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-12-09 18:39:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('乐乐', '123');
INSERT INTO `user` VALUES ('喜喜', '123');
INSERT INTO `user` VALUES ('大大', '123');
INSERT INTO `user` VALUES ('宝宝', '123');
INSERT INTO `user` VALUES ('欢欢', '123');
INSERT INTO `user` VALUES ('美景', 'zzy');
INSERT INTO `user` VALUES ('良辰', 'zzy');
INSERT INTO `user` VALUES ('虚设', 'zzy');
INSERT INTO `user` VALUES ('贝贝', '123');
SET FOREIGN_KEY_CHECKS=1;
