package negocio;

import dao.RedSubeDao;
import datos.RedSube;

public class RedSubeABM {
	RedSubeDao dao = new RedSubeDao();

	public RedSube traerLinea(int idRedSube) throws Exception {
		RedSube redSube = dao.traer(idRedSube);
		if (redSube==null) throw new Exception("El nivel de descuento Red Sube no existe");
		return redSube;
	}
	
	public int agregar(RedSube redSube) {
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
