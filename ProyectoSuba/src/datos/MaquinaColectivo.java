package datos;
import negocio.TarjetaABM;
import negocio.BoletoColectivoABM;
import negocio.ViajeABM;
import negocio.RedSubeABM;
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

	@Override
	public void cobrar(Tarjeta tarjeta, Object boleto) throws Exception {
		TarjetaABM tarjetaABM = new TarjetaABM();
		BoletoColectivoABM boletoColectivoABM = new BoletoColectivoABM();
		ViajeABM viajeABM = new ViajeABM();
		RedSubeABM redSubeABM = new RedSubeABM();
		GregorianCalendar fechaHora = new GregorianCalendar();
		BoletoColectivo boletoColectivo = (BoletoColectivo) boleto;
		float tarifa=0;
		
		if (tarjeta.getViajesGratisRestantes()<1) {
			if (tarjeta.getEstacionIngreso()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())>7200000)
				tarjeta.setEstacionIngreso(null);
			if ((tarjeta.getSaldo()-boletoColectivo.getValor()) < -(boletoColectivoABM.traerBoletoMax().getValor()*3))
				throw new Exception("Saldo insuficiente");
			tarjeta.setUltHoraViaje(fechaHora);
			if (tarjeta.getEstadoRedSube()!=null &&
					(fechaHora.getTime().getTime()-tarjeta.getUltHoraViaje().getTime().getTime())<=7200000) {
				tarifa = boletoColectivo.getValor() * tarjeta.getEstadoRedSube().getPorcentajeDescuento();
				if (tarjeta.getEstadoRedSube().getIdRedSube()==1) tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(2));
				else {
					tarjeta.setNumeroViaje(tarjeta.getNumeroViaje()+1);
					if (tarjeta.getNumeroViaje()>4) {
						tarjeta.setNumeroViaje(0);
						tarjeta.setEstadoRedSube(null);
					}
				}
			}
			else {
				tarifa = boletoColectivo.getValor();
				tarjeta.setEstadoRedSube(redSubeABM.traerRedSube(1));
				tarjeta.setNumeroViaje(1);
			}
			if (tarjeta.getTarifaSocial()!=null) tarifa = tarifa * tarjeta.getTarifaSocial().getPorcentajeDescuento();
			tarjeta.setSaldo(tarjeta.getSaldo()-tarifa);
			tarjetaABM.modificar(tarjeta);
		}
		else tarjeta.setViajesGratisRestantes(tarjeta.getViajesGratisRestantes()-1);
		viajeABM.agregar(fechaHora,tarifa,tarjeta,this);
	}
}
