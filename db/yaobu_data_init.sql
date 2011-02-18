SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `yaobu` ;
CREATE SCHEMA IF NOT EXISTS `yaobu` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `yaobu` ;

-- -----------------------------------------------------
-- Table `yaobu`.`tbl_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yaobu`.`tbl_users` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `yaobu`.`tbl_users` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `account` VARCHAR(45) NULL DEFAULT '' ,
  `passwd` VARCHAR(45) NULL DEFAULT '' ,
  `user_name` VARCHAR(45) NULL DEFAULT '' ,
  `isenabled` INT NULL DEFAULT 1 ,
  `reg_time` DATETIME NULL ,
  `del_time` DATETIME NULL ,
  `released` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`user_id`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `account_UNIQUE` ON `yaobu`.`tbl_users` (`account` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `yaobu`.`tbl_login_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yaobu`.`tbl_login_log` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `yaobu`.`tbl_login_log` (
  `log_id` INT NOT NULL AUTO_INCREMENT ,
  `login_user_id` INT NULL ,
  `login_time` DATETIME NULL ,
  `login_ip` VARCHAR(45) NULL DEFAULT '000.000.000.000' ,
  `released` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`log_id`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `yaobu`.`tbl_site`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yaobu`.`tbl_site` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `yaobu`.`tbl_site` (
  `site_id` INT NOT NULL AUTO_INCREMENT ,
  `site_name` VARCHAR(200) NULL DEFAULT '' ,
  `site_addr` VARCHAR(200) NULL DEFAULT '' ,
  `site_adduser` INT NULL ,
  `site_desc` TEXT NULL ,
  `site_img` VARCHAR(500) NULL DEFAULT '' ,
  `site_logo` VARCHAR(500) NULL DEFAULT '' ,
  `site_addtime` DATETIME NULL ,
  `site_updtime` DATETIME NULL ,
  `site_eval` INT NULL DEFAULT 0 ,
  `released` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`site_id`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `yaobu`.`tbl_invite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yaobu`.`tbl_invite` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `yaobu`.`tbl_invite` (
  `invite_id` INT NOT NULL AUTO_INCREMENT ,
  `invite_site` INT NULL DEFAULT 0 ,
  `invite_user` INT NULL DEFAULT 0 ,
  `invite_content` TEXT NULL ,
  `invite_eval` INT NULL DEFAULT 0 ,
  `invite_allcount` INT NULL DEFAULT 0 ,
  `invite_remain` INT NULL DEFAULT 0 ,
  `invite_addtime` DATETIME NULL ,
  `invite_updtime` DATETIME NULL ,
  `released` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`invite_id`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `yaobu`.`tbl_eval`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yaobu`.`tbl_eval` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `yaobu`.`tbl_eval` (
  `eval_id` INT NOT NULL AUTO_INCREMENT ,
  `eval_fkid` INT NULL ,
  `eval_user` INT NULL ,
  `eval_content` TEXT NULL ,
  `eval_eval` INT NULL DEFAULT 0 ,
  `eval_issite` INT NULL DEFAULT 0 ,
  `eval_addtime` DATETIME NULL ,
  `eval_updtime` DATETIME NULL ,
  `eval_upduser` INT NULL ,
  `released` INT NULL DEFAULT 0 ,
  PRIMARY KEY (`eval_id`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
