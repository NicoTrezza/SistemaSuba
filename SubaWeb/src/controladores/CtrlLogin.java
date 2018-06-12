package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Usuario;
import negocio.BoletoEstudiantilABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class CtrlLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String email = request.getParameter("email");
			long clave = Long.parseLong(request.getParameter("clave"));
			Usuario usu = UsuarioABM.getInstancia().traerUsuarioPorClave(clave);
			
			if (email.equals(usu.getEmail())) {
				Tarjeta t = TarjetaABM.getInstancia().traerTarjetaPorUsuario(usu);
				request.getSession().setAttribute("usuario", usu);
		      	request.getSession().setAttribute("tarjeta", t);
		      	request.getSession().setAttribute("saldo", 1);
			
		      	
		      	
		      	if (usu.getTarifaSocial() != null) 
		      		t.setTarifaSocial(usu.getTarifaSocial());
				if (usu.getBoletoEstudiantil() != null) {
					t.setBoletoEstudiantil(BoletoEstudiantilABM.getInstancia().traerBoletoEstudiantil(usu.getBoletoEstudiantil().getIdBoletoEstudiantil()));
					t.setViajesGratisRestantes(t.getBoletoEstudiantil().getCantViajesGratis());
				}
		      	
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
