package datos;
import java.util.GregorianCalendar;

import negocio.TarjetaABM;

public class Tarjeta {
	protected int idTarjeta;
	private int nroTarjeta;
	private float saldo;
	private boolean activa;
	private Usuario usuario;
	private GregorianCalendar ultHoraViaje;
	private TarifaSocial tarifaSocial;
	private BoletoEstudiantil boletoEstudiantil;
	private RedSube estadoRedSube;
	private BoletoTren boleto;
	
	public Tarjeta() {}
	
	public Tarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = 0;
		this.activa = true;
		this.usuario = null;
		this.tarifaSocial = null;
		this.boletoEstudiantil = null;
		this.estadoRedSube = null;
		this.boleto = null;
	}

	public Tarjeta(int nroTarjeta, float saldo, boolean activa, Usuario usuario,
			GregorianCalendar ultHoraViaje, TarifaSocial tarifaSocial, BoletoEstudiantil boletoEstudiantil,
			RedSube estadoRedSube, BoletoTren boleto) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.activa = activa;
		this.usuario = usuario;
		this.ultHoraViaje = ultHoraViaje;
		this.tarifaSocial = tarifaSocial;
		this.boletoEstudiantil = boletoEstudiantil;
		this.estadoRedSube = estadoRedSube;
		this.boleto = boleto;
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

	public GregorianCalendar getUltHoraViaje() {
		return ultHoraViaje;
	}

	public void setUltHoraViaje(GregorianCalendar ultHoraViaje) {
		this.ultHoraViaje = ultHoraViaje;
	}

	public TarifaSocial getTarifaSocial() {
		return tarifaSocial;
	}

	public void setTarifaSocial(TarifaSocial tarifaSocial) {
		this.tarifaSocial = tarifaSocial;
	}

	public BoletoEstudiantil getBoletoEstudiantil() {
		return boletoEstudiantil;
	}

	public void setBoletoEstudiantil(BoletoEstudiantil boletoEstudiantil) {
		this.boletoEstudiantil = boletoEstudiantil;
	}

	public RedSube getEstadoRedSube() {
		return estadoRedSube;
	}

	public void setEstadoRedSube(RedSube estadoRedSube) {
		this.estadoRedSube = estadoRedSube;
	}

	public BoletoTren getBoleto() {
		return boleto;
	}

	public void setBoleto(BoletoTren boleto) {
		this.boleto = boleto;
	}
	
	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", activa="
				+ activa + "]";
	}

	public void anadirUsuario(Usuario usuario) throws Exception {
		if (this.usuario!=null) throw new Exception("La tarjeta ya tiene un usuario asignado");
		TarjetaABM abm = new TarjetaABM();
		this.usuario = usuario;
		abm.modificar(this);
	}
	
	public void darDeBaja() throws Exception {
		TarjetaABM abm = new TarjetaABM();
		this.activa = false;
		abm.modificar(this);
	}
}
