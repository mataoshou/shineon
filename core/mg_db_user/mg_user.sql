/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - mg_user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg_user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mg_user`;

/*Table structure for table `mg_base_region` */

DROP TABLE IF EXISTS `mg_base_region`;

CREATE TABLE `mg_base_region` (
  `rgid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '栏目id',
  `rgName` varchar(256) DEFAULT NULL COMMENT '栏目名称',
  `timeCreated` datetime DEFAULT NULL COMMENT '创建时间',
  `timeModified` datetime DEFAULT NULL COMMENT '修改时间',
  `flagDeleted` smallint(4) DEFAULT NULL,
  `timeDeleted` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`rgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mg_base_region` */

/*Table structure for table `mg_base_user` */

DROP TABLE IF EXISTS `mg_base_user`;

CREATE TABLE `mg_base_user` (
  `uid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(256) DEFAULT NULL COMMENT '用户名',
  `userPassword` varchar(512) DEFAULT NULL COMMENT '密码  MD5 + 一次对称加密',
  `displayName` varchar(256) DEFAULT NULL COMMENT '显示名称',
  `phone` varchar(64) DEFAULT NULL COMMENT '电话',
  `parent` bigint(11) DEFAULT NULL COMMENT '父级附属',
  `region` bigint(11) DEFAULT NULL COMMENT '一级栏目',
  `zone` bigint(11) DEFAULT NULL COMMENT '二级栏目',
  `timeCreate` datetime DEFAULT NULL COMMENT '创建时间',
  `timeModified` datetime DEFAULT NULL COMMENT '修改时间',
  `deleteFlag` smallint(4) DEFAULT NULL COMMENT '删除状态',
  `timeDelete` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mg_base_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
