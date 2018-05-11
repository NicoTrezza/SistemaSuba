package datos;
import java.util.GregorianCalendar;

public class Viaje {
	protected int idViaje;
	private int nroTarjeta;
	private GregorianCalendar fechaHora;
	private Tarjeta tarjeta;
	private Maquina maquina;
	
	public Viaje() {}

	public Viaje(int nroTarjeta, GregorianCalendar fechaHora, Tarjeta tarjeta, Maquina maquina) {
		this.nroTarjeta = nroTarjeta;
		this.fechaHora = fechaHora;
		this.tarjeta = tarjeta;
		this.maquina = maquina;
	}

	public int getIdViaje() {
		return idViaje;
	}

	protected void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
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
		return "Viaje [idViaje=" + idViaje + ", nroTarjeta=" + nroTarjeta + ", fechaHora=" + fechaHora + ", tarjeta="
				+ tarjeta + ", maquina=" + maquina + "]";
	}
}
