/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : qchat

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-11-23 21:18:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('fish', 'zzy123456');
INSERT INTO `user` VALUES ('hu', '123');
INSERT INTO `user` VALUES ('root', 'zzy123456');
INSERT INTO `user` VALUES ('user', 'zzy123456');
INSERT INTO `user` VALUES ('wo', 'zzy123456');
INSERT INTO `user` VALUES ('张振宇', 'zzy123456');
INSERT INTO `user` VALUES ('张振宇1', '张振宇1');
INSERT INTO `user` VALUES ('许艳芳', '123');
INSERT INTO `user` VALUES ('问问', '问问');
INSERT INTO `user` VALUES ('魏', '3051003');
INSERT INTO `user` VALUES ('魏娜', 'zzy123456');
SET FOREIGN_KEY_CHECKS=1;
