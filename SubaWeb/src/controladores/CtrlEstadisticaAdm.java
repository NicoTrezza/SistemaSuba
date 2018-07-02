package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funciones.Funciones;
import negocio.ViajeABM;


public class CtrlEstadisticaAdm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String fecha1 = request.getParameter("fechaInicio");
			String fecha2 = request.getParameter("fechaFin");
			
			ViajeABM.getInstancia().traerPorTransporte(Funciones.traerFechaInput(fecha1), Funciones.traerFechaInput(fecha2));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/estadisticaAdm.jsp").forward(request, response);
		}
	}

}
