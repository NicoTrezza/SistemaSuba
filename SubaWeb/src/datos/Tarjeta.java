package datos;
import java.util.GregorianCalendar;
import funciones.Funciones;

public class Tarjeta {
	protected int idTarjeta;
	private int nroTarjeta;
	private float saldo;
	private boolean activa;
	private Usuario usuario;
	
	private int numeroViaje;
	private int viajesGratisRestantes;
	private GregorianCalendar ultHoraViaje;
	private TarifaSocial tarifaSocial;
	private BoletoEstudiantil boletoEstudiantil;
	private RedSube estadoRedSube;
	private Estacion estacionIngreso;
	
	public Tarjeta() {}
	
	public Tarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = 0;
		this.activa = true;
	}
	
	public Tarjeta(int nroTarjeta, float saldo, boolean activa, Usuario usuario, int numeroViaje,
			int viajesGratisRestantes, GregorianCalendar ultHoraViaje, TarifaSocial tarifaSocial,
			BoletoEstudiantil boletoEstudiantil, RedSube estadoRedSube, Estacion estacionIngreso) {
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.activa = activa;
		this.usuario = usuario;
		this.numeroViaje = numeroViaje;
		this.viajesGratisRestantes = viajesGratisRestantes;
		this.ultHoraViaje = ultHoraViaje;
		this.tarifaSocial = tarifaSocial;
		this.boletoEstudiantil = boletoEstudiantil;
		this.estadoRedSube = estadoRedSube;
		this.estacionIngreso = estacionIngreso;
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

	public int getNumeroViaje() {
		return numeroViaje;
	}

	public void setNumeroViaje(int numeroViaje) {
		this.numeroViaje = numeroViaje;
	}

	public int getViajesGratisRestantes() {
		return viajesGratisRestantes;
	}

	public void setViajesGratisRestantes(int viajesGratisRestantes) {
		this.viajesGratisRestantes = viajesGratisRestantes;
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
	
	public Estacion getEstacionIngreso() {
		return estacionIngreso;
	}

	public void setEstacionIngreso(Estacion estacionIngreso) {
		this.estacionIngreso = estacionIngreso;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", activa="
				+ activa + ", numeroViaje=" + numeroViaje + ", viajesGratisRestantes=" + viajesGratisRestantes
				+ ", ultHoraViaje=" + Funciones.traerFechaCortaHora(ultHoraViaje) + ", tarifaSocial=" + tarifaSocial
				+ ", boletoEstudiantil=" + boletoEstudiantil + ", estadoRedSube=" + estadoRedSube + ", estacionIngreso="
				+ estacionIngreso + "]";
	}
}
