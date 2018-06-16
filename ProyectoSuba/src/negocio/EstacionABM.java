package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.EstacionDao;
import datos.Estacion;
import datos.Linea;
import datos.Maquina;
import datos.MaquinaTren;

public class EstacionABM {
	private static EstacionABM instancia;
	protected EstacionDao dao;

	protected EstacionABM() {
		dao = new EstacionDao();
	}
	
	public static EstacionABM getInstancia() {
		if (instancia == null)
			instancia = new EstacionABM();
		return instancia;
	}
	
	public Estacion traerEstacion(int idEstacion) throws Exception {
		Estacion estacion = dao.traer(idEstacion);
		if (estacion==null) throw new Exception("La estacion no existe");
		return estacion;
	}
	
	public Estacion traerEstacion(String nombre) throws Exception {
		Estacion estacion = dao.traer(nombre);
		if (estacion==null) throw new Exception("La estacion no existe");
		return estacion;
	}
	
	public Estacion traerEstacionPorMaquina(Maquina maquina) throws Exception {
		Estacion estacion = null;
		MaquinaTren mt;
		
		if (maquina.getTipo() != 0){
			mt = (MaquinaTren) maquina;
			estacion = dao.traer(mt.getEstacion().getIdEstacion());
		}
			
		if (estacion==null) throw new Exception("La estacion no existe");
		return estacion;
	}
	
	public List<Estacion> traerEstaciones() {
		return dao.traer();
	}
	
	public List<Estacion> traerEstacionesTren() throws Exception {
		List<Estacion> estaciones = new ArrayList<Estacion>();
		
		for (Estacion e : dao.traer()) {
			if (MaquinaABM.getInstancia().traerMaquinaPorEstacion(e).getTipo() == 1)
				estaciones.add(e);
		}
		
		return estaciones;
	}
	
	public List<Estacion> traerEstacionesSubte() throws Exception {
		List<Estacion> estaciones = new ArrayList<Estacion>();
		
		for (Estacion e : dao.traer()) {
			if (MaquinaABM.getInstancia().traerMaquinaPorEstacion(e).getTipo() == 2)
				estaciones.add(e);
		}
		
		return estaciones;
	}
	
	public int agregar(String nombre, Linea linea) throws Exception {
		Estacion estacion = new Estacion(nombre,linea);
		if (dao.traer(estacion.getNombre())!=null) throw new Exception("Estacion duplicada");
		return dao.agregar(estacion);
	}
	
	public void modificar(Estacion estacion) throws Exception {
		if (dao.traer(estacion.getNombre())!=null) throw new Exception("Estacion duplicada");
		dao.actualizar(estacion);
	}
	
	public void eliminar(int idEstacion) throws Exception {
		Estacion estacion = dao.traer(idEstacion);
		if (estacion==null) throw new Exception("La estacion no existe");
		dao.eliminar(estacion);
	}
}
