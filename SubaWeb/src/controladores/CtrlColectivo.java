package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.BoletoColectivo;
import datos.LineaColectivo;
import datos.Maquina;
import datos.MaquinaColectivo;
import datos.Tarjeta;
import funciones.Funciones;
import negocio.BoletoColectivoABM;
import negocio.LineaColectivoABM;
import negocio.MaquinaABM;

public class CtrlColectivo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			int l = Integer.parseInt(request.getParameter("linea"));
			float s = Float.parseFloat(request.getParameter("seccion"));
			
			LineaColectivo linea = LineaColectivoABM.getInstancia().traerPorLineaColectivo(l);
						
			BoletoColectivo boleto = BoletoColectivoABM.getInstancia().traerBoletoPorValor(s);
			
			Maquina maq = MaquinaABM.getInstancia().traerMaquinaPorLinea(linea);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			
			if (tar.isActiva()) {
				MaquinaABM.getInstancia().cobrarColectivo(tar, boleto, (MaquinaColectivo)maq, new GregorianCalendar());
				request.getRequestDispatcher("/tabla.jsp").forward(request, response);
			}
			else 
				request.getRequestDispatcher("/colectivo.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getSession().setAttribute("saldo", 0);
			request.getRequestDispatcher("/colectivo.jsp").forward(request, response);
		}
	}
}

