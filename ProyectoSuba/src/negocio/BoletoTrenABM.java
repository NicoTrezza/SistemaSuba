package negocio;

import dao.BoletoTrenDao;
import datos.BoletoTren;
import datos.Estacion;
import datos.TarifaTren;

public class BoletoTrenABM {
	BoletoTrenDao dao = new BoletoTrenDao();

	public BoletoTren traerBoleto(int idBoletoTren) throws Exception {
		BoletoTren boletoTren = dao.traer(idBoletoTren);
		if (boletoTren==null) throw new Exception("No existe el trayecto seleccionado");
		return boletoTren;
	}
	
	public BoletoTren traerBoletoTren(Estacion estacionI, Estacion estacionE) throws Exception {
		BoletoTren boletoTren = dao.traer(estacionI,estacionE);
		if (boletoTren==null) throw new Exception("No existe el trayecto seleccionado");
		return boletoTren;
	}
	
	public int agregar(TarifaTren tarifaTren, Estacion estacionIngreso, Estacion estacionEgreso) {
		BoletoTren boletoTren = new BoletoTren(tarifaTren, estacionIngreso, estacionEgreso);
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
