package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Usuario;
import funciones.Funciones;
import negocio.BoletoEstudiantilABM;
import negocio.UsuarioBoletoEstudiantilABM;

public class CtrlBoletoE extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			String e = request.getParameter("boleto");
			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			Tarjeta t = (Tarjeta) request.getSession().getAttribute("tarjeta");
			
			u.solicitarBoletoEstudiantil(BoletoEstudiantilABM.getInstancia().traerBoletoEstudiantil(e));
			
			UsuarioBoletoEstudiantilABM.getInstancia().agregar(Funciones.traerFechaProximo(new GregorianCalendar(), 30), u, BoletoEstudiantilABM.getInstancia().traerBoletoEstudiantil(e));
			
			if (u.getBoletoEstudiantil() != null) {
				t.setBoletoEstudiantil(BoletoEstudiantilABM.getInstancia().traerBoletoEstudiantil(u.getBoletoEstudiantil().getIdBoletoEstudiantil()));
				t.setViajesGratisRestantes(t.getBoletoEstudiantil().getCantViajesGratis());
			}
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
