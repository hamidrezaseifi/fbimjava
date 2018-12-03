-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: futurebim
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'company','Hauptfiliale','Deutschland','Hannover','30419','Fischteichweg',NULL,'22',NULL,1,'2018-06-10 11:01:58.940668','2018-06-10 11:02:31.431829');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`)
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`companies_BEFORE_UPDATE` BEFORE UPDATE ON `companies` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`emails_BEFORE_UPDATE` BEFORE UPDATE ON `emails` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building`
--

DROP TABLE IF EXISTS `ifc_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building` (
  `id` varchar(50) NOT NULL,
  `site_id` varchar(50) NOT NULL,
  `building_name` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `composition_type` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDING_SITE` (`site_id`),
  CONSTRAINT `IFCBUILDING_SITE` FOREIGN KEY (`site_id`) REFERENCES `ifc_project_site` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building`
--

LOCK TABLES `ifc_building` WRITE;
/*!40000 ALTER TABLE `ifc_building` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_properties`
--

DROP TABLE IF EXISTS `ifc_building_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGPROPERTIES_BUILDING` (`building_id`),
  CONSTRAINT `IFCBUILDINGPROPERTIES_BUILDING` FOREIGN KEY (`building_id`) REFERENCES `ifc_building` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_properties`
--

LOCK TABLES `ifc_building_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey`
--

DROP TABLE IF EXISTS `ifc_building_storey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey` (
  `id` varchar(50) NOT NULL,
  `building_id` varchar(50) NOT NULL,
  `storey_name` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `composition_type` varchar(50) NOT NULL,
  `elevation` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREY_BUILDING` (`building_id`),
  CONSTRAINT `IFCBUILDINGSTOREY_BUILDING` FOREIGN KEY (`building_id`) REFERENCES `ifc_building` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey`
--

LOCK TABLES `ifc_building_storey` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_beam`
--

DROP TABLE IF EXISTS `ifc_building_storey_beam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_beam` (
  `id` varchar(50) NOT NULL,
  `stair_id` varchar(50) NOT NULL,
  `beam_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYBEAM_STOREY` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYBEAM_STOREY` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_beam`
--

LOCK TABLES `ifc_building_storey_beam` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_beam` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_beam` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_beam_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_beam` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_beam_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_beam_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_beam_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beam_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYBEAM_BEAM` (`beam_id`),
  CONSTRAINT `IFCBUILDINGSTOREYBEAMPLAYER_BEAM` FOREIGN KEY (`beam_id`) REFERENCES `ifc_building_storey_beam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_beam_presentationlayers`
--

LOCK TABLES `ifc_building_storey_beam_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_beam_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_beam_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_beam_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_beam_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_beam_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beam_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYBEAM_BEAM` (`beam_id`),
  CONSTRAINT `IFCBUILDINGSTOREYBEAM_BEAM` FOREIGN KEY (`beam_id`) REFERENCES `ifc_building_storey_beam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_beam_properties`
--

LOCK TABLES `ifc_building_storey_beam_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_beam_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_beam_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_covering`
--

DROP TABLE IF EXISTS `ifc_building_storey_covering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_covering` (
  `id` varchar(50) NOT NULL,
  `stair_id` varchar(50) NOT NULL,
  `covering_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `predefined_type` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYCOVERING_STOREY` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYCOVERING_STOREY` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_covering`
--

LOCK TABLES `ifc_building_storey_covering` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_covering` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_covering` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_covering_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_covering` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_covering_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_covering_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_covering_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `covering_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYCOVERING_COVERING` (`covering_id`),
  CONSTRAINT `IFCBUILDINGSTOREYCOVERINGPLAYER_COVERING` FOREIGN KEY (`covering_id`) REFERENCES `ifc_building_storey_covering` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_covering_presentationlayers`
--

LOCK TABLES `ifc_building_storey_covering_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_covering_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_covering_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_covering_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_covering_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_covering_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `covering_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYCOVERING_COVERING` (`covering_id`),
  CONSTRAINT `IFCBUILDINGSTOREYCOVERING_COVERING` FOREIGN KEY (`covering_id`) REFERENCES `ifc_building_storey_covering` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_covering_properties`
--

LOCK TABLES `ifc_building_storey_covering_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_covering_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_covering_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_door`
--

DROP TABLE IF EXISTS `ifc_building_storey_door`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_door` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `door_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `overall_height` varchar(50) NOT NULL,
  `overall_width` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYDOOR_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYDOOR_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_door`
--

LOCK TABLES `ifc_building_storey_door` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_door` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_door` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_door_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_door` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_door_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_door_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_door_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `door_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSLABPRESENTATION_DOOR` (`door_id`),
  CONSTRAINT `IFCBUILDINGSTOREYDOORPRESENTATION_DOOR` FOREIGN KEY (`door_id`) REFERENCES `ifc_building_storey_door` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_door_presentationlayer`
--

LOCK TABLES `ifc_building_storey_door_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_door_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_door_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_door_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_door_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_door_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `door_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYDOORPROPERTIES_DOOR` (`door_id`),
  CONSTRAINT `IFCBUILDINGSTOREYDOORPROPERTIES_DOOR` FOREIGN KEY (`door_id`) REFERENCES `ifc_building_storey_door` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_door_properties`
--

LOCK TABLES `ifc_building_storey_door_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_door_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_door_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_door_style`
--

DROP TABLE IF EXISTS `ifc_building_storey_door_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_door_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `door_id` varchar(50) NOT NULL,
  `style_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYDOORSTYLE_DOOR` (`door_id`),
  CONSTRAINT `IFCBUILDINGSTOREYDOORSTYLE_DOOR` FOREIGN KEY (`door_id`) REFERENCES `ifc_building_storey_door` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_door_style`
--

LOCK TABLES `ifc_building_storey_door_style` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_door_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_door_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storey_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYPROPERTIES_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYPROPERTIES_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_properties`
--

LOCK TABLES `ifc_building_storey_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_slab`
--

DROP TABLE IF EXISTS `ifc_building_storey_slab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_slab` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `slab_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `predefined_type` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSLAB_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSLAB_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_slab`
--

LOCK TABLES `ifc_building_storey_slab` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_slab` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_slab` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_slab_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_slab` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_slab_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_slab_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_slab_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `slab_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSLABPRESENTATION_OPENING` (`slab_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSLABPRESENTATION_OPENING` FOREIGN KEY (`slab_id`) REFERENCES `ifc_building_storey_slab` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_slab_presentationlayer`
--

LOCK TABLES `ifc_building_storey_slab_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_slab_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_slab_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_slab_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_slab_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_slab_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slab_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSLABPROPERTIES_SLAB` (`slab_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSLABPROPERTIES_SLAB` FOREIGN KEY (`slab_id`) REFERENCES `ifc_building_storey_slab` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_slab_properties`
--

LOCK TABLES `ifc_building_storey_slab_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_slab_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_slab_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space`
--

DROP TABLE IF EXISTS `ifc_building_storey_space`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `space_name` varchar(50) NOT NULL,
  `long_name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `composition_type` varchar(50) NOT NULL,
  `interior_or_exterior_space` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACE_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACE_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space`
--

LOCK TABLES `ifc_building_storey_space` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_space_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_space` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_space_felement_opening_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_felement_opening_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_felement_opening_presentationlayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACEOPENINGPRESENTATION_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACEOPENINGPRESENTATION_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_space_furnishingelement_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_felement_opening_presentationlayer`
--

LOCK TABLES `ifc_building_storey_space_felement_opening_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_felement_opening_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_felement_opening_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement` (
  `id` varchar(50) NOT NULL,
  `space_id` varchar(50) NOT NULL,
  `element_name` varchar(100) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYFURNISHINGELEMENT_STOREY_idx` (`space_id`),
  CONSTRAINT `IFCBUILDINGSTOREYFURNISHINGELEMENT_STOREY` FOREIGN KEY (`space_id`) REFERENCES `ifc_building_storey_space` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_space_furnishingelement_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_space_furnishingelement` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement_furnituretypes`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement_furnituretypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement_furnituretypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `felement_id` varchar(50) NOT NULL,
  `furnituretype_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYFURNISHINGELEMENTFURNITURETYPES_FELEMENT` (`felement_id`),
  CONSTRAINT `IFCBUILDINGSTOREYFURNISHINGELEMENTFURNITURETYPES_FELEMENT` FOREIGN KEY (`felement_id`) REFERENCES `ifc_building_storey_space_furnishingelement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement_furnituretypes`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement_furnituretypes` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_furnituretypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_furnituretypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement_opening`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement_opening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement_opening` (
  `id` varchar(50) NOT NULL,
  `element_id` varchar(50) NOT NULL,
  `open_name` varchar(100) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACEOPENING_SPACE` (`element_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACEOPENING_SPACE` FOREIGN KEY (`element_id`) REFERENCES `ifc_building_storey_space_furnishingelement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement_opening`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement_opening` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_opening` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_opening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement_opening_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement_opening_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement_opening_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACEOPENINGPROPERTIES_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACEOPENINGPROPERTIES_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_space_furnishingelement_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement_opening_properties`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement_opening_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_opening_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_opening_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `felement_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYFURNISHINGELEMENT_FELEMENT` (`felement_id`),
  CONSTRAINT `IFCBUILDINGSTOREYFURNISHINGELEMENTPLAYER_FELEMENT` FOREIGN KEY (`felement_id`) REFERENCES `ifc_building_storey_space_furnishingelement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement_presentationlayers`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_furnishingelement_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_furnishingelement_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_furnishingelement_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `felement_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYFURNISHINGELEMENT_FELEMENT` (`felement_id`),
  CONSTRAINT `IFCBUILDINGSTOREYFURNISHINGELEMENT_FELEMENT` FOREIGN KEY (`felement_id`) REFERENCES `ifc_building_storey_space_furnishingelement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3364 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_furnishingelement_properties`
--

LOCK TABLES `ifc_building_storey_space_furnishingelement_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_furnishingelement_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `space_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACE_SPACE` (`space_id`),
  KEY `IFCBUILDINGSTOREYSPACEPLAYER_PLAYER` (`presentationlayer_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACEPLAYER_PLAYER` FOREIGN KEY (`presentationlayer_id`) REFERENCES `ifc_presentationlayers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `IFCBUILDINGSTOREYSPACEPLAYER_SPACE` FOREIGN KEY (`space_id`) REFERENCES `ifc_building_storey_space` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_presentationlayers`
--

LOCK TABLES `ifc_building_storey_space_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_space_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_space_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_space_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `space_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSPACE_SPACE` (`space_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSPACE_SPACE` FOREIGN KEY (`space_id`) REFERENCES `ifc_building_storey_space` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=925 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_space_properties`
--

LOCK TABLES `ifc_building_storey_space_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_space_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_space_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `stair_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `shape_type` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIR_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIR_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair`
--

LOCK TABLES `ifc_building_storey_stair` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_stair_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_stair` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_stair_flight`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_flight` (
  `id` varchar(50) NOT NULL,
  `stair_id` varchar(50) NOT NULL,
  `flight_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `number_of_riser` varchar(50) NOT NULL,
  `number_of_treads` varchar(50) NOT NULL,
  `riser_height` varchar(50) NOT NULL,
  `treads_height` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRFLIGHT_STAIR` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRFLIGHT_STAIR` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_flight`
--

LOCK TABLES `ifc_building_storey_stair_flight` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_stair_flight_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_stair_flight` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_stair_flight_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_flight_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_flight_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRFLIGHTPLAYER_FLIGHT` (`flight_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRFLIGHTPLAYER_FLIGHT` FOREIGN KEY (`flight_id`) REFERENCES `ifc_building_storey_stair_flight` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_flight_presentationlayers`
--

LOCK TABLES `ifc_building_storey_stair_flight_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_flight_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_flight_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_flight_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRFLIGHTPROPERTIES_FLIGHT` (`flight_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRFLIGHTPROPERTIES_FLIGHT` FOREIGN KEY (`flight_id`) REFERENCES `ifc_building_storey_stair_flight` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_flight_properties`
--

LOCK TABLES `ifc_building_storey_stair_flight_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_flight_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_member`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_member` (
  `id` varchar(50) NOT NULL,
  `stair_id` varchar(50) NOT NULL,
  `member_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRMEMBER_STAIR` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRMEMBER_STAIR` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_member`
--

LOCK TABLES `ifc_building_storey_stair_member` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_stair_member_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_stair_member` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_stair_member_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_member_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_member_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRMEMBER_MEMBER` (`member_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRMEMBERPLAYER_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `ifc_building_storey_stair_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_member_presentationlayers`
--

LOCK TABLES `ifc_building_storey_stair_member_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_member_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_member_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_member_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRMEMBER_MEMBER` (`member_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRMEMBER_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `ifc_building_storey_stair_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_member_properties`
--

LOCK TABLES `ifc_building_storey_stair_member_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_member_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stair_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRPROPERTIES_STAIR` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRPROPERTIES_STAIR` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey_stair` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_properties`
--

LOCK TABLES `ifc_building_storey_stair_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_railing`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_railing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_railing` (
  `id` varchar(50) NOT NULL,
  `stair_id` varchar(50) NOT NULL,
  `railing_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRRAILING_STAIR` (`stair_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRRAILING_STAIR` FOREIGN KEY (`stair_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_railing`
--

LOCK TABLES `ifc_building_storey_stair_railing` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_stair_railing_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_stair_railing` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_stair_railing_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_railing_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_railing_presentationlayers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `railing_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRRAILING_RAILING` (`railing_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRRAILINGPLAYER_RAILING` FOREIGN KEY (`railing_id`) REFERENCES `ifc_building_storey_stair_railing` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_railing_presentationlayers`
--

LOCK TABLES `ifc_building_storey_stair_railing_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing_presentationlayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_stair_railing_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_stair_railing_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_stair_railing_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `railing_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSTAIRRAILING_RAILING` (`railing_id`),
  CONSTRAINT `IFCBUILDINGSTOREYSTAIRRAILING_RAILING` FOREIGN KEY (`railing_id`) REFERENCES `ifc_building_storey_stair_railing` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_stair_railing_properties`
--

LOCK TABLES `ifc_building_storey_stair_railing_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_stair_railing_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wall`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `wall_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALL_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALL_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall`
--

LOCK TABLES `ifc_building_storey_wall` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_wall_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_wall` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_wall_opening`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall_opening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall_opening` (
  `id` varchar(50) NOT NULL,
  `wall_id` varchar(50) NOT NULL,
  `wall_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLOPENING_WALL` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLOPENING_WALL` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall_opening`
--

LOCK TABLES `ifc_building_storey_wall_opening` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_wall_opening_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_wall_opening` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_wall_opening_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall_opening_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall_opening_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `opening_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLOPENINGPRESENTATION_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLOPENINGPRESENTATION_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_wall_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall_opening_presentationlayer`
--

LOCK TABLES `ifc_building_storey_wall_opening_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wall_opening_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall_opening_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall_opening_properties` (
  `id` varchar(50) NOT NULL,
  `opening_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLOPENINGPROPERTIES_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLOPENINGPROPERTIES_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_wall_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall_opening_properties`
--

LOCK TABLES `ifc_building_storey_wall_opening_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall_opening_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wall_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `wall_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLPRESENTATION_OPENING` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLPRESENTATION_OPENING` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall_presentationlayer`
--

LOCK TABLES `ifc_building_storey_wall_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wall_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_wall_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wall_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wall_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLPROPERTIES_WALL` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLPROPERTIES_WALL` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wall_properties`
--

LOCK TABLES `ifc_building_storey_wall_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wall_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wall_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `wall_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASE_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASE_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase`
--

LOCK TABLES `ifc_building_storey_wallstandardcase` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase_opening`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase_opening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase_opening` (
  `id` varchar(50) NOT NULL,
  `wall_id` varchar(50) NOT NULL,
  `wall_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENING_WALL` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENING_WALL` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wallstandardcase` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase_opening`
--

LOCK TABLES `ifc_building_storey_wallstandardcase_opening` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase_opening_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase_opening_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase_opening_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `opening_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENINGPRESENTATION_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENINGPRESENTATION_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_wallstandardcase_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase_opening_presentationlayer`
--

LOCK TABLES `ifc_building_storey_wallstandardcase_opening_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase_opening_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase_opening_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase_opening_properties` (
  `id` varchar(50) NOT NULL,
  `opening_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENINGPROPERTIES_OPENING` (`opening_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASEOPENINGPROPERTIES_OPENING` FOREIGN KEY (`opening_id`) REFERENCES `ifc_building_storey_wallstandardcase_opening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase_opening_properties`
--

LOCK TABLES `ifc_building_storey_wallstandardcase_opening_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_opening_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `wall_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASEPRESENTATION_OPENING` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASEPRESENTATION_OPENING` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wallstandardcase` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase_presentationlayer`
--

LOCK TABLES `ifc_building_storey_wallstandardcase_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_wallstandardcase_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_wallstandardcase_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_wallstandardcase_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wall_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWALLSTANDARDCASEPROPERTIES_WALL` (`wall_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWALLSTANDARDCASEPROPERTIES_WALL` FOREIGN KEY (`wall_id`) REFERENCES `ifc_building_storey_wallstandardcase` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_wallstandardcase_properties`
--

LOCK TABLES `ifc_building_storey_wallstandardcase_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_wallstandardcase_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_window`
--

DROP TABLE IF EXISTS `ifc_building_storey_window`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_window` (
  `id` varchar(50) NOT NULL,
  `storey_id` varchar(50) NOT NULL,
  `window_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `overall_height` varchar(50) NOT NULL,
  `overall_width` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWINDOW_STOREY` (`storey_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWINDOW_STOREY` FOREIGN KEY (`storey_id`) REFERENCES `ifc_building_storey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_window`
--

LOCK TABLES `ifc_building_storey_window` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_window` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_window` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_building_storey_window_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_building_storey_window` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_building_storey_window_presentationlayer`
--

DROP TABLE IF EXISTS `ifc_building_storey_window_presentationlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_window_presentationlayer` (
  `id` varchar(50) NOT NULL,
  `window_id` varchar(50) NOT NULL,
  `presentationlayer_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYSLABPRESENTATION_WINDOW` (`window_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWINDOWPRESENTATION_WINDOW` FOREIGN KEY (`window_id`) REFERENCES `ifc_building_storey_window` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_window_presentationlayer`
--

LOCK TABLES `ifc_building_storey_window_presentationlayer` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_window_presentationlayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_window_presentationlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_window_properties`
--

DROP TABLE IF EXISTS `ifc_building_storey_window_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_window_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `window_id` varchar(50) NOT NULL,
  `property_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWINDOWPROPERTIES_WINDOW` (`window_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWINDOWPROPERTIES_WINDOW` FOREIGN KEY (`window_id`) REFERENCES `ifc_building_storey_window` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_window_properties`
--

LOCK TABLES `ifc_building_storey_window_properties` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_window_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_window_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_building_storey_window_style`
--

DROP TABLE IF EXISTS `ifc_building_storey_window_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_building_storey_window_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `window_id` varchar(50) NOT NULL,
  `style_id` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCBUILDINGSTOREYWINDOWSTYLE_WINDOW` (`window_id`),
  CONSTRAINT `IFCBUILDINGSTOREYWINDOWSTYLE_WINDOW` FOREIGN KEY (`window_id`) REFERENCES `ifc_building_storey_window` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_building_storey_window_style`
--

LOCK TABLES `ifc_building_storey_window_style` WRITE;
/*!40000 ALTER TABLE `ifc_building_storey_window_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_building_storey_window_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_conversionbaseunits`
--

DROP TABLE IF EXISTS `ifc_conversionbaseunits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_conversionbaseunits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ifc_id` varchar(50) NOT NULL,
  `unit_name` varchar(100) NOT NULL,
  `unit_type` varchar(100) NOT NULL,
  `equivalent` varchar(100) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCCONVERSATIONBASEUNIT_IFC` (`ifc_id`),
  CONSTRAINT `IFCCONVERSATIONBASEUNIT_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_conversionbaseunits`
--

LOCK TABLES `ifc_conversionbaseunits` WRITE;
/*!40000 ALTER TABLE `ifc_conversionbaseunits` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_conversionbaseunits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_doorstyle`
--

DROP TABLE IF EXISTS `ifc_doorstyle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_doorstyle` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `type_name` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `operation_type` varchar(50) NOT NULL,
  `construction_type` varchar(50) NOT NULL,
  `parameter_takes_precedence` varchar(50) NOT NULL,
  `sizeable` varchar(10) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCDOORSTYLE_IFC` (`ifc_id`),
  CONSTRAINT `IFCDOORSTYLE_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_doorstyle`
--

LOCK TABLES `ifc_doorstyle` WRITE;
/*!40000 ALTER TABLE `ifc_doorstyle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_doorstyle` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_doorstyle_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_doorstyle` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_furnituretypes`
--

DROP TABLE IF EXISTS `ifc_furnituretypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_furnituretypes` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `type_name` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `element_type` varchar(50) NOT NULL,
  `assembly_place` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCFURNITURETYPE_IFC` (`ifc_id`),
  CONSTRAINT `IFCFURNITURETYPE_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_furnituretypes`
--

LOCK TABLES `ifc_furnituretypes` WRITE;
/*!40000 ALTER TABLE `ifc_furnituretypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_furnituretypes` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_furnituretypes_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_furnituretypes` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_presentationlayers`
--

DROP TABLE IF EXISTS `ifc_presentationlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_presentationlayers` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `layer_name` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCLAYER_IFC` (`ifc_id`),
  CONSTRAINT `IFCLAYER_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_presentationlayers`
--

LOCK TABLES `ifc_presentationlayers` WRITE;
/*!40000 ALTER TABLE `ifc_presentationlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_presentationlayers` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_presentationlayers_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_presentationlayers` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_project`
--

DROP TABLE IF EXISTS `ifc_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_project` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `project_long_name` varchar(100) NOT NULL,
  `phase` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCPROJECT_IFC` (`ifc_id`),
  CONSTRAINT `IFCPROJECT_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_project`
--

LOCK TABLES `ifc_project` WRITE;
/*!40000 ALTER TABLE `ifc_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_project` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_project_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_project` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_project_site`
--

DROP TABLE IF EXISTS `ifc_project_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_project_site` (
  `id` varchar(50) NOT NULL,
  `project_id` varchar(50) NOT NULL,
  `site_name` varchar(50) NOT NULL,
  `object_type` varchar(50) NOT NULL,
  `object_placement` varchar(50) NOT NULL,
  `composition_type` varchar(50) NOT NULL,
  `ref_latitude` varchar(50) NOT NULL,
  `ref_longitude` varchar(50) NOT NULL,
  `ref_elevation` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCPROJECTSITE_IFC` (`project_id`),
  CONSTRAINT `IFCPROJECTSITE_IFC` FOREIGN KEY (`project_id`) REFERENCES `ifc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_project_site`
--

LOCK TABLES `ifc_project_site` WRITE;
/*!40000 ALTER TABLE `ifc_project_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_project_site` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_project_site_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_project_site` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_properties`
--

DROP TABLE IF EXISTS `ifc_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_properties` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `property_name` varchar(50) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCPROPERTIES_IFC` (`ifc_id`),
  CONSTRAINT `IFCPROPERTIES_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_properties`
--

LOCK TABLES `ifc_properties` WRITE;
/*!40000 ALTER TABLE `ifc_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_properties` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_properties_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_properties` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ifc_properties_value`
--

DROP TABLE IF EXISTS `ifc_properties_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_properties_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `property_id` varchar(50) NOT NULL,
  `value_name` varchar(50) NOT NULL,
  `nominal_value` varchar(150) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCPROPERTIESVALUE_PROPERTIES` (`property_id`),
  CONSTRAINT `IFCPROPERTIESVALUE_PROPERTIES` FOREIGN KEY (`property_id`) REFERENCES `ifc_properties` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=257605 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_properties_value`
--

LOCK TABLES `ifc_properties_value` WRITE;
/*!40000 ALTER TABLE `ifc_properties_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_properties_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_units`
--

DROP TABLE IF EXISTS `ifc_units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ifc_id` varchar(50) NOT NULL,
  `unit_name` varchar(100) NOT NULL,
  `unit_type` varchar(100) NOT NULL,
  `equivalent` varchar(100) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCUNIT_IFC` (`ifc_id`),
  CONSTRAINT `IFCUNIT_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_units`
--

LOCK TABLES `ifc_units` WRITE;
/*!40000 ALTER TABLE `ifc_units` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifc_windowstyle`
--

DROP TABLE IF EXISTS `ifc_windowstyle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ifc_windowstyle` (
  `id` varchar(50) NOT NULL,
  `ifc_id` varchar(50) NOT NULL,
  `type_name` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `operation_type` varchar(50) NOT NULL,
  `construction_type` varchar(50) NOT NULL,
  `parameter_takes_precedence` varchar(50) NOT NULL,
  `sizeable` varchar(10) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `IFCWINDOWSTYLE_IFC` (`ifc_id`),
  CONSTRAINT `IFCWINDOWSTYLE_IFC` FOREIGN KEY (`ifc_id`) REFERENCES `project_ifc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifc_windowstyle`
--

LOCK TABLES `ifc_windowstyle` WRITE;
/*!40000 ALTER TABLE `ifc_windowstyle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifc_windowstyle` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`ifc_windowstyle_BEFORE_UPDATE` BEFORE UPDATE ON `ifc_windowstyle` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
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

--
-- Table structure for table `project_bcf_files`
--

DROP TABLE IF EXISTS `project_bcf_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_bcf_files` (
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
-- Dumping data for table `project_bcf_files`
--

LOCK TABLES `project_bcf_files` WRITE;
/*!40000 ALTER TABLE `project_bcf_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_bcf_files` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`project_bcf_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_bcf_files` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
  `id` varchar(50) NOT NULL,
  `project_id` int(11) NOT NULL,
  `ifc_name` varchar(100) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_IFC_FILES_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_IFC_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_ifc`
--

LOCK TABLES `project_ifc` WRITE;
/*!40000 ALTER TABLE `project_ifc` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_ifc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`project_ifc_BEFORE_UPDATE` BEFORE UPDATE ON `project_ifc` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`project_ifc_files_BEFORE_UPDATE` BEFORE UPDATE ON `project_ifc_files` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`project_responsible_BEFORE_UPDATE` BEFORE UPDATE ON `project_responsible` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_tasks`
--

DROP TABLE IF EXISTS `project_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_tasks` (
  `id` int(10) unsigned zerofill NOT NULL,
  `project_id` int(11) NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_comments` text DEFAULT NULL,
  `user_create` int(11) NOT NULL,
  `user_allocated` int(11) DEFAULT NULL,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `deatline` date DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_TASKS_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_TASKS_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tasks`
--

LOCK TABLES `project_tasks` WRITE;
/*!40000 ALTER TABLE `project_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_tasks` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`project_tasks_BEFORE_UPDATE` BEFORE UPDATE ON `project_tasks` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
  `project_name` varchar(200) NOT NULL,
  `responsible_user` int(11) NOT NULL,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `deatline` date DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_PROJECTS_ACCOUNT_idx` (`companyid`),
  CONSTRAINT `FK_PROJECTS_ACCOUNT` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,'Projeckt 1',0,'2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310401','2018-06-04 19:36:44.310401'),(2,1,'Projeckt 2',0,'2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-06-04 19:36:44.310863'),(3,1,'Projeckt 3',0,'2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-06-04 19:36:44.310863');
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`projects_BEFORE_UPDATE` BEFORE UPDATE ON `projects` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`telephonesnumbers_BEFORE_UPDATE` BEFORE UPDATE ON `telephonesnumbers` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `hash_password` varchar(45) NOT NULL,
  `gender` smallint(6) NOT NULL DEFAULT 0,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `name_tag` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `users` VALUES (1,1,'administrator','admin',0,'','',NULL,NULL,'',1,1,'2018-06-04 07:51:54.890891','2018-06-04 19:31:38.938720'),(2,1,'user','user',0,'','',NULL,NULL,'',1,1,'2018-06-04 07:52:09.815891','2018-06-04 19:31:38.945944'),(3,1,'u2','u2',0,'','',NULL,NULL,'',1,1,'2018-06-04 07:52:09.815891','2018-06-04 19:31:38.946434');
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `futurebim`.`users_BEFORE_UPDATE` BEFORE UPDATE ON `users` FOR EACH ROW
set new.updated = CURRENT_TIMESTAMP(6) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'futurebim'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04 17:57:11
