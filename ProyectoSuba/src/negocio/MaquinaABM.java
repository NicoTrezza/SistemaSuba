package negocio;

import dao.MaquinaDao;
import datos.Maquina;

public class MaquinaABM {
	MaquinaDao dao = new MaquinaDao(); 
	
	public Maquina traerMaquina(int idMaquina) throws Exception{
		Maquina maquina = dao.traer(idMaquina);
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
