package negocio;

import java.util.GregorianCalendar;

import dao.CargaDao;
import datos.Carga;
import datos.Maquina;
import datos.Tarjeta;

public class CargaABM {
	CargaDao dao = new CargaDao();

	public Carga traerCarga(int idCarga) throws Exception {
		Carga carga = dao.traer(idCarga);
		if (carga==null) throw new Exception("Movimiento de carga no existente");
		return carga;
	}
	
	public int agregar(Carga carga) {
		return dao.agregar(carga);
	}
	
	public int agregar(GregorianCalendar fechaHora, float valor, Tarjeta tarjeta, Maquina maquina) {
		Carga carga = new Carga(fechaHora,valor,tarjeta,maquina);
		return dao.agregar(carga);
	}
	
	public void modificar(Carga carga) {
		dao.actualizar(carga);
	}
	
	public void eliminar(int idCarga) throws Exception {
		Carga carga = dao.traer(idCarga);
		if (carga==null) throw new Exception("Movimiento de carga no existente");
		dao.eliminar(carga);
	}
}
