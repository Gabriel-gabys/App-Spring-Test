-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 ;
USE `test` ;

-- -----------------------------------------------------
-- Table `test`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`login` (
  `usuario` VARCHAR(250) NOT NULL COMMENT '',
  `password` VARCHAR(250) NOT NULL COMMENT '',
  PRIMARY KEY (`usuario`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`clientes` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(100) NOT NULL COMMENT '',
  `app` VARCHAR(50) NOT NULL COMMENT '',
  `apm` VARCHAR(50) NOT NULL COMMENT '',
  `fecha_nacimiento` DATE NOT NULL COMMENT '',
  `sexo` CHAR(1) NULL DEFAULT NULL COMMENT '',
  `usuario` VARCHAR(250) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `usuario` (`usuario` ASC)  COMMENT '',
  CONSTRAINT `clientes_ibfk_1`
    FOREIGN KEY (`usuario`)
    REFERENCES `test`.`login` (`usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test`.`contactos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`contactos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `mail` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `telefono` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
