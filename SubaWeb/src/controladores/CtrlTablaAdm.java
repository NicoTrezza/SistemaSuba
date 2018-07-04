package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CtrlTablaAdm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String fecha1 = request.getParameter("fecha1");
			String fecha2 = request.getParameter("fecha2");
			
			request.setAttribute("fecha1", fecha1);
			request.setAttribute("fecha2", fecha2);
			request.getRequestDispatcher("/vistaTabla.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/estadisticaAdm.jsp").forward(request, response);
		}
	}

}
