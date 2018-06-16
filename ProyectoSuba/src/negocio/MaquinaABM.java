package negocio;

import dao.MaquinaDao;
import datos.Estacion;
import datos.LineaColectivo;
import datos.Maquina;

public class MaquinaABM {
	private static MaquinaABM instancia;
	protected MaquinaDao dao; 
	
	protected MaquinaABM() {
		dao = new MaquinaDao(); 
	}
	
	public static MaquinaABM getInstancia() {
		if (instancia == null)
			instancia = new MaquinaABM();
		return instancia;
	}
	
	public Maquina traerMaquina(int idMaquina) throws Exception{
		Maquina maquina = dao.traer(idMaquina);
		if (maquina==null) throw new Exception("La maquina no existe");
		return maquina;
	}
	
	public Maquina traerMaquinaPorEstacion(Estacion e) throws Exception{
		Maquina maquina = dao.traerPorEstacion(e.getIdEstacion());
		if (maquina==null) throw new Exception("La maquina no existe");
		return maquina;
	}
	
	public Maquina traerMaquinaPorLinea(LineaColectivo l) throws Exception{
		Maquina maquina = dao.traerPorLinea(l.getIdLineaColectivo());
		if (maquina==null) throw new Exception("La maquina no existe");
		return maquina;
	}
	
	public int agregar(Maquina maquina) {
		return dao.agregar(maquina);
	}
	
	public void modificar(Maquina maquina) {
		dao.actualizar(maquina);
	}
	
	public void eliminar(int idMaquina) throws Exception {
		Maquina maquina = dao.traer(idMaquina);
		if (maquina==null) throw new Exception("La maquina no existe");
		dao.eliminar(maquina);
	}
}
