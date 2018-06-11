package datos;

import java.util.GregorianCalendar;

import negocio.CargaABM;
import negocio.TarjetaABM;

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

	@Override
	public String toString() {
		return "Maquina [idMaquina=" + idMaquina + ", tipo=" + tipo + "]";
	}
	
	public void cobrar(Tarjeta tarjeta, Object boleto) throws Exception {}
	public void cobrar(Tarjeta tarjeta, int tipo) throws Exception {}
	
	public void cargar(Tarjeta tarjeta, float valor) throws Exception {
		if (valor > 0) {
			GregorianCalendar horaActual = new GregorianCalendar();
			
			tarjeta.setSaldo(tarjeta.getSaldo() + valor);
			TarjetaABM.getInstancia().modificar(tarjeta);
			CargaABM.getInstancia().agregar(horaActual,valor,tarjeta,this);
		}
	}
}
