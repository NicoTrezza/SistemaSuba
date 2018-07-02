-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SUBAbd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SUBAbd` ;

-- -----------------------------------------------------
-- Schema SUBAbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SUBAbd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SUBAbd` ;

-- -----------------------------------------------------
-- Table `SUBAbd`.`TipoIdentificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`TipoIdentificacion` (
  `idTipoIdentificacion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoIdentificacion`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Permiso` (
  `idPermiso` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nivelPermisos` INT NOT NULL COMMENT '',
  `nombre` VARCHAR(15) NOT NULL COMMENT '',
  PRIMARY KEY (`idPermiso`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`TarifaSocial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`TarifaSocial` (
  `idTarifaSocial` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `porcentajeDescuento` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idTarifaSocial`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`BoletoEstudiantil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`BoletoEstudiantil` (
  `idBoletoEstudiantil` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nivelEducativo` VARCHAR(45) NOT NULL COMMENT '',
  `cantViajesGratis` INT NOT NULL COMMENT '',
  `limiteDiario` INT NOT NULL COMMENT '',
  `horaInicial` INT NOT NULL COMMENT '',
  `horaFinal` INT NOT NULL COMMENT '',
  `diaInicial` INT NOT NULL COMMENT '',
  `diaFinal` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idBoletoEstudiantil`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `apellido` VARCHAR(45) NOT NULL COMMENT '',
  `sexo` CHAR(1) NOT NULL COMMENT '',
  `nroIdentificacion` MEDIUMTEXT NOT NULL COMMENT '',
  `clave` MEDIUMTEXT NOT NULL COMMENT '',
  `email` VARCHAR(320) NULL COMMENT '',
  `movil` MEDIUMTEXT NULL COMMENT '',
  `fijo` MEDIUMTEXT NULL COMMENT '',
  `idTipoIdentificacion` INT NOT NULL COMMENT '',
  `idPermiso` INT NOT NULL COMMENT '',
  `idTarifaSocial` INT NULL COMMENT '',
  `idBoletoEstudiantil` INT NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '',
  INDEX `TipoDocumento_Cliente_idx` (`idTipoIdentificacion` ASC)  COMMENT '',
  INDEX `Cliente_Permiso_idx` (`idPermiso` ASC)  COMMENT '',
  INDEX `fk_Usuario_TarifaSocial1_idx` (`idTarifaSocial` ASC)  COMMENT '',
  INDEX `fk_Usuario_BoletoEstudiantil1_idx` (`idBoletoEstudiantil` ASC)  COMMENT '',
  CONSTRAINT `TipoDocumento_Cliente`
    FOREIGN KEY (`idTipoIdentificacion`)
    REFERENCES `SUBAbd`.`TipoIdentificacion` (`idTipoIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Cliente_Permiso`
    FOREIGN KEY (`idPermiso`)
    REFERENCES `SUBAbd`.`Permiso` (`idPermiso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_TarifaSocial1`
    FOREIGN KEY (`idTarifaSocial`)
    REFERENCES `SUBAbd`.`TarifaSocial` (`idTarifaSocial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_BoletoEstudiantil1`
    FOREIGN KEY (`idBoletoEstudiantil`)
    REFERENCES `SUBAbd`.`BoletoEstudiantil` (`idBoletoEstudiantil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Tarjeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Tarjeta` (
  `idTarjeta` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nroTarjeta` INT NOT NULL COMMENT '',
  `saldo` FLOAT NOT NULL COMMENT '',
  `activa` BIT(1) NOT NULL COMMENT '',
  `idUsuario` INT NULL COMMENT '',
  PRIMARY KEY (`idTarjeta`)  COMMENT '',
  INDEX `fk_Tarjeta_Cliente1_idx` (`idUsuario` ASC)  COMMENT '',
  CONSTRAINT `fk_Tarjeta_Cliente1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `SUBAbd`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Maquina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Maquina` (
  `idMaquina` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `tipo` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idMaquina`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Viaje` (
  `idViaje` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` FLOAT NOT NULL COMMENT 'este se calcula en java, ya que puede tener descuento, ser tren,subte, o colectivo, si es tren puede ser estacion de ingreso o egreso, si es egreso puede o no devolver un valor, si es carga debe devolver un valor a la sube.',
  `fechaHora` DATETIME NOT NULL COMMENT '',
  `idTarjeta` INT NOT NULL COMMENT '',
  `idMaquina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idViaje`)  COMMENT '',
  INDEX `fk_Movimiento_Tarjeta1_idx` (`idTarjeta` ASC)  COMMENT '',
  INDEX `fk_Viaje_Maquina1_idx` (`idMaquina` ASC)  COMMENT '',
  CONSTRAINT `fk_Movimiento_Tarjeta1`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `SUBAbd`.`Tarjeta` (`idTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viaje_Maquina1`
    FOREIGN KEY (`idMaquina`)
    REFERENCES `SUBAbd`.`Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Linea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Linea` (
  `idLinea` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `linea` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`idLinea`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Estacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Estacion` (
  `idEstacion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `idLinea` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idEstacion`)  COMMENT '',
  INDEX `fk_Estacion_Linea1_idx` (`idLinea` ASC)  COMMENT '',
  CONSTRAINT `fk_Estacion_Linea1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `SUBAbd`.`Linea` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`LineaColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`LineaColectivo` (
  `idLineaColectivo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `linea` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idLineaColectivo`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`Carga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`Carga` (
  `idCarga` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` FLOAT NOT NULL COMMENT '',
  `fechaHora` DATETIME NOT NULL COMMENT '',
  `idTarjeta` INT NOT NULL COMMENT '',
  `idMaquina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCarga`)  COMMENT '',
  INDEX `fk_Cargas_Tarjeta1_idx` (`idTarjeta` ASC)  COMMENT '',
  INDEX `fk_Carga_Maquina1_idx` (`idMaquina` ASC)  COMMENT '',
  CONSTRAINT `fk_Cargas_Tarjeta1`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `SUBAbd`.`Tarjeta` (`idTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carga_Maquina1`
    FOREIGN KEY (`idMaquina`)
    REFERENCES `SUBAbd`.`Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`UsuarioBoletoEstudiantil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`UsuarioBoletoEstudiantil` (
  `idUsuarioBoletoEstudiantil` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fechaVencimiento` DATE NULL COMMENT '',
  `idUsuario` INT NOT NULL COMMENT '',
  `idBoletoEstudiantil` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idUsuarioBoletoEstudiantil`)  COMMENT '',
  INDEX `fk_Usuario_has_BoletoEstudiantil_BoletoEstudiantil1_idx` (`idBoletoEstudiantil` ASC)  COMMENT '',
  INDEX `fk_Usuario_has_BoletoEstudiantil_Usuario1_idx` (`idUsuario` ASC)  COMMENT '',
  CONSTRAINT `fk_Usuario_has_BoletoEstudiantil_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `SUBAbd`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_BoletoEstudiantil_BoletoEstudiantil1`
    FOREIGN KEY (`idBoletoEstudiantil`)
    REFERENCES `SUBAbd`.`BoletoEstudiantil` (`idBoletoEstudiantil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`MaquinaTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`MaquinaTren` (
  `idMaquina` INT NOT NULL COMMENT '',
  `idEstacion` INT NOT NULL COMMENT '',
  INDEX `fk_MaquinaTren_Estacion1_idx` (`idEstacion` ASC)  COMMENT '',
  INDEX `fk_MaquinaTren_Maquina1_idx` (`idMaquina` ASC)  COMMENT '',
  PRIMARY KEY (`idMaquina`)  COMMENT '',
  CONSTRAINT `fk_MaquinaTren_Estacion1`
    FOREIGN KEY (`idEstacion`)
    REFERENCES `SUBAbd`.`Estacion` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MaquinaTren_Maquina1`
    FOREIGN KEY (`idMaquina`)
    REFERENCES `SUBAbd`.`Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`MaquinaColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`MaquinaColectivo` (
  `idMaquina` INT NOT NULL COMMENT '',
  `numInterno` INT NOT NULL COMMENT '',
  `idLineaColectivo` INT NOT NULL COMMENT '',
  INDEX `fk_MaquinaColectivo_Maquina1_idx` (`idMaquina` ASC)  COMMENT '',
  PRIMARY KEY (`idMaquina`)  COMMENT '',
  INDEX `fk_MaquinaColectivo_LineaColectivo1_idx` (`idLineaColectivo` ASC)  COMMENT '',
  CONSTRAINT `fk_MaquinaColectivo_Maquina1`
    FOREIGN KEY (`idMaquina`)
    REFERENCES `SUBAbd`.`Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MaquinaColectivo_LineaColectivo1`
    FOREIGN KEY (`idLineaColectivo`)
    REFERENCES `SUBAbd`.`LineaColectivo` (`idLineaColectivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`RedSube`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`RedSube` (
  `idRedSube` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `porcentajeDescuento` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idRedSube`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`TarifaTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`TarifaTren` (
  `idTarifaTren` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idTarifaTren`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`BoletoTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`BoletoTren` (
  `idBoletoTren` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `idTarifaTren` INT NOT NULL COMMENT '',
  `estacionIngreso` INT NOT NULL COMMENT '',
  `estacionEgreso` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idBoletoTren`)  COMMENT '',
  INDEX `fk_BoletoTren_Estacion1_idx` (`estacionIngreso` ASC)  COMMENT '',
  INDEX `fk_BoletoTren_Estacion2_idx` (`estacionEgreso` ASC)  COMMENT '',
  INDEX `fk_BoletoTren_TarifaTren1_idx` (`idTarifaTren` ASC)  COMMENT '',
  CONSTRAINT `fk_BoletoTren_Estacion1`
    FOREIGN KEY (`estacionIngreso`)
    REFERENCES `SUBAbd`.`Estacion` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BoletoTren_Estacion2`
    FOREIGN KEY (`estacionEgreso`)
    REFERENCES `SUBAbd`.`Estacion` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BoletoTren_TarifaTren1`
    FOREIGN KEY (`idTarifaTren`)
    REFERENCES `SUBAbd`.`TarifaTren` (`idTarifaTren`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SUBAbd`.`BoletoColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SUBAbd`.`BoletoColectivo` (
  `idBoletoColectivo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `seccion` INT NOT NULL COMMENT '',
  `valor` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idBoletoColectivo`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('1', '10');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('2', '10.50');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('3', '10.75');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('4', '11.25');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('5', '11.75');

INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('266');
INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('160');

INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('0');
INSERT INTO `subabd`.`maquinacolectivo` (`idMaquina`, `numInterno`, `idLineaColectivo`) VALUES ('1', '1', '1');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('0');
INSERT INTO `subabd`.`maquinacolectivo` (`idMaquina`, `numInterno`, `idLineaColectivo`) VALUES ('2', '1', '2');


INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('3.25');
INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('5');
INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('6.50');

INSERT INTO `subabd`.`linea` (`linea`) VALUES ('General Roca');
INSERT INTO `subabd`.`linea` (`linea`) VALUES ('Linea C');

INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Plaza Constitucion', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Hipolito Yrigoyen', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Avellaneda', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Gerli', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Lanus', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Remedios de Escalada', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Banfield', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Lomas de Zamora', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Temperley', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Adrogue', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Burzaco', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Longchamps', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Glew', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Guernica', '1');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Alejandro Korn', '1');

INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Constitucion', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('San Juan', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Independencia', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Moreno', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Avenida de Mayo', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Diagonal Norte', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Lavalle', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('San Martin', '2');
INSERT INTO `subabd`.`estacion` (`nombre`, `idLinea`) VALUES ('Retiro', '2');

INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('3', '1');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('4', '2');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('5', '3');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('6', '4');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('7', '5');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('8', '6');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('9', '7');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('10', '8');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('11', '9');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('12', '10');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('13', '11');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('14', '12');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('15', '13');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('16', '14');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('17', '15');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('18','16');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('19','17');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('20','18');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('21','19');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('22','20');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('23','21');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('24','22');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('25','23');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idMaquina`, `idEstacion`) VALUES ('26','24');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '1', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '1', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '1', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '1', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '1', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '1', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '1', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '1', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '1', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '2', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '2', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '2', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '2', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '2', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '2', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '2', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '2', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '3', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '3', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '3', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '3', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '3', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '3', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '3', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '3', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '4', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '4', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '4', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '4', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '4', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '4', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '4', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '5', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '5', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '5', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '5', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '5', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '5', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '6', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '6', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '6', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '6', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '6', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '7', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '7', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '7', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '7', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '7', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '7', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '8', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '8', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '8', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '8', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '8', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '9', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '9', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '9', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '9', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '9', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '9', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '10', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '10', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '11', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '11', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '12', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '12', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '13', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '13', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '14');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '13', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '14', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '14', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '14', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '14', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '14', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '14', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '14', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '14', '15');

INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '15', '1');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '15', '2');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '15', '3');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '15', '4');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('3', '15', '5');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '6');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '7');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '8');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '9');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '10');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '11');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('2', '15', '12');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '15', '13');
INSERT INTO `subabd`.`boletotren` (`idTarifaTren`, `estacionIngreso`, `estacionEgreso`) VALUES ('1', '15', '14');

INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('549');
INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('561');
INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('71');

INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('0');
INSERT INTO `subabd`.`maquinacolectivo` (`idMaquina`, `numInterno`, `idLineaColectivo`) VALUES ('27', '1', '3');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('0');
INSERT INTO `subabd`.`maquinacolectivo` (`idMaquina`, `numInterno`, `idLineaColectivo`) VALUES ('28', '1', '4');
INSERT INTO `subabd`.`maquina` (`tipo`) VALUES ('0');
INSERT INTO `subabd`.`maquinacolectivo` (`idMaquina`, `numInterno`, `idLineaColectivo`) VALUES ('29', '1', '5');

INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Inicial', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Primario', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Secundario', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Terciario', '45', '0', '0', '0', '2', '7');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Universitario', '45', '0', '0', '0', '2', '7');

INSERT INTO `subabd`.`redsube` (`porcentajeDescuento`) VALUES ('0.5');
INSERT INTO `subabd`.`redsube` (`porcentajeDescuento`) VALUES ('0.25');

INSERT INTO `subabd`.`tarifasocial` (`porcentajeDescuento`) VALUES ('0.45');

INSERT INTO `subabd`.`permiso` (`nivelPermisos`, `nombre`) VALUES ('0', 'Administrador');
INSERT INTO `subabd`.`permiso` (`nivelPermisos`, `nombre`) VALUES ('1', 'Cliente');

