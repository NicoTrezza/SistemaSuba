package negocio;

import java.util.Set;

import dao.UsuarioDao;
import datos.BoletoEstudiantil;
import datos.Permiso;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.TipoIdentificacion;
import datos.Usuario;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();

	public Usuario traerUsuario(int idUsuario) throws Exception {
		Usuario usuario = dao.traer(idUsuario);
		if (usuario==null) throw new Exception("El usuario no existe");
		return usuario;
	}
	
	public int agregar(String nombre, String apellido, char sexo, long nroIdentificacion, long clave,
			String email, long movil, long fijo, TipoIdentificacion identificacion, Permiso permiso,
			TarifaSocial tarifaSocial, Set<Tarjeta> lstTarjetas, BoletoEstudiantil boletoEstudiantil) throws Exception {
		Usuario usuario = new Usuario(nombre,apellido,sexo,nroIdentificacion,clave,email,movil,fijo,identificacion,
				permiso,tarifaSocial,lstTarjetas,boletoEstudiantil);
		Usuario usuario1 = dao.traerPorIdentificacion(nroIdentificacion);
		if ((usuario1 != null) && (usuario1.getTipoIdentificacion().getIdTipoIdentificacion() == identificacion.getIdTipoIdentificacion())) throw new Exception("Usuario duplicado");
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario usuario) throws Exception {
		Usuario usuario1 = dao.traerPorIdentificacion(usuario.getNroIdentificacion());
		if ((usuario1 != null) && (usuario1.getTipoIdentificacion().getIdTipoIdentificacion() == usuario.getTipoIdentificacion().getIdTipoIdentificacion()) && (usuario1.getIdUsuario() != usuario.getIdUsuario())) throw new Exception("Usuario duplicado");
		dao.actualizar(usuario);
	}
	
	public void eliminar(int idUsuario) throws Exception {
		Usuario usuario = dao.traer(idUsuario);
		if (usuario==null) throw new Exception("El usuario no existe");
		dao.eliminar(usuario);
	}
}
