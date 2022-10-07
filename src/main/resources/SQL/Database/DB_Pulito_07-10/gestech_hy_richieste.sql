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
-- Table structure for table `hy_richieste`
--

DROP TABLE IF EXISTS `hy_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `id_linguaggio` int DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_livello` int DEFAULT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `citta` varchar(100) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `note` text,
  `recruiter` varchar(100) DEFAULT NULL,
  `id_stato` int DEFAULT '1',
  `priorita` int DEFAULT NULL,
  `candidati` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_richieste`
--

LOCK TABLES `hy_richieste` WRITE;
/*!40000 ALTER TABLE `hy_richieste` DISABLE KEYS */;
INSERT INTO `hy_richieste` VALUES (26,2,'2022-10-05 11:09:16',55,14,2,'Accenture','Roma',100,'Va trovato entro questa settimana',NULL,1,1,NULL),(27,2,'2022-10-05 11:32:03',2,2,4,'RpcTech','Roma',40,'...',NULL,3,2,NULL),(28,2,'2022-10-05 11:35:37',55,3,6,'RpcTech','Milano',20,'.',NULL,1,2,NULL),(29,2,'2022-10-07 09:44:33',5,6,5,'RpcTech','Roma',50,'','Giovanni Verdi',2,3,'Francesco Grassi,Valentino Ruggeri');
/*!40000 ALTER TABLE `hy_richieste` ENABLE KEYS */;
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
