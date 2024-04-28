CREATE database springmvc;

CREATE TABLE `springmvc`.`mydiary_users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(100) NULL,
  `user_password` VARCHAR(20) NULL,
  `user_gender` VARCHAR(10) NULL,
  `user_age` INT NULL,
  PRIMARY KEY (`user_id`));


CREATE TABLE `springmvc`.`mydiary_user_entries` (
  `entry_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(100) NULL,
  `entry_date` DATE NULL,
  `entry_text` VARCHAR(2000) NULL,
  PRIMARY KEY (`entry_id`));
