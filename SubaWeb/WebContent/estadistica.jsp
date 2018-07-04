<%@page import="negocio.EstadisticaABM"%>
<%@page import="negocio.ViajeABM"%>
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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
      google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawChart);
      
      function drawChart() {
    	  var data = google.visualization.arrayToDataTable([
              ['Dia', 'Viajes'],
              ['Lunes', <%= EstadisticaABM.getInstancia().traerViajesDelLunes((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Martes', <%= EstadisticaABM.getInstancia().traerViajesDelMartes((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Miercoles', <%= EstadisticaABM.getInstancia().traerViajesDelMiercoles((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Jueves', <%= EstadisticaABM.getInstancia().traerViajesDelJueves((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Viernes', <%= EstadisticaABM.getInstancia().traerViajesDelViernes((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Sabado', <%= EstadisticaABM.getInstancia().traerViajesDelSabado((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
        	  ['Domingo', <%= EstadisticaABM.getInstancia().traerViajesDelDomingo((Tarjeta) request.getSession().getAttribute("tarjeta")) %>]
            ]);
            var options = {
              vAxis: {title: 'Semana',  titleTextStyle: {color: 'red'}}
            };
            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
            chart.draw(data, options);
            
	        var data2 = google.visualization.arrayToDataTable([
	          ['Transporte', 'Viajes'],
	          ['Tren', <%= EstadisticaABM.getInstancia().traerViajesEnTren((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
	          ['Colectivo', <%= EstadisticaABM.getInstancia().traerViajesEnColectivo((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
	          ['Subte', <%= EstadisticaABM.getInstancia().traerViajesEnSubte((Tarjeta) request.getSession().getAttribute("tarjeta")) %>]
	        ]);
	        var options2 = {
	          'width':600, 
	          'height':300,
	          is3D: true,
	        };
	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	        chart.draw(data2, options2);
	        
	        var data3 = google.visualization.arrayToDataTable([
	          ['Dia', 'Viajes'],
	          ['Dia de semana', <%= EstadisticaABM.getInstancia().traerViajesEnSemana((Tarjeta) request.getSession().getAttribute("tarjeta")) %>],
	          ['Fin de semana', <%= EstadisticaABM.getInstancia().traerViajesEnFinDeSemana((Tarjeta) request.getSession().getAttribute("tarjeta")) %>]
	         ]);
	        var options3 = {
	          'width':600, 
	          'height':300,
	          is3D: true,
	        };
	        var chart = new google.visualization.PieChart(document.getElementById('piecharts_3d'));
	        chart.draw(data3, options3);
      }
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
	          		<a href="#">Estadisticas</a>
	        	</li>
	        	<li class="breadcrumb-item active"> <%= usu.getNombre() %> <%= usu.getApellido() %> </li>
	      	</ol>
	      	
	      	<div class="row">
			  <div class="col-lg-12">
			    <div class="card mb-3">
			      <div class="card-header" style="background:#81BEF7;">
			        <i class="fa fa-bar-chart"></i> Viajes por dia de la semana</div>
			      	<div id="chart_div"></div>
			      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
			    </div>
			  </div>
			</div>
	      	
		  	<div class="row">
			  <div class="col-lg-6">
			    <div class="card mb-3">
			      <div class="card-header" style="background:#81BEF7;">
			        <i class="fa fa-pie-chart"></i> Viajes por transporte</div>
			      	<div id="piechart_3d"></div>
			      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
			    </div>
			  </div>
			  <div class="col-lg-6">
			    <div class="card mb-3">
			      <div class="card-header" style="background:#81BEF7;">
			        <i class="fa fa-pie-chart"></i> Viajes por semana</div>
			      	<div id="piecharts_3d"></div>
			      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
			    </div>
			  </div>
			 </div>
			
	     </div>
		<%@include file="pie.jsp" %>
	</div>
</body>
</html>