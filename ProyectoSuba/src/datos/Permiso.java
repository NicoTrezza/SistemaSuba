package datos;

public class Permiso {
	protected int idPermiso;
	private int nivelPermisos;
	private String nombre;
	
	public Permiso() {}
	
	public Permiso(int nivelPermisos, String nombre) {
		this.nivelPermisos = nivelPermisos;
		this.nombre = nombre;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	protected void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public int getNivelPermisos() {
		return nivelPermisos;
	}

	public void setNivelPermisos(int nivelPermisos) {
		this.nivelPermisos = nivelPermisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", nivelPermisos=" + nivelPermisos + ", nombre=" + nombre + "]";
	}
}
