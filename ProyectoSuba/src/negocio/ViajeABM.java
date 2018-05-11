package negocio;

import dao.ViajeDao;
import datos.Viaje;

public class ViajeABM {
	ViajeDao dao = new ViajeDao();

	public Viaje traerCarga(int idViaje) throws Exception {
		Viaje viaje = dao.traer(idViaje);
		if (viaje==null) throw new Exception("Movimiento de viaje no existente");
		return viaje;
	}
	
	public int agregar(Viaje viaje) {
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
