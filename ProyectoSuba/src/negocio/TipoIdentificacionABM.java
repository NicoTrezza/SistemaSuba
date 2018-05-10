package negocio;

import dao.TipoIdentificacionDao;
import datos.TipoIdentificacion;

public class TipoIdentificacionABM {
	TipoIdentificacionDao dao = new TipoIdentificacionDao();

	public TipoIdentificacion traerTipoIdentificacion(int idTipoIdentificacion) throws Exception {
		TipoIdentificacion tipoIdentificacion = dao.traer(idTipoIdentificacion);
		if (tipoIdentificacion==null) throw new Exception("El tipo de identificación no existe.");
		return tipoIdentificacion;
	}
	
	public int agregar(TipoIdentificacion tipoIdentificacion) {
		return dao.agregar(tipoIdentificacion);
	}
	
	public void modificar(TipoIdentificacion tipoIdentificacion) {
		dao.actualizar(tipoIdentificacion);
	}
	
	public void eliminar(int idTipoIdentificacion) throws Exception {
		TipoIdentificacion tipoIdentificacion = dao.traer(idTipoIdentificacion);
		if (tipoIdentificacion==null) throw new Exception("El tipo de identificación no existe.");
		dao.eliminar(tipoIdentificacion);
	}
}
