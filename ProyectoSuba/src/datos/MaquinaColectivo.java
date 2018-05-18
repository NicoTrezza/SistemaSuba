package datos;

public class MaquinaColectivo extends Maquina {
	private int numInterno;
	private LineaColectivo lineaColectivo;
	
	public MaquinaColectivo() {}
	
	public MaquinaColectivo(int numInterno, LineaColectivo lineaColectivo) {
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

	public void cobrar(Tarjeta tarjeta) throws Exception {
		if (tarjeta.getSaldo() - 10 < 20) 
			throw new Exception("Saldo insuficiente");
		tarjeta.setSaldo(tarjeta.getSaldo() - 10);
	}
}
