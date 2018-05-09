package datos;

public class BoletoColectivo {
	protected int idBoletoColectivo;
	private int seccion;
	private float valor;
	
	public BoletoColectivo() {}
	
	public BoletoColectivo(int seccion, float valor) {
		this.seccion = seccion;
		this.valor = valor;
	}

	public int getIdBoletoColectivo() {
		return idBoletoColectivo;
	}

	protected void setIdBoletoColectivo(int idBoletoColectivo) {
		this.idBoletoColectivo = idBoletoColectivo;
	}

	public int getSeccion() {
		return seccion;
	}

	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "BoletoColectivo [idBoletoColectivo=" + idBoletoColectivo + ", seccion=" + seccion + ", valor=" + valor
				+ "]";
	}
}
