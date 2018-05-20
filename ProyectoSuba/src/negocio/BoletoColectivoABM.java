package negocio;

import dao.BoletoColectivoDao;
import datos.BoletoColectivo;

public class BoletoColectivoABM {
	BoletoColectivoDao dao = new BoletoColectivoDao();

	public BoletoColectivo traerBoleto(int idBoletoColectivo) throws Exception {
		BoletoColectivo bc = dao.traer(idBoletoColectivo);
		if (bc==null) throw new Exception("La sección no existe");
		return bc;
	}
	
	public BoletoColectivo traerBoletoMax() throws Exception {
		BoletoColectivo bc = dao.traerMax();
		if (bc==null) throw new Exception("No hay secciones ingresadas");
		return bc;
	}
	
	public int agregar(int seccion, float valor) {
		BoletoColectivo bc = new BoletoColectivo(seccion,valor);
		return dao.agregar(bc);
	}
	
	public void modificar(BoletoColectivo bc) {
		dao.actualizar(bc);
	}
	
	public void eliminar(int idBoletoColectivo) throws Exception {
		BoletoColectivo bc = dao.traer(idBoletoColectivo);
		if (bc==null) throw new Exception("La sección no existe");
		dao.eliminar(bc);
	}
}
