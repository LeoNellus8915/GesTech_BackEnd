CREATE DATABASE  IF NOT EXISTS `gestech` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestech`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: gestech
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
-- Table structure for table `hy_avvisi`
--

DROP TABLE IF EXISTS `hy_avvisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_avvisi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `titolo` varchar(100) DEFAULT NULL,
  `ruoli` varchar(100) DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_avvisi`
--

LOCK TABLES `hy_avvisi` WRITE;
/*!40000 ALTER TABLE `hy_avvisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_avvisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_commenti_candidati`
--

DROP TABLE IF EXISTS `hy_commenti_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_commenti_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  `note` text,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_commenti_candidati`
--

LOCK TABLES `hy_commenti_candidati` WRITE;
/*!40000 ALTER TABLE `hy_commenti_candidati` DISABLE KEYS */;
INSERT INTO `hy_commenti_candidati` VALUES (1,1,9,'ynhgdtrf','2022-09-27'),(2,1,9,'aaaa','2022-09-27');
/*!40000 ALTER TABLE `hy_commenti_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_commenti_richieste`
--

DROP TABLE IF EXISTS `hy_commenti_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_commenti_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `id_richiesta` int DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_commenti_richieste`
--

LOCK TABLES `hy_commenti_richieste` WRITE;
/*!40000 ALTER TABLE `hy_commenti_richieste` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_commenti_richieste` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `hy_dettagli_dipendenti`
--

DROP TABLE IF EXISTS `hy_dettagli_dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_dettagli_dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `file_base64` mediumtext,
  `data_assunzione` date DEFAULT NULL,
  `data_fine_rapporto` date DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `id_contratto` int DEFAULT NULL,
  `id_livello_contratto` int DEFAULT NULL,
  `id_mansione` int DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_periodo_di_prova` int DEFAULT NULL,
  `id_periodo_di_preavviso` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_dettagli_dipendenti`
--

LOCK TABLES `hy_dettagli_dipendenti` WRITE;
/*!40000 ALTER TABLE `hy_dettagli_dipendenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_dettagli_dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_dipendenti_ccnl`
--

DROP TABLE IF EXISTS `hy_dipendenti_ccnl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_dipendenti_ccnl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `data_download` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_dipendenti_ccnl`
--

LOCK TABLES `hy_dipendenti_ccnl` WRITE;
/*!40000 ALTER TABLE `hy_dipendenti_ccnl` DISABLE KEYS */;
INSERT INTO `hy_dipendenti_ccnl` VALUES (1,5,'2022-09-27 12:23:31');
/*!40000 ALTER TABLE `hy_dipendenti_ccnl` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_richieste`
--

