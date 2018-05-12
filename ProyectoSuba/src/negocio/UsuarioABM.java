package negocio;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();

	public Usuario traerUsuario(int idEstacion) throws Exception {
		Usuario usuario = dao.traer(idEstacion);
		if (usuario==null) throw new Exception("El usuario no existe");
		return usuario;
	}
	
	public int agregar(Usuario usuario) throws Exception {
		Usuario usuario1 = dao.traerPorIdentificacion(usuario.getNroIdentificacion());
		if ((usuario1 != null) && (usuario1.getIdentificacion().getIdTipoIdentificacion() == usuario.getIdentificacion().getIdTipoIdentificacion())) throw new Exception("Usuario duplicado");
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario usuario) throws Exception {
		Usuario usuario1 = dao.traerPorIdentificacion(usuario.getNroIdentificacion());
		if ((usuario1 != null) && (usuario1.getIdentificacion().getIdTipoIdentificacion() == usuario.getIdentificacion().getIdTipoIdentificacion())) throw new Exception("Usuario duplicado");
		dao.actualizar(usuario);
	}
	
	public void eliminar(int idEstacion) throws Exception {
		Usuario usuario = dao.traer(idEstacion);
		if (usuario==null) throw new Exception("El usuario no existe");
		dao.eliminar(usuario);
	}
}
