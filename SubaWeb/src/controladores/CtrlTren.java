package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Estacion;
import datos.Maquina;
import datos.MaquinaTren;
import datos.Tarjeta;
import funciones.Funciones;
import negocio.EstacionABM;
import negocio.MaquinaABM;
import negocio.TarifaTrenABM;

public class CtrlTren extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String e = request.getParameter("estacion");
			Estacion estacion = EstacionABM.getInstancia().traerEstacion(e);
			
			Maquina maq = MaquinaABM.getInstancia().traerMaquinaPorEstacion(estacion);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			
			if(tar.isActiva()) {
				MaquinaABM.getInstancia().cobrarTren(tar, (MaquinaTren)maq, new GregorianCalendar());
				request.getRequestDispatcher("/tabla.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("/tren.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getSession().setAttribute("saldo", 0);
			request.getRequestDispatcher("/tren.jsp").forward(request, response);
		}
	}
}