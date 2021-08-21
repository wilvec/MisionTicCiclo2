-- MySQL Script generated by MySQL Workbench
-- Fri Aug 20 20:20:15 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema libreria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema libreria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `libreria` DEFAULT CHARACTER SET utf8 ;
USE `libreria` ;

-- -----------------------------------------------------
-- Table `libreria`.`EDITORIAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`EDITORIAL` (
  `edi_nombre` VARCHAR(300) NOT NULL,
  `edi_telefono` VARCHAR(45) NOT NULL,
  `edi_ciudad` VARCHAR(200) NOT NULL,
  `edi_pais` VARCHAR(200) NOT NULL DEFAULT 'Colombia',
  PRIMARY KEY (`edi_nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria`.`LIBRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`LIBRO` (
  `lib_ISBN` VARCHAR(20) NOT NULL,
  `lib_titulo` VARCHAR(245) NOT NULL,
  `lib_numero_paginas` INT NOT NULL,
  `lib_anio` INT(4) NOT NULL,
  `EDITORIAL_edi_nombre` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`lib_ISBN`),
  INDEX `fk_LIBRO_EDITORIAL_idx` (`EDITORIAL_edi_nombre` ASC) VISIBLE,
  CONSTRAINT `fk_LIBRO_EDITORIAL`
    FOREIGN KEY (`EDITORIAL_edi_nombre`)
    REFERENCES `libreria`.`EDITORIAL` (`edi_nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria`.`AUTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`AUTOR` (
  `aut_codigo` INT NOT NULL,
  `aut_nombre` VARCHAR(145) NOT NULL,
  `aut_apellido` VARCHAR(145) NOT NULL,
  `aut_nacionalidad` VARCHAR(145) NOT NULL,
  `aut_fecha_nto` DATE NOT NULL COMMENT 'Corresponde a la fecha de nacimiento del autor',
  PRIMARY KEY (`aut_codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`CLIENTE` (
  `cli_id` INT NOT NULL,
  `cli_nombre` VARCHAR(145) NOT NULL,
  `cli_ciudad` VARCHAR(145) NOT NULL,
  `clic_telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cli_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria`.`AUTORIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`AUTORIA` (
  `AUTOR_aut_codigo` INT NOT NULL,
  `LIBRO_lib_ISBN` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AUTOR_aut_codigo`, `LIBRO_lib_ISBN`),
  INDEX `fk_AUTOR_has_LIBRO_LIBRO1_idx` (`LIBRO_lib_ISBN` ASC) VISIBLE,
  INDEX `fk_AUTOR_has_LIBRO_AUTOR1_idx` (`AUTOR_aut_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_AUTOR_has_LIBRO_AUTOR1`
    FOREIGN KEY (`AUTOR_aut_codigo`)
    REFERENCES `libreria`.`AUTOR` (`aut_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTOR_has_LIBRO_LIBRO1`
    FOREIGN KEY (`LIBRO_lib_ISBN`)
    REFERENCES `libreria`.`LIBRO` (`lib_ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria`.`VENTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria`.`VENTA` (
  `LIBRO_lib_ISBN` VARCHAR(20) NOT NULL,
  `CLIENTE_cli_id` INT NOT NULL,
  `fecha_venta` DATE NULL,
  PRIMARY KEY (`LIBRO_lib_ISBN`, `CLIENTE_cli_id`),
  INDEX `fk_LIBRO_has_CLIENTE_CLIENTE1_idx` (`CLIENTE_cli_id` ASC) VISIBLE,
  INDEX `fk_LIBRO_has_CLIENTE_LIBRO1_idx` (`LIBRO_lib_ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_LIBRO_has_CLIENTE_LIBRO1`
    FOREIGN KEY (`LIBRO_lib_ISBN`)
    REFERENCES `libreria`.`LIBRO` (`lib_ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIBRO_has_CLIENTE_CLIENTE1`
    FOREIGN KEY (`CLIENTE_cli_id`)
    REFERENCES `libreria`.`CLIENTE` (`cli_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
