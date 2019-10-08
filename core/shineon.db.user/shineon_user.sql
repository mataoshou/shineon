/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - shineon_base_uauth
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shineon_base_uauth` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shineon_base_uauth`;

/*Table structure for table `shineon_base_region` */

DROP TABLE IF EXISTS `shineon_base_region`;

CREATE TABLE `shineon_base_region` (
  `rgid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '栏目id',
  `rgName` varchar(256) DEFAULT NULL COMMENT '栏目名称',
  `parent` bigint(11) DEFAULT NULL,
  `timeCreated` datetime DEFAULT NULL COMMENT '创建时间',
  `timeModified` datetime DEFAULT NULL COMMENT '修改时间',
  `flagDeleted` smallint(4) DEFAULT NULL,
  `timeDeleted` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`rgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shineon_base_region` */

/*Table structure for table `shineon_base_zone` */

DROP TABLE IF EXISTS `shineon_base_zone`;

CREATE TABLE `shineon_base_zone` (
  `znid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '栏目id',
  `znName` varchar(256) DEFAULT NULL COMMENT '栏目名称',
  `parent` bigint(11) DEFAULT NULL,
  `timeCreated` datetime DEFAULT NULL COMMENT '创建时间',
  `timeModified` datetime DEFAULT NULL COMMENT '修改时间',
  `flagDeleted` smallint(4) DEFAULT NULL,
  `timeDeleted` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`znid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shineon_base_zone` */

/*Table structure for table `shineon_user` */

DROP TABLE IF EXISTS `shineon_user`;

CREATE TABLE `shineon_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `displayName` varchar(128) DEFAULT NULL COMMENT '显示名称',
  `parent` int(11) DEFAULT NULL COMMENT '父级',
  `region` int(11) DEFAULT NULL COMMENT '一级栏目',
  `zone` int(11) DEFAULT NULL COMMENT '二级栏目',
  `usercode` varchar(128) DEFAULT NULL COMMENT '编码',
  `userthumb` varchar(128) DEFAULT NULL COMMENT '缩略图',
  `telephone` varchar(128) DEFAULT NULL COMMENT '电话',
  `usermark` varchar(256) DEFAULT NULL COMMENT '备注',
  `userType` tinyint(4) DEFAULT NULL COMMENT '用户类型',
  `admin` tinyint(4) DEFAULT NULL COMMENT '管理员  1 超级管理员  2 普通管理员  100  内部管理员   0不是管理员',
  `timeCreated` datetime DEFAULT NULL,
  `timeModified` datetime DEFAULT NULL,
  `timeDeleted` datetime DEFAULT NULL,
  `flagDeleted` tinyint(4) DEFAULT NULL COMMENT '删除状态',
  `timeLimit` datetime DEFAULT NULL COMMENT '过期时间  用户有效时间   2030年默认为永久有效',
  `countLimit` tinyint(4) DEFAULT NULL COMMENT '限制次数  登录失败次数限制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `shineon_user` */

insert  into `shineon_user`(`id`,`username`,`password`,`displayName`,`parent`,`region`,`zone`,`usercode`,`userthumb`,`telephone`,`usermark`,`userType`,`admin`,`timeCreated`,`timeModified`,`timeDeleted`,`flagDeleted`,`timeLimit`,`countLimit`) values (1,'3','2','2',2,NULL,NULL,'2','1','11','11',1,1,'2019-06-21 15:04:47','2019-06-21 15:04:49','2019-06-21 15:04:50',1,'2019-06-21 15:04:54',1),(2,'2','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'2','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'2','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'matao',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `shineon_user_attached` */

DROP TABLE IF EXISTS `shineon_user_attached`;

CREATE TABLE `shineon_user_attached` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `timeLastLogin` datetime DEFAULT NULL COMMENT '最后登录时间',
  `ipLastLogin` datetime DEFAULT NULL COMMENT '最后登录ip',
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shineon_user_attached` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
