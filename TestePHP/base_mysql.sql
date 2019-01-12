/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.37-MariaDB : Database - test_supero
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_supero` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test_supero`;

/*Table structure for table `tasklist` */

DROP TABLE IF EXISTS `tasklist`;

CREATE TABLE `tasklist` (
  `cd_product` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nm_product` varchar(65) NOT NULL,
  `ds_product` text,
  `status` int(1) NOT NULL DEFAULT '0',
  `dt_creation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_alteration` datetime DEFAULT NULL,
  PRIMARY KEY (`cd_product`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tasklist` */

insert  into `tasklist`(`cd_product`,`nm_product`,`ds_product`,`status`,`dt_creation`,`dt_alteration`) values (1,'Teste 1','Descrição 1',1,'2019-01-09 17:26:51','2019-01-09 19:12:02'),(2,'Teste 2','Descrição 2',0,'2019-01-09 17:26:51','2019-01-09 19:12:15'),(3,'Teste 3','Descrição 3',0,'2019-01-09 19:12:27',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
