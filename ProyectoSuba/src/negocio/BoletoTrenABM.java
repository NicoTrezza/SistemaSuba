package negocio;

import dao.BoletoTrenDao;
import datos.BoletoTren;

public class BoletoTrenABM {
	BoletoTrenDao dao = new BoletoTrenDao();

	public BoletoTren traerBoleto(int idBoletoTren) throws Exception {
		BoletoTren boletoTren = dao.traer(idBoletoTren);
		if (boletoTren==null) throw new Exception("No existe el trayecto seleccionado");
		return boletoTren;
	}
	
	public int agregar(BoletoTren boletoTren) {
		return dao.agregar(boletoTren);
	}
	
	public void modificar(BoletoTren boletoTren) {
		dao.actualizar(boletoTren);
	}
	
	public void eliminar(int idBoletoTren) throws Exception {
		BoletoTren boletoTren = dao.traer(idBoletoTren);
		if (boletoTren==null) throw new Exception("No existe el trayecto seleccionado");
		dao.eliminar(boletoTren);
	}
}
