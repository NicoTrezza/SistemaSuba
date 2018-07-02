package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import dao.UsuarioBoletoEstudiantilDao;
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
	
	public List<UsuarioBoletoEstudiantil> traerPorUsuario(int idUsuario) {
		return dao.traerPorUsuario(idUsuario);
	}
	
	public int agregar(Usuario usuario, GregorianCalendar fechaActual) throws Exception {
		GregorianCalendar fechaVencimiento = new GregorianCalendar(fechaActual.get(GregorianCalendar.YEAR),
				fechaActual.get(GregorianCalendar.MONTH),fechaActual.get(GregorianCalendar.DAY_OF_MONTH));
		UsuarioBoletoEstudiantil ultimo = traerUltimoPorUsuario(usuario.getIdUsuario());
		
		if (usuario.getBoletoEstudiantil()==null) throw new Exception("Este usuario no posee el beneficio del boleto estudiantil");
		if (ultimo!=null) {
			if (ultimo.getFechaVencimiento().compareTo(fechaVencimiento)>=0) throw new Exception("El boleto estudiantil previo no expiro aun");
			fechaVencimiento.add(GregorianCalendar.MONTH,1);
			fechaVencimiento.add(GregorianCalendar.DAY_OF_MONTH,-1);
		}
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = new UsuarioBoletoEstudiantil(fechaVencimiento,usuario,usuario.getBoletoEstudiantil());
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
	
	public UsuarioBoletoEstudiantil traerUltimoPorUsuario(int idUsuario) throws Exception {
		UsuarioBoletoEstudiantil usuarioBoletoEstudiantil = dao.traerUltimoPorUsuario(idUsuario);
		//if (usuarioBoletoEstudiantil==null) throw new Exception("El registro seleccionado no existe");
		return usuarioBoletoEstudiantil;
	}
}
