package datos;

public class RedSube {
	protected int idRedSube;
	private float porcentajeDescuento;
	
	public RedSube() {}
	
	public RedSube(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getIdRedSube() {
		return idRedSube;
	}

	protected void setIdRedSube(int idRedSube) {
		this.idRedSube = idRedSube;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public String toString() {
		return "RedSube [idRedSube=" + idRedSube + ", porcentajeDescuento=" + porcentajeDescuento + "]";
	}
}
