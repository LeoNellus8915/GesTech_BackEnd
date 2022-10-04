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
-- Table structure for table `hy_dettagli_candidati`
--

DROP TABLE IF EXISTS `hy_dettagli_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_dettagli_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_candidato` int DEFAULT NULL,
  `file_base64` mediumtext,
  `data_inserimento` datetime DEFAULT NULL,
  `id_esito_colloquio` int DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_linguaggio1` int DEFAULT NULL,
  `id_linguaggio2` int DEFAULT NULL,
  `id_linguaggio3` int DEFAULT NULL,
  `id_linguaggio4` int DEFAULT NULL,
  `id_linguaggio5` int DEFAULT NULL,
  `id_lingua1` int DEFAULT NULL,
  `id_lingua2` int DEFAULT NULL,
  `id_lingua3` int DEFAULT NULL,
  `id_livello` int DEFAULT NULL,
  `linguaggio_campo_libero` varchar(100) DEFAULT NULL,
  `competenza_principale` varchar(100) DEFAULT NULL,
  `data_colloquio` date DEFAULT NULL,
  `anno_colloquio` int DEFAULT NULL,
  `fonte_reperimento` varchar(100) DEFAULT NULL,
  `costo_giornaliero` double DEFAULT NULL,
  `possibilita_lavorativa` varchar(100) DEFAULT NULL,
  `competenze_totali` varchar(100) DEFAULT NULL,
  `certificazioni` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_dettagli_candidati`
--

LOCK TABLES `hy_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `hy_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `hy_dettagli_candidati` VALUES (2,9,NULL,'2022-09-27 10:27:25',10,4,5,4,9,55,55,5,3,25,4,'aaaaa','aaaa','2022-09-08',2022,'aaaa',12,'aaaa','aaaa','aaaa');
/*!40000 ALTER TABLE `hy_dettagli_candidati` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-04  9:50:03
