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
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="cabeceraAdm.jsp" %>
	<div class="content-wrapper">
	    <div class="container-fluid">
	   		<% Usuario usu = (Usuario) request.getSession().getAttribute("usuario");%>
			<ol class="breadcrumb">
	      		<li class="breadcrumb-item">
	          		<a href="#">Estadisticas</a>
	        	</li>
	        	<li class="breadcrumb-item active"> <%= usu.getNombre() %> <%= usu.getApellido() %> </li>
	      	</ol>
			
			<form method="post" action="/SubaWeb/EstadisticaAdm">
				<label>Fecha inicial: </label> <input type="text" id="calendario" name="fechaInicio">
				<label>Fecha final: </label> <input type="text" id="calendario2" name="fechaFin">
				<input id="boton" type="submit" value="Mostrar">
			</form>
			
	     </div>
		<%@include file="pie.jsp" %>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	 $( function() {
	 	$( "#calendario" ).datepicker();
	 } );
	 
	 $( function() {
		$( "#calendario2" ).datepicker();
	 } );
	</script>
</body>
</html>