package datos;

public class Linea {
	protected int idLinea;
	private String linea;
	
	public Linea() {}
	
	public Linea(String linea) {
		this.linea = linea;
	}

	protected int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "Linea [idLinea=" + idLinea + ", linea=" + linea + "]";
	}
}
