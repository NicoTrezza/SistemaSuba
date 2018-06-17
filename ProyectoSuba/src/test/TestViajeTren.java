package test;

import datos.Estacion;
import datos.Linea;
import datos.MaquinaTren;
import datos.Tarjeta;

public class TestViajeTren {

	public static void main(String[] args) {
		Linea linea = new Linea("Grl Roca");
		Estacion estacionI = new Estacion("Temperley", linea);
		Estacion estacionE = new Estacion("Remedios de Escalada", linea);
		//MaquinaTren maquinaI = new MaquinaTren(estacionI);
		//MaquinaTren maquinaE = new MaquinaTren(estacionE);
		
		//Tarjeta tarjeta = new Tarjeta(123456);
		
		//maquinaI.cargar(tarjeta, 100);
		
		try {
			//maquinaI.cobroMolinete(tarjeta);
			//maquinaE.devolucionMolinete(tarjeta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		//System.out.println(tarjeta.getSaldo());
		//System.out.println(tarjeta.getBoleto());
	}
}
