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
-- Table structure for table `hr_persone`
--

DROP TABLE IF EXISTS `hr_persone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_persone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `codice_fiscale` varchar(16) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cellulare` varchar(10) DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL,
  `citta_di_nascita` varchar(100) DEFAULT NULL,
  `citta_di_residenza` varchar(100) DEFAULT NULL,
  `indirizzo_di_residenza` varchar(100) DEFAULT NULL,
  `cap_di_residenza` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_persone`
--

LOCK TABLES `hr_persone` WRITE;
/*!40000 ALTER TABLE `hr_persone` DISABLE KEYS */;
INSERT INTO `hr_persone` VALUES (1,'Mario','Rossi','','mario.rossi@prova.com','3345899562','1984-08-02','Roma','Roma','Viale Ippocrate 64',161),(2,'Francesca','Rosa',NULL,'francesca.rosa@prova.com','3341896587','1989-07-06','Bologna','Milano','Via Emilio Gola 22',20143),(3,'Carlo','Neri',NULL,'carlo.neri@prova.com','3398766485','1973-05-18','Milano','Roma','Via Giulio Adamoli 35',147),(4,'Paolo','Bianchi',NULL,'paolo.bianchi@prova.com','3341258965','1979-06-06','Roma','Roma','Via Vigna di Fabbri 13',179),(5,'Luca','Gialli',NULL,'luca.gialli@prova.com','3298744156','1980-02-22','Prato','Roma','Viale Palmiro Togliatti 1474',155),(6,'Giovanni','Verdi',NULL,'giovanni.verdi@prova.com','3348968852','1991-12-09','Macerata','Milano','Via dei Soranzo 2',20148),(7,'Primo','Candidato',NULL,'candidato1@prova.com','3314522658','1994-10-14','Pesaro','Macerata','Via Ettore Ricci 111',62100),(8,'Secondo','Candidato',NULL,'candidato2@prova.com','3354969985','1985-12-12','Milano','Milano','Via Antonio Curti 1',20136),(9,'Terzo','Candidato',NULL,'candidato3@prova.com','3465898676','1973-02-25','Roma','Milano','Via Pace 17',20122),(10,'Non','Assegnato',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hr_persone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-28 10:33:34
