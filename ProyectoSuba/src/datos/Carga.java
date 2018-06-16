package datos;
import java.util.GregorianCalendar;

public class Carga {
	protected int idCarga;
	private GregorianCalendar fechaHora;
	private float valor;
	private Tarjeta tarjeta;
	private Maquina maquina;
	
	public Carga() {}

	public Carga(GregorianCalendar fechaHora, float valor, Tarjeta tarjeta, Maquina maquina) {
		this.fechaHora = fechaHora;
		this.valor = valor;
		this.tarjeta = tarjeta;
		this.maquina = maquina;
	}

	public int getIdCarga() {
		return idCarga;
	}

	protected void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Carga [idCarga=" + idCarga + ", fechaHora=" + fechaHora + ", valor=" + valor + "]";
	}
}
