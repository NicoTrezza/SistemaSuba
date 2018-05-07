package datos;
import java.util.GregorianCalendar;

public class Carga {
	protected int idCarga;
	private int nroTarjeta;
	private GregorianCalendar fechaHora;
	private Tarjeta tarjeta;
	private Maquina maquina;
	
	public Carga() {}
	
	public Carga(int nroTarjeta, GregorianCalendar fechaHora, Tarjeta tarjeta, Maquina maquina) {
		this.nroTarjeta = nroTarjeta;
		this.fechaHora = fechaHora;
		this.tarjeta = tarjeta;
		this.maquina = maquina;
	}

	public int getIdCarga() {
		return idCarga;
	}

	protected void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public int getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
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
		return "Carga [idCarga=" + idCarga + ", nroTarjeta=" + nroTarjeta + ", fechaHora=" + fechaHora + ", tarjeta="
				+ tarjeta + ", maquina=" + maquina + "]";
	}
}
