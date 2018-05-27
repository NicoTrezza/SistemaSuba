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
	public void cobrar(Tarjeta tarjeta) throws Exception {
		GregorianCalendar fechaHora = new GregorianCalendar();
		if (tarjeta.getEstacionIngreso()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
			tarjeta.setEstacionIngreso(null);
		if (tarjeta.getEstacionIngreso()!=null) devolucionMolinete(tarjeta);
		else cobroMolinete(tarjeta);
	}
	
	public void cobroMolinete(Tarjeta tarjeta) throws Exception {
		TarjetaABM tarjetaABM = new TarjetaABM();
		TarifaTrenABM tarifaTrenABM = new TarifaTrenABM();
		ViajeABM viajeABM = new ViajeABM();
		RedSubeABM redSubeABM = new RedSubeABM();
		GregorianCalendar fechaHora = new GregorianCalendar();
		TarifaTren tarifaTren = tarifaTrenABM.traerTarifaTrenMax();
		float tarifa;
		
		if (tarjeta.getSaldo()-tarifaTren.getValor() < -(tarifaTren.getValor()*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setUltHoraViaje(fechaHora);
		tarifa = tarifaTren.getValor();
		/*if (tarjeta.getEstadoRedSube()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
			if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(2));
			else {
				tarjeta.setNumeroViaje(tarjeta.getNumeroViaje()+1);
				if (tarjeta.getNumeroViaje()>5) {
					tarjeta.setNumeroViaje(0);
					tarjeta.setEstadoRedSube(null);
				}
			}
		}
		else {
			tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(1));
			tarjeta.setNumeroViaje(1);
		}*/
		tarjeta.setSaldo(tarjeta.getSaldo()-tarifa);
		tarjeta.setEstacionIngreso(estacion);
		tarjetaABM.modificar(tarjeta);
		viajeABM.agregar(fechaHora,tarifa,tarjeta,this);
	}
	
	public void devolucionMolinete(Tarjeta tarjeta) throws Exception {
		TarjetaABM tarjetaABM = new TarjetaABM();
		TarifaTrenABM tarifaTrenABM = new TarifaTrenABM();
		ViajeABM viajeABM = new ViajeABM();
		RedSubeABM redSubeABM = new RedSubeABM();
		GregorianCalendar fechaHora = new GregorianCalendar();
		BoletoTrenABM boletoTrenABM = new BoletoTrenABM();
		BoletoTren boletoTren = boletoTrenABM.traerBoletoTren(tarjeta.getEstacionIngreso(),estacion);
		System.out.println(boletoTren.toString());
		float tarifa;
		
		if (tarjeta.getSaldo()-boletoTren.getTarifaTren().getValor() <
				-(tarifaTrenABM.traerTarifaTrenMax().getValor()*3)) throw new Exception("Saldo insuficiente");
		
		if (tarjeta.getEstadoRedSube()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
			tarifa = boletoTren.getTarifaTren().getValor() * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
			if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(2));
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
			tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(1));
			tarjeta.setNumeroViaje(1);
		}
		if (tarjeta.getTarifaSocial()!=null) tarifa = tarifa * tarjeta.getTarifaSocial().getPorcentajeDescuento();
		tarifa = tarifaTrenABM.traerTarifaTrenMax().getValor()-tarifa;
		tarjeta.setSaldo(tarjeta.getSaldo()+tarifa);
		tarjetaABM.modificar(tarjeta);
		viajeABM.agregar(fechaHora,-tarifa,tarjeta,this);
		
		if (tarjeta.getEstacionIngreso()!=null &&
				(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
			tarjeta.setEstacionIngreso(null);
	}
	
	public void cobroMolineteSubte(Tarjeta tarjeta) throws Exception {
		if (tarjeta.getSaldo() - 11 < 20) 
			throw new Exception("Saldo insuficiente");
		tarjeta.setSaldo(tarjeta.getSaldo() - 11);
	}
}
