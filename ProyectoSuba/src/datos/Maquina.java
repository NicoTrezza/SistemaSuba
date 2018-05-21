package datos;

public class Maquina {
	protected int idMaquina;
	private int tipo;
	
	public Maquina() {}
	
	public Maquina(int tipo) {
		this.tipo = tipo;
	}

	public int getIdMaquina() {
		return idMaquina;
	}

	protected void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void cobrar(Tarjeta tarjeta, Object boleto) throws Exception {}

	@Override
	public String toString() {
		return "Maquina [idMaquina=" + idMaquina + ", tipo=" + tipo + "]";
	}
}
