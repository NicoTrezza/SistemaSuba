package datos;

public class MaquinaColectivo extends Maquina {
	private int numInterno;
	private LineaColectivo lineaColectivo;
	
	public MaquinaColectivo() {}
	
	public MaquinaColectivo(int numInterno, LineaColectivo lineaColectivo, int tipo) {
		this.tipo = tipo;
		this.numInterno = numInterno;
		this.lineaColectivo = lineaColectivo;
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
}
