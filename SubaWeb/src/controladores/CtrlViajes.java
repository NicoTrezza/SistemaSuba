package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Estacion;
import datos.Maquina;
import datos.Tarjeta;
import negocio.EstacionABM;
import negocio.MaquinaABM;
import negocio.TarjetaABM;

public class CtrlViajes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String e = request.getParameter("estacion");
			
			EstacionABM eAbm = new EstacionABM();
			Estacion estacion = eAbm.traerEstacion(e);
			
			MaquinaABM mAbm = new MaquinaABM();
			Maquina maq = mAbm.traerMaquinaPorEstacion(estacion);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			maq.cobrar(tar);
						
			request.getRequestDispatcher("/tabla.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/tren.jsp").forward(request, response);
		}
	}
}