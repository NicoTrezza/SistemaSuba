package test;
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
			//tipoIdentificacionABM.agregar("Documento Nacional de Identidad");
			//permisoABM.agregar(0, "Administrador");
			//tarifaSocialABM.agregar((float)45.5);
			//boletoEstudiantilABM.agregar("Inicial",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Primario",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Secundario",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Terciario",45,0,0,0,2,7);
			//boletoEstudiantilABM.agregar("Universitario",45,0,0,0,2,7);
			//redSubeABM.agregar(50);
			//redSubeABM.agregar(25);
			
			//usuarioABM.agregar("Juan","Perez",'M',33444555,4555,"a@a.com",1166882233,44446666,
			//		tipoIdentificacionABM.traerTipoIdentificacion(1),permisoABM.traerPermisoPorNivel(0),null,null);
			/*-------Crear usuario-------*/
			
			//tarjetaABM.agregar(130,0,true,null); //Primero se da de alta la tarjeta en el sistema
			//usuarioABM.traerUsuario(1).registrarTarjeta(tarjetaABM.traerTarjetaPorNumero(130)); //Y luego se la asigna a un usuario
			/*-------Agregar y asignar tarjeta-------*/
			 
			//usuarioABM.traerUsuario(1).otorgarTarifaSocial(tarifaSocialABM.traerTarifaSocial(1));
			/*-------Beneficio Tarifa Social-------*/
			
			//
			/*-------Beneficio Boleto Estudiantil-------*/
			
			//tarjetaABM.traerTarjetaPorNumero(130).darDeBaja();
			/*-------Dar de baja Tarjeta-------*/
			
			/*SubeVirtual subeVirtual = new SubeVirtual(130,0,true,new GregorianCalendar(),
					tarifaSocialABM.traerTarifaSocial(1),boletoEstudiantilABM.traerBoletoEstudiantil(1),null);*/
			
			/*System.out.println(tarifaSocialABM.traerTarifaSocial(1).toString());
			System.out.println(boletoEstudiantilABM.traerBoletoEstudiantil(1).toString());
			System.out.println(redSubeABM.traerRedSube(1).toString());
			System.out.println(redSubeABM.traerRedSube(2).toString());
			System.out.println(tarjetaABM.traerTarjetaPorNumero(130).toString());*/
			System.out.println(usuarioABM.traerUsuario(1).toString());
			
			//System.out.println(subeVirtual.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
