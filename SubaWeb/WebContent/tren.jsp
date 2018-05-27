<%@page import="datos.Maquina"%>
<%@page import="negocio.MaquinaABM"%>
<%@page import="datos.Estacion"%>
<%@page import="java.util.List"%>
<%@page import="negocio.EstacionABM"%>
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
  <title>Sistema Suba - Tren</title>
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
 	$(document).ready(function(){
	    $('#boton').click(function(){
	    	var estacion = $('option').val();
	    	$.ajax({
	    		method: "POST",
	    		url: "Viajes",
	    		data: {estacion: estacion},
	    		async: false
	    	}).done(function(data) {
	    		$("#estacion").html(data);
	    	})
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
	          		<a href="#">Tren</a>
	        	</li>
	        	<li class="breadcrumb-item active"> <%= usu.getNombre() %> <%= usu.getApellido() %> </li>
	      	</ol>
	      	
	      	<div class="card mb-3">
	            <div class="card-header" style="background:#81BEF7;">
	              <i class="fa fa-train"></i> Estacion de ingreso</div>
	            <select>
		      		<% 	EstacionABM abm = new EstacionABM();
		      			MaquinaABM mabm = new MaquinaABM();
		      			List<Estacion> estaciones = abm.traerEstaciones();
		      			for (Estacion estacion: estaciones) {%>
		      				<option><%= estacion.getNombre() %></option>
		      			<% } %>
		      	</select>
	      		<input id="boton" type="submit" value="Viajar">
          	</div>
	          
          	<div class="card text-white bg-success o-hidden h-100">
	            <div class="card-body">
	              <div style="text-align: center;">Saldo actual: <%= tar.getSaldo() %></div>
	            </div>
          	</div>
	     </div>
		<%@include file="pie.jsp" %>
	</div>
</body>
</html>