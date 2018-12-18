-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: featurebim
-- ------------------------------------------------------
-- Server version	5.5.5-10.2.14-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) NOT NULL,
  `identname` varchar(45) NOT NULL,
  `comments` text DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identname_UNIQUE` (`identname`),
  KEY `FK_COMPANY_STATUS_idx` (`status`),
  CONSTRAINT `FK_COMPANY_STATUS` FOREIGN KEY (`status`) REFERENCES `company_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Test Company','00011',NULL,1,2,'2018-06-04 19:31:58.672344','2018-12-17 12:10:19.572287'),(2,'Company 1','00012',NULL,4,1,'2018-06-08 19:10:21.325301','2018-12-10 18:40:20.129548'),(3,'Company 2','00013',NULL,4,1,'2018-06-08 19:10:21.328295','2018-12-10 18:40:20.130010'),(4,'Company 3','00014',NULL,4,1,'2018-06-09 10:13:19.446634','2018-12-10 18:40:20.130524');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_contact_person`
--

DROP TABLE IF EXISTS `company_contact_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_contact_person` (
  `companyid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`companyid`,`userid`),
  KEY `FK_COMPANY_CONTACT_PERSON_USER_idx` (`userid`),
  CONSTRAINT `FK_COMPANY_CONTACT_PERSON_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_COMPANY_CONTACT_PERSON_USER` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_contact_person`
--

LOCK TABLES `company_contact_person` WRITE;
/*!40000 ALTER TABLE `company_contact_person` DISABLE KEYS */;
INSERT INTO `company_contact_person` VALUES (1,1,'2018-12-17 12:10:19.595095');
/*!40000 ALTER TABLE `company_contact_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_emails`
--

DROP TABLE IF EXISTS `company_emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_emails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `email_name` varchar(45) NOT NULL,
  `emailaddress` varchar(45) NOT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_COMPANYEMAIL_COMPANY_idx` (`companyid`),
  CONSTRAINT `FK_COMPANYEMAIL_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_emails`
--

LOCK TABLES `company_emails` WRITE;
/*!40000 ALTER TABLE `company_emails` DISABLE KEYS */;
INSERT INTO `company_emails` VALUES (6,1,'default','aaaa@bb.de',NULL,1,1,'2018-12-17 12:10:19.590198','2018-12-17 12:10:19.590198');
/*!40000 ALTER TABLE `company_emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_phonesnumbers`
--

DROP TABLE IF EXISTS `company_phonesnumbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_phonesnumbers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `telephone_name` varchar(45) NOT NULL,
  `phonenumner` varchar(45) NOT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_COMPANYTELEPHONE_COMPANY_idx` (`companyid`),
  CONSTRAINT `FK_COMPANYTELEPHONE_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_phonesnumbers`
--

LOCK TABLES `company_phonesnumbers` WRITE;
/*!40000 ALTER TABLE `company_phonesnumbers` DISABLE KEYS */;
INSERT INTO `company_phonesnumbers` VALUES (5,1,'Empfang','+491122334455',NULL,1,1,'2018-12-17 12:10:19.586706','2018-12-17 12:10:19.586706');
/*!40000 ALTER TABLE `company_phonesnumbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_postaladdresses`
--

DROP TABLE IF EXISTS `company_postaladdresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_postaladdresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `address_name` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `postcode` varchar(15) NOT NULL,
  `street` varchar(45) NOT NULL,
  `house_number` varchar(10) NOT NULL,
  `additional_address` varchar(200) DEFAULT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_COMPANYADDRESS_COMPANY_idx` (`companyid`),
  CONSTRAINT `FK_COMPANYADDRESS_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_postaladdresses`
--

LOCK TABLES `company_postaladdresses` WRITE;
/*!40000 ALTER TABLE `company_postaladdresses` DISABLE KEYS */;
INSERT INTO `company_postaladdresses` VALUES (4,1,'Hauptfiliale','Deutschland','Hannover','30419','Fischteichweg','22','aaaaaaaaaa',NULL,1,1,'2018-12-17 12:10:19.582563','2018-12-17 12:10:19.582563');
/*!40000 ALTER TABLE `company_postaladdresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_status`
--

DROP TABLE IF EXISTS `company_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_status`
--

LOCK TABLES `company_status` WRITE;
/*!40000 ALTER TABLE `company_status` DISABLE KEYS */;
INSERT INTO `company_status` VALUES (0,'company.status.unknown','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(1,'company.status.active','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(2,'company.status.deactive','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(3,'company.status.deleted','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(4,'company.status.noinit','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182');
/*!40000 ALTER TABLE `company_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emails`
--

DROP TABLE IF EXISTS `emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emails` (
  `ownerid` int(11) NOT NULL,
  `owner_type` varchar(45) NOT NULL,
  `email_name` varchar(45) NOT NULL,
  `emailaddress` varchar(50) NOT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`ownerid`,`owner_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;
/*!40000 ALTER TABLE `emails` DISABLE KEYS */;
INSERT INTO `emails` VALUES (1,'company','Info','aaaa@em.de',NULL,1,'2018-06-10 11:05:42.997236','2018-06-10 11:05:42.997236');
/*!40000 ALTER TABLE `emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration`
--

DROP TABLE IF EXISTS `migration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration`
--

LOCK TABLES `migration` WRITE;
/*!40000 ALTER TABLE `migration` DISABLE KEYS */;
INSERT INTO `migration` VALUES ('m000000_000000_base',1528924419),('m130524_201442_init',1528924427);
/*!40000 ALTER TABLE `migration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone`
--

DROP TABLE IF EXISTS `milestone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milestone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `start_date` datetime NOT NULL,
  `deadline` datetime NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `comments` text DEFAULT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_MILESTONE_PROJECT_idx` (`project_id`),
  CONSTRAINT `FK_MILESTONE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
INSERT INTO `milestone` VALUES (1,1,'Milestone 1','2018-12-20 00:00:00','2019-12-20 00:00:00',1,NULL,'2018-11-24 18:00:52.831540','2018-11-24 18:00:52.831540');
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone_task`
--

DROP TABLE IF EXISTS `milestone_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milestone_task` (
  `milestone_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`milestone_id`,`task_id`),
  KEY `FK_MILESTONETASK_TASK_idx` (`task_id`),
  KEY `FK_MILESTONETASK_WORKFLOW_idx` (`milestone_id`),
  CONSTRAINT `FK_MILESTONETASK_MILESTONE` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_MILESTONETASK_TASK` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone_task`
--

LOCK TABLES `milestone_task` WRITE;
/*!40000 ALTER TABLE `milestone_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone_workflow`
--

DROP TABLE IF EXISTS `milestone_workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milestone_workflow` (
  `milestone_id` int(11) NOT NULL,
  `workflow_id` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`milestone_id`,`workflow_id`),
  KEY `FK_MILESTONEWORKFLOW_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_MILESTONEWORKFLOW_MILESTONE_idx` (`milestone_id`),
  CONSTRAINT `FK_MILESTONEWORKFLOW_MILESTONE` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_MILESTONEWORKFLOW_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone_workflow`
--

LOCK TABLES `milestone_workflow` WRITE;
/*!40000 ALTER TABLE `milestone_workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone_workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_access_type`
--

DROP TABLE IF EXISTS `project_access_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_access_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_access_type`
--

LOCK TABLES `project_access_type` WRITE;
/*!40000 ALTER TABLE `project_access_type` DISABLE KEYS */;
INSERT INTO `project_access_type` VALUES (1,'Zugrif 1',1,'2018-12-17 13:04:30.617764','2018-12-17 13:04:30.617764'),(2,'Zugrif 2',1,'2018-12-17 13:04:30.626412','2018-12-17 13:04:30.626412');
/*!40000 ALTER TABLE `project_access_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_bfc_files`
--

DROP TABLE IF EXISTS `project_bfc_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_bfc_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_path` varchar(500) NOT NULL,
  `object_id` varchar(100) NOT NULL,
  `viewpoint` varchar(45) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_BFC_FILES_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_BFC_FILES_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_bfc_files`
--

LOCK TABLES `project_bfc_files` WRITE;
/*!40000 ALTER TABLE `project_bfc_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_bfc_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_comments`
--

DROP TABLE IF EXISTS `project_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type` varchar(200) NOT NULL,
  `item_id` varchar(200) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `comments` text DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_PROJECTCOMMENTS_USER_idx` (`user_id`),
  CONSTRAINT `FK_PROJECTCOMMENTS_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_comments`
--

LOCK TABLES `project_comments` WRITE;
/*!40000 ALTER TABLE `project_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_comments_files`
--

DROP TABLE IF EXISTS `project_comments_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_comments_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_comments_id` int(11) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_path` varchar(500) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_PROJECTCOMMENTSFILES_PROJECTCOMMENTS_idx` (`project_comments_id`),
  CONSTRAINT `FK_PROJECTCOMMENTSFILES_PROJECTCOMMENTS` FOREIGN KEY (`project_comments_id`) REFERENCES `project_comments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_comments_files`
--

LOCK TABLES `project_comments_files` WRITE;
/*!40000 ALTER TABLE `project_comments_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_comments_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_ifc`
--

DROP TABLE IF EXISTS `project_ifc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_ifc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(150) NOT NULL,
  `project_id` int(11) NOT NULL,
  `ifc_name` varchar(150) NOT NULL,
  `comments` text DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `filename_UNIQUE` (`filename`),
  KEY `PROJECT_IFC_FILES_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_IFC_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_ifc`
--

LOCK TABLES `project_ifc` WRITE;
/*!40000 ALTER TABLE `project_ifc` DISABLE KEYS */;
INSERT INTO `project_ifc` VALUES (57,'P1- IFC 001',1,'P1- IFC 001',NULL,1,1,'2018-07-19 22:57:13.400777','2018-07-20 10:42:19.822930'),(58,'P1- IFC 002',1,'P1- IFC 002',NULL,1,1,'2018-07-19 22:58:08.368766','2018-07-20 10:42:19.825929'),(60,'P2- IFC 001',2,'P2- IFC 001',NULL,1,1,'2018-07-19 23:00:10.064291','2018-07-20 10:42:19.826587'),(61,'P2- IFC 002',2,'P2- IFC 002',NULL,1,1,'2018-07-19 23:01:28.624479','2018-07-20 10:42:19.827018');
/*!40000 ALTER TABLE `project_ifc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_ifc_files`
--

DROP TABLE IF EXISTS `project_ifc_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_ifc_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_path` varchar(500) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_IFC_FILES_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_IFC_FILES_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_ifc_files`
--

LOCK TABLES `project_ifc_files` WRITE;
/*!40000 ALTER TABLE `project_ifc_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_ifc_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_other_files`
--

DROP TABLE IF EXISTS `project_other_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_other_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_path` varchar(500) NOT NULL,
  `viewpoint` varchar(45) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_OTHER_FILES_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_OTHER_FILES_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_other_files`
--

LOCK TABLES `project_other_files` WRITE;
/*!40000 ALTER TABLE `project_other_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_other_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_responsible`
--

DROP TABLE IF EXISTS `project_responsible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_responsible` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_RESP_PROJECT` (`project_id`),
  KEY `FK_RESP_USERS` (`user_id`),
  CONSTRAINT `FK_RESP_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RESP_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_responsible`
--

LOCK TABLES `project_responsible` WRITE;
/*!40000 ALTER TABLE `project_responsible` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_responsible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_roles`
--

DROP TABLE IF EXISTS `project_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) DEFAULT 0,
  `name` varchar(45) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_ROLES_CREATEDBY_idx` (`created_by`),
  CONSTRAINT `FK_ROLES_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_roles`
--

LOCK TABLES `project_roles` WRITE;
/*!40000 ALTER TABLE `project_roles` DISABLE KEYS */;
INSERT INTO `project_roles` VALUES (1,0,'Role 1',NULL,1,1,'2018-12-17 10:38:51.058537','2018-12-17 10:38:51.058537'),(2,0,'Role 2',NULL,1,1,'2018-12-17 10:38:51.067318','2018-12-17 10:38:51.067318'),(3,0,'Role 3',NULL,1,1,'2018-12-17 10:38:51.067617','2018-12-17 10:38:51.067617'),(4,0,'Role 4',NULL,1,1,'2018-12-17 10:38:51.067905','2018-12-17 10:38:51.067905');
/*!40000 ALTER TABLE `project_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_status`
--

DROP TABLE IF EXISTS `project_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_types`
--

DROP TABLE IF EXISTS `project_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_types` (
  `id` int(11) NOT NULL,
  `type_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_types`
--

LOCK TABLES `project_types` WRITE;
/*!40000 ALTER TABLE `project_types` DISABLE KEYS */;
INSERT INTO `project_types` VALUES (1,'Test Type 1',1,'2018-11-27 09:48:50.688182','2018-12-16 19:58:56.803554'),(2,'Test Type 2',1,'2018-12-16 19:58:56.805459','2018-12-16 19:58:56.805459'),(3,'Test Type 3',1,'2018-12-16 19:58:56.806383','2018-12-16 19:58:56.806383');
/*!40000 ALTER TABLE `project_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_users`
--

DROP TABLE IF EXISTS `project_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_users` (
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `access_type` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`project_id`,`user_id`),
  KEY `FK_USERPROJECT_PROJECT` (`project_id`),
  KEY `FK_USERPROJECT_USERS` (`user_id`),
  KEY `FK_USERPROJECT_ACCESSTYPE_idx` (`access_type`),
  KEY `FK_USERPROJECT_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_USERPROJECT_ACCESSTYPE` FOREIGN KEY (`access_type`) REFERENCES `project_access_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECT_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECT_ROLE` FOREIGN KEY (`role_id`) REFERENCES `project_roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECT_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_users`
--

LOCK TABLES `project_users` WRITE;
/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
INSERT INTO `project_users` VALUES (1,1,1,1,'2018-12-17 13:05:08.940378','2018-12-17 13:05:08.940378'),(1,4,2,2,'2018-12-17 13:05:08.950056','2018-12-17 13:05:08.950056'),(1,5,3,2,'2018-12-17 13:05:08.950362','2018-12-17 13:05:08.950362');
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `parent_project` int(11) NOT NULL DEFAULT 0,
  `type` int(11) NOT NULL,
  `project_name` varchar(200) NOT NULL,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `deadline` datetime DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_PROJECTS_ACCOUNT_idx` (`companyid`),
  KEY `FK_PROJECTS_PTYPE_idx` (`type`),
  CONSTRAINT `FK_PROJECTS_ACCOUNT` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PROJECTS_PTYPE` FOREIGN KEY (`type`) REFERENCES `project_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,0,1,'Haupt Projeckt','2019-08-05 00:00:00','2020-10-13 00:00:00',7,1,'2018-06-04 19:36:44.310401','2018-12-17 10:35:21.641560'),(2,1,0,3,'Projeckt 222222','2019-05-07 00:00:00','2021-01-07 00:00:00',5,1,'2018-06-04 19:36:44.310863','2018-12-17 09:56:23.838432'),(3,1,0,1,'Projeckt 3456','2019-06-02 00:00:00','2020-09-30 00:00:00',5,1,'2018-06-04 19:36:44.310863','2018-12-16 19:57:00.465175'),(7,1,0,2,'My Projekt 1','2019-07-07 00:00:00','2020-11-25 00:00:00',1,1,'2018-12-16 20:37:28.767585','2018-12-16 20:37:28.767585'),(8,1,0,1,'Projekt Test 5','2019-03-04 00:00:00',NULL,1,1,'2018-12-16 20:38:20.731658','2018-12-16 20:38:20.731658'),(11,1,0,1,'Neu Projekt 66666','2019-06-05 00:00:00',NULL,1,1,'2018-12-17 09:56:47.046444','2018-12-17 09:56:47.046444');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `rolname` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'role.norole','NOROLE','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(5,'role.user','USER','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(10,'role.view','VIEW','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(15,'role.guest','GUEST','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(25,'role.admin','ADMIN','2018-11-28 15:16:44.574107','2018-11-28 15:16:44.574107');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_comments` text DEFAULT NULL,
  `user_create` int(11) NOT NULL,
  `user_allocated` int(11) DEFAULT NULL,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `deatline` date DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_TASKS_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_TASKS_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `leader` int(11) DEFAULT NULL,
  `created_by` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_TEAM_LEADER_idx` (`leader`),
  KEY `FK_TEAM_CREATEDBY_idx` (`created_by`),
  CONSTRAINT `FK_TEAM_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TEAM_LEADER` FOREIGN KEY (`leader`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_members`
--

DROP TABLE IF EXISTS `team_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_members` (
  `teamid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`teamid`,`userid`),
  KEY `FK_TEAMMEMEBERS_USER_idx` (`userid`),
  KEY `FK_TEAMMEMEBERS_CREATEDBY_idx` (`created_by`),
  CONSTRAINT `FK_TEAMMEMEBERS_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_TEAMMEMEBERS_TEAM` FOREIGN KEY (`teamid`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TEAMMEMEBERS_USER` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_members`
--

LOCK TABLES `team_members` WRITE;
/*!40000 ALTER TABLE `team_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolbars`
--

DROP TABLE IF EXISTS `toolbars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toolbars` (
  `id` varchar(40) NOT NULL,
  `parent` varchar(40) NOT NULL DEFAULT '-',
  `label` varchar(45) NOT NULL DEFAULT '-',
  `url` varchar(100) NOT NULL,
  `image` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `type` varchar(45) NOT NULL,
  `pos` smallint(6) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolbars`
--

LOCK TABLES `toolbars` WRITE;
/*!40000 ALTER TABLE `toolbars` DISABLE KEYS */;
INSERT INTO `toolbars` VALUES ('menu.basicdata','','menu.basicdata','/basics/','glyphicon glyphicon-list',1,'top',10),('menu.basicdata.companies','menu.basicdata','menu.basicdata.companies','/basics/companies/index','glyphicon glyphicon-user',1,'left',5),('menu.mydashboard','','menu.mydashboard','/my/dashboard','glyphicon glyphicon-home',1,'top',5),('menu.mydashboard.dashboard','menu.mydashboard','menu.mydashboard','/my/dashboard','glyphicon glyphicon-home',1,'left',5),('menu.user','','menu.user','/user/changepassword','glyphicon glyphicon-user',1,'top',15),('menu.user.changepassword','menu.user','menu.user.changepassword','/user/changepassword','glyphicon glyphicon-user',1,'left',5);
/*!40000 ALTER TABLE `toolbars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password_reset_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 10,
  `created_at` int(11) NOT NULL,
  `updated_at` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `password_reset_token` (`password_reset_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_project_access`
--

DROP TABLE IF EXISTS `user_project_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_project_access` (
  `userid` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `access_type` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`userid`,`projectid`),
  KEY `FK_USER_PROJECT_ACCESS_ACCESSTYPE` (`access_type`),
  KEY `FK_USER_PROJECT_ACCESS_PROJECT` (`projectid`),
  CONSTRAINT `FK_USER_PROJECT_ACCESS_ACCESSTYPE` FOREIGN KEY (`access_type`) REFERENCES `project_access_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_PROJECT_ACCESS_PROJECT` FOREIGN KEY (`projectid`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_PROJECT_ACCESS_USER` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_project_access`
--

LOCK TABLES `user_project_access` WRITE;
/*!40000 ALTER TABLE `user_project_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_project_roles`
--

DROP TABLE IF EXISTS `user_project_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_project_roles` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`user_id`,`project_id`,`role_id`),
  KEY `FK_USERPROJECTROLES_PROJECT_idx` (`project_id`),
  KEY `FK_USERPROJECTROLES_ROLE_idx` (`role_id`),
  KEY `FK_USERPROJECTROLES_CREATEDBY_idx` (`created_by`),
  CONSTRAINT `FK_USERPROJECTROLES_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_USERPROJECTROLES_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECTROLES_ROLE` FOREIGN KEY (`role_id`) REFERENCES `project_roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECTROLES_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_project_roles`
--

LOCK TABLES `user_project_roles` WRITE;
/*!40000 ALTER TABLE `user_project_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK_USERROLES_ROLES_idx` (`roleid`),
  CONSTRAINT `FK_USERROLES_ROLES` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERROLES_USERS` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,25,'2018-12-07 16:38:32.704818'),(2,5,'2018-11-28 15:19:16.222107'),(2,10,'2018-11-28 15:19:24.037107');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `hash_password` varchar(200) NOT NULL,
  `gender` smallint(6) NOT NULL DEFAULT 0,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `name_tag` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `usernamecompany_UNIQUE` (`username`,`companyid`),
  KEY `FK_USERS_ACCOUNT_idx` (`companyid`),
  CONSTRAINT `FK_USERS_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin','$2a$10$0mUTXMCBQj2eR6Yc/naHoe0iunzvbaaVHiV1OPFLMEdFzF0bvvdj.',1,'Hamidreza','Seifi','n.t.','1977-09-11 00:00:00','hh@gg.com',1,7,'2018-06-04 07:51:54.890891','2018-12-07 16:38:32.785918'),(2,1,'user','$2a$10$JRkYyAEuswbwqUEVPpwioetQ.9UqBUuVleMaLEzCJk2BAeec8oMjm',2,'user','user',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.915829'),(3,1,'u2','u2',1,'test','test',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.924770'),(4,1,'user1','-',1,'User1','User1',NULL,NULL,'-',1,1,'2018-12-17 13:01:17.555571','2018-12-17 13:01:17.555571'),(5,1,'user2','-',1,'User 2','User 2',NULL,NULL,'-',1,1,'2018-12-17 13:01:17.564324','2018-12-17 13:01:17.564324'),(6,1,'user3','-',1,'User 3','User 3',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.988110','2018-12-18 15:09:45.988110'),(7,1,'user4','-',1,'User 4','User 4',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.988110','2018-12-18 15:09:45.988110'),(8,1,'user5','-',1,'User 5','User 5',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.992110','2018-12-18 15:09:45.992110'),(9,1,'user6','-',1,'User 6','User 6',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.993110','2018-12-18 15:09:45.993110');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `workflow_type` int(11) NOT NULL,
  `name` varchar(200) NOT NULL DEFAULT '(new workflow)',
  `created_by` int(11) NOT NULL,
  `responsible` int(11) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_WOEKFLOW_PROJECT_idx` (`project_id`),
  KEY `FK_WOEKFLOW_TYPE_idx` (`workflow_type`),
  KEY `FK_WOEKFLOW_USER_idx` (`created_by`),
  KEY `FK_WOEKFLOW_USERRESPONSIBLE_idx` (`responsible`),
  CONSTRAINT `FK_WOEKFLOW_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WOEKFLOW_TYPE` FOREIGN KEY (`workflow_type`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WOEKFLOW_USER` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WOEKFLOW_USERRESPONSIBLE` FOREIGN KEY (`responsible`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_tasks`
--

DROP TABLE IF EXISTS `workflow_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow_tasks` (
  `workflow_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`workflow_id`,`task_id`),
  KEY `WORKFLOWTASKS_TASK_idx` (`task_id`),
  CONSTRAINT `WORKFLOWTASKS_TASK` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `WORKFLOWTASKS_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_tasks`
--

LOCK TABLES `workflow_tasks` WRITE;
/*!40000 ALTER TABLE `workflow_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_type`
--

DROP TABLE IF EXISTS `workflow_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_type`
--

LOCK TABLES `workflow_type` WRITE;
/*!40000 ALTER TABLE `workflow_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'featurebim'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18 17:41:48
