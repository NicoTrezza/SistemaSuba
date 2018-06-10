package negocio;

import java.util.List;

import dao.BoletoColectivoDao;
import datos.BoletoColectivo;

public class BoletoColectivoABM {
	private static BoletoColectivoABM instancia;
	protected BoletoColectivoDao dao;

	protected BoletoColectivoABM() {
		dao = new BoletoColectivoDao();
	}
	
	public static BoletoColectivoABM getInstancia() {
		if (instancia == null) 
			instancia = new BoletoColectivoABM();
		return instancia;
	}
	
	public BoletoColectivo traerBoleto(int idBoletoColectivo) throws Exception {
		BoletoColectivo bc = dao.traer(idBoletoColectivo);
		if (bc==null) throw new Exception("La sección no existe");
		return bc;
	}
	
	public List<BoletoColectivo> traerBoletos() throws Exception {
		return dao.traer();
	}
	
	public BoletoColectivo traerBoletoPorSeccion(int seccion) throws Exception {
		BoletoColectivo bc = dao.traerPorSeccion(seccion);
		if (bc==null) throw new Exception("La sección no existe");
		return bc;
	}
	
	public BoletoColectivo traerBoletoPorValor(float valor) throws Exception {
		BoletoColectivo bc = dao.traerPorValor(valor);
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
