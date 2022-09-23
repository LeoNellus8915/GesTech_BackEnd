CREATE DATABASE  IF NOT EXISTS `gestech2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestech2`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestech2
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
  `titolo` varchar(50) DEFAULT NULL,
  `id_risorsa` int DEFAULT NULL,
  `ruoli` varchar(100) DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_avvisi`
--

LOCK TABLES `hy_avvisi` WRITE;
/*!40000 ALTER TABLE `hy_avvisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_avvisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_commenti_richieste`
--

DROP TABLE IF EXISTS `hy_commenti_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_commenti_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `id_destinatario` int DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_commenti_richieste`
--

LOCK TABLES `hy_commenti_richieste` WRITE;
/*!40000 ALTER TABLE `hy_commenti_richieste` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_commenti_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_commenti_risorse`
--

DROP TABLE IF EXISTS `hy_commenti_risorse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_commenti_risorse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_mittente` int DEFAULT NULL,
  `id_destinatario` int DEFAULT NULL,
  `note` text,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_commenti_risorse`
--

LOCK TABLES `hy_commenti_risorse` WRITE;
/*!40000 ALTER TABLE `hy_commenti_risorse` DISABLE KEYS */;
/*!40000 ALTER TABLE `hy_commenti_risorse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_dettaglio_risorsa`
--

DROP TABLE IF EXISTS `hy_dettaglio_risorsa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_dettaglio_risorsa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `file_base64` mediumtext,
  `data_inserimento` datetime DEFAULT NULL,
  `id_esito_colloquio` int DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_skill1` int DEFAULT NULL,
  `id_skill2` int DEFAULT NULL,
  `id_skill3` int DEFAULT NULL,
  `id_skill4` int DEFAULT NULL,
  `id_skill5` int DEFAULT NULL,
  `id_lingua1` int DEFAULT NULL,
  `id_lingua2` int DEFAULT NULL,
  `id_lingua3` int DEFAULT NULL,
  `id_seniority` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_dettaglio_risorsa`
--

