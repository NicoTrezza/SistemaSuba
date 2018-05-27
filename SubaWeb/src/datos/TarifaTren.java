package datos;

public class TarifaTren {
	private int idTarifaTren;
	private float valor;
	
	public TarifaTren() {}

	public TarifaTren(float valor) {
		this.valor = valor;
	}

	public int getIdTarifaTren() {
		return idTarifaTren;
	}

	public void setIdTarifaTren(int idTarifaTren) {
		this.idTarifaTren = idTarifaTren;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "TarifaTren [idTarifaTren=" + idTarifaTren + ", valor=" + valor + "]";
	}
}
