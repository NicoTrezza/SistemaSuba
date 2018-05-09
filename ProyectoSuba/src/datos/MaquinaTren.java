package datos;

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
	
	public void Cobrar(SubeVirtual tarjeta) {
		float importe;
		/*BoletoTren boleto;
		importe = boleto.getValor();
		tarjeta.setSaldo(tarjeta.getSaldo() - importe);*/
	}
}
