<%@page import="negocio.LineaColectivoABM"%>
<%@page import="datos.Maquina"%>
<%@page import="datos.MaquinaTren"%>
<%@page import="negocio.MaquinaABM"%>
<%@page import="datos.Estacion"%>
<%@page import="negocio.EstacionABM"%>
<%@page import="negocio.CargaABM"%>
<%@page import="datos.Carga"%>
<%@page import="funciones.Funciones"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.List"%>
<%@page import="datos.Viaje"%>
<%@page import="negocio.ViajeABM"%>
<%@page import="datos.Tarjeta"%>
<%@page import="datos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Sistema Suba - Tablas</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="cabecera.jsp" %>
	<div class="content-wrapper">
	    <div class="container-fluid">
			<% Usuario usu = (Usuario) request.getSession().getAttribute("usuario"); 
	    	Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");
	    	List<Viaje> viajes = ViajeABM.getInstancia().traerViajes();
	    	List<Carga> cargas = CargaABM.getInstancia().traerCargas();%>
			<ol class="breadcrumb">
	      		<li class="breadcrumb-item">
	          		<a href="#">Tablas</a>
	        	</li>
	        	<li class="breadcrumb-item active"> <%= usu.getNombre() %> <%= usu.getApellido() %> </li>
	      	</ol>
	      	<div class="card mb-3">
	        <div class="card-header" style="background:#81BEF7;">
	          <i class="fa fa-table"></i> Movimientos realizados</div>
		        <div class="card-body">
		          <div class="table-responsive">
		            <table class="table table-bordered" id="dataTable">
		              <thead>
		                <tr>
		                  <th>Id viaje</th>
		                  <th>Fecha Hora</th>
		                  <th>Valor</th>
		                  <th>Máquina</th>
		                  <th>Estacion / Colectivo</th>	
		                </tr>
		              </thead>
		              <tfoot>
		                <tr>
		                  <th>Id viaje</th>
		                  <th>Fecha Hora</th>
		                  <th>Valor</th>
		                  <th>Máquina</th>
		                  <th>Estacion / Colectivo</th>
		                </tr>
		              </tfoot>
		              <tbody>
		              <% for (Viaje viaje: viajes) { 
		              	if (viaje.getTarjeta().getIdTarjeta() == tar.getIdTarjeta()) { %>
		              	<tr>
		              	  <td><%= viaje.getIdViaje() %></td>
		                  <td><%= Funciones.traerFechaCortaHora(viaje.getFechaHora())%></td>
		                  <% if (viaje.getValor() * -1 < 0) { %>
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
		             	<% } 
		              	} %>
		              </tbody>
		            </table>
		          </div>
		        </div>
	        <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
	      </div>
	     </div>
		<%@include file="pie.jsp" %>
	</div>
</body>
</html>