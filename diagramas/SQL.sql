INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('1', '10');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('2', '10.50');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('3', '10.75');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('4', '11.25');
INSERT INTO `subabd`.`boletocolectivo` (`seccion`, `valor`) VALUES ('5', '11.75');

INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('266');
INSERT INTO `subabd`.`lineacolectivo` (`linea`) VALUES ('160');

INSERT INTO `subabd`.`maquinacolectivo` (`numInterno`, `idLineaColectivo`) VALUES ('1', '1');
INSERT INTO `subabd`.`maquinacolectivo` (`numInterno`, `idLineaColectivo`) VALUES ('1', '2');

INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('3.25');
INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('5');
INSERT INTO `subabd`.`tarifatren` (`valor`) VALUES ('6.50');

INSERT INTO `subabd`.`linea` (`linea`) VALUES ('General Roca');

INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Plaza Constitucion');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Hipolito Yrigoyen');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Avellaneda');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Gerli');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Lanus');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Remedios de Escalada');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Banfield');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Lomas de Zamora');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Temperley');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Adrogue');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Burzaco');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Longchamps');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Glew');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Guernica');
INSERT INTO `subabd`.`estacion` (`nombre`) VALUES ('Alejandro Korn');

INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('1');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('2');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('3');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('4');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('5');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('6');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('7');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('8');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('9');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('10');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('11');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('12');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('13');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('14');
INSERT INTO `subabd`.`maquinatren` (`idEstacion`) VALUES ('15');

INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Inicial', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Primario', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Secundario', '50', '4', '500', '2300', '2', '6');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Terciario', '45', '0', '0', '0', '2', '7');
INSERT INTO `subabd`.`boletoestudiantil` (`nivelEducativo`, `cantViajesGratis`, `limiteDiario`, `horaInicial`, `horaFinal`, `diaInicial`, `diaFinal`) VALUES ('Universitario', '45', '0', '0', '0', '2', '7');

INSERT INTO `subabd`.`redsube` (`porcentajeDescuento`) VALUES ('0.5');
INSERT INTO `subabd`.`redsube` (`porcentajeDescuento`) VALUES ('0.25');

INSERT INTO `subabd`.`tarifasocial` (`porcentajeDescuento`) VALUES ('0.45');

INSERT INTO `subabd`.`permiso` (`nivelPermisos`, `nombre`) VALUES ('0', 'Administrador');

INSERT INTO `subabd`.`tipoidentificacion` (`nombre`) VALUES ('Documento Nacional de Identidad');