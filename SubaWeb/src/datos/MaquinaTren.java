package datos;

import java.util.GregorianCalendar;
import negocio.RedSubeABM;
import negocio.TarifaTrenABM;
import negocio.TarjetaABM;
import negocio.ViajeABM;
import negocio.BoletoTrenABM;
import datos.BoletoTren;

public class MaquinaTren extends Maquina {
	private Estacion estacion;
	
	public MaquinaTren() {}
	
	public MaquinaTren(Estacion estacion) {
		this.estacion = estacion;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	@Override
	public String toString() {
		return "MaquinaTren [estacion=" + estacion + "]";
	}

	@Override
	public void cobrar(Tarjeta tarjeta, int tipo) throws Exception {
		GregorianCalendar fechaHora = new GregorianCalendar();
		if (tarjeta.getEstacionIngreso()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
			tarjeta.setEstacionIngreso(null);
		if (tarjeta.getEstacionIngreso()!=null) devolucionMolinete(tarjeta);
		else if (tipo==0) cobroMolinete(tarjeta);
		else if (tipo==1) cobroMolineteSubte(tarjeta);
	}
	
	private void cobroMolinete(Tarjeta tarjeta) throws Exception {
		GregorianCalendar fechaHora = new GregorianCalendar();
		TarifaTren tarifaTren = TarifaTrenABM.getInstancia().traerTarifaTrenMax();
		float tarifa=0;
		
		if (tarjeta.getSaldo()-tarifaTren.getValor() < -(tarifaTren.getValor()*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setUltHoraViaje(fechaHora);
		if (tarjeta.getViajesGratisRestantes()<1) {
			tarifa = tarifaTren.getValor();
			tarjeta.setSaldo(tarjeta.getSaldo()-tarifa);
			TarjetaABM.getInstancia().modificar(tarjeta);
		}
		tarjeta.setEstacionIngreso(estacion);
		ViajeABM.getInstancia().agregar(fechaHora,tarifa,tarjeta,this);
	}
	
	private void devolucionMolinete(Tarjeta tarjeta) throws Exception {
		GregorianCalendar fechaHora = new GregorianCalendar();
		BoletoTren boletoTren = BoletoTrenABM.getInstancia().traerBoletoTren(tarjeta.getEstacionIngreso(),estacion);
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
		ViajeABM.getInstancia().agregar(fechaHora,-tarifa,tarjeta,this);
	}
	
	private void cobroMolineteSubte(Tarjeta tarjeta) throws Exception {
		GregorianCalendar fechaHora = new GregorianCalendar();
		float tarifa = 0; 
		
		if (tarjeta.getSaldo()-tarifa < -(tarifa*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setUltHoraViaje(fechaHora);
		
		if (tarjeta.getViajesGratisRestantes()<1) {
			if (tarjeta.getEstadoRedSube()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
				tarifa = 12.5f * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
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
			if (tarjeta.getTarifaSocial()!=null) tarifa = 12.5f * tarjeta.getTarifaSocial().getPorcentajeDescuento();
			tarjeta.setSaldo(tarjeta.getSaldo() - tarifa);
			TarjetaABM.getInstancia().modificar(tarjeta);
		}
		else tarjeta.setViajesGratisRestantes(tarjeta.getViajesGratisRestantes()-1);
		ViajeABM.getInstancia().agregar(fechaHora,tarifa,tarjeta,this);
	}
}
