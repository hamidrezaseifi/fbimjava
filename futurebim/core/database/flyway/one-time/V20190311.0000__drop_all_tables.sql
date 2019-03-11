
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `featurebim`.`companies`;
DROP TABLE IF EXISTS `featurebim`.`company_contact_person`;
DROP TABLE IF EXISTS `featurebim`.`company_emails`;
DROP TABLE IF EXISTS `featurebim`.`company_phonesnumbers`;
DROP TABLE IF EXISTS `featurebim`.`company_postaladdresses`;
DROP TABLE IF EXISTS `featurebim`.`company_status`;
DROP TABLE IF EXISTS `featurebim`.`emails`;
DROP TABLE IF EXISTS `featurebim`.`migration`;
DROP TABLE IF EXISTS `featurebim`.`milestone`;
DROP TABLE IF EXISTS `featurebim`.`milestone_task`;
DROP TABLE IF EXISTS `featurebim`.`milestone_workflow`;
DROP TABLE IF EXISTS `featurebim`.`project_access_type`;
DROP TABLE IF EXISTS `featurebim`.`project_bfc_files`;
DROP TABLE IF EXISTS `featurebim`.`project_comments`;
DROP TABLE IF EXISTS `featurebim`.`project_comments_files`;
DROP TABLE IF EXISTS `featurebim`.`project_ifc`;
DROP TABLE IF EXISTS `featurebim`.`project_ifc_files`;
DROP TABLE IF EXISTS `featurebim`.`project_other_files`;
DROP TABLE IF EXISTS `featurebim`.`project_responsible`;
DROP TABLE IF EXISTS `featurebim`.`project_roles`;
DROP TABLE IF EXISTS `featurebim`.`project_status`;
DROP TABLE IF EXISTS `featurebim`.`project_types`;
DROP TABLE IF EXISTS `featurebim`.`project_users`;
DROP TABLE IF EXISTS `featurebim`.`projects`;
DROP TABLE IF EXISTS `featurebim`.`roles`;
DROP TABLE IF EXISTS `featurebim`.`tasks`;
DROP TABLE IF EXISTS `featurebim`.`team`;
DROP TABLE IF EXISTS `featurebim`.`team_members`;
DROP TABLE IF EXISTS `featurebim`.`toolbars`;
DROP TABLE IF EXISTS `featurebim`.`user`;
DROP TABLE IF EXISTS `featurebim`.`user_project_access`;
DROP TABLE IF EXISTS `featurebim`.`user_project_roles`;
DROP TABLE IF EXISTS `featurebim`.`user_roles`;
DROP TABLE IF EXISTS `featurebim`.`user_status`;
DROP TABLE IF EXISTS `featurebim`.`users`;
DROP TABLE IF EXISTS `featurebim`.`workflow`;
DROP TABLE IF EXISTS `featurebim`.`workflow_tasks`;
DROP TABLE IF EXISTS `featurebim`.`workflow_type`;

SET foreign_key_checks = 1;