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

INSERT INTO `subabd`.`tarjeta` (`nroTarjeta`, `saldo`, `activa`, `idUsuario`) VALUES ('130', '200', 1, '1');

INSERT INTO `subabd`.`usuarioboletoestudiantil` (`fechaVencimiento`, `idUsuario`, `idBoletoEstudiantil`) VALUES ('2018-06-21', '1', '1');