package negocio;

import java.util.List;

import dao.LineaColectivoDao;
import datos.LineaColectivo;
import datos.Maquina;
import datos.MaquinaColectivo;

public class LineaColectivoABM {
	private static LineaColectivoABM instancia;
	protected LineaColectivoDao dao;

	protected LineaColectivoABM() {
		dao = new LineaColectivoDao();
	}
	
	public static LineaColectivoABM getInstancia() {
		if (instancia == null)
			instancia = new LineaColectivoABM();
		return instancia;
	}
	
	public LineaColectivo traerLineaColectivoPorMaquina(Maquina maquina) throws Exception {
		LineaColectivo lc = null;
		MaquinaColectivo mc;
		
		if (maquina.getTipo() == 0) {
			mc = (MaquinaColectivo) maquina;
			lc = dao.traer(mc.getLineaColectivo().getIdLineaColectivo());
		}
		if (lc==null) throw new Exception("La linea no existe");
		return lc;
	}
	
	public LineaColectivo traerLineaColectivo(int idLineaColectivo) throws Exception {
		LineaColectivo lc = dao.traer(idLineaColectivo);
		if (lc==null) throw new Exception("La linea no existe");
		return lc;
	}
	
	public LineaColectivo traerPorLineaColectivo(int linea) throws Exception {
		LineaColectivo lc = dao.traerLinea(linea);
		if (lc==null) throw new Exception("La linea no existe");
		return lc;
	}
	
	public List<LineaColectivo> traerLineas() {
		return dao.traer();
	}
	
	public int agregar(int linea) {
		LineaColectivo lc = new LineaColectivo(linea);
		return dao.agregar(lc);
	}
	
	public void modificar(LineaColectivo lc) {
		dao.actualizar(lc);
	}
	
	public void eliminar(int idLineaColectivo) throws Exception {
		LineaColectivo lc = dao.traer(idLineaColectivo);
		if (lc==null) throw new Exception("La linea no existe");
		dao.eliminar(lc);
	}
}
