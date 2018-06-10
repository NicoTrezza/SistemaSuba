package negocio;

import dao.RedSubeDao;
import datos.RedSube;

public class RedSubeABM {
	private static RedSubeABM instancia;
	protected RedSubeDao dao;

	protected RedSubeABM() {
		dao = new RedSubeDao();
	}
	
	public static RedSubeABM getInstancia() {
		if (instancia == null)
			instancia = new RedSubeABM();
		return instancia;
	}
	
	public RedSube traerRedSube(int idRedSube) throws Exception {
		RedSube redSube = dao.traer(idRedSube);
		if (redSube==null) throw new Exception("El nivel de descuento Red Sube no existe");
		return redSube;
	}
	
	public int agregar(float porcentajeDescuento) {
		RedSube redSube = new RedSube(porcentajeDescuento);
		return dao.agregar(redSube);
	}
	
	public void modificar(RedSube redSube) {
		dao.actualizar(redSube);
	}
	
	public void eliminar(int idRedSube) throws Exception {
		RedSube redSube = dao.traer(idRedSube);
		if (redSube==null) throw new Exception("El nivel de descuento Red Sube no existe");
		dao.eliminar(redSube);
	}
}
