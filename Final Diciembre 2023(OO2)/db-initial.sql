SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema bdfinalcallcenter
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `bdfinalcallcenter` ;
CREATE SCHEMA IF NOT EXISTS `bdfinalcallcenter` ;

-- ----------------------------------------------------------------------------
-- Table bdfinalcallcenter.cliente
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfinalcallcenter`.`cliente` (
  `idpersona` INT(11) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idpersona`),
  CONSTRAINT `fk_cliente_1`
    FOREIGN KEY (`idpersona`)
    REFERENCES `bdfinalcallcenter`.`persona` (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table bdfinalcallcenter.empleado
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfinalcallcenter`.`empleado` (
  `idpersona` INT(11) NOT NULL,
  `sueldobase` INT(11) NOT NULL,
  PRIMARY KEY (`idpersona`),
  CONSTRAINT `fk_emplado_1`
    FOREIGN KEY (`idpersona`)
    REFERENCES `bdfinalcallcenter`.`persona` (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table bdfinalcallcenter.llamada
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfinalcallcenter`.`llamada` (
  `idllamada` INT(11) NOT NULL AUTO_INCREMENT,
  `idcliente` INT(11) NOT NULL,
  `idempleado` INT(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `nivelDeSatisfaccion` INT(11) NOT NULL,
  PRIMARY KEY (`idllamada`),
  INDEX `fk_llamada_1_idx` (`idcliente` ASC),
  INDEX `fk_llamada_2_idx` (`idempleado` ASC),
  CONSTRAINT `fk_llamada_1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `bdfinalcallcenter`.`cliente` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_llamada_2`
    FOREIGN KEY (`idempleado`)
    REFERENCES `bdfinalcallcenter`.`empleado` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table bdfinalcallcenter.persona
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfinalcallcenter`.`persona` (
  `idpersona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `dni` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `bdfinalcallcenter`.`persona` (`nombre`, `apellido`, `dni`) VALUES ("Cliente 1", "Ape 1", 11111111);
INSERT INTO `bdfinalcallcenter`.`persona` (`nombre`, `apellido`, `dni`) VALUES ("Cliente 2", "Ape 2", 22222222);
INSERT INTO `bdfinalcallcenter`.`cliente` (`idpersona`, `activo`) VALUES (1, TRUE);
INSERT INTO `bdfinalcallcenter`.`cliente` (`idpersona`, `activo`) VALUES (2, TRUE);

USE `bdfinalcallcenter`;
select*from cliente;
select*from empleado;
select*from persona;
select*from llamada;