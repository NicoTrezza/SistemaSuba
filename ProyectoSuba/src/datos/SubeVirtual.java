package datos;

import java.util.GregorianCalendar;
import funciones.Funciones;

public class SubeVirtual {
	private int nroTarjeta;
	private float saldo;
	private boolean activa;
	private GregorianCalendar ultHoraViaje;
	private TarifaSocial tarifaSocial;
	private BoletoEstudiantil boletoEstudiantil;
	private RedSube estadoRedSube;
	
	public SubeVirtual(int nroTarjeta, float saldo, boolean activa, GregorianCalendar ultHoraViaje,
			TarifaSocial tarifaSocial, BoletoEstudiantil boletoEstudiantil, RedSube estadoRedSube) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.activa = activa;
		this.ultHoraViaje = ultHoraViaje;
		this.tarifaSocial = tarifaSocial;
		this.boletoEstudiantil = boletoEstudiantil;
		this.estadoRedSube = estadoRedSube;
	}

	public int getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public GregorianCalendar getUltHoraViaje() {
		return ultHoraViaje;
	}

	public void setUltHoraViaje(GregorianCalendar ultHoraViaje) {
		this.ultHoraViaje = ultHoraViaje;
	}

	public TarifaSocial getTarifaSocial() {
		return tarifaSocial;
	}

	public void setTarifaSocial(TarifaSocial tarifaSocial) {
		this.tarifaSocial = tarifaSocial;
	}

	public BoletoEstudiantil getBoletoEstudiantil() {
		return boletoEstudiantil;
	}

	public void setBoletoEstudiantil(BoletoEstudiantil boletoEstudiantil) {
		this.boletoEstudiantil = boletoEstudiantil;
	}

	public RedSube getEstadoRedSube() {
		return estadoRedSube;
	}

	public void setEstadoRedSube(RedSube estadoRedSube) {
		this.estadoRedSube = estadoRedSube;
	}

	@Override
	public String toString() {
		return "SubeVirtual [nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", activa=" + activa + ", ultHoraViaje="
				+ Funciones.traerFechaCortaHora(ultHoraViaje) + ", tarifaSocial=" + tarifaSocial + ", boletoEstudiantil=" + boletoEstudiantil
				+ ", estadoRedSube=" + estadoRedSube + "]";
	}
}
