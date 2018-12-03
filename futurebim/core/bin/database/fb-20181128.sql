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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `ownerid` int(11) NOT NULL,
  `owner_type` varchar(45) NOT NULL,
  `address_name` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `postcode` varchar(15) NOT NULL,
  `street` varchar(45) NOT NULL,
  `street2` varchar(200) DEFAULT NULL,
  `house_number` varchar(10) NOT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`ownerid`,`owner_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'company','Hauptfiliale','Deutschland','Hannover','30419','Fischteichweg',NULL,'22',NULL,1,'2018-06-10 11:01:58.940668','2018-06-10 11:02:31.431829');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`addresses_BEFORE_UPDATE` BEFORE UPDATE ON `addresses` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) NOT NULL,
  `comments` text DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_COMPANY_STATUS_idx` (`status`),
  CONSTRAINT `FK_COMPANY_STATUS` FOREIGN KEY (`status`) REFERENCES `company_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Test Company',NULL,1,1,'2018-06-04 19:31:58.672344','2018-06-04 19:31:58.672344'),(2,'Company 1',NULL,2,1,'2018-06-08 19:10:21.325301','2018-06-08 19:10:21.325301'),(3,'Company 2',NULL,3,1,'2018-06-08 19:10:21.328295','2018-06-08 19:10:21.328295'),(4,'Company 3',NULL,0,1,'2018-06-09 10:13:19.446634','2018-06-10 10:16:34.473327');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`companies_BEFORE_UPDATE` BEFORE UPDATE ON `companies` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `company_contact_person`
--

DROP TABLE IF EXISTS `company_contact_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_contact_person` (
  `companyid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
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
/*!40000 ALTER TABLE `company_contact_person` ENABLE KEYS */;
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`company_status_BEFORE_UPDATE` BEFORE UPDATE ON `company_status` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`emails_BEFORE_UPDATE` BEFORE UPDATE ON `emails` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`milestone_BEFORE_UPDATE` BEFORE UPDATE ON `milestone` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_access_type`
--

LOCK TABLES `project_access_type` WRITE;
/*!40000 ALTER TABLE `project_access_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_access_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_access_type_BEFORE_UPDATE` BEFORE UPDATE ON `project_access_type` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_bfc_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_bfc_files` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_comments_BEFORE_UPDATE` BEFORE UPDATE ON `project_comments` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_comments_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_comments_files` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_ifc_BEFORE_UPDATE` BEFORE UPDATE ON `project_ifc` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_ifc_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_ifc_files` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_other_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_other_files` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_responsible_BEFORE_UPDATE` BEFORE UPDATE ON `project_responsible` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_roles`
--

DROP TABLE IF EXISTS `project_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_ROLES_CREATEDBY_idx` (`created_by`),
  CONSTRAINT `FK_ROLES_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_roles`
--

LOCK TABLES `project_roles` WRITE;
/*!40000 ALTER TABLE `project_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_roles_BEFORE_UPDATE` BEFORE UPDATE ON `project_roles` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_status_BEFORE_UPDATE` BEFORE UPDATE ON `project_status` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
INSERT INTO `project_types` VALUES (1,'Test Type',1,'2018-11-27 09:48:50.688182','2018-11-27 09:48:50.688182');
/*!40000 ALTER TABLE `project_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_types_BEFORE_UPDATE` BEFORE UPDATE ON `project_types` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_users`
--

DROP TABLE IF EXISTS `project_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `access_type` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_USER_PROJECT` (`project_id`),
  KEY `FK_USER_USERS` (`user_id`),
  KEY `FK_USERPROJECT_ACCESSTYPE_idx` (`access_type`),
  CONSTRAINT `FK_USERPROJECT_ACCESSTYPE` FOREIGN KEY (`access_type`) REFERENCES `project_access_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_users`
--

LOCK TABLES `project_users` WRITE;
/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_users_BEFORE_UPDATE` BEFORE UPDATE ON `project_users` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,0,1,'Projeckt 1','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310401','2018-11-27 09:45:03.411182'),(2,1,0,1,'Projeckt 2','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-11-11 09:36:27.293365'),(3,1,0,1,'Projeckt 3','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-11-11 09:36:27.293365');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`projects_BEFORE_UPDATE` BEFORE UPDATE ON `projects` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`roles_BEFORE_UPDATE` BEFORE UPDATE ON `roles` FOR EACH ROW
BEGIN
set new.updated = CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`project_tasks_BEFORE_UPDATE` BEFORE UPDATE ON `tasks` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`team_BEFORE_UPDATE` BEFORE UPDATE ON `team` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`team_members_BEFORE_UPDATE` BEFORE UPDATE ON `team_members` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `telephonesnumbers`
--

DROP TABLE IF EXISTS `telephonesnumbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telephonesnumbers` (
  `ownerid` int(11) NOT NULL,
  `owner_type` varchar(45) NOT NULL,
  `telephone_name` varchar(45) NOT NULL,
  `country_code` varchar(45) NOT NULL,
  `city_code` varchar(45) NOT NULL,
  `subscriber` varchar(15) NOT NULL,
  `comments` varchar(300) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`ownerid`,`owner_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telephonesnumbers`
--

LOCK TABLES `telephonesnumbers` WRITE;
/*!40000 ALTER TABLE `telephonesnumbers` DISABLE KEYS */;
INSERT INTO `telephonesnumbers` VALUES (1,'company','Empfang','49','115','123456',NULL,1,'2018-06-10 11:04:01.293072','2018-06-10 11:04:01.293072');
/*!40000 ALTER TABLE `telephonesnumbers` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`telephonesnumbers_BEFORE_UPDATE` BEFORE UPDATE ON `telephonesnumbers` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`user_project_roles_BEFORE_UPDATE` BEFORE UPDATE ON `user_project_roles` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
INSERT INTO `user_roles` VALUES (1,5,'2018-11-28 15:19:16.219107'),(1,10,'2018-11-28 15:19:16.221107'),(1,25,'2018-11-28 15:19:16.219107'),(2,5,'2018-11-28 15:19:16.222107'),(2,10,'2018-11-28 15:19:24.037107');
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`user_status_BEFORE_UPDATE` BEFORE UPDATE ON `user_status` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  KEY `FK_USERS_ACCOUNT_idx` (`companyid`),
  CONSTRAINT `FK_USERS_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin','$2a$10$9iVKcQ2RzNWrBHq4G0Jc6ed5Dno.kij4NWdexBkpwjj0Fxo/P3Ldi',0,'Hamidreza','Seifi','n.t.','1977-09-11 00:00:00','hh@gg.com',1,1,'2018-06-04 07:51:54.890891','2018-11-28 14:21:42.483107'),(2,1,'user','$2a$10$JRkYyAEuswbwqUEVPpwioetQ.9UqBUuVleMaLEzCJk2BAeec8oMjm',0,'','',NULL,NULL,'',1,1,'2018-06-04 07:52:09.815891','2018-11-28 14:24:01.211107'),(3,1,'u2','u2',0,'','',NULL,NULL,'',1,1,'2018-06-04 07:52:09.815891','2018-06-04 19:31:38.946434');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`users_BEFORE_UPDATE` BEFORE UPDATE ON `users` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`workflow_BEFORE_UPDATE` BEFORE UPDATE ON `workflow` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `featurebim`.`workflow_type_BEFORE_UPDATE` BEFORE UPDATE ON `workflow_type` FOR EACH ROW
BEGIN
set NEW.updated=CURRENT_TIMESTAMP(6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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

-- Dump completed on 2018-11-28 17:32:46
