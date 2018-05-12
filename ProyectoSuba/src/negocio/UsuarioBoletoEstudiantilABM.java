package negocio;

import dao.UsuarioBoletoEstudiantilDao;
import datos.UsuarioBoletoEstudiantil;

public class UsuarioBoletoEstudiantilABM {
	UsuarioBoletoEstudiantilDao dao = new UsuarioBoletoEstudiantilDao();

	public UsuarioBoletoEstudiantil traerUsuarioBoletoEstudiantil(int idUsuarioBoletoEstudiantil) throws Exception {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = dao.traer(idUsuarioBoletoEstudiantil);
		if (usuarioBoletoEstudiantil==null) throw new Exception("El registro seleccionado no existe");
		return usuarioBoletoEstudiantil;
	}
	
	public int agregar(UsuarioBoletoEstudiantil usuarioBoletoEstudiantil) {
		return dao.agregar(usuarioBoletoEstudiantil);
	}
	
	public void modificar(UsuarioBoletoEstudiantil usuarioBoletoEstudiantil) {
		dao.actualizar(usuarioBoletoEstudiantil);
	}
	
	public void eliminar(int idUsuarioBoletoEstudiantil) throws Exception {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = dao.traer(idUsuarioBoletoEstudiantil);
		if (usuarioBoletoEstudiantil==null) throw new Exception("El registro seleccionado no existe");
		dao.eliminar(usuarioBoletoEstudiantil);
	}
}