LOCK TABLES `hy_richieste` WRITE;
/*!40000 ALTER TABLE `hy_richieste` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_session`
--

DROP TABLE IF EXISTS `hy_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_session` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `token` mediumtext,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_session`
--

LOCK TABLES `hy_session` WRITE;
/*!40000 ALTER TABLE `hy_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_auth`
--

DROP TABLE IF EXISTS `sy_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_auth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_auth`
--

LOCK TABLES `sy_auth` WRITE;
/*!40000 ALTER TABLE `sy_auth` DISABLE KEYS */;
INSERT INTO `sy_auth` VALUES (1,1,'21232f297a57a5a743894a0e4a801fc3','2022-07-15'),(4,5,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(5,6,'21232f297a57a5a743894a0e4a801fc3','2022-09-27'),(6,7,'21232f297a57a5a743894a0e4a801fc3','2022-09-27');
/*!40000 ALTER TABLE `sy_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_aziende_dipendenti`
--

DROP TABLE IF EXISTS `sy_aziende_dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_aziende_dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_aziende_dipendenti`
--

LOCK TABLES `sy_aziende_dipendenti` WRITE;
/*!40000 ALTER TABLE `sy_aziende_dipendenti` DISABLE KEYS */;
INSERT INTO `sy_aziende_dipendenti` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4);
/*!40000 ALTER TABLE `sy_aziende_dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_beni`
--

LOCK TABLES `sy_beni` WRITE;
/*!40000 ALTER TABLE `sy_beni` DISABLE KEYS */;
INSERT INTO `sy_beni` VALUES (1,'yhgfaaa','mnfdb','uyhtgdrf','nbve','ytbvr','nfgfdc','','',NULL,NULL),(2,'uytgdrf','ugjyhfgdtrfs','yhdtgrsef','jyhtgrefs','tgfrsedaw','','','',NULL,NULL),(3,'gf','mhgnfbvd','mnb','yhdtgrefs','yhtgdr','','','',NULL,NULL),(4,'gf','mhgnfbvd','mnb','yhdtgrefs','yhtgdr','','','',NULL,NULL),(5,'jyhtgref','','hgrsefaw','','jyhtgdrsef','','','',NULL,NULL),(6,'bbbbb','aaaaaaa','aaaaaaa','aaaaaaa','aaaaaaa','','','',NULL,NULL);
/*!40000 ALTER TABLE `sy_beni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_candidati`
--

DROP TABLE IF EXISTS `sy_candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_candidati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_cognome` varchar(100) DEFAULT NULL,
  `cellulare` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `profilo_linkedin` varchar(500) DEFAULT NULL,
  `citta` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_candidati`
--

LOCK TABLES `sy_candidati` WRITE;
/*!40000 ALTER TABLE `sy_candidati` DISABLE KEYS */;
INSERT INTO `sy_candidati` VALUES (9,'Riccardo Omar Barionovi','aaaa','aaaa','hfytgdfrse','aaaa');
/*!40000 ALTER TABLE `sy_candidati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_dipendenti`
--

DROP TABLE IF EXISTS `sy_dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_cognome` varchar(100) DEFAULT NULL,
  `codice_fiscale` varchar(16) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cellulare` varchar(10) DEFAULT NULL,
  `residenza` varchar(100) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL,
  `luogo_di_nascita` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_dipendenti`
--

LOCK TABLES `sy_dipendenti` WRITE;
/*!40000 ALTER TABLE `sy_dipendenti` DISABLE KEYS */;
INSERT INTO `sy_dipendenti` VALUES (1,'Mario Rossi',NULL,'mario.rossi@prova.com',NULL,NULL,NULL,NULL,NULL),(2,'Giovanni Verdi',NULL,'giovanni.verdi@prova.com',NULL,NULL,NULL,NULL,NULL),(3,'Paolo Bianchi','','paolo.bianchi@prova.com',NULL,NULL,NULL,NULL,NULL),(4,'Francesca Rosa',NULL,'francesca.rosa@prova.com',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sy_dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_dipendenti_richieste`
--

DROP TABLE IF EXISTS `sy_dipendenti_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_dipendenti_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `id_richiesta` int DEFAULT NULL,
  `visualizzato` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_dipendenti_richieste`
--

LOCK TABLES `sy_dipendenti_richieste` WRITE;
/*!40000 ALTER TABLE `sy_dipendenti_richieste` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_dipendenti_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_ruoli_dipendenti`
--

DROP TABLE IF EXISTS `sy_ruoli_dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_ruoli_dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int DEFAULT NULL,
  `id_ruolo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_ruoli_dipendenti`
--

LOCK TABLES `sy_ruoli_dipendenti` WRITE;
/*!40000 ALTER TABLE `sy_ruoli_dipendenti` DISABLE KEYS */;
INSERT INTO `sy_ruoli_dipendenti` VALUES (1,1,1),(5,2,4),(6,2,3),(7,3,2),(8,3,4),(9,4,4),(10,4,5);
/*!40000 ALTER TABLE `sy_ruoli_dipendenti` ENABLE KEYS */;
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
-- Table structure for table `ty_ccnl`
--

DROP TABLE IF EXISTS `ty_ccnl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_ccnl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_azienda` int DEFAULT NULL,
  `ccnl` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_ccnl`
--

LOCK TABLES `ty_ccnl` WRITE;
/*!40000 ALTER TABLE `ty_ccnl` DISABLE KEYS */;
INSERT INTO `ty_ccnl` VALUES (1,1,'data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64,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');
/*!40000 ALTER TABLE `ty_ccnl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_clienti`
--

DROP TABLE IF EXISTS `ty_clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_clienti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_clienti`
--

LOCK TABLES `ty_clienti` WRITE;
/*!40000 ALTER TABLE `ty_clienti` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_contratti`
--

DROP TABLE IF EXISTS `ty_contratti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_contratti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_contratti`
--

LOCK TABLES `ty_contratti` WRITE;
/*!40000 ALTER TABLE `ty_contratti` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_contratti` ENABLE KEYS */;
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
-- Table structure for table `ty_livelli_contratto`
--

DROP TABLE IF EXISTS `ty_livelli_contratto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_livelli_contratto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_livelli_contratto`
--

LOCK TABLES `ty_livelli_contratto` WRITE;
/*!40000 ALTER TABLE `ty_livelli_contratto` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_livelli_contratto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_mansioni`
--

DROP TABLE IF EXISTS `ty_mansioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_mansioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_mansioni`
--

LOCK TABLES `ty_mansioni` WRITE;
/*!40000 ALTER TABLE `ty_mansioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_mansioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_periodi_di_preavviso`
--

DROP TABLE IF EXISTS `ty_periodi_di_preavviso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_periodi_di_preavviso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_periodi_di_preavviso`
--

LOCK TABLES `ty_periodi_di_preavviso` WRITE;
/*!40000 ALTER TABLE `ty_periodi_di_preavviso` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_periodi_di_preavviso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_priodi_di_prova`
--

DROP TABLE IF EXISTS `ty_priodi_di_prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_priodi_di_prova` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_priodi_di_prova`
--

LOCK TABLES `ty_priodi_di_prova` WRITE;
/*!40000 ALTER TABLE `ty_priodi_di_prova` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_priodi_di_prova` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_ruoli`
--

LOCK TABLES `ty_ruoli` WRITE;
/*!40000 ALTER TABLE `ty_ruoli` DISABLE KEYS */;
INSERT INTO `ty_ruoli` VALUES (1,'Admin'),(2,'Commerciale'),(3,'Recruiter'),(4,'Dipendente'),(5,'Personale');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_stati_richiesta`
--

LOCK TABLES `ty_stati_richiesta` WRITE;
/*!40000 ALTER TABLE `ty_stati_richiesta` DISABLE KEYS */;
INSERT INTO `ty_stati_richiesta` VALUES (1,'Nuova'),(2,'In Lavorazione'),(3,'Chiusa');
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

-- Dump completed on 2022-09-27 14:37:19
