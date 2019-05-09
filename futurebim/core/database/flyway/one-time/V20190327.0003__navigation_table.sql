
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `navigation`;

CREATE TABLE `navigation` (
  `id` VARCHAR(45) NOT NULL,
  `parent` VARCHAR(45) NOT NULL DEFAULT 0,
  `label` VARCHAR(45) NOT NULL DEFAULT '-',
  `url` VARCHAR(45) NOT NULL DEFAULT '#',
  `image` VARCHAR(200) NOT NULL DEFAULT '-',
  `version` INT NOT NULL DEFAULT 1,
  `sort` INT NOT NULL DEFAULT 1,
  `state` SMALLINT NOT NULL DEFAULT 1,
  `created` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
  

LOCK TABLES `navigation` WRITE;
/*!40000 ALTER TABLE `navigation` DISABLE KEYS */;
INSERT INTO `navigation` VALUES ('menu.root','-','menu.root','#','-',1,1,1,'2019-03-27 15:34:50.821732','2019-03-27 15:34:50.821732'),('menu.top.bim','menu.root','menu.top.bim','/bim','list',1,25,1,'2019-03-27 15:38:17.860732','2019-03-27 15:38:17.860732'),('menu.top.home','menu.root','menu.top.home','/','dashboard',1,5,1,'2019-03-27 15:38:17.854732','2019-03-27 15:38:17.854732'),('menu.top.ifc','menu.root','menu.top.ifc','#','playlist_add_check',1,20,1,'2019-03-27 15:38:17.860732','2019-03-27 15:38:17.860732'),('menu.top.messages','menu.root','menu.top.messages','/messages','message',1,30,1,'2019-03-27 15:38:17.860732','2019-03-27 15:38:17.860732'),('menu.top.projects','menu.root','menu.top.projects','/projects','chrome_reader_mode',1,10,1,'2019-03-27 15:38:17.860732','2019-03-27 15:38:17.860732'),('menu.top.settings','menu.root','menu.top.settings','/options','build',1,35,1,'2019-03-27 15:38:17.861732','2019-03-27 15:38:17.861732'),('menu.top.workflow','menu.root','menu.top.workflow','/workflow','menu',1,15,1,'2019-03-27 15:38:17.860732','2019-03-27 15:38:17.860732'),('project.projects-create','menu.top.projects','project.projects-create','/projects/create','add',1,10,1,'2019-03-27 15:57:15.079732','2019-03-27 15:57:15.079732'),('project.projects-list','menu.top.projects','project.projects-list','/projects','list',1,5,1,'2019-03-27 15:57:15.078732','2019-03-27 15:57:15.078732'),('workflow.workflow-create','menu.top.workflow','workflow.workflow-create','/workflow/create','add',1,10,1,'2019-03-27 15:57:15.079732','2019-03-27 15:57:15.079732'),('workflow.workflow-graph','menu.top.workflow','workflow.workflow-graph','/workflow/graph','assessment',1,15,1,'2019-03-27 16:43:37.598732','2019-03-27 16:43:37.598732'),('workflow.workflow-list','menu.top.workflow','workflow.workflow-list','/workflow','list',1,5,1,'2019-03-27 15:57:15.079732','2019-03-27 15:57:15.079732');
/*!40000 ALTER TABLE `navigation` ENABLE KEYS */;
UNLOCK TABLES;

SET foreign_key_checks = 1;
