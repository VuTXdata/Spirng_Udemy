CREATE DATABASE IF NOT EXISTS `employee_directory` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `employee` VALUES 
    (1,'Leslie','Andrews','leslie@luv2code.com'),
    (2,'Emma','Baumgarten','emma@luv2code.com'),
    (3,'Avani','Gupta','avani@luv2code.com'),
    (4,'Yuri','Petrov','yuri@luv2code.com'),
    (5,'Juan','Vega','juan@luv2code.com');
