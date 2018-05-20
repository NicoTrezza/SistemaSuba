package datos;
import negocio.TarjetaABM;
import negocio.BoletoColectivoABM;
import negocio.ViajeABM;
import java.util.GregorianCalendar;

public class MaquinaColectivo extends Maquina {
	private int numInterno;
	private LineaColectivo lineaColectivo;
	
	public MaquinaColectivo() {}
	
	public MaquinaColectivo(int numInterno, LineaColectivo lineaColectivo) {
		this.numInterno = numInterno;
		this.lineaColectivo = lineaColectivo;
	}
	
	public int getNumInterno() {
		return numInterno;
	}

	public void setNumInterno(int numInterno) {
		this.numInterno = numInterno;
	}

	public LineaColectivo getLineaColectivo() {
		return lineaColectivo;
	}

	public void setLineaColectivo(LineaColectivo lineaColectivo) {
		this.lineaColectivo = lineaColectivo;
	}

	public void cobrar(Tarjeta tarjeta, BoletoColectivo boletoColectivo) throws Exception {
		TarjetaABM tarjetaABM = new TarjetaABM();
		BoletoColectivoABM boletoColectivoABM = new BoletoColectivoABM();
		ViajeABM viajeABM = new ViajeABM();
		GregorianCalendar fechaHora = new GregorianCalendar();
		if ((tarjeta.getSaldo()-boletoColectivo.getValor()) < -(boletoColectivoABM.traerBoletoMax().getValor()*3)) throw new Exception("Saldo insuficiente");
		tarjeta.setSaldo(tarjeta.getSaldo() - boletoColectivo.getValor());
		tarjetaABM.modificar(tarjeta);
		viajeABM.agregar(fechaHora,boletoColectivo.getValor(),tarjeta,this);
	}
}
