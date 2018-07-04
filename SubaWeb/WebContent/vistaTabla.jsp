<%@page import="negocio.EstacionABM"%>
<%@page import="negocio.LineaColectivoABM"%>
<%@page import="negocio.MaquinaABM"%>
<%@page import="datos.Maquina"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="negocio.ViajeABM"%>
<%@page import="java.util.List"%>
<%@page import="funciones.Funciones"%>
<%@page import="negocio.TarjetaABM"%>
<%@page import="negocio.UsuarioABM"%>
<%@page import="datos.Viaje"%>
<div class="card mb-3">
	        <div class="card-header" style="background:#81BEF7;">
	          <i class="fa fa-table"></i> Movimientos de todos los pasajeros realizados</div>
		        <div class="card-body">
		          <div class="table-responsive">
		            <table class="table table-bordered" id="dataTable">
		              <thead>
		                <tr>
		                  <th>Id viaje</th>
		                  <th>Usuario</th>
		                  <th>Tarjeta</th>
		                  <th>Fecha Hora</th>
		                  <th>Valor</th>
		                  <th>Máquina</th>
		                  <th>Estacion / Colectivo</th>	
		                </tr>
		              </thead>
		              <tfoot>
		                <tr>
		                  <th>Id viaje</th>
		                  <th>Usuario</th>
		                  <th>Tarjeta</th>
		                  <th>Fecha Hora</th>
		                  <th>Valor</th>
		                  <th>Máquina</th>
		                  <th>Estacion / Colectivo</th>
		                </tr>
		              </tfoot>
		              <tbody>
		              
		             <% String f1 = (String)request.getAttribute("fecha1");
			          	String f2 = (String)request.getAttribute("fecha2");
			          	GregorianCalendar fecha1 = Funciones.traerFechaInput(f1);
			          	GregorianCalendar fecha2 = Funciones.traerFechaInput(f2);
		              List<Viaje> viajes = ViajeABM.getInstancia().traerPorTransporte(fecha1, fecha2);
		              for (Viaje viaje: viajes) { %>
		              	<tr>
		              	  <td><%= viaje.getIdViaje() %></td>
		              	  <td><%= UsuarioABM.getInstancia().traerUsuario(TarjetaABM.getInstancia().traerTarjeta(viaje.getTarjeta().getIdTarjeta()).getUsuario().getIdUsuario()).getApellido()%></td>
		                  <td><%= TarjetaABM.getInstancia().traerTarjeta(viaje.getTarjeta().getIdTarjeta()).getNroTarjeta()%></td>
		                  <td><%= Funciones.traerFechaCortaHora(viaje.getFechaHora())%></td>
		                  <% if (viaje.getValor() >= 0) { %>
		                  	<td style="color:red;"><%= viaje.getValor() * -1 %></td>
		                  <% }  else {%>
		                  	<td style="color:green;"><%= viaje.getValor() * -1 %></td>
		                  <% } %>
		                  <td><%= viaje.getMaquina().getIdMaquina() %></td>
		                  <% Maquina m = MaquinaABM.getInstancia().traerMaquina(viaje.getMaquina().getIdMaquina());
		                  	if (m.getTipo() == 0) { %>
		                  		<td><%= LineaColectivoABM.getInstancia().traerLineaColectivoPorMaquina(m).getLinea() %></td>
		                  <% } else { %>
		                  		<td><%= EstacionABM.getInstancia().traerEstacionPorMaquina(m).getNombre() %></td>
		                  <% } %>
		                 </tr>
		             	<% } %>
		              </tbody>
		            </table>
		          </div>
		        </div>
	        <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
	      </div>