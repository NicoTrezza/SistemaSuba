package datos;

public class BoletoTren {
	protected int idBoletoTren;
	private float valor;
	private Estacion estacionIngreso;
	private Estacion estacionEgreso;
	
	public BoletoTren() {}
	
	public BoletoTren(float valor, Estacion estacionIngreso, Estacion estacionEgreso) {
		this.valor = valor;
		this.estacionIngreso = estacionIngreso;
		this.estacionEgreso = estacionEgreso;
	}

	public int getIdBoletoTren() {
		return idBoletoTren;
	}

	protected void setIdBoletoTren(int idBoletoTren) {
		this.idBoletoTren = idBoletoTren;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Estacion getEstacionIngreso() {
		return estacionIngreso;
	}

	public void setEstacionIngreso(Estacion estacionIngreso) {
		this.estacionIngreso = estacionIngreso;
	}

	public Estacion getEstacionEgreso() {
		return estacionEgreso;
	}

	public void setEstacionEgreso(Estacion estacionEgreso) {
		this.estacionEgreso = estacionEgreso;
	}

	@Override
	public String toString() {
		return "BoletoTren [idBoletoTren=" + idBoletoTren + ", valor=" + valor + ", estacionIngreso=" + estacionIngreso
				+ ", estacionEgreso=" + estacionEgreso + "]";
	}
}
