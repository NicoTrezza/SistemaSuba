package datos;

public class Estacion {
	protected int idEstacion;
	private String nombre;
	private Linea linea;
	
	public Estacion() {}
	
	public Estacion(String nombre, Linea linea) {
		this.nombre = nombre;
		this.linea = linea;
	}

	public int getIdEstacion() {
		return idEstacion;
	}

	protected void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "Estacion [idEstacion=" + idEstacion + ", nombre=" + nombre + "]";
	}
}
