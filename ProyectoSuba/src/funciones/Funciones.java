package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
	
	public static boolean esBisiesto(int anio) {
		return new GregorianCalendar().isLeapYear(anio);
	}
	
	public static int traerAnio(GregorianCalendar fecha) {
		return fecha.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar fecha) {
		return fecha.get(Calendar.MONTH) + 1;
	}
	
	public static int traerDia(GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int traerHoras(GregorianCalendar fecha) {
		return fecha.get(Calendar.HOUR);
	}
	
	public static int traerMinutos(GregorianCalendar fecha) {
		return fecha.get(Calendar.MINUTE);
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia) {
		return !(anio < 1 || mes < 1 || mes > 12 || dia < 1 || dia > traerCantDiasDeUnMes(anio, mes));
	}
	
	public static boolean esFechaValida(int anio, int mes) {
		return !(anio < 1 || mes < 1 || mes > 12);
	}
	
	public static GregorianCalendar traerProximoMes(GregorianCalendar fecha) {
		return new GregorianCalendar(traerAnio(fecha), traerMes(fecha), traerDia(fecha));
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {
		return new GregorianCalendar(anio, mes - 1, dia);
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia, int hora, int minuto) {
		return new GregorianCalendar(anio, mes - 1, dia, hora, minuto, 0);
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia, int hora, int minuto, int segundo) {
		return new GregorianCalendar(anio, mes - 1, dia, hora, minuto, segundo);
	}
	
	public static GregorianCalendar traerFecha(String fecha) {		
		return new GregorianCalendar(Integer.parseInt(fecha.substring(6,10)), Integer.parseInt(fecha.substring(3,5)) - 1, Integer.parseInt(fecha.substring(0,2)));
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
	}
	
	public static String traerHora(GregorianCalendar fecha) {
		return fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND);
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		return traerFechaCorta(fecha) + " " + traerHora(fecha);
	}
	
	public static String traerFechaLargaHora(GregorianCalendar fecha) {
		return traerFechaLarga(fecha) + " " + traerHora(fecha);
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {
		GregorianCalendar fechaProximo = new GregorianCalendar(traerAnio(fecha), traerMes(fecha) - 1, traerDia(fecha));
		fechaProximo.add(Calendar.DAY_OF_MONTH, cantDias);
		return fechaProximo;
	}
	
	public static boolean esDiaHabil(GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_WEEK) != 1 && fecha.get(Calendar.DAY_OF_WEEK) != 7;
	}
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		String[] dia = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
		return dia[fecha.get(Calendar.DAY_OF_WEEK) - 1];
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String[] mes = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		return mes[traerMes(fecha) - 1];
	}
	
	public static String traerFechaLarga(GregorianCalendar fecha) {
		return traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " del " + traerAnio(fecha);
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		return traerAnio(fecha) == traerAnio(fecha1) && traerMes(fecha) == traerMes(fecha1) && traerDia(fecha) == traerDia(fecha1);
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		return sonFechasIguales(fecha, fecha1) && fecha.get(Calendar.HOUR) == fecha1.get(Calendar.HOUR) && fecha.get(Calendar.MINUTE) == fecha1.get(Calendar.MINUTE) && fecha.get(Calendar.SECOND) == fecha1.get(Calendar.SECOND);
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		return new GregorianCalendar(anio, mes, 0).get(Calendar.DAY_OF_MONTH);
	}
	
	public static double aproximar2Decimal(double valor) {
		return Math.rint(valor * 100) / 100;
	}
	
	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	
	public static boolean esCaracter(char c) {
		return Character.isLetter(c);
	}
	
	public static boolean esCadenaNros(String cadena) {
		boolean numero = true;
		int i = 0;
		
		while (numero && i < cadena.length()) {
			numero = esNumero(cadena.charAt(i));
			i++;
		}
		
		return numero;
	}
	
	public static boolean esCadenaLetras(String cadena) {
		boolean letra = true;
		int i = 0;
		
		while (letra && i < cadena.length()) {
			letra = esCaracter(cadena.charAt(i));
			i++;
		}
		
		return letra;
	}
	
	public static double convertirADouble(int n) {
		return (double) n;
	}
	
	public static int CharToInt(char c) {
		return Integer.valueOf(Character.toString(c));
	}
}