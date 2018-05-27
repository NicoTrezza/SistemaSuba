package datos;

public class BoletoEstudiantil {
	protected int idBoletoEstudiantil;
	private String nivelEducativo;
	private int cantViajesGratis;
	private int limiteDiario;
	private int horaInicial;
	private int horaFinal;
	private int diaInicial;
	private int diaFinal;
	
	public BoletoEstudiantil() {}
	
	public BoletoEstudiantil(String nivelEducativo, int cantViajesGratis, int limiteDiario,
			int horaInicial, int horaFinal, int diaInicial, int diaFinal) {
		this.nivelEducativo = nivelEducativo;
		this.cantViajesGratis = cantViajesGratis;
		this.limiteDiario = limiteDiario;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
	}

	public int getIdBoletoEstudiantil() {
		return idBoletoEstudiantil;
	}

	protected void setIdBoletoEstudiantil(int idBoletoEstudiantil) {
		this.idBoletoEstudiantil = idBoletoEstudiantil;
	}

	public String getNivelEducativo() {
		return nivelEducativo;
	}

	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public int getCantViajesGratis() {
		return cantViajesGratis;
	}

	public void setCantViajesGratis(int cantViajesGratis) {
		this.cantViajesGratis = cantViajesGratis;
	}

	public int getLimiteDiario() {
		return limiteDiario;
	}

	public void setLimiteDiario(int limiteDiario) {
		this.limiteDiario = limiteDiario;
	}

	public int getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(int horaInicial) {
		this.horaInicial = horaInicial;
	}

	public int getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(int diaInicial) {
		this.diaInicial = diaInicial;
	}

	public int getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(int diaFinal) {
		this.diaFinal = diaFinal;
	}

	@Override
	public String toString() {
		return "BoletoEstudiantil [idBoletoEstudiantil=" + idBoletoEstudiantil + ", nivelEducativo=" + nivelEducativo
				+ ", cantViajesGratis=" + cantViajesGratis + ", limiteDiario=" + limiteDiario + ", horaInicial="
				+ horaInicial + ", horaFinal=" + horaFinal + ", diaInicial=" + diaInicial + ", diaFinal=" + diaFinal
				+ "]";
	}
}
