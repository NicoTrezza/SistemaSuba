package datos;
import java.util.Set;

public class Usuario {
	protected int idUsuario;
	private String nombre;
	private String apellido;
	private char sexo;
	private int nroIdentificacion;
	private int clave;
	private String email;
	private long movil;
	private long fijo;
	private TipoIdentificacion identificacion;
	private Permiso permiso;
	private TarifaSocial tarifaSocial;
	private Set<Tarjeta> lstTarjetas;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, char sexo, int nroIdentificacion, int clave,
			String email, long movil, long fijo, TipoIdentificacion identificacion, Permiso permiso,
			TarifaSocial tarifaSocial, Set<Tarjeta> lstTarjetas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nroIdentificacion = nroIdentificacion;
		this.clave = clave;
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
		this.identificacion = identificacion;
		this.permiso = permiso;
		this.tarifaSocial = tarifaSocial;
		this.lstTarjetas = lstTarjetas;
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

	public int getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(int nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
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

	public TipoIdentificacion getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(TipoIdentificacion identificacion) {
		this.identificacion = identificacion;
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
}
