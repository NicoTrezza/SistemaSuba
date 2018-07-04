package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import datos.Tarjeta;
import datos.Viaje;
import funciones.Funciones;

public class EstadisticaABM {

	private static EstadisticaABM instancia;
	
	protected EstadisticaABM() {
		
	}
	
	public static EstadisticaABM getInstancia() {
		if (instancia == null)
			instancia = new EstadisticaABM();
		return instancia;
	}
	
	public float traerMontoEnTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		float monto = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnTren(fechaInicio, fechaFin)) {
			monto += v.getValor();
		}
		
		return monto;
	}
	
	public float traerMontoEnColectivo(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		float monto = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnColectivo(fechaInicio, fechaFin)) {
			monto += v.getValor();
		}
		
		return monto;
	}
	
	public float traerMontoEnSubte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		float monto = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnSubte(fechaInicio, fechaFin)) {
			monto += v.getValor();
		}
		
		return monto;
	}
	
	public int traerViajesEnTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		return ViajeABM.getInstancia().traerViajesEnTren(fechaInicio, fechaFin).size();
	}
	
	public int traerViajesEnColectivo(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		return ViajeABM.getInstancia().traerViajesEnColectivo(fechaInicio, fechaFin).size();
	}
	
	public int traerViajesEnSubte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		return ViajeABM.getInstancia().traerViajesEnSubte(fechaInicio, fechaFin).size();
	}
	
	public List<Viaje> traerViajesEnTren(Tarjeta t, GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnTren(fechaInicio, fechaFin)) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes.add(v);
		}
		
		return viajes;
	}
	
	public int traerViajesEnTren(Tarjeta t) throws Exception {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnTren()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes++;
		}
		
		return viajes / 2;
	}
	
	public List<Viaje> traerViajesEnColectivo(Tarjeta t, GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnColectivo(fechaInicio, fechaFin)) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes.add(v);
		}
		
		return viajes;
	}
	
	public int traerViajesEnColectivo(Tarjeta t) throws Exception {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnColectivo()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes++;
		}
		
		return viajes;
	}
	
	public List<Viaje> traerViajesEnSubte(Tarjeta t, GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnSubte(fechaInicio, fechaFin)) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes.add(v);
		}
		
		return viajes;
	}
	
	public int traerViajesEnSubte(Tarjeta t) throws Exception {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajesEnSubte()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelLunes(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Lunes")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelMartes(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Martes")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelMiercoles(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Miercoles")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelJueves(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Jueves")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelViernes(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Viernes")
				viajes++;
		}
			
		return viajes;
	}
	
	public int traerViajesDelSabado(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Sabado")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesDelDomingo(Tarjeta t) {
		int viajes = 0;
		
		for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
			if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Domingo")
				viajes++;
		}
		
		return viajes;
	}
	
	public int traerViajesEnSemana(Tarjeta t) {
		return traerViajesDelLunes(t) + traerViajesDelMartes(t) + traerViajesDelMiercoles(t) + traerViajesDelJueves(t) + traerViajesDelViernes(t);
	}
	
	public int traerViajesEnFinDeSemana(Tarjeta t) {
		return traerViajesDelSabado(t) + traerViajesDelDomingo(t);
	}
}
