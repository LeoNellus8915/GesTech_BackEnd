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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_hardware`
--

LOCK TABLES `am_hardware` WRITE;
/*!40000 ALTER TABLE `am_hardware` DISABLE KEYS */;
INSERT INTO `am_hardware` VALUES (1,1,2,'','','','2022-10-18','2022-10-18',''),(2,0,5,'','','','2022-10-18','2022-10-18','');
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
INSERT INTO `am_richieste` VALUES (35,3,'2022-10-17 16:21:55',6,6,2,3,'Bracciano',1200,'Messaggio di prova','Verdi  Giovanni',3,2),(36,3,'2022-10-17 16:22:27',2,3,3,1,'Roma',1200,'Messaggio di prova','Candidato  Primo, Verdi  Giovanni',2,1),(37,3,'2022-10-17 16:22:51',8,9,4,1,'Milano',1200,'Messaggio di prova','Verdi  Giovanni',3,1),(38,3,'2022-10-18 11:18:42',5,6,2,3,'Roma',1200,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Verdi  Giovanni, Candidato  Primo',2,2),(39,3,'2022-10-18 12:18:31',2,5,2,2,'Roma',1200,'','Verdi  Giovanni, Candidato  Primo',2,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_auth`
--

LOCK TABLES `ap_auth` WRITE;
/*!40000 ALTER TABLE `ap_auth` DISABLE KEYS */;
INSERT INTO `ap_auth` VALUES (1,1,'21232f297a57a5a743894a0e4a801fc3','2022-07-15'),(2,2,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(3,3,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(4,4,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(5,5,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(6,6,'21232f297a57a5a743894a0e4a801fc3','2022-09-28');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_ruoli_persone`
--

LOCK TABLES `ap_ruoli_persone` WRITE;
/*!40000 ALTER TABLE `ap_ruoli_persone` DISABLE KEYS */;
INSERT INTO `ap_ruoli_persone` VALUES (1,1,1),(2,2,2),(3,2,3),(4,3,2),(5,3,4),(6,4,2),(7,4,5),(8,5,2),(9,5,6),(10,6,2),(11,6,7),(12,7,7);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_session`
--

LOCK TABLES `ap_session` WRITE;
/*!40000 ALTER TABLE `ap_session` DISABLE KEYS */;
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
  `id_dettaglio_candiato` int DEFAULT NULL,
  `id_lingua` int DEFAULT NULL,
  `descrizione` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_lingue_dettagli_candidati`
--

LOCK TABLES `as_lingue_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_lingue_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_lingue_dettagli_candidati` VALUES (1,6,2,NULL),(2,6,8,NULL),(3,7,9,NULL),(4,8,12,NULL),(5,8,7,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_profili_dettagli_candidati`
--

LOCK TABLES `as_profili_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_profili_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_profili_dettagli_candidati` VALUES (1,6,2,2,5,NULL),(4,7,5,4,4,NULL),(5,8,2,4,25,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_richieste_dettagli_candidati`
--

LOCK TABLES `as_richieste_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `as_richieste_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `as_richieste_dettagli_candidati` VALUES (5,35,8,NULL),(6,35,7,NULL),(7,35,9,NULL),(8,37,8,NULL),(9,37,7,NULL),(10,37,9,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_richieste_persone`
--

LOCK TABLES `as_richieste_persone` WRITE;
/*!40000 ALTER TABLE `as_richieste_persone` DISABLE KEYS */;
INSERT INTO `as_richieste_persone` VALUES (3,6,33,1),(4,6,31,1),(5,6,32,1),(6,6,37,1),(7,6,35,1),(8,7,36,0),(9,7,36,0),(10,6,36,0),(11,7,38,0),(12,6,39,0),(13,7,39,0),(14,6,38,0),(15,6,38,0),(16,6,38,0),(17,7,38,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_contratti`
--

LOCK TABLES `hr_contratti` WRITE;
/*!40000 ALTER TABLE `hr_contratti` DISABLE KEYS */;
INSERT INTO `hr_contratti` VALUES (1,1,NULL,NULL,NULL,NULL,5,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_dettagli_candidati`
--

LOCK TABLES `hr_dettagli_candidati` WRITE;
/*!40000 ALTER TABLE `hr_dettagli_candidati` DISABLE KEYS */;
INSERT INTO `hr_dettagli_candidati` VALUES (6,7,NULL,'2022-10-17 00:00:00',4,NULL,'Java','2022-09-22',2022,'Db',40,'Immediata','xfgh',NULL),(7,8,NULL,'2022-08-15 00:00:00',6,NULL,'asdf','2022-05-19',2022,'dfh',50,'dg','xfgh',NULL),(8,9,NULL,'2022-10-17 00:00:00',8,NULL,'Angular','2022-10-15',2022,'fgh',70,'dfh','fgh',NULL),(9,11,'','2022-10-19 10:35:18',11,NULL,'','2022-10-19',2022,'',0,'','',''),(10,12,'','2022-10-19 10:37:40',11,NULL,'','2022-10-19',2022,'',0,'','',''),(11,13,'','2022-10-19 10:38:39',11,NULL,'','2022-10-19',2022,'',0,'','',''),(12,14,'','2022-10-19 11:42:38',11,NULL,'','2022-10-19',2022,'',0,'','','');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_persone`
--

LOCK TABLES `hr_persone` WRITE;
/*!40000 ALTER TABLE `hr_persone` DISABLE KEYS */;
INSERT INTO `hr_persone` VALUES (1,'Mario','Rossi','','mario.rossi@prova.com','3345899562','1984-08-02','Roma','Roma','Viale Ippocrate 64',161),(2,'Francesca','Rosa',NULL,'francesca.rosa@prova.com','3341896587','1989-07-06','Bologna','Milano','Via Emilio Gola 22',20143),(3,'Carlo','Neri',NULL,'carlo.neri@prova.com','3398766485','1973-05-18','Milano','Roma','Via Giulio Adamoli 35',147),(4,'Paolo','Bianchi',NULL,'paolo.bianchi@prova.com','3341258965','1979-06-06','Roma','Roma','Via Vigna di Fabbri 13',179),(5,'Luca','Gialli',NULL,'luca.gialli@prova.com','3298744156','1980-02-22','Prato','Roma','Viale Palmiro Togliatti 1474',155),(6,'Giovanni','Verdi',NULL,'giovanni.verdi@prova.com','3348968852','1991-12-09','Macerata','Milano','Via dei Soranzo 2',20148),(7,'Primo','Candidato',NULL,'candidato1@prova.com','3314522658','1994-10-14','Pesaro','Macerata','Via Ettore Ricci 111',62100),(8,'Secondo','Candidato',NULL,'candidato2@prova.com','3354969985','1985-12-12','Milano','Milano','Via Antonio Curti 1',20136),(9,'Terzo','Candidato',NULL,'candidato3@prova.com','3465898676','1973-02-25','Roma','Milano','Via Pace 17',20122),(14,'','',NULL,'','',NULL,NULL,'',NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hs_cv`
--

LOCK TABLES `hs_cv` WRITE;
/*!40000 ALTER TABLE `hs_cv` DISABLE KEYS */;
INSERT INTO `hs_cv` VALUES (1,11,NULL,'2022-10-19 10:35:18'),(2,12,NULL,'2022-10-19 10:37:40'),(3,13,NULL,'2022-10-19 10:38:39'),(4,14,NULL,'2022-10-19 11:42:38');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_dispositivi`
--

LOCK TABLES `ty_dispositivi` WRITE;
/*!40000 ALTER TABLE `ty_dispositivi` DISABLE KEYS */;
INSERT INTO `ty_dispositivi` VALUES (1,'cellulare',NULL),(2,'portatile',NULL),(3,'mouse',NULL),(4,'monitor',NULL);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-19 11:44:35
