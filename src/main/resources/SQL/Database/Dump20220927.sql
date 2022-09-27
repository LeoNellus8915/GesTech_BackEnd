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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_dipendenti_ccnl`
--

LOCK TABLES `hy_dipendenti_ccnl` WRITE;
/*!40000 ALTER TABLE `hy_dipendenti_ccnl` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_auth`
--

LOCK TABLES `sy_auth` WRITE;
/*!40000 ALTER TABLE `sy_auth` DISABLE KEYS */;
INSERT INTO `sy_auth` VALUES (1,1,'21232f297a57a5a743894a0e4a801fc3','2022-07-15'),(4,5,'21232f297a57a5a743894a0e4a801fc3','2022-09-27');
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
INSERT INTO `sy_aziende_dipendenti` VALUES (1,1,1),(4,5,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_dipendenti`
--

LOCK TABLES `sy_dipendenti` WRITE;
/*!40000 ALTER TABLE `sy_dipendenti` DISABLE KEYS */;
INSERT INTO `sy_dipendenti` VALUES (1,'Mario Rossi',NULL,'mario.rossi@gmail.com',NULL,NULL,NULL,NULL,NULL),(5,'Giovanni Verdi',NULL,'giovanni.verdi@gmail.com',NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_ruoli_dipendenti`
--

LOCK TABLES `sy_ruoli_dipendenti` WRITE;
/*!40000 ALTER TABLE `sy_ruoli_dipendenti` DISABLE KEYS */;
INSERT INTO `sy_ruoli_dipendenti` VALUES (1,1,1),(5,5,4),(6,5,3);
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

-- Dump completed on 2022-09-27 11:37:51
