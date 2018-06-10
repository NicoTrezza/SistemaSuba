package negocio;

import dao.BoletoEstudiantilDao;
import datos.BoletoEstudiantil;

public class BoletoEstudiantilABM {
	private static BoletoEstudiantilABM instancia;
	protected BoletoEstudiantilDao dao;

	protected BoletoEstudiantilABM() {
		dao = new BoletoEstudiantilDao();
	}
	
	public static BoletoEstudiantilABM getInstancia() {
		if (instancia == null)
			instancia = new BoletoEstudiantilABM();
		return instancia;
	}
	
	public BoletoEstudiantil traerBoletoEstudiantil(int idBoletoEstudiantil) throws Exception {
		BoletoEstudiantil boletoEstudiantil = dao.traer(idBoletoEstudiantil);
		if (boletoEstudiantil==null) throw new Exception("El boleto estudiantil seleccionado no existe");
		return boletoEstudiantil;
	}
	
	public int agregar(String nivelEducativo, int cantViajesGratis, int limiteDiario,
			int horaInicial, int horaFinal, int diaInicial, int diaFinal) throws Exception {
		if (dao.traer(nivelEducativo)!=null) throw new Exception("Ya existe un beneficio para el nivel educativo seleccionado");
		BoletoEstudiantil boletoEstudiantil = new BoletoEstudiantil(nivelEducativo,cantViajesGratis,limiteDiario,
				horaInicial,horaFinal,diaInicial,diaFinal);
		return dao.agregar(boletoEstudiantil);
	}
	
	public void modificar(BoletoEstudiantil boletoEstudiantil) {
		dao.actualizar(boletoEstudiantil);
	}
	
	public void eliminar(int idBoletoEstudiantil) throws Exception {
		BoletoEstudiantil boletoEstudiantil = dao.traer(idBoletoEstudiantil);
		if (boletoEstudiantil==null) throw new Exception("El boleto estudiantil seleccionado no existe");
		dao.eliminar(boletoEstudiantil);
	}
}