LOCK TABLES `hy_dettaglio_risorsa` WRITE;
/*!40000 ALTER TABLE `hy_dettaglio_risorsa` DISABLE KEYS */;
INSERT INTO `hy_dettaglio_risorsa` VALUES (148,243,NULL,'2022-09-21 12:59:32',10,2,3,17,18,55,55,3,25,25,4),(149,244,NULL,'2022-09-21 14:03:20',9,11,11,10,5,55,55,11,15,25,6),(150,245,NULL,'2022-09-21 14:17:41',10,15,4,8,11,55,55,15,3,11,4),(151,246,NULL,'2022-09-21 14:18:58',8,15,3,50,53,55,55,3,13,16,6);
/*!40000 ALTER TABLE `hy_dettaglio_risorsa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hy_richieste`
--

DROP TABLE IF EXISTS `hy_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `id_skill` int DEFAULT NULL,
  `id_profilo` int DEFAULT NULL,
  `id_seniority` int DEFAULT NULL,
  `cliente` varchar(45) DEFAULT NULL,
  `citta` varchar(60) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `note` text,
  `recruiter` varchar(100) DEFAULT NULL,
  `id_stato` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_richieste`
--

LOCK TABLES `hy_richieste` WRITE;
/*!40000 ALTER TABLE `hy_richieste` DISABLE KEYS */;
INSERT INTO `hy_richieste` VALUES (120,1,'2022-09-21 15:33:03',7,6,3,'Accenture','Roma',1200,'Da reperire entro data xx/xx','Tutti',1);
/*!40000 ALTER TABLE `hy_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_auth`
--

DROP TABLE IF EXISTS `sy_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_auth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `password` text,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_auth`
--

LOCK TABLES `sy_auth` WRITE;
/*!40000 ALTER TABLE `sy_auth` DISABLE KEYS */;
INSERT INTO `sy_auth` VALUES (1,1,'21232f297a57a5a743894a0e4a801fc3','2022-07-15'),(78,240,'21232f297a57a5a743894a0e4a801fc3','2022-09-21'),(79,241,'21232f297a57a5a743894a0e4a801fc3','2022-09-21'),(80,242,'21232f297a57a5a743894a0e4a801fc3','2022-09-21');
/*!40000 ALTER TABLE `sy_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_aziende_risorse`
--

DROP TABLE IF EXISTS `sy_aziende_risorse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_aziende_risorse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_aziende_risorse`
--

LOCK TABLES `sy_aziende_risorse` WRITE;
/*!40000 ALTER TABLE `sy_aziende_risorse` DISABLE KEYS */;
INSERT INTO `sy_aziende_risorse` VALUES (2,1,1),(8,240,4),(9,241,1),(10,242,1);
/*!40000 ALTER TABLE `sy_aziende_risorse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_beni`
--

DROP TABLE IF EXISTS `sy_beni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_beni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dispositivo` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modello` varchar(50) DEFAULT NULL,
  `numero_seriale` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `dipendente` varchar(50) DEFAULT NULL,
  `societa` varchar(50) DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `data_restituzione` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_beni`
--

LOCK TABLES `sy_beni` WRITE;
/*!40000 ALTER TABLE `sy_beni` DISABLE KEYS */;
INSERT INTO `sy_beni` VALUES (11,'Pc Portatile','Hp','laptop15bs1xx','SED12318GHIR','1010','','Francesca Rosa','Rpctech','2022-09-21',NULL);
/*!40000 ALTER TABLE `sy_beni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_risorse`
--

DROP TABLE IF EXISTS `sy_risorse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_risorse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_cognome` varchar(60) DEFAULT NULL,
  `recapito` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `profilo_linkedin` varchar(500) DEFAULT NULL,
  `citta` varchar(50) DEFAULT NULL,
  `competenza_principale` varchar(100) DEFAULT NULL,
  `data_colloquio` date DEFAULT NULL,
  `anno_colloquio` varchar(5) DEFAULT NULL,
  `fonte_reperimento` varchar(50) DEFAULT NULL,
  `costo_giornaliero` double DEFAULT NULL,
  `possibilita_lavorativa` varchar(30) DEFAULT NULL,
  `skill_campo_libero` varchar(100) DEFAULT NULL,
  `competenze_totali` varchar(100) DEFAULT NULL,
  `certificazioni` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_risorse`
--

LOCK TABLES `sy_risorse` WRITE;
/*!40000 ALTER TABLE `sy_risorse` DISABLE KEYS */;
INSERT INTO `sy_risorse` VALUES (1,'Mario Rossi',NULL,'mario.rossi@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(240,'Paolo Bianchi',NULL,'paolo.bianchi@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(241,'Giovanni Verdi',NULL,'giovanni.verdi@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(242,'Francesca Rosa',NULL,'francesca.rosa@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(243,'Giacomo Dioguardi','3346155721','dioguardigiacomo96@gmail.com','','Bracciano','','2022-02-10','2022','',0,'','','',''),(244,'Federico Nobili','3356488952','federico.nobili@gmail.com','','Roma','','2022-03-18',NULL,'',0,'','','',''),(245,'Riccardo Omar Barionovi','3245569852','riccardoomarbarionovi@gmail.com','','Magliano Sabina','','2022-02-19',NULL,'',0,'','','',''),(246,'Alessandro Ancinelli','3245569852','alessandro.ancinelli@gmail.com','','Roma','','2022-07-01',NULL,'',0,'','','','');
/*!40000 ALTER TABLE `sy_risorse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_risorse_richieste`
--

DROP TABLE IF EXISTS `sy_risorse_richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_risorse_richieste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `id_richiesta` int DEFAULT NULL,
  `visualizzato` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_risorse_richieste`
--

LOCK TABLES `sy_risorse_richieste` WRITE;
/*!40000 ALTER TABLE `sy_risorse_richieste` DISABLE KEYS */;
INSERT INTO `sy_risorse_richieste` VALUES (105,241,120,0);
/*!40000 ALTER TABLE `sy_risorse_richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_ruoli_risorse`
--

DROP TABLE IF EXISTS `sy_ruoli_risorse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sy_ruoli_risorse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_risorsa` int DEFAULT NULL,
  `id_ruolo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_ruoli_risorse`
--

LOCK TABLES `sy_ruoli_risorse` WRITE;
/*!40000 ALTER TABLE `sy_ruoli_risorse` DISABLE KEYS */;
INSERT INTO `sy_ruoli_risorse` VALUES (1,1,1),(81,240,4),(82,240,2),(83,241,4),(84,241,3),(85,242,4),(86,242,5);
/*!40000 ALTER TABLE `sy_ruoli_risorse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_aziende`
--

DROP TABLE IF EXISTS `ty_aziende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_aziende` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
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
-- Table structure for table `ty_esiti_colloquio`
--

DROP TABLE IF EXISTS `ty_esiti_colloquio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_esiti_colloquio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
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
  `nome` varchar(30) DEFAULT NULL,
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
  `nome` varchar(30) DEFAULT NULL,
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
  `nome` varchar(20) DEFAULT NULL,
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
  `nome` varchar(45) DEFAULT NULL,
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

-- Dump completed on 2022-09-22  9:52:09
