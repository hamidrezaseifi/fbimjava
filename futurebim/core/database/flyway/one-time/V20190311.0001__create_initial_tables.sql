
SET foreign_key_checks = 0;


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

CREATE TABLE `company_contact_person` (
  `companyid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`companyid`,`userid`),
  KEY `FK_COMPANY_CONTACT_PERSON_USER_idx` (`userid`),
  CONSTRAINT `FK_COMPANY_CONTACT_PERSON_COMPANY` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_COMPANY_CONTACT_PERSON_USER` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `company_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `project_access_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

CREATE TABLE `project_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `project_types` (
  `id` int(11) NOT NULL,
  `type_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  CONSTRAINT `FK_USERPROJECT_ACCESSTYPE` FOREIGN KEY (`access_type`) REFERENCES `project_access_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECT_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERPROJECT_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `rolname` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `comments` text DEFAULT NULL,
  `reporter` int(11) NOT NULL,
  `assigned_to` int(11) DEFAULT NULL,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `deadline` date DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `PROJECT_TASKS_PROJECT` (`project_id`),
  CONSTRAINT `PROJECT_TASKS_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

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

CREATE TABLE `user_roles` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK_USERROLES_ROLES_idx` (`roleid`),
  CONSTRAINT `FK_USERROLES_ROLES` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERROLES_USERS` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user_status` (
  `id` smallint(6) NOT NULL,
  `titleid` varchar(45) NOT NULL,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`,`titleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `workflow_type` int(11) NOT NULL,
  `name` varchar(200) NOT NULL DEFAULT '(new workflow)',
  `reporter` int(11) NOT NULL,
  `responsible` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_WOEKFLOW_PROJECT_idx` (`project_id`),
  KEY `FK_WOEKFLOW_TYPE_idx` (`workflow_type`),
  KEY `FK_WOEKFLOW_USER_idx` (`reporter`),
  CONSTRAINT `FK_WOEKFLOW_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WOEKFLOW_TYPE` FOREIGN KEY (`workflow_type`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WOEKFLOW_USER` FOREIGN KEY (`reporter`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

CREATE TABLE `workflow_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `created` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;




SET foreign_key_checks = 1;