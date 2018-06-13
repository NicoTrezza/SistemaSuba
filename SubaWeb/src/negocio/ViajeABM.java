package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ViajeDao;
import datos.Maquina;
import datos.Tarjeta;
import datos.Viaje;

public class ViajeABM {
	private static ViajeABM instancia;
	protected ViajeDao dao;

	protected ViajeABM() {
		dao = new ViajeDao();
	}
	
	public static ViajeABM getInstancia() {
		if (instancia == null)
			instancia = new ViajeABM();
		return instancia;
	}
	
	public Viaje traerViaje(int idViaje) throws Exception {
		Viaje viaje = dao.traer(idViaje);
		if (viaje==null) throw new Exception("Movimiento de viaje no existente");
		return viaje;
	}
	
	public List<Viaje> traerViajes() {
		return dao.traer();
	}
	
	public List<Viaje> traerViajesEnTren() throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje viaje : dao.traer()) {
			if (MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 1)
				viajes.add(viaje);
		}
		
		return viajes;
	}
	
	public List<Viaje> traerViajesEnTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje viaje : dao.traer()) {
			if (!fechaInicio.after(viaje.getFechaHora()) && !fechaFin.before(viaje.getFechaHora()) && MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 1)
				viajes.add(viaje);
		}
		
		return viajes;
	}
	
	public List<Viaje> traerViajesEnSubte() throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
	
		for (Viaje viaje : dao.traer()) {
			if (MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 2)
				viajes.add(viaje);
		}
		
		return viajes;
	}
	
	public List<Viaje> traerViajesEnSubte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje viaje : dao.traer()) {
			if (!fechaInicio.after(viaje.getFechaHora()) && !fechaFin.before(viaje.getFechaHora()) && MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 2)
				viajes.add(viaje);
		}
		
		return viajes;
	}
	
	public List<Viaje> traerViajesEnColectivo() throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje viaje : dao.traer()) {
			if (MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 0)
				viajes.add(viaje);
		}
	
		return viajes;
	}
	
	public List<Viaje> traerViajesEnColectivo(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		List<Viaje> viajes = new ArrayList<Viaje>();
		
		for (Viaje viaje : dao.traer()) {
			if (!fechaInicio.after(viaje.getFechaHora()) && !fechaFin.before(viaje.getFechaHora()) && MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina()).getTipo() == 0)
				viajes.add(viaje);
		}
		
		return viajes;
	}
		
	public int agregar(GregorianCalendar fechaHora, float valor, Tarjeta tarjeta, Maquina maquina) {
		Viaje viaje = new Viaje(fechaHora,valor,tarjeta,maquina);
		return dao.agregar(viaje);
	}
	
	public void modificar(Viaje viaje) {
		dao.actualizar(viaje);
	}
	
	public void eliminar(int idViaje) throws Exception {
		Viaje viaje = dao.traer(idViaje);
		if (viaje==null) throw new Exception("Movimiento de viaje no existente");
		dao.eliminar(viaje);
	}
}
