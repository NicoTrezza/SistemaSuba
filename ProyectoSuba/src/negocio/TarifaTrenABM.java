package negocio;

import dao.TarifaTrenDao;
import datos.TarifaTren;

public class TarifaTrenABM {
	private static TarifaTrenABM instancia;
	protected TarifaTrenDao dao;

	protected TarifaTrenABM() {
		dao = new TarifaTrenDao();
	}
	
	public static TarifaTrenABM getInstancia() {
		if (instancia == null)
			instancia = new TarifaTrenABM();
		return instancia;
	}
	
	public TarifaTren traerTarifaTren(int idTarifaTren) throws Exception {
		TarifaTren tarifaTren = dao.traer(idTarifaTren);
		if (tarifaTren==null) throw new Exception("La tarifa no existe");
		return tarifaTren;
	}
	
	public TarifaTren traerTarifaTrenMax() throws Exception {
		TarifaTren tarifaTren = dao.traerMax();
		if (tarifaTren==null) throw new Exception("No hay tarifas ingresadas");
		return tarifaTren;
	}
	
	public int agregar(float tarifa) {
		TarifaTren tarifaTren = new TarifaTren(tarifa);
		return dao.agregar(tarifaTren);
	}
	
	public void modificar(TarifaTren tarifaTren) {
		dao.actualizar(tarifaTren);
	}
	
	public void eliminar(int idTarifaTren) throws Exception {
		TarifaTren tarifaTren = dao.traer(idTarifaTren);
		if (tarifaTren==null) throw new Exception("La tarifa no existe");
		dao.eliminar(tarifaTren);
	}
}
