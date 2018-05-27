package datos;

public class TarifaSocial {
	protected int idTarifaSocial;
	private float porcentajeDescuento;
	
	public TarifaSocial() {}
	
	public TarifaSocial(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getIdTarifaSocial() {
		return idTarifaSocial;
	}

	protected void setIdTarifaSocial(int idTarifaSocial) {
		this.idTarifaSocial = idTarifaSocial;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public String toString() {
		return "TarifaSocial [idTarifaSocial=" + idTarifaSocial + ", porcentajeDescuento=" + porcentajeDescuento + "]";
	}
}
