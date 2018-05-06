package datos;
import java.util.GregorianCalendar;

public class UsuarioBoletoEstudiantil {
	protected int idUsuarioBoletoEstudiantil;
	private GregorianCalendar fechaVencimiento;
	private Usuario usuario;
	private BoletoEstudiantil boletoEstudiantil;
	
	public UsuarioBoletoEstudiantil(GregorianCalendar fechaVencimiento, Usuario usuario,
			BoletoEstudiantil boletoEstudiantil) {
		this.fechaVencimiento = fechaVencimiento;
		this.usuario = usuario;
		this.boletoEstudiantil = boletoEstudiantil;
	}

	public int getIdUsuarioBoletoEstudiantil() {
		return idUsuarioBoletoEstudiantil;
	}

	protected void setIdUsuarioBoletoEstudiantil(int idUsuarioBoletoEstudiantil) {
		this.idUsuarioBoletoEstudiantil = idUsuarioBoletoEstudiantil;
	}

	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BoletoEstudiantil getBoletoEstudiantil() {
		return boletoEstudiantil;
	}

	public void setBoletoEstudiantil(BoletoEstudiantil boletoEstudiantil) {
		this.boletoEstudiantil = boletoEstudiantil;
	}

	@Override
	public String toString() {
		return "UsuarioBoletoEstudiantil [idUsuarioBoletoEstudiantil=" + idUsuarioBoletoEstudiantil
				+ ", fechaVencimiento=" + fechaVencimiento + ", usuario=" + usuario + ", boletoEstudiantil="
				+ boletoEstudiantil + "]";
	}
}
