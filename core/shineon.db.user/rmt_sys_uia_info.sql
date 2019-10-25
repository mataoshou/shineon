/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - rmt_sys_uia_info
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rmt_sys_uia_info` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rmt_sys_uia_info`;

/*Table structure for table `rmt_actior_info` */

DROP TABLE IF EXISTS `rmt_actior_info`;

CREATE TABLE `rmt_actior_info` (
  `id` varchar(64) NOT NULL COMMENT '角色ID',
  `actorName` varchar(32) NOT NULL COMMENT '角色名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `privilegeGroup` text COMMENT '权限组',
  `secretLevel` int(11) NOT NULL COMMENT '密级',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `systemActorFlag` varchar(255) DEFAULT NULL COMMENT '出厂自带角色标识',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_actior_info` */

/*Table structure for table `rmt_department_chart_info` */

DROP TABLE IF EXISTS `rmt_department_chart_info`;

CREATE TABLE `rmt_department_chart_info` (
  `id` varchar(64) NOT NULL COMMENT '架构信息ID',
  `departmentID` varchar(128) NOT NULL COMMENT '部门ID',
  `departmentCode` int(11) NOT NULL COMMENT '部门代码',
  `departmentName` varchar(128) DEFAULT NULL COMMENT '部门名称',
  `organizationID` varchar(128) DEFAULT NULL COMMENT '所属机构代码',
  `levelInfo` varchar(128) DEFAULT NULL COMMENT '组织级别串号',
  `parentID` varchar(128) DEFAULT NULL COMMENT '父级部门ID',
  `showOrder` int(11) DEFAULT NULL COMMENT '展示排序',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_department_chart_info` */

/*Table structure for table `rmt_department_extend_info` */

DROP TABLE IF EXISTS `rmt_department_extend_info`;

CREATE TABLE `rmt_department_extend_info` (
  `id` varchar(64) NOT NULL COMMENT '扩展信息ID',
  `departmentID` varchar(64) NOT NULL COMMENT '部门ID',
  `departmentAbbr` varchar(128) DEFAULT NULL COMMENT '部门简称',
  `workerNumber` int(11) DEFAULT NULL COMMENT '人员数量',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_department_extend_info` */

/*Table structure for table `rmt_department_info` */

DROP TABLE IF EXISTS `rmt_department_info`;

CREATE TABLE `rmt_department_info` (
  `id` varchar(64) NOT NULL COMMENT '条目信息ID',
  `departmentID` varchar(128) NOT NULL COMMENT '部门ID',
  `departmentCode` int(11) NOT NULL COMMENT '部门代码',
  `departmentName` varchar(128) DEFAULT NULL COMMENT '部门名称',
  `departmentType` varchar(128) NOT NULL COMMENT '部门类型',
  `description` varchar(128) DEFAULT NULL COMMENT '部门描述',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `deletedTime` datetime DEFAULT NULL COMMENT '删除时间',
  `deletedUserID` varchar(64) DEFAULT NULL COMMENT '删除用户ID',
  `deletedFlag` tinyint(4) DEFAULT NULL COMMENT '删除状态',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_department_info` */

/*Table structure for table `rmt_operate_group_info` */

DROP TABLE IF EXISTS `rmt_operate_group_info`;

CREATE TABLE `rmt_operate_group_info` (
  `id` varchar(64) NOT NULL COMMENT '操作组ID',
  `operateGroupName` varchar(256) NOT NULL COMMENT '操作组名称',
  `operateGroupType` int(11) NOT NULL COMMENT '操作组类型',
  `opreateSet` text COMMENT '操作集合',
  `belongSystem` varchar(128) NOT NULL COMMENT '所属系统',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_operate_group_info` */

/*Table structure for table `rmt_operate_info` */

DROP TABLE IF EXISTS `rmt_operate_info`;

CREATE TABLE `rmt_operate_info` (
  `id` varchar(64) NOT NULL COMMENT '操作ID',
  `operateName` varchar(255) DEFAULT NULL COMMENT '操作名称',
  `operateType` int(11) NOT NULL COMMENT '操作类型',
  `belongSystem` varchar(128) NOT NULL COMMENT '所属系统',
  `pageLocation` varchar(128) NOT NULL COMMENT '页面',
  `areaLocation` varchar(255) NOT NULL COMMENT '区域',
  `applicationKey` varchar(128) NOT NULL COMMENT '应用操作键值',
  `visibility` int(11) NOT NULL COMMENT '可见性',
  `operability` int(11) NOT NULL COMMENT '可操作性',
  `isRequiredField` int(11) NOT NULL COMMENT '是否为必填项',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_operate_info` */

/*Table structure for table `rmt_organization_chart_info` */

DROP TABLE IF EXISTS `rmt_organization_chart_info`;

CREATE TABLE `rmt_organization_chart_info` (
  `id` varchar(64) NOT NULL COMMENT '机构信息ID',
  `organizationID` varchar(64) NOT NULL COMMENT '机构ID',
  `organizationCode` int(11) NOT NULL COMMENT '机构代码',
  `organizationName` varchar(128) DEFAULT NULL COMMENT '机构名称',
  `levelInfo` varchar(128) NOT NULL COMMENT '组织级别串号',
  `parentID` varchar(64) DEFAULT NULL COMMENT '父级机构ID',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_organization_chart_info` */

/*Table structure for table `rmt_organization_department_info` */

DROP TABLE IF EXISTS `rmt_organization_department_info`;

CREATE TABLE `rmt_organization_department_info` (
  `id` varchar(64) NOT NULL COMMENT '映射信息ID',
  `departementID` varchar(64) NOT NULL COMMENT '部门ID',
  `organizationID` varchar(64) NOT NULL COMMENT '机构ID',
  `reserved1` int(255) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_organization_department_info` */

/*Table structure for table `rmt_organization_extend_info` */

DROP TABLE IF EXISTS `rmt_organization_extend_info`;

CREATE TABLE `rmt_organization_extend_info` (
  `id` varchar(64) NOT NULL COMMENT '扩展信息ID',
  `organizationID` varchar(64) NOT NULL COMMENT '机构ID',
  `organizationAddress` varchar(128) DEFAULT NULL COMMENT '机构地址',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_organization_extend_info` */

/*Table structure for table `rmt_organization_info` */

DROP TABLE IF EXISTS `rmt_organization_info`;

CREATE TABLE `rmt_organization_info` (
  `id` varchar(64) NOT NULL COMMENT '机构信息ID',
  `organizationID` varchar(128) NOT NULL COMMENT '机构ID',
  `organizationCode` int(11) NOT NULL COMMENT '机构代码',
  `organizationName` varchar(128) DEFAULT NULL COMMENT '机构名称',
  `organizationType` int(11) DEFAULT NULL COMMENT '机构类型',
  `description` varchar(128) DEFAULT NULL COMMENT '机构描述',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `deletedTime` datetime DEFAULT NULL COMMENT '删除时间',
  `deletedUserID` varchar(64) DEFAULT NULL COMMENT '删除用户ID',
  `deletedFlag` tinyint(4) DEFAULT NULL COMMENT '删除标记',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_organization_info` */

/*Table structure for table `rmt_privilege_group_info` */

DROP TABLE IF EXISTS `rmt_privilege_group_info`;

CREATE TABLE `rmt_privilege_group_info` (
  `id` varchar(64) NOT NULL COMMENT '权限组ID',
  `privilegeGroupName` varchar(256) NOT NULL COMMENT '权限组名称',
  `privilegeGroupType` int(11) NOT NULL COMMENT '权限组类型',
  `privilegeSet` text COMMENT '权限集合',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_privilege_group_info` */

/*Table structure for table `rmt_privilege_info` */

DROP TABLE IF EXISTS `rmt_privilege_info`;

CREATE TABLE `rmt_privilege_info` (
  `id` varchar(64) NOT NULL COMMENT '权限ID',
  `privilegeName` varchar(32) NOT NULL COMMENT '权限名称',
  `operateGroup` text NOT NULL COMMENT '操作组',
  `description` varchar(32) DEFAULT NULL COMMENT '描述',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_privilege_info` */

/*Table structure for table `rmt_tenant_chart_info` */

DROP TABLE IF EXISTS `rmt_tenant_chart_info`;

CREATE TABLE `rmt_tenant_chart_info` (
  `id` varchar(64) NOT NULL COMMENT '架构信息ID',
  `tenantID` varchar(64) NOT NULL COMMENT '租户ID',
  `tenantName` varchar(128) NOT NULL COMMENT '租户名称',
  `tenantCode` int(11) NOT NULL COMMENT '租户代码',
  `levelInfo` varchar(255) NOT NULL COMMENT '租户级别串号',
  `parentID` varchar(64) DEFAULT NULL COMMENT '父级租户ID',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_tenant_chart_info` */

/*Table structure for table `rmt_tenant_extend_info` */

DROP TABLE IF EXISTS `rmt_tenant_extend_info`;

CREATE TABLE `rmt_tenant_extend_info` (
  `id` int(11) NOT NULL COMMENT '扩展信息ID',
  `TenantID` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `TenantName` varchar(128) DEFAULT NULL COMMENT '租户名称',
  `TenantCode` int(11) DEFAULT NULL COMMENT '租户代码',
  `TenantType` tinyint(4) DEFAULT NULL COMMENT '租户类型',
  `Description` varchar(255) DEFAULT NULL COMMENT '描述',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_tenant_extend_info` */

/*Table structure for table `rmt_tenant_info` */

DROP TABLE IF EXISTS `rmt_tenant_info`;

CREATE TABLE `rmt_tenant_info` (
  `id` varchar(64) NOT NULL COMMENT '租户信息ID',
  `tenantID` varchar(64) NOT NULL COMMENT '租户ID',
  `tenantCode` int(11) NOT NULL COMMENT '租户代码',
  `tenantName` varchar(255) NOT NULL COMMENT '租户名称',
  `tenantType` tinyint(4) DEFAULT NULL COMMENT '租户类型',
  `tenantState` tinyint(4) DEFAULT NULL COMMENT '租户有效性状态',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `createdUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `organizationID` varchar(64) DEFAULT NULL COMMENT '关联机构ID',
  `tenantExpiryDate` datetime NOT NULL COMMENT '租户有效期',
  `tenantAdminSet` text NOT NULL COMMENT '租户管理员集合',
  `tenantExtendID` varchar(64) DEFAULT NULL COMMENT '租户扩展信息ID',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_tenant_info` */

/*Table structure for table `rmt_user_actor_info` */

DROP TABLE IF EXISTS `rmt_user_actor_info`;

CREATE TABLE `rmt_user_actor_info` (
  `id` int(11) NOT NULL COMMENT '用户角色ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  `departmentID` varchar(128) DEFAULT NULL COMMENT '所属部门',
  `actorGroup` varchar(255) NOT NULL COMMENT '角色组ID',
  `speciallyGroup` varchar(255) DEFAULT NULL COMMENT '特定组ID',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(128) NOT NULL COMMENT '创建用户ID',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `reserved1` varchar(255) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_user_actor_info` */

/*Table structure for table `rmt_user_department_info` */

DROP TABLE IF EXISTS `rmt_user_department_info`;

CREATE TABLE `rmt_user_department_info` (
  `id` varchar(64) NOT NULL COMMENT '映射信息ID',
  `userID` varchar(64) NOT NULL COMMENT '用户ID',
  `departmentID` varchar(64) NOT NULL COMMENT '组织ID',
  `showOrder` int(11) NOT NULL COMMENT '展示排序',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_user_department_info` */

/*Table structure for table `rmt_user_extend_info` */

DROP TABLE IF EXISTS `rmt_user_extend_info`;

CREATE TABLE `rmt_user_extend_info` (
  `id` varchar(64) NOT NULL COMMENT '扩展信息ID',
  `userID` varchar(64) NOT NULL COMMENT '用户ID',
  `realName` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `spellName` varchar(64) DEFAULT NULL COMMENT '拼音',
  `postName` varchar(64) DEFAULT NULL COMMENT '岗位',
  `dutiesName` varchar(64) DEFAULT NULL COMMENT '职务',
  `officeAddress` varchar(128) DEFAULT NULL COMMENT '办公地点',
  `mobilePhone` varchar(128) DEFAULT NULL COMMENT '移动电话',
  `officeTelephone` varchar(128) DEFAULT NULL COMMENT '办公室电话',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  `officeCode` varchar(64) DEFAULT NULL COMMENT '办公室',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_user_extend_info` */

/*Table structure for table `rmt_user_info` */

DROP TABLE IF EXISTS `rmt_user_info`;

CREATE TABLE `rmt_user_info` (
  `id` varchar(64) NOT NULL COMMENT '用户ID',
  `userCode` varchar(128) NOT NULL COMMENT '用户编码',
  `userName` varchar(128) NOT NULL COMMENT '用户名称',
  `userPassword` varchar(128) NOT NULL COMMENT '用户密码',
  `displayName` varchar(128) NOT NULL COMMENT '显示名称',
  `userThumb` varchar(128) DEFAULT NULL COMMENT '缩略图',
  `workCode` varchar(64) DEFAULT NULL COMMENT '工号',
  `oganizationID` varchar(64) DEFAULT NULL COMMENT '所属机构',
  `departmentID` varchar(64) DEFAULT NULL COMMENT '所属部门',
  `userExtendID` varchar(64) DEFAULT NULL COMMENT '用户扩展信息ID',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `createUserID` varchar(64) NOT NULL COMMENT '创建用户ID',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `modifyUserID` varchar(64) NOT NULL COMMENT '修改用户ID',
  `deletedTime` datetime DEFAULT NULL COMMENT '删除时间',
  `deletedUserID` varchar(64) DEFAULT '' COMMENT '删除用户ID',
  `deletedFlag` tinyint(4) DEFAULT NULL COMMENT '删除标记',
  `limitedTime` datetime DEFAULT NULL COMMENT '过期时间-2100年默认为永久有效',
  `loginCount` tinyint(4) DEFAULT NULL COMMENT '当前登入次数',
  `selectCondition` tinyint(11) DEFAULT NULL COMMENT '查询条件扩展，内部具体定义',
  `systemUserFlag` tinyint(4) DEFAULT NULL COMMENT '出厂自带用户标识',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(256) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_user_info` */

/*Table structure for table `rmt_user_login_info` */

DROP TABLE IF EXISTS `rmt_user_login_info`;

CREATE TABLE `rmt_user_login_info` (
  `id` varchar(64) NOT NULL COMMENT '条目信息ID',
  `userID` varchar(64) NOT NULL COMMENT '用户ID',
  `loginIP` varchar(64) NOT NULL COMMENT '登入地IP',
  `lastTimeLogin` datetime NOT NULL COMMENT '最后登入时间',
  `lastTimeLogout` int(11) NOT NULL COMMENT '最后退出时间',
  `reserved1` int(11) DEFAULT NULL COMMENT '保留',
  `reserved2` varchar(255) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `rmt_user_login_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
