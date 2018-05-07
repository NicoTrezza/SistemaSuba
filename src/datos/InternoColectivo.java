package datos;

public class InternoColectivo {
	protected int idInternoColectivo;
	private int numInterno;
	private LineaColectivo lineaColectivo;
	
	public InternoColectivo() {}
	
	public InternoColectivo(int numInterno, LineaColectivo lineaColectivo) {
		this.numInterno = numInterno;
		this.lineaColectivo = lineaColectivo;
	}

	public int getIdInternoColectivo() {
		return idInternoColectivo;
	}

	protected void setIdInternoColectivo(int idInternoColectivo) {
		this.idInternoColectivo = idInternoColectivo;
	}

	public int getNumInterno() {
		return numInterno;
	}

	public void setNumInterno(int numInterno) {
		this.numInterno = numInterno;
	}

	public LineaColectivo getLineaColectivo() {
		return lineaColectivo;
	}

	public void setLineaColectivo(LineaColectivo lineaColectivo) {
		this.lineaColectivo = lineaColectivo;
	}

	@Override
	public String toString() {
		return "InternoColectivo [idInternoColectivo=" + idInternoColectivo + ", numInterno=" + numInterno
				+ ", lineaColectivo=" + lineaColectivo + "]";
	}
}
