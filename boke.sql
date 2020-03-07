/*
Navicat MySQL Data Transfer

Source Server         : Xiong
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : boke

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-09-01 12:19:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(64) NOT NULL,
  `adminpass` varchar(64) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for bokeinfo
-- ----------------------------
DROP TABLE IF EXISTS `bokeinfo`;
CREATE TABLE `bokeinfo` (
  `bokeid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `editordate` varchar(32) NOT NULL,
  `title` varchar(32) NOT NULL,
  `label` varchar(128) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  `pics` varchar(128) DEFAULT NULL,
  `original` varchar(4) DEFAULT '1',
  `type` int(11) NOT NULL,
  `shape` int(11) NOT NULL DEFAULT '0',
  `state` int(11) DEFAULT '0',
  `readnum` int(11) DEFAULT '0',
  `evaluate` int(11) DEFAULT '0',
  PRIMARY KEY (`bokeid`),
  KEY `FK_boke_userid` (`userid`),
  KEY `FK_boke_type` (`type`),
  CONSTRAINT `FK_boke_type` FOREIGN KEY (`type`) REFERENCES `typeinfo` (`type`),
  CONSTRAINT `FK_boke_userid` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collectionid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `bokeid` int(11) NOT NULL,
  `collectiondate` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`collectionid`),
  KEY `FK_collect_bokeid` (`bokeid`),
  KEY `EK_collect_userid` (`userid`),
  CONSTRAINT `EK_collect_userid` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`),
  CONSTRAINT `FK_collect_bokeid` FOREIGN KEY (`bokeid`) REFERENCES `bokeinfo` (`bokeid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `evaluationid` int(11) NOT NULL AUTO_INCREMENT,
  `evaluationman` varchar(100) NOT NULL,
  `evaluationedman` varchar(100) NOT NULL,
  `bokeid` int(11) NOT NULL,
  `evaluationtime` varchar(32) NOT NULL,
  `evaluationcontent` text,
  PRIMARY KEY (`evaluationid`),
  KEY `FK_evaluation_bokeid` (`bokeid`),
  CONSTRAINT `FK_evaluation_bokeid` FOREIGN KEY (`bokeid`) REFERENCES `bokeinfo` (`bokeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `focuid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `focususerid` int(11) NOT NULL,
  PRIMARY KEY (`focuid`),
  KEY `FK_focus_userid` (`userid`),
  KEY `FK_focus_focususerid` (`focususerid`),
  CONSTRAINT `FK_focus_focususerid` FOREIGN KEY (`focususerid`) REFERENCES `userinfo` (`userid`),
  CONSTRAINT `FK_focus_userid` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for labelinfo
-- ----------------------------
DROP TABLE IF EXISTS `labelinfo`;
CREATE TABLE `labelinfo` (
  `labelid` int(11) NOT NULL AUTO_INCREMENT,
  `labelname` varchar(100) NOT NULL,
  PRIMARY KEY (`labelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for respond
-- ----------------------------
DROP TABLE IF EXISTS `respond`;
CREATE TABLE `respond` (
  `respondid` int(11) NOT NULL AUTO_INCREMENT,
  `respondman` varchar(100) NOT NULL,
  `respondedman` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `aboutid` int(11) NOT NULL,
  `whichbelong` varchar(32) NOT NULL DEFAULT '0',
  `bokeid` int(11) NOT NULL,
  `respondtime` varchar(32) NOT NULL,
  `respondcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`respondid`),
  KEY `FK_respond_bokeid` (`bokeid`),
  KEY `FK_respond_respondusername` (`respondman`),
  KEY `FK_respond_respondedusernameed` (`respondedman`),
  CONSTRAINT `FK_respond_bokeid` FOREIGN KEY (`bokeid`) REFERENCES `bokeinfo` (`bokeid`),
  CONSTRAINT `FK_respond_respondedusernameed` FOREIGN KEY (`respondedman`) REFERENCES `userinfo` (`username`),
  CONSTRAINT `FK_respond_respondusername` FOREIGN KEY (`respondman`) REFERENCES `userinfo` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for typeinfo
-- ----------------------------
DROP TABLE IF EXISTS `typeinfo`;
CREATE TABLE `typeinfo` (
  `type` int(11) NOT NULL,
  `typename` varchar(100) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `userpass` varchar(64) NOT NULL,
  `realname` varchar(32) DEFAULT NULL,
  `contackway` varchar(11) NOT NULL,
  `birthday` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `work` varchar(64) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `contackway` (`contackway`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
