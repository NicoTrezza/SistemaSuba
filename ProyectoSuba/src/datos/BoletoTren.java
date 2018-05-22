package datos;

public class BoletoTren {
	protected int idBoletoTren;
	private TarifaTren tarifaTren;
	private Estacion estacionIngreso;
	private Estacion estacionEgreso;
	
	public BoletoTren() {}
	
	public BoletoTren(TarifaTren tarifaTren, Estacion estacionIngreso, Estacion estacionEgreso) {
		this.tarifaTren = tarifaTren;
		this.estacionIngreso = estacionIngreso;
		this.estacionEgreso = estacionEgreso;
	}

	public int getIdBoletoTren() {
		return idBoletoTren;
	}

	protected void setIdBoletoTren(int idBoletoTren) {
		this.idBoletoTren = idBoletoTren;
	}

	public TarifaTren getTarifaTren() {
		return tarifaTren;
	}

	public void setTarifaTren(TarifaTren tarifaTren) {
		this.tarifaTren = tarifaTren;
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
		return "BoletoTren [idBoletoTren=" + idBoletoTren + ", tarifaTren=" + tarifaTren + ", estacionIngreso="
				+ estacionIngreso + ", estacionEgreso=" + estacionEgreso + "]";
	}
}
