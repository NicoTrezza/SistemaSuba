<%@page import="datos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Sistema Suba - Ingreso</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5 ingreso">
    <% Usuario usu = (Usuario) request.getSession().getAttribute("usuario");  %>
      <div class="card-header"> Bienvenido <%= usu.getNombre() %> <%= usu.getApellido() %></div>
      <div class="card-body">
          <a class="nav-link" href="tablaAdm.jsp">
            <i class="fa fa-fw fa-home"></i>
            <span class="nav-link-text">Entrar como Administrador</span>
          </a>
          <a class="nav-link" href="index.jsp">
            <i class="fa fa-fw fa-home"></i>
            <span class="nav-link-text">Entrar como Usuario</span>
          </a>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>