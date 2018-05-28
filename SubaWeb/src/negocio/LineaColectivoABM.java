package negocio;

import java.util.List;

import dao.LineaColectivoDao;
import datos.LineaColectivo;

public class LineaColectivoABM {
	LineaColectivoDao dao = new LineaColectivoDao();

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
