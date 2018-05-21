package test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import negocio.TarifaSocialABM;
import negocio.BoletoEstudiantilABM;
import negocio.RedSubeABM;
import negocio.TarjetaABM;
import negocio.TipoIdentificacionABM;
import negocio.PermisoABM;
import negocio.UsuarioABM;
import negocio.UsuarioBoletoEstudiantilABM;
import negocio.BoletoColectivoABM;
import negocio.LineaColectivoABM;
import negocio.MaquinaABM;
import datos.Tarjeta;
import datos.Usuario;
import funciones.Funciones;

public class TestMain {

	public static void main(String[] args) {
		TarifaSocialABM tarifaSocialABM = new TarifaSocialABM();
		BoletoEstudiantilABM boletoEstudiantilABM = new BoletoEstudiantilABM();
		RedSubeABM redSubeABM = new RedSubeABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		TipoIdentificacionABM tipoIdentificacionABM = new TipoIdentificacionABM();
		PermisoABM permisoABM = new PermisoABM();
		UsuarioABM usuarioABM = new UsuarioABM();
		UsuarioBoletoEstudiantilABM usuarioBoletoEstudiantilABM = new UsuarioBoletoEstudiantilABM();
		BoletoColectivoABM boletoColectivoABM = new BoletoColectivoABM();
		MaquinaABM maquinaABM = new MaquinaABM();
		LineaColectivoABM lineaColectivoABM = new LineaColectivoABM();
		
		try {
			//tipoIdentificacionABM.agregar("Documento Nacional de Identidad");
			//permisoABM.agregar(0, "Administrador");
			//tarifaSocialABM.agregar((float)0.45);
			//boletoEstudiantilABM.agregar("Inicial",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Primario",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Secundario",50,4,500,2300,2,6);
			//boletoEstudiantilABM.agregar("Terciario",45,0,0,0,2,7);
			//boletoEstudiantilABM.agregar("Universitario",45,0,0,0,2,7);
			//redSubeABM.agregar((float)0.5);
			//redSubeABM.agregar((float)0.25);
			//boletoColectivoABM.agregar(1, 9f);
			//boletoColectivoABM.agregar(2, 9.25f);
			//boletoColectivoABM.agregar(3, 9.50f);
			//boletoColectivoABM.agregar(4, 9.75f);
			//boletoColectivoABM.agregar(5, 10f);
			//lineaColectivoABM.agregar(266);
			//lineaColectivoABM.agregar(160);
			//MaquinaColectivo maquinaColectivo = new MaquinaColectivo(1,lineaColectivoABM.traerLineaColectivo(1));
			//maquinaABM.agregar(maquinaColectivo);
			//maquinaColectivo.setNumInterno(1);
			//maquinaColectivo.setLineaColectivo(lineaColectivoABM.traerLineaColectivo(2));
			//maquinaABM.agregar(maquinaColectivo);
			
			//usuarioABM.agregar("Juan","Perez",'M',33444555,4555,"a@a.com",1166882233,44446666,
			//		tipoIdentificacionABM.traerTipoIdentificacion(1),permisoABM.traerPermisoPorNivel(0),null,null,null);
			/*-------Crear usuario-------*/
			
			//tarjetaABM.agregar(130); //Primero se da de alta la tarjeta en el sistema
			//usuarioABM.traerUsuario(1).registrarTarjeta(tarjetaABM.traerTarjetaPorNumero(130)); //Y luego se la asigna a un usuario
			/*-------Agregar y asignar tarjeta-------*/
			
			//tarjetaABM.traerTarjetaPorNumero(130).darDeBaja();
			/*-------Dar de baja Tarjeta-------*/
			 
			//usuarioABM.traerUsuario(1).solicitarTarifaSocial(tarifaSocialABM.traerTarifaSocial(1));
			/*-------Beneficio Tarifa Social-------*/
			
			//usuarioABM.traerUsuario(1).solicitarBoletoEstudiantil(boletoEstudiantilABM.traerBoletoEstudiantil(1));
			//GregorianCalendar fechaVencimiento = new GregorianCalendar();
			//fechaVencimiento.add(GregorianCalendar.MONTH,1);
			//usuarioBoletoEstudiantilABM.agregar(fechaVencimiento,usuarioABM.traerUsuario(1),
			//		boletoEstudiantilABM.traerBoletoEstudiantil(1));
			/*-------Beneficio Boleto Estudiantil-------*/
			
			//Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNumero(130);
			//Usuario usuario = usuarioABM.traerUsuario(tarjeta.getUsuario().getIdUsuario());
			//if (usuario.getTarifaSocial()!=null) tarjeta.setTarifaSocial(usuario.getTarifaSocial());
			//maquinaABM.traerMaquina(1).cobrar(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(1));
			//maquinaABM.traerMaquina(2).cobrar(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(1));
			//maquinaABM.traerMaquina(2).cobrar(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(3));
			/*-------Cobro en MaquinaColectivo-------*/
			
			/*System.out.println(tarifaSocialABM.traerTarifaSocial(1).toString());
			System.out.println(boletoEstudiantilABM.traerBoletoEstudiantil(1).toString());
			System.out.println(redSubeABM.traerRedSube(1).toString());
			System.out.println(redSubeABM.traerRedSube(2).toString());*/
			//System.out.println(tarjeta.toString());
			System.out.println(usuarioABM.traerUsuario(1).toString());
			System.out.println(usuarioBoletoEstudiantilABM.traerUsuarioBoletoEstudiantil(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
