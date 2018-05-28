package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Maquina;
import datos.MaquinaTren;
import datos.Tarjeta;
import negocio.MaquinaABM;

public class CtrlSubte extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			MaquinaABM mAbm = new MaquinaABM();
			Maquina maq = mAbm.traerMaquina(3);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			maq.cobrar(tar, 1);
			
			request.getRequestDispatcher("/tabla.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/subte.jsp").forward(request, response);
		}
	}
}
