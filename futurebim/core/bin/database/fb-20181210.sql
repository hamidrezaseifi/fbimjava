-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: featurebim
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Test Company','00011',NULL,4,1,'2018-06-04 19:31:58.672344','2018-12-10 18:40:20.128261'),(2,'Company 1','00012',NULL,4,1,'2018-06-08 19:10:21.325301','2018-12-10 18:40:20.129548'),(3,'Company 2','00013',NULL,4,1,'2018-06-08 19:10:21.328295','2018-12-10 18:40:20.130010'),(4,'Company 3','00014',NULL,4,1,'2018-06-09 10:13:19.446634','2018-12-10 18:40:20.130524');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_contact_person`
--

LOCK TABLES `company_contact_person` WRITE;
/*!40000 ALTER TABLE `company_contact_person` DISABLE KEYS */;
INSERT INTO `company_contact_person` VALUES (1,1,'2018-12-08 13:58:33.098549');
/*!40000 ALTER TABLE `company_contact_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_emails`
--

LOCK TABLES `company_emails` WRITE;
/*!40000 ALTER TABLE `company_emails` DISABLE KEYS */;
INSERT INTO `company_emails` VALUES (2,1,'default','aaaa@bb.de',NULL,1,1,'2018-12-08 18:50:44.916535','2018-12-08 18:50:44.916535'),(3,1,'info','ingo@bb.de',NULL,1,1,'2018-12-08 18:50:44.925277','2018-12-08 18:50:44.925277');
/*!40000 ALTER TABLE `company_emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_phonesnumbers`
--

LOCK TABLES `company_phonesnumbers` WRITE;
/*!40000 ALTER TABLE `company_phonesnumbers` DISABLE KEYS */;
INSERT INTO `company_phonesnumbers` VALUES (1,1,'Empfang','+491122334455',NULL,1,1,'2018-06-10 11:04:01.293072','2018-12-08 14:03:37.959479'),(2,1,'Filiale 2','+49123456789',NULL,1,1,'2018-12-08 18:52:43.860877','2018-12-08 18:52:43.860877');
/*!40000 ALTER TABLE `company_phonesnumbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_postaladdresses`
--

LOCK TABLES `company_postaladdresses` WRITE;
/*!40000 ALTER TABLE `company_postaladdresses` DISABLE KEYS */;
INSERT INTO `company_postaladdresses` VALUES (1,1,'Hauptfiliale','Deutschland','Hannover','30419','Fischteichweg','22',NULL,NULL,1,1,'2018-06-10 11:01:58.940668','2018-06-10 11:02:31.431829');
/*!40000 ALTER TABLE `company_postaladdresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_status`
--

LOCK TABLES `company_status` WRITE;
/*!40000 ALTER TABLE `company_status` DISABLE KEYS */;
INSERT INTO `company_status` VALUES (0,'company.status.unknown','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(1,'company.status.active','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(2,'company.status.deactive','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(3,'company.status.deleted','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182'),(4,'company.status.noinit','2018-11-27 09:41:55.698182','2018-11-27 09:41:55.698182');
/*!40000 ALTER TABLE `company_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;
/*!40000 ALTER TABLE `emails` DISABLE KEYS */;
INSERT INTO `emails` VALUES (1,'company','Info','aaaa@em.de',NULL,1,'2018-06-10 11:05:42.997236','2018-06-10 11:05:42.997236');
/*!40000 ALTER TABLE `emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `migration`
--

LOCK TABLES `migration` WRITE;
/*!40000 ALTER TABLE `migration` DISABLE KEYS */;
INSERT INTO `migration` VALUES ('m000000_000000_base',1528924419),('m130524_201442_init',1528924427);
/*!40000 ALTER TABLE `migration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
INSERT INTO `milestone` VALUES (1,1,'Milestone 1','2018-12-20 00:00:00','2019-12-20 00:00:00',1,NULL,'2018-11-24 18:00:52.831540','2018-11-24 18:00:52.831540');
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `milestone_task`
--

LOCK TABLES `milestone_task` WRITE;
/*!40000 ALTER TABLE `milestone_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `milestone_workflow`
--

LOCK TABLES `milestone_workflow` WRITE;
/*!40000 ALTER TABLE `milestone_workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone_workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_access_type`
--

LOCK TABLES `project_access_type` WRITE;
/*!40000 ALTER TABLE `project_access_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_access_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_bfc_files`
--

LOCK TABLES `project_bfc_files` WRITE;
/*!40000 ALTER TABLE `project_bfc_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_bfc_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_comments`
--

LOCK TABLES `project_comments` WRITE;
/*!40000 ALTER TABLE `project_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_comments_files`
--

LOCK TABLES `project_comments_files` WRITE;
/*!40000 ALTER TABLE `project_comments_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_comments_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_ifc`
--

LOCK TABLES `project_ifc` WRITE;
/*!40000 ALTER TABLE `project_ifc` DISABLE KEYS */;
INSERT INTO `project_ifc` VALUES (57,'P1- IFC 001',1,'P1- IFC 001',NULL,1,1,'2018-07-19 22:57:13.400777','2018-07-20 10:42:19.822930'),(58,'P1- IFC 002',1,'P1- IFC 002',NULL,1,1,'2018-07-19 22:58:08.368766','2018-07-20 10:42:19.825929'),(60,'P2- IFC 001',2,'P2- IFC 001',NULL,1,1,'2018-07-19 23:00:10.064291','2018-07-20 10:42:19.826587'),(61,'P2- IFC 002',2,'P2- IFC 002',NULL,1,1,'2018-07-19 23:01:28.624479','2018-07-20 10:42:19.827018');
/*!40000 ALTER TABLE `project_ifc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_ifc_files`
--

LOCK TABLES `project_ifc_files` WRITE;
/*!40000 ALTER TABLE `project_ifc_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_ifc_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_other_files`
--

LOCK TABLES `project_other_files` WRITE;
/*!40000 ALTER TABLE `project_other_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_other_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_responsible`
--

LOCK TABLES `project_responsible` WRITE;
/*!40000 ALTER TABLE `project_responsible` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_responsible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_roles`
--

LOCK TABLES `project_roles` WRITE;
/*!40000 ALTER TABLE `project_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_types`
--

LOCK TABLES `project_types` WRITE;
/*!40000 ALTER TABLE `project_types` DISABLE KEYS */;
INSERT INTO `project_types` VALUES (1,'Test Type',1,'2018-11-27 09:48:50.688182','2018-11-27 09:48:50.688182');
/*!40000 ALTER TABLE `project_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_users`
--

LOCK TABLES `project_users` WRITE;
/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,0,1,'Projeckt 1','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310401','2018-11-27 09:45:03.411182'),(2,1,0,1,'Projeckt 2','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-11-11 09:36:27.293365'),(3,1,0,1,'Projeckt 3','2018-06-14 21:35:15',NULL,1,1,'2018-06-04 19:36:44.310863','2018-11-11 09:36:27.293365');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'role.norole','NOROLE','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(5,'role.user','USER','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(10,'role.view','VIEW','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(15,'role.guest','GUEST','2018-11-28 15:16:44.575107','2018-11-28 15:16:44.575107'),(25,'role.admin','ADMIN','2018-11-28 15:16:44.574107','2018-11-28 15:16:44.574107');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_members`
--

LOCK TABLES `team_members` WRITE;
/*!40000 ALTER TABLE `team_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `toolbars`
--

LOCK TABLES `toolbars` WRITE;
/*!40000 ALTER TABLE `toolbars` DISABLE KEYS */;
INSERT INTO `toolbars` VALUES ('menu.basicdata','','menu.basicdata','/basics/','glyphicon glyphicon-list',1,'top',10),('menu.basicdata.companies','menu.basicdata','menu.basicdata.companies','/basics/companies/index','glyphicon glyphicon-user',1,'left',5),('menu.mydashboard','','menu.mydashboard','/my/dashboard','glyphicon glyphicon-home',1,'top',5),('menu.mydashboard.dashboard','menu.mydashboard','menu.mydashboard','/my/dashboard','glyphicon glyphicon-home',1,'left',5),('menu.user','','menu.user','/user/changepassword','glyphicon glyphicon-user',1,'top',15),('menu.user.changepassword','menu.user','menu.user.changepassword','/user/changepassword','glyphicon glyphicon-user',1,'left',5);
/*!40000 ALTER TABLE `toolbars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_project_access`
--

LOCK TABLES `user_project_access` WRITE;
/*!40000 ALTER TABLE `user_project_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_project_roles`
--

LOCK TABLES `user_project_roles` WRITE;
/*!40000 ALTER TABLE `user_project_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,25,'2018-12-07 16:38:32.704818'),(2,5,'2018-11-28 15:19:16.222107'),(2,10,'2018-11-28 15:19:24.037107');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin','$2a$10$0mUTXMCBQj2eR6Yc/naHoe0iunzvbaaVHiV1OPFLMEdFzF0bvvdj.',1,'Hamidreza','Seifi','n.t.','1977-09-11 00:00:00','hh@gg.com',1,7,'2018-06-04 07:51:54.890891','2018-12-07 16:38:32.785918'),(2,1,'user','$2a$10$JRkYyAEuswbwqUEVPpwioetQ.9UqBUuVleMaLEzCJk2BAeec8oMjm',2,'user','user',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.915829'),(3,1,'u2','u2',1,'test','test',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.924770');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow_tasks`
--

LOCK TABLES `workflow_tasks` WRITE;
/*!40000 ALTER TABLE `workflow_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow_type`
--

LOCK TABLES `workflow_type` WRITE;
/*!40000 ALTER TABLE `workflow_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-10 22:10:52
