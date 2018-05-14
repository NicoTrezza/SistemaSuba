package datos;
import negocio.TarjetaABM;

public class Tarjeta {
	protected int idTarjeta;
	private int nroTarjeta;
	private float saldo;
	private boolean activa;
	private Usuario usuario;
	
	public Tarjeta() {}
	
	public Tarjeta(int nroTarjeta, float saldo, boolean activa, Usuario usuario) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.activa = activa;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", activa="
				+ activa + "]";
	}
	
	public void añadirUsuario(Usuario usuario) throws Exception {
		if (this.usuario!=null) throw new Exception("La tarjeta ya tiene un usuario asignado");
		TarjetaABM abm = new TarjetaABM();
		this.usuario = usuario;
		abm.modificar(this);
	}
}
