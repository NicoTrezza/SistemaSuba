<%@page import="java.util.GregorianCalendar"%>
<%@page import="funciones.Funciones"%>
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
  <title>Sistema Suba - Estadisticas</title>
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
	    	Tarjeta tar = (Tarjeta) request.getSession().getAttribute("tarjeta");%>
			<ol class="breadcrumb">
	      		<li class="breadcrumb-item">
	          		<a href="#">Estadisticas</a>
	        	</li>
	        	<li class="breadcrumb-item active"> <%= usu.getNombre() %> <%= usu.getApellido() %> </li>
	      	</ol>
	      	        
    		<div class="card mb-3">
	     	  <div class="card-header" style="background:#81BEF7;">
		         <i class="fa fa-area-chart"></i> Area Chart Example</div>
		      <div class="card-body">
		      	<canvas id="myAreaChart" width="100%" height="30"></canvas>
		      </div>
		      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
		  	</div>
		  	
			<div class="row">
			  <div class="col-lg-8">
			    <!-- Example Bar Chart Card-->
			    <div class="card mb-3">
			      <div class="card-header" style="background:#81BEF7;">
			        <i class="fa fa-bar-chart"></i> Viajes por semana</div>
			      <div class="card-body">
			        <canvas id="myBarChart" width="100" height="50"></canvas>
			      </div>
			      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
			    </div>
			  </div>
			  <div class="col-lg-4">
			    <!-- Example Pie Chart Card-->
			    <div class="card mb-3">
			      <div class="card-header" style="background:#81BEF7;">
			        <i class="fa fa-pie-chart"></i> Transportes mas utilizados</div>
			      <div class="card-body">
			        <canvas id="myPieChart" width="100%" height="100"></canvas>
			      </div>
			      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
			    </div>
			  </div>
			</div>
	     </div>
		<%@include file="pie.jsp" %>
	</div>
</body>
</html>