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
import negocio.LineaABM;
import negocio.EstacionABM;
import negocio.TarifaTrenABM;
import negocio.BoletoTrenABM;
import datos.Tarjeta;
import datos.Usuario;
import datos.MaquinaColectivo;
import datos.MaquinaTren;
import datos.Maquina;

public class TestMain {

	public static void main(String[] args) {
		TarifaSocialABM tarifaSocialABM = TarifaSocialABM.getInstancia();
		BoletoEstudiantilABM boletoEstudiantilABM = BoletoEstudiantilABM.getInstancia();
		RedSubeABM redSubeABM = RedSubeABM.getInstancia();
		TarjetaABM tarjetaABM = TarjetaABM.getInstancia();
		TipoIdentificacionABM tipoIdentificacionABM = TipoIdentificacionABM.getInstancia();
		PermisoABM permisoABM = PermisoABM.getInstancia();
		UsuarioABM usuarioABM = UsuarioABM.getInstancia();
		UsuarioBoletoEstudiantilABM usuarioBoletoEstudiantilABM = UsuarioBoletoEstudiantilABM.getInstancia();
		BoletoColectivoABM boletoColectivoABM = BoletoColectivoABM.getInstancia();
		MaquinaABM maquinaABM = MaquinaABM.getInstancia();
		LineaColectivoABM lineaColectivoABM = LineaColectivoABM.getInstancia();
		LineaABM lineaABM = LineaABM.getInstancia();
		EstacionABM estacionABM = EstacionABM.getInstancia();
		TarifaTrenABM tarifaTrenABM = TarifaTrenABM.getInstancia();
		BoletoTrenABM boletoTrenABM = BoletoTrenABM.getInstancia();
		
		try {
			//tipoIdentificacionABM.agregar("Documento Nacional de Identidad");
			//permisoABM.agregar(0, "Administrador");
			//permisoABM.agregar(1, "Usuario");
			//tarifaSocialABM.agregar((float)0.45);
			/*boletoEstudiantilABM.agregar("Inicial",50,4,500,2300,2,6);
			boletoEstudiantilABM.agregar("Primario",50,4,500,2300,2,6);
			boletoEstudiantilABM.agregar("Secundario",50,4,500,2300,2,6);
			boletoEstudiantilABM.agregar("Terciario",45,0,0,0,2,7);
			boletoEstudiantilABM.agregar("Universitario",45,0,0,0,2,7);*/
			//redSubeABM.agregar((float)0.5);
			//redSubeABM.agregar((float)0.25);
			/*boletoColectivoABM.agregar(1, 9f);
			boletoColectivoABM.agregar(2, 9.25f);
			boletoColectivoABM.agregar(3, 9.50f);
			boletoColectivoABM.agregar(4, 9.75f);
			boletoColectivoABM.agregar(5, 10f);*/
			//lineaColectivoABM.agregar(266);
			//lineaColectivoABM.agregar(160);
			/*MaquinaColectivo maquinaColectivo = new MaquinaColectivo(1,lineaColectivoABM.traerLineaColectivo(1),1);
			maquinaABM.agregar(maquinaColectivo);
			maquinaColectivo.setNumInterno(1);
			maquinaColectivo.setLineaColectivo(lineaColectivoABM.traerLineaColectivo(2));
			maquinaABM.agregar(maquinaColectivo);*/
			/*lineaABM.agregar("Ferrocarril General Roca");
			estacionABM.agregar("Plaza Constitucion",lineaABM.traerLinea(1));
			estacionABM.agregar("Hipolito Yrigoyen",lineaABM.traerLinea(1));
			estacionABM.agregar("Avellaneda",lineaABM.traerLinea(1));
			estacionABM.agregar("Gerli",lineaABM.traerLinea(1));
			estacionABM.agregar("Lanus",lineaABM.traerLinea(1));
			estacionABM.agregar("Remedios de Escalada",lineaABM.traerLinea(1));
			estacionABM.agregar("Banfield",lineaABM.traerLinea(1));
			estacionABM.agregar("Lomas de Zamora",lineaABM.traerLinea(1));
			estacionABM.agregar("Temperley",lineaABM.traerLinea(1));
			estacionABM.agregar("Adrogué",lineaABM.traerLinea(1));
			estacionABM.agregar("Burzaco",lineaABM.traerLinea(1));
			estacionABM.agregar("Longchamps",lineaABM.traerLinea(1));
			estacionABM.agregar("Glew",lineaABM.traerLinea(1));
			estacionABM.agregar("Guernica",lineaABM.traerLinea(1));
			estacionABM.agregar("Alejandro Korn",lineaABM.traerLinea(1));*/
			/*MaquinaTren maquinaTren = new MaquinaTren(estacionABM.traerEstacion("Plaza Constitucion"),2);
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Hipolito Yrigoyen"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Avellaneda"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Gerli"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Lanus"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Remedios de Escalada"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Banfield"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Lomas de Zamora"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Temperley"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Adrogué"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Burzaco"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Longchamps"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Glew"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Guernica"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Alejandro Korn"));
			maquinaABM.agregar(maquinaTren);*/
			/*tarifaTrenABM.agregar(2.75f);
			tarifaTrenABM.agregar(4f);
			tarifaTrenABM.agregar(5.5f);*/
			/*boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(1), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Hipolito Yrigoyen"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(1), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Avellaneda"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(1), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Gerli"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(1), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Lanus"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(1), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Remedios de Escalada"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Banfield"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Lomas de Zamora"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Temperley"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Adrogué"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Burzaco"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(2), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Longchamps"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(3), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Glew"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(3), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Guernica"));
			boletoTrenABM.agregar(tarifaTrenABM.traerTarifaTren(3), estacionABM.traerEstacion("Plaza Constitucion"),
					estacionABM.traerEstacion("Alejandro Korn"));*/
			/*lineaABM.agregar("Linea C");
			estacionABM.agregar("Constitucion",lineaABM.traerLinea(2));
			estacionABM.agregar("San Juan",lineaABM.traerLinea(2));
			estacionABM.agregar("Independencia",lineaABM.traerLinea(2));
			estacionABM.agregar("Moreno",lineaABM.traerLinea(2));
			estacionABM.agregar("Avenida de Mayo",lineaABM.traerLinea(2));
			estacionABM.agregar("Diagonal Norte",lineaABM.traerLinea(2));
			estacionABM.agregar("Lavalle",lineaABM.traerLinea(2));
			estacionABM.agregar("San Martin",lineaABM.traerLinea(2));
			estacionABM.agregar("Retiro",lineaABM.traerLinea(2));*/
			/*MaquinaTren maquinaTren = new MaquinaTren(estacionABM.traerEstacion("Constitucion"),3);
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("San Juan"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Independencia"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Moreno"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Avenida de Mayo"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Diagonal Norte"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Lavalle"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("San Martin"));
			maquinaABM.agregar(maquinaTren);
			maquinaTren.setEstacion(estacionABM.traerEstacion("Retiro"));
			maquinaABM.agregar(maquinaTren);*/
			/*Maquina maquina = new Maquina(4);
			maquinaABM.agregar(maquina);*/
			
			//usuarioABM.agregar("Juan","Perez",'M',33444555,4555,"a@a.com",1166882233,44446666,
			//		tipoIdentificacionABM.traerTipoIdentificacion(1),permisoABM.traerPermisoPorNivel(0),null,null,null);
			/*-------Crear usuario-------*/
			
			//tarjetaABM.agregar(1); //Primero se da de alta la tarjeta en el sistema
			//usuarioABM.registrarTarjeta(usuarioABM.traerUsuario(1),tarjetaABM.traerTarjetaPorNumero(1)); //Y luego se la asigna a un usuario
			/*-------Agregar y asignar tarjeta-------*/
			
			//tarjetaABM.darDeBaja(tarjetaABM.traerTarjetaPorNumero(1));
			/*-------Dar de baja Tarjeta-------*/
			 
			//usuarioABM.solicitarTarifaSocial(usuarioABM.traerUsuario(1),tarifaSocialABM.traerTarifaSocial(1));
			/*-------Beneficio Tarifa Social-------*/
			
			/*usuarioABM.solicitarBoletoEstudiantil(usuarioABM.traerUsuario(1),boletoEstudiantilABM.traerBoletoEstudiantil(1));
			GregorianCalendar fechaActual = new GregorianCalendar(2018,6,17);
			usuarioBoletoEstudiantilABM.agregar(usuarioABM.traerUsuario(1),fechaActual);*/
			/*-------Beneficio Boleto Estudiantil-------*/
			
			/*Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNumero(1);
			Usuario usuario = usuarioABM.traerUsuario(tarjeta.getUsuario().getIdUsuario());
			if (usuario.getTarifaSocial()!=null) tarjeta.setTarifaSocial(usuario.getTarifaSocial());
			if (usuario.getBoletoEstudiantil()!=null) {
				tarjeta.setBoletoEstudiantil(usuario.getBoletoEstudiantil());
				tarjeta.setViajesGratisRestantes(tarjeta.getBoletoEstudiantil().getCantViajesGratis());
			}
			GregorianCalendar fechaHora = new GregorianCalendar();
			maquinaABM.cobrarColectivo(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(1),
					(MaquinaColectivo)maquinaABM.traerMaquina(1),fechaHora);
			maquinaABM.cobrarColectivo(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(1),
					(MaquinaColectivo)maquinaABM.traerMaquina(2),fechaHora);
			maquinaABM.cobrarColectivo(tarjeta, boletoColectivoABM.traerBoletoPorSeccion(3),
					(MaquinaColectivo)maquinaABM.traerMaquina(2),fechaHora);
			System.out.println(tarjeta.toString());*/
			/*-------Cobro en MaquinaColectivo-------*/
			
			/*Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNumero(1);
			Usuario usuario = usuarioABM.traerUsuario(tarjeta.getUsuario().getIdUsuario());
			if (usuario.getTarifaSocial()!=null) tarjeta.setTarifaSocial(usuario.getTarifaSocial());
			if (usuario.getBoletoEstudiantil()!=null) {
				tarjeta.setBoletoEstudiantil(usuario.getBoletoEstudiantil());
				tarjeta.setViajesGratisRestantes(tarjeta.getBoletoEstudiantil().getCantViajesGratis());
			}
			GregorianCalendar fechaHora = new GregorianCalendar();
			maquinaABM.cobrarTren(tarjeta,(MaquinaTren)maquinaABM.traerMaquina(3),fechaHora);
			System.out.println(tarjeta.toString());
			maquinaABM.cobrarTren(tarjeta,(MaquinaTren)maquinaABM.traerMaquina(10),fechaHora);
			System.out.println(tarjeta.toString());*/
			/*-------Cobro en MaquinaTren-------*/
			
			/*Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNumero(1);
			Usuario usuario = usuarioABM.traerUsuario(tarjeta.getUsuario().getIdUsuario());
			if (usuario.getTarifaSocial()!=null) tarjeta.setTarifaSocial(usuario.getTarifaSocial());
			if (usuario.getBoletoEstudiantil()!=null) {
				tarjeta.setBoletoEstudiantil(usuario.getBoletoEstudiantil());
				tarjeta.setViajesGratisRestantes(tarjeta.getBoletoEstudiantil().getCantViajesGratis());
			}
			maquinaABM.cobrarTren(tarjeta,(MaquinaTren)maquinaABM.traerMaquina(26));
			System.out.println(tarjeta.toString());*/
			/*-------Cobro en MaquinaTren(Subte)-------*/
			
			/*Tarjeta tarjeta = tarjetaABM.traerTarjetaPorNumero(1);
			maquinaABM.cargar(tarjeta,100f,maquinaABM.traerMaquina(27));
			System.out.println(tarjeta.toString());*/
			/*-------Carga en Maquina-------*/
			
			/*System.out.println(tarifaSocialABM.traerTarifaSocial(1).toString());
			System.out.println(boletoEstudiantilABM.traerBoletoEstudiantil(1).toString());
			System.out.println(redSubeABM.traerRedSube(1).toString());
			System.out.println(redSubeABM.traerRedSube(2).toString());*/
			//System.out.println(tarjeta.toString());
			System.out.println(usuarioABM.traerUsuario(1).toString());
			System.out.println(usuarioBoletoEstudiantilABM.traerUltimoPorUsuario(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
