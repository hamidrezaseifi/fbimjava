
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subtask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `reporter` int(11) DEFAULT NULL,
  `progress` int(11) NOT NULL DEFAULT 0,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_SUBTASK_TASK_idx` (`taskid`),
  KEY `FK:SUBTASK_REPORTER_USER_idx` (`reporter`),
  CONSTRAINT `FK:SUBTASK_REPORTER_USER` FOREIGN KEY (`reporter`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_SUBTASK_TASK` FOREIGN KEY (`taskid`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET foreign_key_checks = 1;
