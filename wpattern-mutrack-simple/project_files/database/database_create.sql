	-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_wpattern_mutrack_simple
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_wpattern_mutrack_simple
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_wpattern_mutrack_simple` DEFAULT CHARACTER SET utf8 ;
USE `db_wpattern_mutrack_simple` ;

-- -----------------------------------------------------
-- Table `db_wpattern_mutrack_simple`.`tb_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_wpattern_mutrack_simple`.`tb_permission` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_wpattern_mutrack_simple`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_wpattern_mutrack_simple`.`tb_user` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(120) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_wpattern_mutrack_simple`.`tb_package`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_wpattern_mutrack_simple`.`tb_package` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `code` VARCHAR(20) NOT NULL,
  `description` VARCHAR(50) NULL,
  `register_date` VARCHAR(45) NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`pk_id`, `owner_id`),
  INDEX `fk_tb_package_tb_user_idx` (`owner_id` ASC),
  CONSTRAINT `fk_tb_package_tb_user`
    FOREIGN KEY (`owner_id`)
    REFERENCES `db_wpattern_mutrack_simple`.`tb_user` (`pk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_wpattern_mutrack_simple`.`tb_user_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_wpattern_mutrack_simple`.`tb_user_permission` (
  `permission_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`permission_id`, `user_id`),
  INDEX `fk_tb_permission_has_tb_user_tb_user1_idx` (`user_id` ASC),
  INDEX `fk_tb_permission_has_tb_user_tb_permission1_idx` (`permission_id` ASC),
  CONSTRAINT `fk_tb_permission_has_tb_user_tb_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `db_wpattern_mutrack_simple`.`tb_permission` (`pk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_permission_has_tb_user_tb_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_wpattern_mutrack_simple`.`tb_user` (`pk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mutrack_simple`.`tb_permission`
-- -----------------------------------------------------
START TRANSACTION;
USE `db_wpattern_mutrack_simple`;
INSERT INTO `db_wpattern_mutrack_simple`.`tb_permission` (`pk_id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `db_wpattern_mutrack_simple`.`tb_permission` (`pk_id`, `role`) VALUES (2, 'ROLE_USER');

-- Password: "admin".
INSERT INTO `db_wpattern_mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('1', 'Admin', 'admin@admin.com', '9fe76e18dd29100230680fa6c812e26c4da4b3cf48a85850910e6f4400a6b3ff9ec05190c175f592');
-- Password: "user".
INSERT INTO `db_wpattern_mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('2', 'User', 'user@user.com', '4a6e2c62e383f9c944f112388e5917caea81cecfef06cd2aa3af12d82f2dbe97ad56ea6934366ad3');

INSERT INTO `db_wpattern_mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('1', 'Sensor de Temperatura', 'RE736868622SE', 'Compra realizada na Aliexpress.', '2015-05-28', '1');
INSERT INTO `db_wpattern_mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('2', 'Livro Angularjs', 'DM567434841BR', 'Enviada pela submarino.', '2015-05-21', '2');
INSERT INTO `db_wpattern_mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('3', 'Arduino Leonardo', 'RJ367374538CN', 'Compra da DX', '2015-04-01', '1');

INSERT INTO `db_wpattern_mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `db_wpattern_mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '1');
INSERT INTO `db_wpattern_mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '2');

COMMIT;

