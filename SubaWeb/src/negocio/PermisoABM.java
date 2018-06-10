package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	private static PermisoABM instancia;
	protected PermisoDao dao;
	
	protected PermisoABM() {
		dao = new PermisoDao();
	}
	
	public static PermisoABM getInstancia() {
		if (instancia == null)
			instancia = new PermisoABM();
		return instancia;
	}

	public Permiso traerPermisoPorID(int idPermiso) throws Exception {
		Permiso permiso = dao.traer(idPermiso);
		if (permiso==null) throw new Exception("El permiso no existe");
		return permiso;
	}
	
	public Permiso traerPermisoPorNivel(int nivelPermisos) throws Exception {
		Permiso permiso = dao.traerPorNivel(nivelPermisos);
		if (permiso==null) throw new Exception("El permiso no existe");
		return permiso;
	}
	
	public int agregar(int nivelPermisos, String nombre) throws Exception {
		if (dao.traerPorNivel(nivelPermisos)!=null) throw new Exception("Numero de nivel ya existente.");
		Permiso permiso = new Permiso(nivelPermisos,nombre);
		return dao.agregar(permiso);
	}
	
	public void modificar(int nivelPermisos, String nombre) throws Exception {
		if (dao.traerPorNivel(nivelPermisos)!=null) throw new Exception("Numero de nivel ya existente.");
		Permiso permiso = new Permiso(nivelPermisos,nombre);
		dao.actualizar(permiso);
	}
	
	public void eliminar(int idPermiso) throws Exception {
		Permiso permiso = dao.traer(idPermiso);
		if (permiso==null) throw new Exception("El permiso no existe.");
		dao.eliminar(permiso);
	}
}
