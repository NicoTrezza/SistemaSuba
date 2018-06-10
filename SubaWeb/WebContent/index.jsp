<%@page import="negocio.EstacionABM"%>
<%@page import="datos.Estacion"%>
<%@page import="java.util.List"%>
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
  <title>Sistema Suba - Principal</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		$('#mostrarTarjeta').hide();
  		$('#mostrarSaldo').hide();
  		$('#tarjeta').mouseover(function() {
  			$('#mostrarTarjeta').show();
  			$('#mostrarSaldo').hide();
  		});
  		$('#saldo').mouseover(function() {
  			$('#mostrarSaldo').show();
  			$('#mostrarTarjeta').hide();
  		});
  	});
  </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="cabecera.jsp" %>
	<div class="content-wrapper">
	    <div class="container-fluid">
	    	<% Usuario usu = (Usuario) request.getSession().getAttribute("usuario"); 
	    	Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");%>
			<ol class="breadcrumb">
	      		<li class="breadcrumb-item">
	          		<a href="#">Principal</a>
	        	</li>
	        	<li class="breadcrumb-item active"><%= usu.getNombre() %> <%= usu.getApellido() %></li>
	      	</ol>
	        <div class="row">
		        <div class="col-xl-6 col-sm-6 mb-3">
		          <div class="card text-white bg-primary o-hidden h-100">
		            <div class="card-body">
		              <div class="card-body-icon">
		                <i class="fa fa-fw "></i>
		              </div>
		              <div class="mr-5">Numero de Tarjeta: <%= tar.getNroTarjeta() %></div>
		            </div>
		            <a id="tarjeta" class="card-footer text-white clearfix small z-1" href="#">
		              <span class="float-left">Ver mas datos</span>
		              <span class="float-right">
		                <i class="fa fa-angle-right"></i>
		              </span>
		            </a>
		          </div>
		        </div>
		        <div class="col-xl-6 col-sm-6 mb-3">
		          <div class="card text-white bg-success o-hidden h-100">
		            <div class="card-body">
		              <div class="card-body-icon">
		                <i class="fa fa-fw "></i>
		              </div>
		              <div class="mr-5">Saldo actual: <%= tar.getSaldo() %></div>
		            </div>
		            <a id="saldo" class="card-footer text-white clearfix small z-1" href="#">
		              <span class="float-left">Recargar saldo</span>
		              <span class="float-right">
		                <i class="fa fa-angle-right"></i>
		              </span>
		            </a>
		          </div>
		        </div>
	        </div>
	        <div class="row">
		        <div id="mostrarTarjeta" class="col-xl-12 col-sm-6 mb-3">
		          <div>
		            <div class="card-body">
		              <div class="card-body-icon">
		                <i class="fa fa-fw "></i>
		              </div>
		              <div>
		              	<h6> Boleto Estudiantil: </h6>
					  	<% if (tar.getBoletoEstudiantil() == null) { %>
					  		<%= tar.getBoletoEstudiantil() %>
					  	<%} else { %>
					  		<h6> Activado </h6><br>
					  	<% } %>
					  	<h6> Tarifa Social: </h6>
					  	<% if (tar.getTarifaSocial() == null) { %>
					  		<h6> Desactivado </h6>
					  		<%= tar.getTarifaSocial() %>
					  	<%} else { %>
					  		<h6> Activado </h6>
					  	<% } %>
					  </div>
		            </div>
		          </div>
		        </div>
		        <div id="mostrarSaldo" class="col-xl-12 col-sm-6 mb-3">
		          <div>
		            <div class="card-body">
		              <div class="card-body-icon">
		                <i class="fa fa-fw "></i>
		              </div>
		              <div>
		              <form method="post" action="/SubaWeb/Carga">
		              	<div class="card mb-3">
				            <div class="card-header" style="background:#81BEF7;">
			            	  <i class="fa fa-train"></i> Estacion</div>
				            <select name="estacion">
					      		<% List<Estacion> estaciones = EstacionABM.getInstancia().traerEstacionesTren();
					      			for (Estacion estacion: estaciones) { %>
					      					<option><%= estacion.getNombre() %></option>
					      			<% } %>
					      	</select>
					      	<div class="card-header" style="background:#81BEF7;">
			            	  <i class="fa fa-money"></i> Saldo a cargar</div>
					      	<input name="saldo" type="text" placeholder="Saldo">
				      		<input id="boton" type="submit" value="Cargar">
			          	</div>
			          </form>
		              </div>
		            </div>
		          </div>
		        </div>
	        </div>
        </div>
        <%@include file="pie.jsp" %>
	</div>
</body>
</html>