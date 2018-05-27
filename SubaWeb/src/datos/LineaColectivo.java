package datos;

public class LineaColectivo {
	protected int idLineaColectivo;
	private int linea;
	
	public LineaColectivo() {}
	
	public LineaColectivo(int linea) {
		this.linea = linea;
	}

	public int getIdLineaColectivo() {
		return idLineaColectivo;
	}

	protected void setIdLineaColectivo(int idLineaColectivo) {
		this.idLineaColectivo = idLineaColectivo;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "LineaColectivo [idLineaColectivo=" + idLineaColectivo + ", linea=" + linea + "]";
	}
}
