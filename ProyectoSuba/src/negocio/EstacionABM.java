package negocio;

import dao.EstacionDao;
import datos.Estacion;

public class EstacionABM {
	EstacionDao dao = new EstacionDao();

	public Estacion traerEstacion(int idEstacion) throws Exception {
		Estacion estacion = dao.traer(idEstacion);
		if (estacion==null) throw new Exception("La estacion no existe");
		return estacion;
	}
	
	public int agregar(Estacion estacion) throws Exception {
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
