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
-- Table structure for table `am_clienti`
--

DROP TABLE IF EXISTS `am_clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `am_clienti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `sede` varchar(100) DEFAULT NULL,
  `partita_iva` varchar(100) DEFAULT NULL,
  `stato` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_clienti`
--

LOCK TABLES `am_clienti` WRITE;
/*!40000 ALTER TABLE `am_clienti` DISABLE KEYS */;
INSERT INTO `am_clienti` VALUES (1,'Cliente 1','Via Inventata 1','13258985745',1),(2,'Cliente 2','Via Inventata 2','12525478563',1),(3,'Cliente 3','Via Inventata 3','11231525214',0);
/*!40000 ALTER TABLE `am_clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_hardware`
--

DROP TABLE IF EXISTS `am_hardware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `am_hardware` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `id_dispositivo` int DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modello` varchar(100) DEFAULT NULL,
  `seriale` varchar(50) DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `data_restituzione` date DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_hardware`
--

LOCK TABLES `am_hardware` WRITE;
/*!40000 ALTER TABLE `am_hardware` DISABLE KEYS */;
INSERT INTO `am_hardware` VALUES (22,6,2,'Hp','laptop15bs1xx','SN1484454874684','2022-11-03',NULL,''),(23,10,4,'Hp','Z598hj004','SN7845468','2022-11-03',NULL,''),(24,43,2,'Hp','laptop15bs1xx','SN1484454874684','2022-10-20','2022-10-31','prova');
/*!40000 ALTER TABLE `am_hardware` ENABLE KEYS */;
UNLOCK TABLES;

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
  `recruiter` mediumtext,
  `id_stato` int DEFAULT '1',
  `priorita` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_richieste`
--

LOCK TABLES `am_richieste` WRITE;
/*!40000 ALTER TABLE `am_richieste` DISABLE KEYS */;
INSERT INTO `am_richieste` VALUES (50,3,'2022-11-07 10:04:12',2,3,3,2,'Roma',60,'Urgente\nScadenza xx/xx',NULL,1,0),(51,3,'2022-11-07 10:04:29',14,55,4,3,'Roma',40,'','Giovanni  Verdi, Tommaso  Azzurro, Alessandra  Viola',4,1),(52,3,'2022-11-07 10:04:48',2,2,4,2,'Milano',40,'',NULL,1,2);
/*!40000 ALTER TABLE `am_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ap_auth`
--

DROP TABLE IF EXISTS `ap_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ap_auth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_auth`
--

LOCK TABLES `ap_auth` WRITE;
/*!40000 ALTER TABLE `ap_auth` DISABLE KEYS */;
INSERT INTO `ap_auth` VALUES (1,1,'21232f297a57a5a743894a0e4a801fc3','2022-07-15'),(2,2,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(3,3,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(4,4,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(5,5,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(6,6,'21232f297a57a5a743894a0e4a801fc3','2022-09-28'),(10,43,'21232f297a57a5a743894a0e4a801fc3','2022-11-03'),(11,44,'21232f297a57a5a743894a0e4a801fc3','2022-11-03'),(12,45,'21232f297a57a5a743894a0e4a801fc3','2022-11-03');
/*!40000 ALTER TABLE `ap_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ap_ruoli_persone`
--

DROP TABLE IF EXISTS `ap_ruoli_persone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ap_ruoli_persone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `id_ruolo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_ruoli_persone`
--

