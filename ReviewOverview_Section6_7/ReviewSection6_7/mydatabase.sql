CREATE DATABASE IF NOT EXISTS `mydatabase` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `mydatabase`;

DROP TABLE IF EXISTS `student`;

create table `student`(
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) default null,
  `semester` varchar(45) default null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

