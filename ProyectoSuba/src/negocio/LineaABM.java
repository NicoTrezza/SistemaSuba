package negocio;
import dao.LineaDao;
import datos.Linea;

public class LineaABM {
	LineaDao dao = new LineaDao();

	public Linea traerLinea(int idLinea) throws Exception {
		Linea l = dao.traer(idLinea);
		if (l==null) throw new Exception("La linea no existe");
		return l;
	}
	
	public int agregar(String linea) {
		Linea l = new Linea(linea);
		return dao.agregar(l);
	}
	
	public void modificar(Linea l) {
		dao.actualizar(l);
	}
	
	public void eliminar(int idLinea) throws Exception {
		Linea l = dao.traer(idLinea);
		if (l==null) throw new Exception("La linea no existe");
		dao.eliminar(l);
	}
}