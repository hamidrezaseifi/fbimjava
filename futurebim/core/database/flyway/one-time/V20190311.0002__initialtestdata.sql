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
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Test Company','00011',NULL,1,3,'2018-06-04 19:31:58.672344','2018-12-17 12:10:19.572287'),(2,'Company 1','00012',NULL,4,1,'2018-06-08 19:10:21.325301','2018-12-10 18:40:20.129548'),(3,'Company 2','00013',NULL,4,1,'2018-06-08 19:10:21.328295','2018-12-10 18:40:20.130010'),(4,'Company 3','00014',NULL,4,1,'2018-06-09 10:13:19.446634','2018-12-10 18:40:20.130524');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_contact_person`
--

LOCK TABLES `company_contact_person` WRITE;
/*!40000 ALTER TABLE `company_contact_person` DISABLE KEYS */;
INSERT INTO `company_contact_person` VALUES (1,1,'2018-12-19 16:24:28.338841');
/*!40000 ALTER TABLE `company_contact_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_emails`
--

LOCK TABLES `company_emails` WRITE;
/*!40000 ALTER TABLE `company_emails` DISABLE KEYS */;
INSERT INTO `company_emails` VALUES (7,1,'default','aaaa@bb.de',NULL,1,1,'2018-12-19 16:24:28.335253','2018-12-19 16:24:28.335253');
/*!40000 ALTER TABLE `company_emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_phonesnumbers`
--

LOCK TABLES `company_phonesnumbers` WRITE;
/*!40000 ALTER TABLE `company_phonesnumbers` DISABLE KEYS */;
INSERT INTO `company_phonesnumbers` VALUES (6,1,'Empfang','+491122334455',NULL,1,1,'2018-12-19 16:24:28.331992','2018-12-19 16:24:28.331992');
/*!40000 ALTER TABLE `company_phonesnumbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_postaladdresses`
--

LOCK TABLES `company_postaladdresses` WRITE;
/*!40000 ALTER TABLE `company_postaladdresses` DISABLE KEYS */;
INSERT INTO `company_postaladdresses` VALUES (5,1,'Hauptfiliale','Deutschland','Hannover','30419','Fischteichweg','22','aaaaaaaaaa',NULL,1,1,'2018-12-19 16:24:28.327573','2018-12-19 16:24:28.327573');
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
INSERT INTO `project_access_type` VALUES (0,'None',1,'2018-12-19 07:54:54.470534','2018-12-19 07:54:54.470534'),(1,'Admin',1,'2018-12-17 13:04:30.617764','2018-12-17 13:04:30.617764'),(2,'Read/Write',1,'2018-12-17 13:04:30.626412','2018-12-17 13:04:30.626412'),(3,'Read',1,'2018-12-19 07:54:54.470058','2018-12-19 07:54:54.470058');
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
INSERT INTO `project_roles` VALUES (1,0,'Role 1',NULL,1,1,'2018-12-17 10:38:51.058537','2018-12-17 10:38:51.058537'),(2,0,'Role 2',NULL,1,1,'2018-12-17 10:38:51.067318','2018-12-17 10:38:51.067318'),(3,0,'Role 3',NULL,1,1,'2018-12-17 10:38:51.067617','2018-12-17 10:38:51.067617'),(4,0,'Role 4',NULL,1,1,'2018-12-17 10:38:51.067905','2018-12-17 10:38:51.067905');
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
INSERT INTO `project_types` VALUES (1,'Test Type 1',1,'2018-11-27 09:48:50.688182','2018-12-16 19:58:56.803554'),(2,'Test Type 2',1,'2018-12-16 19:58:56.805459','2018-12-16 19:58:56.805459'),(3,'Test Type 3',1,'2018-12-16 19:58:56.806383','2018-12-16 19:58:56.806383');
/*!40000 ALTER TABLE `project_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_users`
--

LOCK TABLES `project_users` WRITE;
/*!40000 ALTER TABLE `project_users` DISABLE KEYS */;
INSERT INTO `project_users` VALUES (1,1,1,1,'2018-12-17 13:05:08.940378','2018-12-17 13:05:08.940378'),(1,2,0,3,'2018-12-19 10:46:52.847281','2018-12-19 10:46:52.847281'),(1,4,2,2,'2018-12-17 13:05:08.950056','2018-12-17 13:05:08.950056'),(1,7,2,2,'2018-12-19 16:27:06.857569','2018-12-19 16:27:06.857569'),(1,8,2,2,'2018-12-19 11:20:22.996969','2018-12-19 11:20:22.996969');
/*!40000 ALTER TABLE `project_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,1,0,1,'Haupt Projeckt','2019-08-05 00:00:00','2020-10-13 00:00:00',7,1,'2018-06-04 19:36:44.310401','2018-12-17 10:35:21.641560'),(2,1,0,3,'Projeckt 222222','2019-05-07 00:00:00','2021-01-07 00:00:00',6,1,'2018-06-04 19:36:44.310863','2018-12-17 09:56:23.838432'),(3,1,0,1,'Projeckt 3456','2019-06-02 00:00:00','2020-09-30 00:00:00',5,1,'2018-06-04 19:36:44.310863','2018-12-16 19:57:00.465175'),(7,1,0,2,'My Projekt 1','2019-07-07 00:00:00','2020-11-25 00:00:00',1,1,'2018-12-16 20:37:28.767585','2018-12-16 20:37:28.767585'),(8,1,0,1,'Projekt Test 5','2019-03-04 00:00:00',NULL,1,1,'2018-12-16 20:38:20.731658','2018-12-16 20:38:20.731658'),(11,1,0,1,'Neu Projekt 66666','2019-06-05 00:00:00',NULL,1,1,'2018-12-17 09:56:47.046444','2018-12-17 09:56:47.046444');
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
INSERT INTO `tasks` VALUES (1,1,'Task 1',NULL,1,0,'2018-12-19 00:00:00','2021-09-14',1,1,'2018-12-19 12:28:57.154219','2018-12-19 12:28:57.154219'),(2,1,'Task 2',NULL,1,2,'2018-12-19 13:28:57','2010-05-19',1,1,'2018-12-19 12:28:57.156762','2018-12-19 12:28:57.156762'),(3,1,'Task 3',NULL,1,0,'2018-10-10 00:00:00','2019-08-19',1,1,'2018-12-19 12:28:57.157027','2018-12-19 12:28:57.157027'),(4,1,'Task 4',NULL,1,3,'2018-12-19 13:28:57','2019-05-19',1,1,'2018-12-19 12:28:57.157312','2018-12-19 12:28:57.157312'),(5,1,'new Task','bbbbbbbbbbbbb',1,7,'2018-12-20 00:00:00','2020-09-24',1,1,'2018-12-20 10:09:41.677439','2018-12-20 10:09:41.677439'),(10,1,'Task 5','',1,0,'2018-12-21 00:00:00','2020-08-19',1,1,'2018-12-21 21:54:42.924806','2018-12-21 21:54:42.924806'),(11,1,'Task 6','',1,0,'2018-12-21 00:00:00','2021-03-11',1,1,'2018-12-21 21:54:59.380576','2018-12-21 21:54:59.380576'),(12,1,'Task 7','',1,0,'2018-12-21 00:00:00','2020-09-17',1,1,'2018-12-21 21:55:26.763677','2018-12-21 21:55:26.763677'),(13,1,'Task 8','',1,0,'2018-12-21 00:00:00','2021-12-16',1,1,'2018-12-21 21:55:46.885053','2018-12-21 21:55:46.885053'),(14,1,'my new task 77','',0,0,'2018-12-22 00:00:00','2019-11-27',1,1,'2018-12-21 23:02:34.864366','2018-12-21 23:02:34.864366'),(15,1,'my new task 77','',0,0,'2018-12-22 00:00:00','2019-11-27',1,1,'2018-12-21 23:02:39.607408','2018-12-21 23:02:39.607408'),(16,1,'WWWWWWWWW','',0,0,'2018-12-22 00:00:00','2019-09-11',1,1,'2018-12-21 23:05:05.255752','2018-12-21 23:05:05.255752'),(17,1,'My New Added Task 56','',0,0,'2019-06-05 00:00:00','2021-08-11',1,1,'2018-12-21 23:05:47.295883','2018-12-21 23:05:47.295883');
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
INSERT INTO `user_roles` VALUES (1,25,'2018-12-19 16:23:49.994191'),(2,5,'2018-11-28 15:19:16.222107'),(2,10,'2018-11-28 15:19:24.037107');
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
INSERT INTO `users` VALUES (1,1,'admin','$2a$10$WeW6PSCH8GAmnhdJgVF9XOHUKNAcNqsV/qxnF1DPFDktXqe7vgnJO',1,'Hamidreza','Seifi','n.t.','1977-09-11 00:00:00','hh@gg.com',1,9,'2018-06-04 07:51:54.890891','2018-12-07 16:38:32.785918'),(2,1,'user','$2a$10$JRkYyAEuswbwqUEVPpwioetQ.9UqBUuVleMaLEzCJk2BAeec8oMjm',2,'user','user',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.915829'),(3,1,'u2','u2',1,'test','test',NULL,NULL,'',4,1,'2018-06-04 07:52:09.815891','2018-12-08 15:54:26.924770'),(4,1,'user1','-',1,'User1','User1',NULL,NULL,'-',1,1,'2018-12-17 13:01:17.555571','2018-12-17 13:01:17.555571'),(5,1,'user2','-',1,'User 2','User 2',NULL,NULL,'-',1,1,'2018-12-17 13:01:17.564324','2018-12-17 13:01:17.564324'),(6,1,'user3','-',1,'User 3','User 3',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.988110','2018-12-18 15:09:45.988110'),(7,1,'user4','-',1,'User 4','User 4',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.988110','2018-12-18 15:09:45.988110'),(8,1,'user5','-',1,'User 5','User 5',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.992110','2018-12-18 15:09:45.992110'),(9,1,'user6','-',1,'User 6','User 6',NULL,NULL,'-',1,1,'2018-12-18 15:09:45.993110','2018-12-18 15:09:45.993110');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
INSERT INTO `workflow` VALUES (1,1,1,'Workflow 1',1,1,1,1,'2018-12-20 23:12:07.463760','2018-12-20 23:12:07.463760'),(2,1,2,'Workflow 2',1,1,1,1,'2018-12-20 23:12:07.467329','2018-12-20 23:12:07.467329'),(3,1,3,'Workflow 3',2,2,1,1,'2018-12-20 23:12:07.467817','2018-12-20 23:12:07.467817'),(4,1,1,'Workflow 4',1,8,1,1,'2018-12-20 23:12:07.468062','2018-12-20 23:12:07.468062');
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow_tasks`
--

LOCK TABLES `workflow_tasks` WRITE;
/*!40000 ALTER TABLE `workflow_tasks` DISABLE KEYS */;
INSERT INTO `workflow_tasks` VALUES (1,1,1,'2018-12-21 09:47:02.883000'),(1,2,1,'2018-12-21 09:47:02.891667'),(1,4,1,'2018-12-21 10:57:25.607376'),(1,10,1,'2018-12-21 22:43:40.708270'),(1,12,1,'2018-12-21 22:41:01.092570'),(1,16,1,'2018-12-21 23:05:05.295760'),(1,17,1,'2018-12-21 23:05:47.324546');
/*!40000 ALTER TABLE `workflow_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workflow_type`
--

LOCK TABLES `workflow_type` WRITE;
/*!40000 ALTER TABLE `workflow_type` DISABLE KEYS */;
INSERT INTO `workflow_type` VALUES (1,'Workflow Type 1','images/workflow_1.png',1,'2018-12-20 10:25:26.176679','2018-12-20 10:25:26.176679'),(2,'Workflow Type 2','images/workflow_2.png',1,'2018-12-20 10:25:26.177202','2018-12-20 10:25:26.177202'),(3,'Workflow Type 3','images/workflow_3.png',1,'2018-12-20 10:25:26.177489','2018-12-20 10:25:26.177489'),(4,'Workflow Type 4','images/workflow_4.png',1,'2018-12-20 10:25:26.177693','2018-12-20 10:25:26.177693');
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

-- Dump completed on 2019-03-11 17:02:18
