package test;
import datos.SubeVirtual;
import java.util.GregorianCalendar;
import negocio.TarifaSocialABM;
import negocio.BoletoEstudiantilABM;
import negocio.RedSubeABM;
import negocio.TarjetaABM;
import negocio.TipoIdentificacionABM;
import negocio.PermisoABM;
import negocio.UsuarioABM;

public class TestMain {

	public static void main(String[] args) {
		TarifaSocialABM tarifaSocialABM = new TarifaSocialABM();
		BoletoEstudiantilABM boletoEstudiantilABM = new BoletoEstudiantilABM();
		RedSubeABM redSubeABM = new RedSubeABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		TipoIdentificacionABM tipoIdentificacionABM = new TipoIdentificacionABM();
		PermisoABM permisoABM = new PermisoABM();
		UsuarioABM usuarioABM = new UsuarioABM();
		
		try {
			//tarifaSocialABM.agregar((float)45.5);
			//boletoEstudiantilABM.agregar("Secundario",60,3,600,2000,2,6);
			//redSubeABM.agregar(50);
			//redSubeABM.agregar(25);
			//tarjetaABM.agregar(130,0,true,null);
			//tipoIdentificacionABM.agregar("Documento Nacional de Identidad");
			//permisoABM.agregar(0, "Administrador");
			//usuarioABM.agregar("Juan","Perez",'M',33444555,4555,"a@a.com",1166882233,44446666,
			//		tipoIdentificacionABM.traerTipoIdentificacion(1),permisoABM.traerPermisoPorNivel(0),
			//		tarifaSocialABM.traerTarifaSocial(1),null);
			//usuarioABM.traerUsuario(1).registrarTarjeta(tarjetaABM.traerTarjetaPorNumero(130));
			
			SubeVirtual subeVirtual = new SubeVirtual(130,0,true,new GregorianCalendar(),
					tarifaSocialABM.traerTarifaSocial(1),boletoEstudiantilABM.traerBoletoEstudiantil(1),null);
			
			System.out.println(tarifaSocialABM.traerTarifaSocial(1).toString());
			System.out.println(boletoEstudiantilABM.traerBoletoEstudiantil(1).toString());
			System.out.println(redSubeABM.traerRedSube(1).toString());
			System.out.println(redSubeABM.traerRedSube(2).toString());
			System.out.println(tarjetaABM.traerTarjetaPorNumero(130).toString());
			System.out.println(tipoIdentificacionABM.traerTipoIdentificacion(1).toString());
			System.out.println(permisoABM.traerPermisoPorNivel(0).toString());
			System.out.println(usuarioABM.traerUsuario(1).toString());
			
			System.out.println(subeVirtual.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
