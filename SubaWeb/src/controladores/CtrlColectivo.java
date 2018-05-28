package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.BoletoColectivo;
import datos.LineaColectivo;
import datos.Maquina;
import datos.Tarjeta;
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
			int s = Integer.parseInt(request.getParameter("seccion"));
			
			LineaColectivoABM lAbm = new LineaColectivoABM();
			LineaColectivo linea = lAbm.traerPorLineaColectivo(l);
						
			BoletoColectivoABM bAbm = new BoletoColectivoABM();
			BoletoColectivo boleto = bAbm.traerBoletoPorSeccion(s);
			
			MaquinaABM mAbm = new MaquinaABM();
			Maquina maq = mAbm.traerMaquinaPorLinea(linea);
			
			Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
			maq.cobrar(tar, boleto);
			
			request.getRequestDispatcher("/tabla.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/colectivo.jsp").forward(request, response);
		}
	}
}

