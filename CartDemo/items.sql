/*
Navicat MySQL Data Transfer


Source Server         : MySQL50
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : shopping


Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001


Date: 2016-08-01 12:12:31
*/

CREATE DATABASE `shopping` CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL ON `shopping`.* TO `caybcc`@localhost IDENTIFIED BY '123456';
 


SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `price` int(11) default NULL,
  `number` int(11) default NULL,
  `picture` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '��������Ь', '��ɽ', '180', '500', '001.jpg');
INSERT INTO `items` VALUES ('2', '��̤�˶�Ь', '����', '120', '800', '002.jpg');
INSERT INTO `items` VALUES ('3', '�Ϳ��˶�Ь', '����', '500', '1000', '003.jpg');
INSERT INTO `items` VALUES ('4', '���ϴ�˹TѪ��', '�Ϻ�', '388', '600', '004.jpg');
INSERT INTO `items` VALUES ('5', '�����Ļ���', '����', '180', '900', '005.jpg');
INSERT INTO `items` VALUES ('6', 'С��3', '����', '1999', '3000', '006.jpg');
INSERT INTO `items` VALUES ('7', 'С��2S', '����', '1299', '1000', '007.jpg');
INSERT INTO `items` VALUES ('8', 'thinkpad�ʼǱ�', '����', '6999', '500', '008.jpg');
INSERT INTO `items` VALUES ('9', 'dell�ʼǱ�', '����', '3999', '500', '009.jpg');
INSERT INTO `items` VALUES ('10', 'ipad5', '����', '5999', '500', '010.jpg');

CREATE TABLE `user`(
`id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(50) NOT NULL DEFAULT '',
`password` VARCHAR(50) NOT NULL DEFAULT ''
)DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;