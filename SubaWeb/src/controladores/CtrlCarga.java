package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Estacion;
import datos.Maquina;
import datos.Tarjeta;
import negocio.EstacionABM;
import negocio.MaquinaABM;

public class CtrlCarga extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			String e = request.getParameter("estacion");
			float s = Float.parseFloat(request.getParameter("saldo"));
			
			Estacion estacion = EstacionABM.getInstancia().traerEstacion(e);
			
			Maquina maq = MaquinaABM.getInstancia().traerMaquinaPorEstacion(estacion);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			maq.cargar(tar, s);
						
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}