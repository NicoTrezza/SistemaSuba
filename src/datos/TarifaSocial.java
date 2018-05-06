package datos;

public class TarifaSocial {
	protected int idTarifaSocial;
	private float procentajeDescuento;
	
	public TarifaSocial() {}
	
	public TarifaSocial(float procentajeDescuento) {
		this.procentajeDescuento = procentajeDescuento;
	}

	public int getIdTarifaSocial() {
		return idTarifaSocial;
	}

	protected void setIdTarifaSocial(int idTarifaSocial) {
		this.idTarifaSocial = idTarifaSocial;
	}

	public float getProcentajeDescuento() {
		return procentajeDescuento;
	}

	public void setProcentajeDescuento(float procentajeDescuento) {
		this.procentajeDescuento = procentajeDescuento;
	}

	@Override
	public String toString() {
		return "TarifaSocial [idTarifaSocial=" + idTarifaSocial + ", procentajeDescuento=" + procentajeDescuento + "]";
	}
}
