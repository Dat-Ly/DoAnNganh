-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: qlpt
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `idBill` int NOT NULL AUTO_INCREMENT,
  `total` decimal(10,0) NOT NULL,
  `idRoom` int NOT NULL,
  `createDate` date NOT NULL,
  `idCustomer` int NOT NULL,
  `tienNuoc` decimal(10,0) NOT NULL,
  `tienDien` decimal(10,0) NOT NULL,
  `tienPhong` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idBill`),
  KEY `fk_bill_room_idx` (`idRoom`),
  KEY `fk_bill_cus_idx` (`idCustomer`),
  CONSTRAINT `fk_bill_cus` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_room` FOREIGN KEY (`idRoom`) REFERENCES `room` (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (8,2600000,3,'2022-10-26',15,200000,400000,2000000);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `idCustomer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `idRoom` int NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`idCustomer`),
  KEY `fk_cus_room_idx` (`idRoom`),
  CONSTRAINT `fk_cus_room` FOREIGN KEY (`idRoom`) REFERENCES `room` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (15,'Hau','0123654789',3,'456@gmail.com'),(18,'Hung','0765919498',5,'456@gmail.com'),(19,'Luan','0123999999',4,'456@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `idRoom` int NOT NULL AUTO_INCREMENT,
  `roomName` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `avatar` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `soluong` int DEFAULT NULL,
  `trangthai` varchar(45) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',1,'PHÒNG TRỐNG'),(3,'A04',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665840020/tgamcnkc86v4rgkg7qvv.jpg',1,'ĐÃ THUÊ'),(4,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',1,'ĐÃ THUÊ'),(5,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',1,'PHÒNG TRỐNG'),(6,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',2,'PHÒNG TRỐNG'),(7,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',3,'PHÒNG TRỐNG'),(9,'A03',2000000,'https://res.cloudinary.com/lydat/image/upload/v1665737049/i9frodfpi0rhdoor1o8u.jpg',1,'PHÒNG TRỐNG'),(11,'A02',100000,'https://res.cloudinary.com/lydat/image/upload/v1665967232/ibblshp7fveaiox3qyz0.jpg',1,'PHÒNG TRỐNG');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-26 17:15:58