LOCK TABLES `ap_ruoli_persone` WRITE;
/*!40000 ALTER TABLE `ap_ruoli_persone` DISABLE KEYS */;
INSERT INTO `ap_ruoli_persone` VALUES (1,1,1),(2,2,3),(3,2,2),(4,3,4),(5,3,2),(6,4,5),(7,4,2),(8,5,6),(9,5,2),(10,6,7),(11,6,2),(14,44,7),(15,44,2),(16,45,7),(17,45,2);
/*!40000 ALTER TABLE `ap_ruoli_persone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ap_session`
--

DROP TABLE IF EXISTS `ap_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ap_session` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `token` mediumtext,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_session`
--

LOCK TABLES `ap_session` WRITE;
/*!40000 ALTER TABLE `ap_session` DISABLE KEYS */;
INSERT INTO `ap_session` VALUES (132,1,'ZmQwY2QzODNlNzIzNDYxMzg0ODc2MDRiMzk0MjlhMWE6MjAyMjExMzEyNzQzOjA0NmQyN2ZlYmY3NzRjMTg5NTg4N2ZkNGI3YzBjZmI4','2022-11-03 12:16:17'),(139,45,'MjRlN2U0MzgzNTQ0NGIzMWFkMzdhM2JkMmYxOWJjNzU6MjAyMjExMzE1MjU1Mzo5OGRiMjE0NzAzOTA0OGI2ODQzNTJjMGMxMzMyMzIwNQ==','2022-11-03 15:25:53'),(179,44,'YjRlN2VjNTM5OGRmNDJiMzgxMDAwMzk2OWU5M2IzNzA6MjAyMjExMzE3NTAxODpiNjcyNTExNGYwYTk0M2YyOTVjNGUzNGFkYTI3NTI3Mw==','2022-11-03 17:50:21'),(202,4,'MmE2NWYzZDBlOTBhNDZjZGFlNDQzMTIxMjFkYzIxM2Q6MjAyMjExNzEwNTQ0OjRhZGNiNmZkZjlmZDRiYzY5NzQ3NTE5MTJlZWRlODky','2022-11-07 10:05:54'),(203,5,'MzMwZGVjOTZmNDkwNGQ0YWI1MWU0NjA4NzhmMzhhZWU6MjAyMjExNzEwNjM6ZjIyNzRlNGUwYzc3NGY3OGIzMmQ4MTY3ZjRmNTNhZmU=','2022-11-07 10:06:19'),(204,6,'OTg0YzMyZTkxNmZmNDdlMTgyZWY5ZTgwZjk2YjFiMjA6MjAyMjExNzEwNjI1OjY3YTdiOGExMzczZTRmMTg4YTg2OWY3Mzg1ZTIyZDRi','2022-11-07 10:06:42'),(206,3,'MGRkMDkxZDhmYThlNGE1NThiYTliMWI0ODdmOTllYWM6MjAyMjExNzEwMTAyOjE1ZmFiZWQxN2Y0NzRjM2NhYjhkN2UzZDMxZWJjYzAx','2022-11-07 10:10:08'),(207,2,'ZTkzNTliYTg3ZWY4NDIwN2ExYjM4ZDVhYzcwYWFmZTg6MjAyMjExNzEwMTAzNDo0N2NkMDRiYTc2Yzg0ZDVhYmE1YzhkNDcwNjk1YmZiMA==','2022-11-07 10:10:43');
/*!40000 ALTER TABLE `ap_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `as_lingue_dettagli_candidati`
--

DROP TABLE IF EXISTS `as_lingue_dettagli_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_lingue_dettagli_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dettaglio_candidato` int DEFAULT NULL,
  `id_lingua` int DEFAULT NULL,
  `descrizione` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_lingue_dettagli_candidati`
--

LOCK TABLES `as_lingue_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_lingue_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_lingue_dettagli_candidati` VALUES (51,40,4,''),(52,40,15,''),(53,41,5,''),(54,41,9,''),(55,41,15,'');
/*!40000 ALTER TABLE `as_lingue_dettagli_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `as_profili_dettagli_candidati`
--

DROP TABLE IF EXISTS `as_profili_dettagli_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_profili_dettagli_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dettaglio_candidato` int DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_livello` int DEFAULT NULL,
  `id_linguaggio` int DEFAULT '0',
  `descrizione` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_profili_dettagli_candidati`
--

LOCK TABLES `as_profili_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_profili_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_profili_dettagli_candidati` VALUES (85,40,2,2,3,''),(86,41,14,2,55,''),(87,42,2,4,3,'');
/*!40000 ALTER TABLE `as_profili_dettagli_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `as_richieste_dettagli_candidati`
--

DROP TABLE IF EXISTS `as_richieste_dettagli_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_richieste_dettagli_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_richiesta` int DEFAULT NULL,
  `id_dettaglio_candidato` int DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_richieste_dettagli_candidati`
--

LOCK TABLES `as_richieste_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_richieste_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_richieste_dettagli_candidati` VALUES (45,51,40,NULL),(46,51,41,NULL);
/*!40000 ALTER TABLE `as_richieste_dettagli_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `as_richieste_persone`
--

DROP TABLE IF EXISTS `as_richieste_persone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_richieste_persone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `id_richiesta` int DEFAULT NULL,
  `visualizzato` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_richieste_persone`
--

LOCK TABLES `as_richieste_persone` WRITE;
/*!40000 ALTER TABLE `as_richieste_persone` DISABLE KEYS */;
INSERT INTO `as_richieste_persone` VALUES (48,6,51,1),(49,44,51,0),(50,45,51,0);
/*!40000 ALTER TABLE `as_richieste_persone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hr_contratti`
--

DROP TABLE IF EXISTS `hr_contratti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_contratti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `id_tipo_contratto` int DEFAULT NULL,
  `id_ccnl` int DEFAULT NULL,
  `data_di_inizio` date DEFAULT NULL,
  `data_di_fine` date DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `periodo_di_prova` int DEFAULT NULL,
  `ral` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_contratti`
--

LOCK TABLES `hr_contratti` WRITE;
/*!40000 ALTER TABLE `hr_contratti` DISABLE KEYS */;
INSERT INTO `hr_contratti` VALUES (1,1,NULL,NULL,NULL,NULL,5,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,3,NULL,NULL),(3,3,NULL,NULL,NULL,NULL,1,NULL,NULL),(4,4,NULL,NULL,NULL,NULL,1,NULL,NULL),(5,5,NULL,NULL,NULL,NULL,2,NULL,NULL),(6,6,NULL,NULL,NULL,NULL,3,NULL,NULL),(11,43,0,0,NULL,NULL,2,0,0),(12,44,0,0,NULL,NULL,4,0,0),(13,45,0,0,NULL,NULL,1,0,0);
/*!40000 ALTER TABLE `hr_contratti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hr_dettagli_candidati`
--

DROP TABLE IF EXISTS `hr_dettagli_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_dettagli_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `profilo_linkedin` varchar(100) DEFAULT NULL,
  `data_inserimento` datetime DEFAULT NULL,
  `id_esito_colloquio` int DEFAULT NULL,
  `competenza_principale` varchar(100) DEFAULT NULL,
  `data_colloquio` date DEFAULT NULL,
  `anno_colloquio` int DEFAULT NULL,
  `fonte_reperimento` varchar(100) DEFAULT NULL,
  `costo_giornaliero` double DEFAULT NULL,
  `possibilita_lavorativa` varchar(100) DEFAULT NULL,
  `competenze_totali` varchar(100) DEFAULT NULL,
  `certificazioni` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_dettagli_candidati`
--

LOCK TABLES `hr_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `hr_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `hr_dettagli_candidati` VALUES (40,46,'prova1.com','2022-11-07 09:23:40',2,'Programmatore Java','2022-11-04',2022,'Linkedin',60,'','',''),(41,47,'prova2.com','2022-11-07 09:25:21',5,'Sistemista','2022-09-16',2022,'Linkedin',60,'','',''),(42,48,'prova3.com','2022-11-07 09:26:47',11,'Programmatore Java','2021-08-07',2021,'Linkedin',40,'','','');
/*!40000 ALTER TABLE `hr_dettagli_candidati` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_persone`
--

LOCK TABLES `hr_persone` WRITE;
/*!40000 ALTER TABLE `hr_persone` DISABLE KEYS */;
INSERT INTO `hr_persone` VALUES (1,'Mario','Rossi','','mario.rossi@prova.com','3345899562','1984-08-02','Roma','Roma','Viale Ippocrate 64',161),(2,'Francesca','Rosa',NULL,'francesca.rosa@prova.com','3341896587','1989-07-06','Bologna','Milano','Via Emilio Gola 22',20143),(3,'Carlo','Neri',NULL,'carlo.neri@prova.com','3398766485','1973-05-18','Milano','Roma','Via Giulio Adamoli 35',147),(4,'Paolo','Bianchi',NULL,'paolo.bianchi@prova.com','3341258965','1979-06-06','Roma','Roma','Via Vigna di Fabbri 13',179),(5,'Luca','Gialli',NULL,'luca.gialli@prova.com','3298744156','1980-02-22','Prato','Roma','Viale Palmiro Togliatti 1474',155),(6,'Giovanni','Verdi',NULL,'giovanni.verdi@prova.com','3348968852','1991-12-09','Macerata','Milano','Via dei Soranzo 2',20148),(7,'Primo','Candidato',NULL,'candidato1@prova.com','3314522658','1994-10-14','Pesaro','Macerata','Via Ettore Ricci 111',62100),(8,'Secondo','Candidato',NULL,'candidato2@prova.com','3348599875','1985-12-12','Milano','Roma','Via Antonio Curti 1',20136),(9,'Terzo','Candidato',NULL,'candidato3@prova.com','3465898676','1973-02-25','Roma','Milano','Via Pace 17',20122),(10,'Non','Assegnato',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'Tommaso','Azzurro',NULL,'tommaso.azzurro@prova.com',NULL,NULL,NULL,NULL,NULL,0),(45,'Alessandra','Viola',NULL,'alessandra.viola@prova.com',NULL,NULL,NULL,NULL,NULL,0),(46,'Primo','Candidato',NULL,'primo.candidato@prova.com','3348599875',NULL,NULL,'Milano',NULL,0),(47,'Secondo','Candidato',NULL,'secondo.candidato@prova.com','3346589658',NULL,NULL,'Roma',NULL,0),(48,'Terzo','Candidato',NULL,'terzo.candidato@prova.com','3346589658',NULL,NULL,'Milano',NULL,0);
/*!40000 ALTER TABLE `hr_persone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hs_avvisi`
--

DROP TABLE IF EXISTS `hs_avvisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hs_avvisi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `titolo` varchar(100) DEFAULT NULL,
  `ruoli` varchar(100) DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_avvisi`
--

LOCK TABLES `hs_avvisi` WRITE;
/*!40000 ALTER TABLE `hs_avvisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `hs_avvisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hs_cv`
--

DROP TABLE IF EXISTS `hs_cv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hs_cv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `file_cv_base64` mediumtext,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_cv`
--

LOCK TABLES `hs_cv` WRITE;
/*!40000 ALTER TABLE `hs_cv` DISABLE KEYS */;
/*!40000 ALTER TABLE `hs_cv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hs_dettagli_contratti`
--

DROP TABLE IF EXISTS `hs_dettagli_contratti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hs_dettagli_contratti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_contratto` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_dettagli_contratti`
--

LOCK TABLES `hs_dettagli_contratti` WRITE;
/*!40000 ALTER TABLE `hs_dettagli_contratti` DISABLE KEYS */;
/*!40000 ALTER TABLE `hs_dettagli_contratti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_commenti_candidati`
--

DROP TABLE IF EXISTS `ms_commenti_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_commenti_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dettaglio_candidato` int DEFAULT NULL,
  `id_persona` int DEFAULT NULL,
  `note` text,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_commenti_candidati`
--

LOCK TABLES `ms_commenti_candidati` WRITE;
/*!40000 ALTER TABLE `ms_commenti_candidati` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_commenti_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_commenti_richieste`
--

DROP TABLE IF EXISTS `ms_commenti_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_commenti_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_persona` int DEFAULT NULL,
  `id_richiesta` int DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  `nascosto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_commenti_richieste`
--

LOCK TABLES `ms_commenti_richieste` WRITE;
/*!40000 ALTER TABLE `ms_commenti_richieste` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_commenti_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_aziende`
--

DROP TABLE IF EXISTS `ty_aziende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_aziende` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_aziende`
--

LOCK TABLES `ty_aziende` WRITE;
/*!40000 ALTER TABLE `ty_aziende` DISABLE KEYS */;
INSERT INTO `ty_aziende` VALUES (1,'Azienda 1'),(2,'Azienda 2'),(3,'Azienda 3'),(4,'Azienda 4'),(5,'Azienda 5');
/*!40000 ALTER TABLE `ty_aziende` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_benefit`
--

DROP TABLE IF EXISTS `ty_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_benefit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_benefit`
--

LOCK TABLES `ty_benefit` WRITE;
/*!40000 ALTER TABLE `ty_benefit` DISABLE KEYS */;
INSERT INTO `ty_benefit` VALUES (1,'Assicurazione Sanitaria',NULL),(2,'Buoni Pasto',NULL),(3,'Auto Aziendale',NULL),(4,'Rimborso Km',NULL);
/*!40000 ALTER TABLE `ty_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_ccnl`
--

DROP TABLE IF EXISTS `ty_ccnl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_ccnl` (
  `id` int NOT NULL,
  `codice` int DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_ccnl`
--

LOCK TABLES `ty_ccnl` WRITE;
/*!40000 ALTER TABLE `ty_ccnl` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_ccnl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_corsi`
--

DROP TABLE IF EXISTS `ty_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_corsi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_corsi`
--

LOCK TABLES `ty_corsi` WRITE;
/*!40000 ALTER TABLE `ty_corsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_dispositivi`
--

DROP TABLE IF EXISTS `ty_dispositivi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_dispositivi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_dispositivi`
--

LOCK TABLES `ty_dispositivi` WRITE;
/*!40000 ALTER TABLE `ty_dispositivi` DISABLE KEYS */;
INSERT INTO `ty_dispositivi` VALUES (1,'cellulare',NULL),(2,'portatile',NULL),(3,'mouse',NULL),(4,'monitor',NULL),(5,'non selezionato',NULL);
/*!40000 ALTER TABLE `ty_dispositivi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_esiti_colloquio`
--

DROP TABLE IF EXISTS `ty_esiti_colloquio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_esiti_colloquio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `colore` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_esiti_colloquio`
--

LOCK TABLES `ty_esiti_colloquio` WRITE;
/*!40000 ALTER TABLE `ty_esiti_colloquio` DISABLE KEYS */;
INSERT INTO `ty_esiti_colloquio` VALUES (1,'Ottimo',1),(2,'Positivo',1),(3,'Negativo',3),(4,'Pessimo',3),(5,'Da Ricolloquiare',2),(6,'Non si Presenta',2),(7,'Non Ricontattare',3),(8,'Non Risponde al Telefono',2),(9,'Rinuncia',2),(10,'Inaffidabile',3),(11,'Non Colloquiato',4);
/*!40000 ALTER TABLE `ty_esiti_colloquio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_linguaggi`
--

DROP TABLE IF EXISTS `ty_linguaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_linguaggi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_linguaggi`
--

LOCK TABLES `ty_linguaggi` WRITE;
/*!40000 ALTER TABLE `ty_linguaggi` DISABLE KEYS */;
INSERT INTO `ty_linguaggi` VALUES (1,'cobol'),(2,'php'),(3,'java'),(4,'java BE'),(5,'java FE'),(6,'J2EE'),(7,'spring'),(8,'struts'),(9,'.net c#'),(10,'.net vb.net'),(11,'c'),(12,'c++'),(13,'web'),(14,'pl/sql'),(15,'tsql'),(16,'hibernate'),(17,'angular js'),(18,'mysql'),(19,'sviluppo'),(20,'testing'),(21,'uml'),(22,'devops'),(23,'agile'),(24,'micro servizi'),(25,'scrum'),(26,'unix'),(27,'linux'),(28,'microsoft'),(29,'mvs'),(30,'db2'),(31,'oracle'),(32,'sql server'),(33,'mongodb'),(34,'distribuiti/ass-tecnica'),(35,'sna'),(36,'cisco'),(37,'tcp'),(38,'voip'),(39,'tlc'),(40,'abap'),(41,'sap'),(42,'microstrategy'),(43,'powercenter'),(44,'bo'),(45,'datastage'),(46,'qlikview'),(47,'qliksense'),(48,'siebel'),(49,'salesforce'),(50,'tibco'),(51,'bea'),(52,'jboss'),(53,'websphere'),(54,'broadcasting'),(55,'Non specificato');
/*!40000 ALTER TABLE `ty_linguaggi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_lingue`
--

DROP TABLE IF EXISTS `ty_lingue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_lingue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_lingue`
--

LOCK TABLES `ty_lingue` WRITE;
/*!40000 ALTER TABLE `ty_lingue` DISABLE KEYS */;
INSERT INTO `ty_lingue` VALUES (1,'Inglese A1 Beginner'),(2,'Inglese A2 Beginner'),(3,'Inglese B1 Intermediate'),(4,'Inglese B2 Intermediate'),(5,'Inglese C1 Advanced'),(6,'Inglese C2 Advanced'),(7,'Francese A1 Beginner'),(8,'Francese A2 Beginner'),(9,'Francese B1 Intermediate'),(10,'Francese B2 Intermediate'),(11,'Francese C1 Advanced'),(12,'Francese C2 Advanced'),(13,'Spagnolo A1 Beginner'),(14,'Spagnolo A2 Beginner'),(15,'Spagnolo B1 Intermediate'),(16,'Spagnolo B2 Intermediate'),(17,'Spagnolo C1 Advanced'),(18,'Spagnolo C2 Advanced'),(19,'Tedesco A1 Beginner'),(20,'Tedesco A2 Beginner'),(21,'Tedesco B1 Intermediate'),(22,'Tedesco B2 Intermediate'),(23,'Tedesco C1 Advanced'),(24,'Tedesco C1 Advanced'),(25,'Non specificato');
/*!40000 ALTER TABLE `ty_lingue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_livelli`
--

DROP TABLE IF EXISTS `ty_livelli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_livelli` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_livelli`
--

LOCK TABLES `ty_livelli` WRITE;
/*!40000 ALTER TABLE `ty_livelli` DISABLE KEYS */;
INSERT INTO `ty_livelli` VALUES (1,'master > 10'),(2,'senior > 5 e < 10'),(3,'expert > 2 e < 5'),(4,'junior < 2'),(5,'neog = 0'),(6,'Non specificato');
/*!40000 ALTER TABLE `ty_livelli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_profili`
--

DROP TABLE IF EXISTS `ty_profili`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_profili` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_profili`
--

LOCK TABLES `ty_profili` WRITE;
/*!40000 ALTER TABLE `ty_profili` DISABLE KEYS */;
INSERT INTO `ty_profili` VALUES (1,'analista funzionale'),(2,'analista programmatore'),(3,'architetto'),(4,'broadcast video'),(5,'capo progetto/team leader'),(6,'dba'),(7,'gestore applicativo'),(8,'network engineer'),(9,'operatore'),(10,'pmo'),(11,'progettista sicurezza'),(12,'progettista telecomunicazioni'),(13,'security engineer'),(14,'sistemista'),(15,'sistemista applicativo'),(16,'software tester'),(17,'Non specificato');
/*!40000 ALTER TABLE `ty_profili` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_ruoli`
--

DROP TABLE IF EXISTS `ty_ruoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_ruoli` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_ruoli`
--

LOCK TABLES `ty_ruoli` WRITE;
/*!40000 ALTER TABLE `ty_ruoli` DISABLE KEYS */;
INSERT INTO `ty_ruoli` VALUES (1,'Admin'),(2,'Dipendente'),(3,'Personale'),(4,'Account'),(5,'Direttore Commerciale'),(6,'Direttore Recruiter'),(7,'Recruiter');
/*!40000 ALTER TABLE `ty_ruoli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_stati_richiesta`
--

DROP TABLE IF EXISTS `ty_stati_richiesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_stati_richiesta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_stati_richiesta`
--

LOCK TABLES `ty_stati_richiesta` WRITE;
/*!40000 ALTER TABLE `ty_stati_richiesta` DISABLE KEYS */;
INSERT INTO `ty_stati_richiesta` VALUES (1,'Nuova'),(2,'In Lavorazione'),(3,'Attesa Conferma'),(4,'Chiusa');
/*!40000 ALTER TABLE `ty_stati_richiesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_tipo_contratto`
--

DROP TABLE IF EXISTS `ty_tipo_contratto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_tipo_contratto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `note` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_tipo_contratto`
--

LOCK TABLES `ty_tipo_contratto` WRITE;
/*!40000 ALTER TABLE `ty_tipo_contratto` DISABLE KEYS */;
INSERT INTO `ty_tipo_contratto` VALUES (1,'stage',NULL),(2,'tirocinio',NULL),(3,'indeterminato',NULL);
/*!40000 ALTER TABLE `ty_tipo_contratto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 10:59:34
