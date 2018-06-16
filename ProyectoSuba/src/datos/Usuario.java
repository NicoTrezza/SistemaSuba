package datos;
import java.util.Set;
import negocio.UsuarioABM;

public class Usuario {
	protected int idUsuario;
	private String nombre;
	private String apellido;
	private char sexo;
	private long nroIdentificacion;
	private long clave;
	private String email;
	private long movil;
	private long fijo;
	private TipoIdentificacion tipoIdentificacion;
	private Permiso permiso;
	private TarifaSocial tarifaSocial;
	private Set<Tarjeta> lstTarjetas;
	private BoletoEstudiantil boletoEstudiantil;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, char sexo, long nroIdentificacion, long clave, String email,
			TipoIdentificacion tipoIdentificacion, Permiso permiso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nroIdentificacion = nroIdentificacion;
		this.clave = clave;
		this.email = email;
		this.tipoIdentificacion = tipoIdentificacion;
		this.permiso = permiso;
	}
	
	public Usuario(String nombre, String apellido, char sexo, long nroIdentificacion, long clave, String email,
			long movil, long fijo, TipoIdentificacion tipoIdentificacion, Permiso permiso, TarifaSocial tarifaSocial,
			Set<Tarjeta> lstTarjetas, BoletoEstudiantil boletoEstudiantil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nroIdentificacion = nroIdentificacion;
		this.clave = clave;
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
		this.tipoIdentificacion = tipoIdentificacion;
		this.permiso = permiso;
		this.tarifaSocial = tarifaSocial;
		this.lstTarjetas = lstTarjetas;
		this.boletoEstudiantil = boletoEstudiantil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public long getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(long nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public long getClave() {
		return clave;
	}

	public void setClave(long clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMovil() {
		return movil;
	}

	public void setMovil(long movil) {
		this.movil = movil;
	}

	public long getFijo() {
		return fijo;
	}

	public void setFijo(long fijo) {
		this.fijo = fijo;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public TarifaSocial getTarifaSocial() {
		return tarifaSocial;
	}

	public void setTarifaSocial(TarifaSocial tarifaSocial) {
		this.tarifaSocial = tarifaSocial;
	}

	public Set<Tarjeta> getLstTarjetas() {
		return lstTarjetas;
	}

	public void setLstTarjetas(Set<Tarjeta> lstTarjetas) {
		this.lstTarjetas = lstTarjetas;
	}

	public BoletoEstudiantil getBoletoEstudiantil() {
		return boletoEstudiantil;
	}

	public void setBoletoEstudiantil(BoletoEstudiantil boletoEstudiantil) {
		this.boletoEstudiantil = boletoEstudiantil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", nroIdentificacion=" + nroIdentificacion + ", clave=" + clave + ", email=" + email + ", movil="
				+ movil + ", fijo=" + fijo + ", tipoIdentificacion=" + tipoIdentificacion + ", permiso=" + permiso
				+ ", tarifaSocial=" + tarifaSocial + ", lstTarjetas=" + lstTarjetas + ", boletoEstudiantil="
				+ boletoEstudiantil + "]";
	}

	public void registrarTarjeta(Tarjeta tarjeta) throws Exception {
		tarjeta.anadirUsuario(this);
		this.lstTarjetas.add(tarjeta);
	}
	
	public void solicitarTarifaSocial(TarifaSocial tarifaSocial) throws Exception {
		this.tarifaSocial=tarifaSocial;
		UsuarioABM.getInstancia().modificar(this);
	}
	
	public void solicitarBoletoEstudiantil(BoletoEstudiantil boletoEstudiantil) throws Exception {
		this.boletoEstudiantil = boletoEstudiantil;
		UsuarioABM.getInstancia().modificar(this);
	}
}
