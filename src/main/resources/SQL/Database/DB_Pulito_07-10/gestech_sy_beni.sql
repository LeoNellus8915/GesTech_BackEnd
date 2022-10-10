CREATE DATABASE  IF NOT EXISTS `gestech` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestech`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestech
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `sy_beni`
--

DROP TABLE IF EXISTS `sy_beni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_beni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dispositivo` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `modello` varchar(100) DEFAULT NULL,
  `numero_seriale` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `note` text,
  `dipendente` varchar(100) DEFAULT NULL,
  `societa` varchar(100) DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `data_restituzione` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_beni`
--

LOCK TABLES `sy_beni` WRITE;
/*!40000 ALTER TABLE `sy_beni` DISABLE KEYS */;
INSERT INTO `sy_beni` VALUES (7,'Pc Portatile','Hp','laptop15bs1xx','SED12318GHIR','1010','','Paolo Bianchi','Rpctech',NULL,NULL),(8,'Pc Portatile','Asus','Z598hj004','SDV58406980BJ0','1234','','','',NULL,NULL),(9,'Tablet','Samsung','GalaxyTab 5','FB4561537DFDB8','Non presente','','','',NULL,NULL),(10,'Pc Portatile','Hp','laptop15bs1xx','SED12318GHIR','1010','','Carlo Neri','Rpctech','2022-10-08','2022-10-06'),(11,'Pc Portatile','Hp','laptop15bs1xx','SED12318GHIR','1010','','Francesca Rosa','Rpctech','2022-10-10','2022-10-13');
/*!40000 ALTER TABLE `sy_beni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-07 10:45:10
