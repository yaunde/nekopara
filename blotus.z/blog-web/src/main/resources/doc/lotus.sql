/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.21 : Database - lotus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`lotus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lotus`;

/*Table structure for table `lt_commentmeta` */

DROP TABLE IF EXISTS `lt_commentmeta`;

CREATE TABLE `lt_commentmeta` (
  `meta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`meta_id`),
  KEY `comment_id` (`comment_id`),
  KEY `meta_key` (`meta_key`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_commentmeta` */

/*Table structure for table `lt_comments` */

DROP TABLE IF EXISTS `lt_comments`;

CREATE TABLE `lt_comments` (
  `comment_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_post_ID` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '每个评论对应的文章的ID号',
  `comment_author` tinytext NOT NULL COMMENT '每个评论的评论者名称',
  `comment_author_email` varchar(100) NOT NULL DEFAULT '',
  `comment_author_url` varchar(200) NOT NULL DEFAULT '' COMMENT '每个评论的评论者网址',
  `comment_author_IP` varchar(100) NOT NULL DEFAULT '' COMMENT '每个评论的评论者的IP地址',
  `comment_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `comment_date_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '每个评论发表的时间，datetime值(是标准的格林尼治时间)',
  `comment_content` text NOT NULL COMMENT '每个评论的具体内容，text值',
  `comment_karma` int(11) NOT NULL DEFAULT '0',
  `comment_approved` varchar(20) NOT NULL DEFAULT '1' COMMENT '每个评论的当前状态，为一个枚举值enum(’0′,’1′,’spam’)，0为等待审核，1为允许发布，spam为垃圾评论。默认值为1',
  `comment_agent` varchar(255) NOT NULL DEFAULT '' COMMENT '每个评论的评论者的客户端信息，varchar(255)值，主要包括其浏览器和操作系统的类型、版本等资料。',
  `comment_type` varchar(20) NOT NULL DEFAULT '' COMMENT '评论的类型，varchar(20)值',
  `comment_parent` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '某一评论的上级评论，int(11)值，对应wp_comment.ID，默认为0，即无上级评论。',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '某一评论对应的用户ID，只有当用户注册后才会生成，int(11)值，对应wp_users.ID。未注册的用户，即外部评论者，这个ID的值为0',
  PRIMARY KEY (`comment_ID`),
  KEY `comment_post_ID` (`comment_post_ID`),
  KEY `comment_approved_date_gmt` (`comment_approved`,`comment_date_gmt`),
  KEY `comment_date_gmt` (`comment_date_gmt`),
  KEY `comment_parent` (`comment_parent`),
  KEY `comment_author_email` (`comment_author_email`(10))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章评论信息表';

/*Data for the table `lt_comments` */

/*Table structure for table `lt_links` */

DROP TABLE IF EXISTS `lt_links`;

CREATE TABLE `lt_links` (
  `link_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `link_url` varchar(255) NOT NULL DEFAULT '',
  `link_name` varchar(255) NOT NULL DEFAULT '',
  `link_image` varchar(255) NOT NULL DEFAULT '',
  `link_target` varchar(25) NOT NULL DEFAULT '',
  `link_description` varchar(255) NOT NULL DEFAULT '',
  `link_visible` varchar(20) NOT NULL DEFAULT 'Y',
  `link_owner` bigint(20) unsigned NOT NULL DEFAULT '1',
  `link_rating` int(11) NOT NULL DEFAULT '0',
  `link_updated` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `link_rel` varchar(255) NOT NULL DEFAULT '',
  `link_notes` mediumtext NOT NULL,
  `link_rss` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`link_id`),
  KEY `link_visible` (`link_visible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_links` */

/*Table structure for table `lt_options` */

DROP TABLE IF EXISTS `lt_options`;

CREATE TABLE `lt_options` (
  `option_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `option_name` varchar(191) NOT NULL DEFAULT '',
  `option_value` longtext NOT NULL,
  `autoload` varchar(20) NOT NULL DEFAULT 'yes',
  PRIMARY KEY (`option_id`),
  UNIQUE KEY `option_name` (`option_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_options` */

/*Table structure for table `lt_postmeta` */

DROP TABLE IF EXISTS `lt_postmeta`;

CREATE TABLE `lt_postmeta` (
  `meta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`meta_id`),
  KEY `post_id` (`post_id`),
  KEY `meta_key` (`meta_key`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_postmeta` */

/*Table structure for table `lt_posts` */

DROP TABLE IF EXISTS `lt_posts`;

CREATE TABLE `lt_posts` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `post_author` bigint(20) unsigned NOT NULL DEFAULT '0',
  `post_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_date_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_content` longtext NOT NULL,
  `post_title` text NOT NULL,
  `post_excerpt` text NOT NULL,
  `post_status` varchar(20) NOT NULL DEFAULT 'publish',
  `comment_status` varchar(20) NOT NULL DEFAULT 'open',
  `ping_status` varchar(20) NOT NULL DEFAULT 'open',
  `post_password` varchar(20) NOT NULL DEFAULT '',
  `post_name` varchar(200) NOT NULL DEFAULT '',
  `to_ping` text NOT NULL,
  `pinged` text NOT NULL,
  `post_modified` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_modified_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_content_filtered` longtext NOT NULL,
  `post_parent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `guid` varchar(255) NOT NULL DEFAULT '',
  `menu_order` int(11) NOT NULL DEFAULT '0',
  `post_type` varchar(20) NOT NULL DEFAULT 'post',
  `post_mime_type` varchar(100) NOT NULL DEFAULT '',
  `comment_count` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `post_name` (`post_name`(191)),
  KEY `type_status_date` (`post_type`,`post_status`,`post_date`,`ID`),
  KEY `post_parent` (`post_parent`),
  KEY `post_author` (`post_author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_posts` */

/*Table structure for table `lt_term_relationships` */

DROP TABLE IF EXISTS `lt_term_relationships`;

CREATE TABLE `lt_term_relationships` (
  `object_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `term_taxonomy_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `term_order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`term_taxonomy_id`),
  KEY `term_taxonomy_id` (`term_taxonomy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_term_relationships` */

/*Table structure for table `lt_term_taxonomy` */

DROP TABLE IF EXISTS `lt_term_taxonomy`;

CREATE TABLE `lt_term_taxonomy` (
  `term_taxonomy_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `term_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `taxonomy` varchar(32) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  `parent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `count` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`term_taxonomy_id`),
  UNIQUE KEY `term_id_taxonomy` (`term_id`,`taxonomy`),
  KEY `taxonomy` (`taxonomy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_term_taxonomy` */

/*Table structure for table `lt_termmeta` */

DROP TABLE IF EXISTS `lt_termmeta`;

CREATE TABLE `lt_termmeta` (
  `meta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `term_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`meta_id`),
  KEY `term_id` (`term_id`),
  KEY `meta_key` (`meta_key`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_termmeta` */

/*Table structure for table `lt_terms` */

DROP TABLE IF EXISTS `lt_terms`;

CREATE TABLE `lt_terms` (
  `term_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '',
  `slug` varchar(200) NOT NULL DEFAULT '',
  `term_group` bigint(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`term_id`),
  KEY `slug` (`slug`(191)),
  KEY `name` (`name`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_terms` */

/*Table structure for table `lt_usermeta` */

DROP TABLE IF EXISTS `lt_usermeta`;

CREATE TABLE `lt_usermeta` (
  `umeta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`umeta_id`),
  KEY `user_id` (`user_id`),
  KEY `meta_key` (`meta_key`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_usermeta` */

/*Table structure for table `lt_users` */

DROP TABLE IF EXISTS `lt_users`;

CREATE TABLE `lt_users` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_login` varchar(60) NOT NULL DEFAULT '' COMMENT '用户的注册名称',
  `user_pass` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_nicename` varchar(50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `user_email` varchar(100) NOT NULL DEFAULT '' COMMENT '电邮地址',
  `user_url` varchar(100) NOT NULL DEFAULT '' COMMENT '用户网址',
  `user_registered` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '用户注册时间，datetime值。',
  `user_activation_key` varchar(255) NOT NULL DEFAULT '' COMMENT '用户激活码，不详。',
  `user_status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态，int(11)值，默认为0',
  `display_name` varchar(250) NOT NULL DEFAULT '' COMMENT '来前台显示出来的用户名字',
  PRIMARY KEY (`ID`),
  KEY `user_login_key` (`user_login`),
  KEY `user_nicename` (`user_nicename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lt_users` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `type` tinyint(1) DEFAULT '0' COMMENT '0、禁用 1、正常',
  `ctime` datetime DEFAULT NULL COMMENT '自定义填充的创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`age`,`type`,`ctime`) values (784972358981328902,'Tom',24,127,'2018-03-03 00:00:00'),(784972358981328903,'Jammy',21,127,'2018-03-04 00:00:00');

/*Table structure for table `wp_commentmeta` */

DROP TABLE IF EXISTS `wp_commentmeta`;

CREATE TABLE `wp_commentmeta` (
  `meta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`meta_id`),
  KEY `comment_id` (`comment_id`),
  KEY `meta_key` (`meta_key`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章评论额外信息表。';

/*Data for the table `wp_commentmeta` */

/*Table structure for table `wp_comments` */

DROP TABLE IF EXISTS `wp_comments`;

CREATE TABLE `wp_comments` (
  `comment_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_post_ID` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '每个评论对应的文章的ID号',
  `comment_author` tinytext NOT NULL COMMENT '每个评论的评论者名称',
  `comment_author_email` varchar(100) NOT NULL DEFAULT '',
  `comment_author_url` varchar(200) NOT NULL DEFAULT '' COMMENT '每个评论的评论者网址',
  `comment_author_IP` varchar(100) NOT NULL DEFAULT '' COMMENT '每个评论的评论者的IP地址',
  `comment_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `comment_date_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '每个评论发表的时间，datetime值(是标准的格林尼治时间)',
  `comment_content` text NOT NULL COMMENT '每个评论的具体内容，text值',
  `comment_karma` int(11) NOT NULL DEFAULT '0',
  `comment_approved` varchar(20) NOT NULL DEFAULT '1' COMMENT '每个评论的当前状态，为一个枚举值enum(’0′,’1′,’spam’)，0为等待审核，1为允许发布，spam为垃圾评论。默认值为1',
  `comment_agent` varchar(255) NOT NULL DEFAULT '' COMMENT '每个评论的评论者的客户端信息，varchar(255)值，主要包括其浏览器和操作系统的类型、版本等资料。',
  `comment_type` varchar(20) NOT NULL DEFAULT '' COMMENT '评论的类型，varchar(20)值',
  `comment_parent` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '某一评论的上级评论，int(11)值，对应wp_comment.ID，默认为0，即无上级评论。',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '某一评论对应的用户ID，只有当用户注册后才会生成，int(11)值，对应wp_users.ID。未注册的用户，即外部评论者，这个ID的值为0',
  PRIMARY KEY (`comment_ID`),
  KEY `comment_post_ID` (`comment_post_ID`),
  KEY `comment_approved_date_gmt` (`comment_approved`,`comment_date_gmt`),
  KEY `comment_date_gmt` (`comment_date_gmt`),
  KEY `comment_parent` (`comment_parent`),
  KEY `comment_author_email` (`comment_author_email`(10))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章评论信息表';

/*Data for the table `wp_comments` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
