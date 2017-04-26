-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ebank
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ebank` ;

-- -----------------------------------------------------
-- Schema ebank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ebank` DEFAULT CHARACTER SET utf8 ;
USE `ebank` ;

-- -----------------------------------------------------
-- Table `ebank`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ebank`.`Customer` ;

CREATE TABLE IF NOT EXISTS `ebank`.`Customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `dob` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `contactNo` VARCHAR(13) NULL,
  `email` VARCHAR(45) NULL,
  `accountType` INT NULL,
  `accountNo` VARCHAR(45) NULL,
  `sortCode` VARCHAR(45) NULL,
  `balance` DECIMAL(8,2) NULL,
  `cardNo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cardNo_UNIQUE` ON `ebank`.`Customer` (`cardNo` ASC);

CREATE UNIQUE INDEX `accountNo_UNIQUE` ON `ebank`.`Customer` (`accountNo` ASC);


-- -----------------------------------------------------
-- Table `ebank`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ebank`.`Employee` ;

CREATE TABLE IF NOT EXISTS `ebank`.`Employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `name` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `userName_UNIQUE` ON `ebank`.`Employee` (`userName` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
