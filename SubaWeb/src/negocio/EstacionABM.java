package negocio;

import java.util.List;

import dao.EstacionDao;
import datos.Estacion;
import datos.Linea;

public class EstacionABM {
	EstacionDao dao = new EstacionDao();

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
	
	public List<Estacion> traerEstaciones() {
		return dao.traer();
	}
	
	public int agregar(String nombre, Linea linea) throws Exception {
		Estacion estacion = new Estacion(nombre,linea);
		if (dao.traer(estacion.getNombre())!=null) throw new Exception("Estación duplicada");
		return dao.agregar(estacion);
	}
	
	public void modificar(Estacion estacion) throws Exception {
		if (dao.traer(estacion.getNombre())!=null) throw new Exception("Estación duplicada");
		dao.actualizar(estacion);
	}
	
	public void eliminar(int idEstacion) throws Exception {
		Estacion estacion = dao.traer(idEstacion);
		if (estacion==null) throw new Exception("La estacion no existe");
		dao.eliminar(estacion);
	}
}
