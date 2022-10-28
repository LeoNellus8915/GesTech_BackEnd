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
-- Table structure for table `am_richieste`
--

DROP TABLE IF EXISTS `am_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `am_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_linguaggio` int DEFAULT NULL,
  `id_livello` int DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `citta` varchar(100) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `note` text,
  `recruiter` varchar(100) DEFAULT NULL,
  `id_stato` int DEFAULT '1',
  `priorita` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_richieste`
--

LOCK TABLES `am_richieste` WRITE;
/*!40000 ALTER TABLE `am_richieste` DISABLE KEYS */;
INSERT INTO `am_richieste` VALUES (35,3,'2022-10-17 16:21:55',6,6,2,3,'Bracciano',1200,'Messaggio di prova','Verdi  Giovanni',3,2),(36,3,'2022-10-17 16:22:27',2,3,3,1,'Roma',1200,'Messaggio di prova','Candidato  Primo, Verdi  Giovanni',2,1),(37,3,'2022-10-17 16:22:51',8,9,4,1,'Milano',1200,'Messaggio di prova','Verdi  Giovanni',1,1),(38,3,'2022-10-18 11:18:42',5,6,2,3,'Roma',1200,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Verdi  Giovanni, Candidato  Primo',4,2),(39,3,'2022-10-18 12:18:31',2,5,2,2,'Roma',1200,'','Verdi  Giovanni, Candidato  Primo',4,2);
/*!40000 ALTER TABLE `am_richieste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-28 10:33:36
