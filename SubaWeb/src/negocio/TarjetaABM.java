package negocio;

import dao.TarjetaDao;
import datos.Tarjeta;
import datos.Usuario;

public class TarjetaABM {
	TarjetaDao dao = new TarjetaDao();

	public Tarjeta traerTarjeta(int idTarjeta) throws Exception {
		Tarjeta tarjeta = dao.traer(idTarjeta);
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		return tarjeta;
	}
	
	public Tarjeta traerTarjetaPorNumero(int nroTarjeta) throws Exception {
		Tarjeta tarjeta = dao.traerPorNumero(nroTarjeta);
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		return tarjeta;
	}
	
	public Tarjeta traerTarjetaPorUsuario(Usuario u) throws Exception {
		Tarjeta tarjeta = dao.traerPorUsuario(u.getIdUsuario());
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		return tarjeta;
	}

	
	public int agregar(int nroTarjeta) throws Exception {
		Tarjeta tarjeta = new Tarjeta(nroTarjeta);
		if (dao.traerPorNumero(tarjeta.getNroTarjeta())!=null) throw new Exception("Tarjeta duplicada");
		return dao.agregar(tarjeta);
	}
	
	public void modificar(Tarjeta tarjeta) throws Exception {
		Tarjeta tarjeta1 = dao.traerPorNumero(tarjeta.getNroTarjeta());
		if (tarjeta1!=null && (tarjeta1.getIdTarjeta()!=tarjeta.getIdTarjeta()) ) throw new Exception("Tarjeta duplicada");
		dao.actualizar(tarjeta);
	}
	
	public void eliminar(int idTarjeta) throws Exception {
		Tarjeta tarjeta = dao.traer(idTarjeta);
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		dao.eliminar(tarjeta);
	}
}
