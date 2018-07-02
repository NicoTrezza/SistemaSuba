package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import negocio.TarjetaABM;

public class CtrlTarjeta extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Tarjeta t = (Tarjeta) request.getSession().getAttribute("tarjeta");
			
			if (t.isActiva())
				TarjetaABM.getInstancia().darDeBaja(t);
			else 
				TarjetaABM.getInstancia().darDeAlta(t);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
