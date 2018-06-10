package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Usuario;
import negocio.PermisoABM;
import negocio.TarjetaABM;
import negocio.TipoIdentificacionABM;
import negocio.UsuarioABM;

public class CtrlRegistro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String apellido = request.getParameter("apellido");
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String sexo = request.getParameter("sexo");
			int numTar = Integer.parseInt(request.getParameter("numtar"));
			int nroIdentificacion = Integer.parseInt(request.getParameter("dni"));
			long clave = Long.parseLong(request.getParameter("clave"));
			long conclave = Long.parseLong(request.getParameter("conclave"));			
		
			if (clave == conclave) {
				Usuario usu = new Usuario(nombre, apellido, sexo.charAt(0), nroIdentificacion, conclave, email, TipoIdentificacionABM.getInstancia().traerTipoIdentificacion(1), PermisoABM.getInstancia().traerPermisoPorID(2));
				
				UsuarioABM.getInstancia().agregar(usu);
				
				TarjetaABM.getInstancia().agregar(numTar, usu);
				
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/registro.jsp").forward(request, response);
			}		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/registro.jsp").forward(request, response);
		}
	}
}
