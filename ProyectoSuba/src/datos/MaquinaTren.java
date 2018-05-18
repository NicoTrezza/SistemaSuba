package datos;

public class MaquinaTren extends Maquina {
	private Estacion estacion;
	
	public MaquinaTren() {}
	
	public MaquinaTren(Estacion estacion) {
		this.estacion = estacion;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	@Override
	public String toString() {
		return "MaquinaTren [estacion=" + estacion + "]";
	}
	
	public void cobroMolineteSubte(Tarjeta tarjeta) throws Exception {
		if (tarjeta.getSaldo() - 11 < 20) 
			throw new Exception("Saldo insuficiente");
		tarjeta.setSaldo(tarjeta.getSaldo() - 11);
	}
	
	public void cobroMolinete(Tarjeta tarjeta) throws Exception {
		if (tarjeta.getSaldo() - 6.25 < 20) 
			throw new Exception("Saldo insuficiente");
		tarjeta.setSaldo(tarjeta.getSaldo() - 6.25f);
		tarjeta.getBoleto().setEstacionIngreso(getEstacion());
		tarjeta.getBoleto().setValor(tarjeta.getBoleto().getValor() + 6.25f);
	}
	
	public void devolucionMolinete(Tarjeta tarjeta) throws Exception {
		if (tarjeta.getSaldo() - 6.25 < 20) 
			throw new Exception("Saldo insuficiente");
		if (tarjeta.getBoleto().getEstacionIngreso() == null) {
			tarjeta.setSaldo(tarjeta.getSaldo() - 6.25f);
			tarjeta.getBoleto().setEstacionEgreso(getEstacion());
			tarjeta.getBoleto().setValor(tarjeta.getBoleto().getValor() + 6.25f);
		}
		else {
			tarjeta.setSaldo(tarjeta.getSaldo() + 3.25f);
			tarjeta.getBoleto().setEstacionEgreso(getEstacion());
			tarjeta.getBoleto().setValor(tarjeta.getBoleto().getValor() - 3.25f);
		}		
	}
	
	public void cargar(Tarjeta tarjeta, float valor) {
		tarjeta.setSaldo(tarjeta.getSaldo() + valor);
	}
}