INSERT INTO `subabd`.`tipoidentificacion` (`nombre`) VALUES ('Documento Nacional de Identidad');

INSERT INTO `subabd`.`usuario` (`nombre`, `apellido`, `sexo`, `nroIdentificacion`, `clave`, `email`, `movil`, `fijo`, `idTipoIdentificacion`, `idPermiso`, `idTarifaSocial`, `idBoletoEstudiantil`) VALUES ('Juan', 'Perez', 'M', '33444555', '4555', 'a@a.com', '1166882233', '44446666', '1', '1', '1', '1');
INSERT INTO `subabd`.`usuario` (`nombre`, `apellido`, `sexo`, `nroIdentificacion`, `clave`, `email`, `movil`, `fijo`, `idTipoIdentificacion`, `idPermiso`) VALUES ('Isco', 'Alarcon', 'M', '35000000', '1234', 'isco@gmail', '1122334455', '42314231', '1', '2');

INSERT INTO `subabd`.`tarjeta` (`nroTarjeta`, `saldo`, `activa`, `idUsuario`) VALUES ('1300', '0', 0, '1');
INSERT INTO `subabd`.`tarjeta` (`nroTarjeta`, `saldo`, `activa`, `idUsuario`) VALUES ('8888', '0', 0, '2');

INSERT INTO `subabd`.`usuarioboletoestudiantil` (`fechaVencimiento`, `idUsuario`, `idBoletoEstudiantil`) VALUES ('2018-06-21', '1', '1');