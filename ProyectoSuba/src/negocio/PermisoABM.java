package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	PermisoDao dao = new PermisoDao();

	public Permiso traerPermisoPorID(int idPermiso) throws Exception {
		Permiso permiso = dao.traer(idPermiso);
		if (permiso==null) throw new Exception("El permiso no existe.");
		return permiso;
	}
	
	public Permiso traerPermisoPorNivel(int nivelPermisos) throws Exception {
		Permiso permiso = dao.traerPorNivel(nivelPermisos);
		if (permiso==null) throw new Exception("El permiso no existe.");
		return permiso;
	}
	
	public int agregar(Permiso permiso) throws Exception {
		Permiso permiso1 = dao.traerPorNivel(permiso.getNivelPermisos());
		if (permiso1!=null) throw new Exception("Numero de nivel ya existente.");
		return dao.agregar(permiso);
	}
	
	public void modificar(Permiso permiso) throws Exception {
		Permiso permiso1 = dao.traerPorNivel(permiso.getNivelPermisos());
		if (permiso1!=null) throw new Exception("Numero de nivel ya existente.");
		dao.actualizar(permiso);
	}
	
	public void eliminar(int idPermiso) throws Exception {
		Permiso permiso = dao.traer(idPermiso);
		if (permiso==null) throw new Exception("El permiso no existe.");
		dao.eliminar(permiso);
	}
}
