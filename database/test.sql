/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.35-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `VERSION` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`age`,`email`,`VERSION`,`deleted`,`create_time`,`update_time`) values (1,'Jone',120,'test1@baomidou.com',NULL,1,NULL,'2021-08-30 10:46:32'),(2,'Andy123',12,'test2@baomidou.com',NULL,0,NULL,'2021-08-31 15:33:21'),(3,'Andy123',12,'test3@baomidou.com',NULL,0,NULL,'2021-08-31 15:33:21'),(4,'Andy123',12,'test4@baomidou.com',NULL,0,NULL,'2021-08-31 15:33:21'),(5,'Andy123',12,'test5@baomidou.com',NULL,0,NULL,'2021-08-31 15:33:21'),(6,'Andy123',12,'123456789@qq.com',1,0,'2021-08-30 10:47:29','2021-08-31 15:33:21'),(7,'market',120,'123456789@qq.com',2,1,'2021-08-30 10:50:29','2021-08-30 10:51:20'),(8,'Andy123',12,'123456789@qq.com',1,0,'2021-08-31 15:27:15','2021-08-31 15:33:21'),(9,'market',111,'123456789@qq.com',1,1,'2021-08-31 15:30:49','2021-08-31 15:30:49'),(10,'Andy123',12,'123456789@qq.com',1,0,'2021-08-31 15:33:21','2021-08-31 15:33:21');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
