package negocio;

import java.util.GregorianCalendar;

import dao.MaquinaDao;
import datos.BoletoColectivo;
import datos.BoletoTren;
import datos.Estacion;
import datos.LineaColectivo;
import datos.Maquina;
import datos.Tarjeta;
import datos.MaquinaColectivo;
import datos.TarifaTren;
import datos.MaquinaTren;

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
	
	public void cobrarColectivo(Tarjeta tarjeta, BoletoColectivo boletoColectivo,
			MaquinaColectivo maquinaColectivo, GregorianCalendar fechaHora) throws Exception {
		float tarifa=0;
		
		if (tarjeta.getViajesGratisRestantes()<1) {
			if (tarjeta.getEstacionIngreso()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
				tarjeta.setEstacionIngreso(null);
			if ((tarjeta.getSaldo()-boletoColectivo.getValor()) < -(BoletoColectivoABM.getInstancia().traerBoletoMax().getValor()*3))
				throw new Exception("Saldo insuficiente");
			tarjeta.setUltHoraViaje(fechaHora);
			if (tarjeta.getEstadoRedSube()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
				tarifa = boletoColectivo.getValor() * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
				if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(2));
				else {
					tarjeta.setNumeroViaje(tarjeta.getNumeroViaje()+1);
					if (tarjeta.getNumeroViaje()>4) {
						tarjeta.setNumeroViaje(0);
						tarjeta.setEstadoRedSube(null);
					}
				}
			}
			else {
				tarifa = boletoColectivo.getValor();
				tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(1));
				tarjeta.setNumeroViaje(1);
			}
			if (tarjeta.getTarifaSocial()!=null) tarifa = tarifa * tarjeta.getTarifaSocial().getPorcentajeDescuento();
			tarjeta.setSaldo(tarjeta.getSaldo()-tarifa);
			TarjetaABM.getInstancia().modificar(tarjeta);
		}
		else tarjeta.setViajesGratisRestantes(tarjeta.getViajesGratisRestantes()-1);
		ViajeABM.getInstancia().agregar(fechaHora,tarifa,tarjeta,maquinaColectivo);
	}
	
	public void cobrarTren(Tarjeta tarjeta, MaquinaTren maquinaTren, GregorianCalendar fechaHora) throws Exception {
		if (tarjeta.getEstacionIngreso()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
			tarjeta.setEstacionIngreso(null);
		else if (maquinaTren.getTipo()==2) {
			if (tarjeta.getEstacionIngreso()!=null) devolucionMolinete(tarjeta, maquinaTren, fechaHora);
			else cobroMolinete(tarjeta, maquinaTren, fechaHora);
		}
		else if (maquinaTren.getTipo()==3) cobroMolineteSubte(tarjeta, maquinaTren, fechaHora);
	}
	
	private void cobroMolinete(Tarjeta tarjeta, MaquinaTren maquinaTren, GregorianCalendar fechaHora) throws Exception {
		TarifaTren tarifaTren = TarifaTrenABM.getInstancia().traerTarifaTrenMax();
		float tarifa=0;
		
		if (tarjeta.getSaldo()-tarifaTren.getValor() < -(tarifaTren.getValor()*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setUltHoraViaje(fechaHora);
		if (tarjeta.getViajesGratisRestantes()<1) {
			tarifa = tarifaTren.getValor();
			tarjeta.setSaldo(tarjeta.getSaldo()-tarifa);
			TarjetaABM.getInstancia().modificar(tarjeta);
		}
		tarjeta.setEstacionIngreso(maquinaTren.getEstacion());
		ViajeABM.getInstancia().agregar(fechaHora,tarifa,tarjeta,maquinaTren);
	}
	
	private void devolucionMolinete(Tarjeta tarjeta, MaquinaTren maquinaTren, GregorianCalendar fechaHora) throws Exception {
		BoletoTren boletoTren = BoletoTrenABM.getInstancia().traerBoletoTren(tarjeta.getEstacionIngreso(),
				maquinaTren.getEstacion());
		System.out.println(boletoTren.toString());
		float tarifa=0;
		
		if (tarjeta.getSaldo()-boletoTren.getTarifaTren().getValor() <
				-(TarifaTrenABM.getInstancia().traerTarifaTrenMax().getValor()*3)) throw new Exception("Saldo insuficiente");
		
		if (tarjeta.getViajesGratisRestantes()<1) {
			if (tarjeta.getEstadoRedSube()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
				tarifa = boletoTren.getTarifaTren().getValor() * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
				if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(2));
				else {
					tarjeta.setNumeroViaje(tarjeta.getNumeroViaje()+1);
					if (tarjeta.getNumeroViaje()>4) {
						tarjeta.setNumeroViaje(0);
						tarjeta.setEstadoRedSube(null);
					}
				}
			}
			else {
				tarifa = boletoTren.getTarifaTren().getValor();
				tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(1));
				tarjeta.setNumeroViaje(1);
			}
			if (tarjeta.getTarifaSocial()!=null) tarifa = tarifa * tarjeta.getTarifaSocial().getPorcentajeDescuento();
			tarifa = TarifaTrenABM.getInstancia().traerTarifaTrenMax().getValor()-tarifa;
			tarjeta.setSaldo(tarjeta.getSaldo()+tarifa);
		}
		else tarjeta.setViajesGratisRestantes(tarjeta.getViajesGratisRestantes()-1);
		tarjeta.setEstacionIngreso(null);
		TarjetaABM.getInstancia().modificar(tarjeta);
		ViajeABM.getInstancia().agregar(fechaHora,-tarifa,tarjeta,maquinaTren);
	}
	
	private void cobroMolineteSubte(Tarjeta tarjeta, MaquinaTren maquinaTren, GregorianCalendar fechaHora) throws Exception {
		float tarifa = 0; 
		
		if (tarjeta.getSaldo()-tarifa < -(tarifa*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setUltHoraViaje(fechaHora);
		
		if (tarjeta.getViajesGratisRestantes()<1) {
			tarifa = 12.5f; 
			if (tarjeta.getEstadoRedSube()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
				tarifa = tarifa * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
				if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(2));
				else {
					tarjeta.setNumeroViaje(tarjeta.getNumeroViaje()+1);
					if (tarjeta.getNumeroViaje()>4) {
						tarjeta.setNumeroViaje(0);
						tarjeta.setEstadoRedSube(null);
					}
				}
			}
			else {
				tarjeta.setEstadoRedSube(RedSubeABM.getInstancia().traerRedSube(1));
				tarjeta.setNumeroViaje(1);
			}
			if (tarjeta.getTarifaSocial()!=null) tarifa = tarifa * tarjeta.getTarifaSocial().getPorcentajeDescuento();
			tarjeta.setSaldo(tarjeta.getSaldo() - tarifa);
			TarjetaABM.getInstancia().modificar(tarjeta);
		}
		else tarjeta.setViajesGratisRestantes(tarjeta.getViajesGratisRestantes()-1);
		ViajeABM.getInstancia().agregar(fechaHora,tarifa,tarjeta,maquinaTren);
	}
	
	public void cargar(Tarjeta tarjeta, float valor, Maquina maquina) throws Exception {
		if (valor > 0) {
			GregorianCalendar horaActual = new GregorianCalendar();
			
			tarjeta.setSaldo(tarjeta.getSaldo() + valor);
			TarjetaABM.getInstancia().modificar(tarjeta);
			CargaABM.getInstancia().agregar(horaActual,valor,tarjeta,maquina);
		}
	}
}
