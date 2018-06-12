package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Usuario;
import negocio.TarifaSocialABM;

public class CtrlTarifaS extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			Tarjeta t = (Tarjeta) request.getSession().getAttribute("tarjeta");
			
			u.solicitarTarifaSocial(TarifaSocialABM.getInstancia().traerTarifaSocial(1));
			
			if (u.getTarifaSocial() != null) 
	      		t.setTarifaSocial(u.getTarifaSocial());
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}