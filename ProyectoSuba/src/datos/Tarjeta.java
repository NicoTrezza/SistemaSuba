package datos;

public class Tarjeta {
	protected int idTarjeta;
	private int nroTarjeta;
	private float saldo;
	private boolean activa;
	
	public Tarjeta() {}
	
	public Tarjeta(int nroTarjeta, float saldo, boolean activa, Usuario usuario) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.activa = activa;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	protected void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", activa="
				+ activa + "]";
	}
}
