package datos;
import test.SubeVirtual;

public class MaquinaColectivo extends Maquina {
	private InternoColectivo internoColectivo;
	private BoletoColectivo boleto;
	
	public MaquinaColectivo() {}
	
	public MaquinaColectivo(InternoColectivo internoColectivo, BoletoColectivo boleto) {
		this.internoColectivo = internoColectivo;
		this.boleto = boleto;
	}

	public InternoColectivo getInternoColectivo() {
		return internoColectivo;
	}

	public void setInternoColectivo(InternoColectivo internoColectivo) {
		this.internoColectivo = internoColectivo;
	}

	public BoletoColectivo getBoleto() {
		return boleto;
	}

	public void setBoleto(BoletoColectivo boleto) {
		this.boleto = boleto;
	}

	@Override
	public String toString() {
		return "MaquinaColectivo [idMaquina=" + idMaquina + ", internoColectivo=" + internoColectivo + ", boleto=" + boleto + "]";
	}
	
	public void Cobrar(SubeVirtual tarjeta) {
		tarjeta.setSaldo(tarjeta.getSaldo() - boleto.getValor());
	}
}
