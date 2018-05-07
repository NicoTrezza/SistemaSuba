package datos;

import test.SubeVirtual;

public class MaquinaTren extends Maquina {
	private Estacion estacion;
	private BoletoTren boleto;
	
	public MaquinaTren() {}
	
	public MaquinaTren(Estacion estacion, BoletoTren boleto) {
		this.estacion = estacion;
		this.boleto = boleto;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public BoletoTren getBoleto() {
		return boleto;
	}

	public void setBoleto(BoletoTren boleto) {
		this.boleto = boleto;
	}

	@Override
	public String toString() {
		return "MaquinaTren [estacion=" + estacion + ", boleto=" + boleto + "]";
	}
	
	public void Cobrar(SubeVirtual tarjeta) {
		float importe;
		importe = boleto.getValor();
		tarjeta.setSaldo(tarjeta.getSaldo() - importe);
	}
}
