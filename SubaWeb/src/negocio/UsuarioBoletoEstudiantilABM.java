package negocio;

import java.util.GregorianCalendar;
import dao.UsuarioBoletoEstudiantilDao;
import datos.BoletoEstudiantil;
import datos.Usuario;
import datos.UsuarioBoletoEstudiantil;

public class UsuarioBoletoEstudiantilABM {
	private static UsuarioBoletoEstudiantilABM instancia;
	protected UsuarioBoletoEstudiantilDao dao;

	protected UsuarioBoletoEstudiantilABM() {
		dao = new UsuarioBoletoEstudiantilDao();
	}
	
	public static UsuarioBoletoEstudiantilABM getInstancia() {
		if (instancia == null)
			instancia = new UsuarioBoletoEstudiantilABM();
		return instancia;
	}
	
	public UsuarioBoletoEstudiantil traerUsuarioBoletoEstudiantil(int idUsuarioBoletoEstudiantil) throws Exception {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = dao.traer(idUsuarioBoletoEstudiantil);
		if (usuarioBoletoEstudiantil==null) throw new Exception("El registro seleccionado no existe");
		return usuarioBoletoEstudiantil;
	}
	
	public UsuarioBoletoEstudiantil traerPorUsuario(int idUsuario) throws Exception {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = dao.traerPorUsuario(idUsuario);
		if (usuarioBoletoEstudiantil==null) throw new Exception("El registro seleccionado no existe");
		return usuarioBoletoEstudiantil;
	}
	
	public int agregar(GregorianCalendar fechaVencimiento, Usuario usuario,
			BoletoEstudiantil boletoEstudiantil) {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = new UsuarioBoletoEstudiantil(fechaVencimiento,usuario,
				boletoEstudiantil);
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
