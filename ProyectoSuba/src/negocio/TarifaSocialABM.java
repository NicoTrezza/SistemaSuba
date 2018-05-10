package negocio;

import dao.TarifaSocialDao;
import datos.TarifaSocial;

public class TarifaSocialABM {
	TarifaSocialDao dao = new TarifaSocialDao();

	public TarifaSocial traerTarifaSocial(int idTarifaSocial) throws Exception {
		TarifaSocial tarifaSocial = dao.traer(idTarifaSocial);
		if (tarifaSocial==null) throw new Exception("La tarifa social seleccionada no existe");
		return tarifaSocial;
	}
	
	public int agregar(TarifaSocial tarifaSocial) {
		return dao.agregar(tarifaSocial);
	}
	
	public void modificar(TarifaSocial tarifaSocial) {
		dao.actualizar(tarifaSocial);
	}
	
	public void eliminar(int idTarifaSocial) throws Exception {
		TarifaSocial tarifaSocial = dao.traer(idTarifaSocial);
		if (tarifaSocial==null) throw new Exception("La tarifa social seleccionada no existe");
		dao.eliminar(tarifaSocial);
	}
}
