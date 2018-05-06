package datos;

public class TipoIdentificacion {
	protected int idTipoIdentificacion;
	private String nombre;
	
	public TipoIdentificacion() {}
	
	public TipoIdentificacion(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	protected void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoIdentificacion [idTipoIdentificacion=" + idTipoIdentificacion + ", nombre=" + nombre + "]";
	}
}
