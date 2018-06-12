package negocio;

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
	
	public int traerViajesEnTren(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajesEnTren()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesEnColectivo(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajesEnColectivo()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesEnSubte(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajesEnSubte()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta())
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelLunes(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Lunes")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelMartes(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Martes")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelMiercoles(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Miercoles")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelJueves(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Jueves")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelViernes(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Viernes")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelSabado(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Sabado")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
	public int traerViajesDelDomingo(Tarjeta t) {
		int viajes = 0;
		
		try {
			for (Viaje v : ViajeABM.getInstancia().traerViajes()) {
				if (v.getTarjeta().getIdTarjeta() == t.getIdTarjeta() && Funciones.traerDiaDeLaSemana(v.getFechaHora()) == "Domingo")
					viajes++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return viajes;
	}
	
}
