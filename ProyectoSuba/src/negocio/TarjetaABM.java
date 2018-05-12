package negocio;

import dao.TarjetaDao;
import datos.Tarjeta;

public class TarjetaABM {
	TarjetaDao dao = new TarjetaDao();

	public Tarjeta traerTarjeta(int idTarjeta) throws Exception {
		Tarjeta tarjeta = dao.traer(idTarjeta);
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		return tarjeta;
	}
	
	public int agregar(Tarjeta tarjeta) throws Exception {
		if (dao.traerPorNumero(tarjeta.getNroTarjeta())!=null) throw new Exception("Tarjeta duplicada");
		return dao.agregar(tarjeta);
	}
	
	public void modificar(Tarjeta tarjeta) throws Exception {
		if (dao.traerPorNumero(tarjeta.getNroTarjeta())!=null) throw new Exception("Tarjeta duplicada");
		dao.actualizar(tarjeta);
	}
	
	public void eliminar(int idTarjeta) throws Exception {
		Tarjeta tarjeta = dao.traer(idTarjeta);
		if (tarjeta==null) throw new Exception("La tarjeta no existe");
		dao.eliminar(tarjeta);
	}
}
