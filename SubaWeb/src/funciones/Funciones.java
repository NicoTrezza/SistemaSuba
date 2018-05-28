package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
	
	public static boolean esBisiesto(int anio) {
		boolean ret=false;
		
		if (anio>100 && anio%400==0) {
			ret=true;
		}
		else if (anio%4==0 && anio%100 != 0) {
			ret=true;
		}
		
		return ret;
	}
	
	public static int traerAnio (GregorianCalendar f){
		return f.get(Calendar.YEAR);
	}
	
	public static int traerMes (GregorianCalendar f){
		return f.get(Calendar.MONTH)+1;
	}
	
	public static int traerDia (GregorianCalendar f){
		return f.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esFechaValida (int anio,int mes,int dia) {
		boolean ret=true;
		
		if (mes > 12 || mes < 1) {
			ret=false;
		}
		
		switch (mes) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (dia > 31 || dia < 1) {
					ret=false;
				}
				break;
			case 4: case 6: case 9: case 11:
				if (dia > 30 || dia < 1) {
					ret=false;
				}
				break;
			case 2:
				if (esBisiesto(anio)==true) {
					if (dia > 29 || dia < 1) {
						ret=false;
					}
				}
				else {
					if (dia > 28 || dia < 1) {
						ret=false;
					}
				}
				break;
		}
		
		return ret;
	}
	
	public static GregorianCalendar traerFecha (int anio, int mes, int dia) {
		GregorianCalendar f = new GregorianCalendar();
		if (esFechaValida(anio,mes,dia)) {
			f.set(anio, mes, dia);
		}
		return f;
	}
	
	public static GregorianCalendar traerFecha (String fecha) {
		int anio,mes,dia;
		GregorianCalendar f = new GregorianCalendar();
		
		dia = Integer.parseInt(fecha.substring(0, 1));
		mes = Integer.parseInt(fecha.substring(3, 4));
		anio = Integer.parseInt(fecha.substring(6, 9));
		
		if (esFechaValida(anio,mes,dia)) {
			f.set(anio, mes, dia);
		}
		return f;
	}
	
	public static String traerFechaCorta (GregorianCalendar f){
		String fechaCorta=null;
		if (f!=null) {
			fechaCorta = traerDia(f) + "/";
			if (traerMes(f) < 9) 
				fechaCorta += "0" + traerMes(f) + "/" + traerAnio(f);
			else
				fechaCorta += traerMes(f) + "/" + traerAnio(f);
		}
		return fechaCorta;
	}
	
	public static String traerFechaCortaHora (GregorianCalendar f){
		String fechaCorta=null;
		if (f!=null) {
			fechaCorta = traerFechaCorta(f) + " " + f.get(Calendar.HOUR_OF_DAY) + ":";
			if (f.get(Calendar.MINUTE) <= 9) 
				fechaCorta += "0" + f.get(Calendar.MINUTE) + ":";
			else
				fechaCorta += f.get(Calendar.MINUTE) + ":";
			
			if (f.get(Calendar.SECOND) <= 9) 
				fechaCorta += "0" + f.get(Calendar.SECOND);
			else 
				fechaCorta += f.get(Calendar.SECOND);
		}
		return fechaCorta;
	}
	
	public static GregorianCalendar traerFechaProximo (GregorianCalendar fecha, int cantDias) {
		GregorianCalendar fProxima = new GregorianCalendar(traerAnio(fecha),traerMes(fecha)-1,traerDia(fecha));
		fProxima.add(Calendar.DAY_OF_MONTH, cantDias);
		return fProxima;
	}
	
	public static boolean esDiaHabil (GregorianCalendar fecha) {
		return (fecha.get(Calendar.DAY_OF_WEEK) >= 2 && fecha.get(Calendar.DAY_OF_WEEK) <= 6); 
	}
	
	public static String traerDiaDeLaSemana (GregorianCalendar fecha) {
		String dia = "Domingo";
		
		switch(fecha.get(Calendar.DAY_OF_WEEK)) {
			case 2:
				dia = "Lunes";
				break;
			case 3:
				dia = "Martes";
				break;
			case 4:
				dia = "Miercoles";
				break;
			case 5:
				dia = "Jueves";
				break;
			case 6:
				dia = "Viernes";
				break;
			case 7:
				dia = "Sabado";
				break;
		}
		return dia;
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String mes = "Enero";
		
		switch(traerMes(fecha)-1) {
			case 1:
				mes = "Febrero";
				break;
			case 2:
				mes = "Marzo";
				break;
			case 3:
				mes = "Abril";
				break;
			case 4:
				mes = "Mayo";
				break;
			case 5:
				mes = "Junio";
				break;
			case 6:
				mes = "Julio";
				break;
			case 7:
				mes = "Agosto";
				break;
			case 8:
				mes = "Septiembre";
				break;
			case 9:
				mes = "Octubre";
				break;
			case 10:
				mes = "Noviembre";
				break;
			case 11:
				mes = "Diciembre";
				break;
		}
		return mes;
	}
	
	public static String traerFechaLarga (GregorianCalendar fecha) {
		String fechaLarga;
		
		fechaLarga = traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " del " + traerAnio(fecha);
		
		return fechaLarga;
	}
	
	public static boolean sonFechasIguales (GregorianCalendar fecha, GregorianCalendar fecha1) {
		String strFecha1=traerFechaCorta(fecha);
		String strFecha2=traerFechaCorta(fecha1);
		return (strFecha1.compareTo(strFecha2)==0);
	}
	
	public static boolean sonFechasHorasIguales (GregorianCalendar fecha, GregorianCalendar fecha1) {
		String strFecha1=traerFechaCortaHora(fecha);
		String strFecha2=traerFechaCortaHora(fecha1);
		return (strFecha1.compareTo(strFecha2)==0);
	}
	
	public static int traerCantDiasDeUnMes (int anio, int mes) {
		GregorianCalendar fecha = new GregorianCalendar();
		int cantDias;
		
		fecha.set(anio, mes-1, 1);
		cantDias = fecha.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		return (cantDias);
	}
	
	public static double aproximar2Decimal (double valor) {
		double resultado;
		
		resultado = valor * 1000;
		
		if (resultado%10 >= 5) resultado++;
		
		return (resultado/1000);
	}
	
	public static boolean esNumero (char c) {
		char[] diccNumeros = {'1','2','3','4','5','6','7','8','9','0'};
		int i=0;
		boolean encontrado = false;
		
		while ((i<10) && (encontrado != true)) {
			if (c == diccNumeros[i]) encontrado=true;
			i++;
		}
		return encontrado;
	}
	
	public static boolean esLetra (char c) {
		char[] diccLetras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int i=0;
		boolean encontrado = false;
		
		while ((i<diccLetras.length) && (encontrado == false)) {
			if (c == diccLetras[i]) encontrado=true;
			i++;
		}
		return encontrado;
	}
	
	public static boolean esCadenaNros(String cadena) {
		int i;
		boolean esNumeros = true;
		
		for (i=0;i<cadena.length();i++) {
			if (esNumero(cadena.charAt(i)) == false) esNumeros = false;
		}
		return esNumeros;
	}
	
	public static boolean esCadenaLetras(String cadena) {
		int i;
		boolean esLetras = true;
		
		for (i=0;i<cadena.length();i++) {
			if (esLetra(cadena.charAt(i)) == false) esLetras = false;
		}
		return esLetras;
	}
}
