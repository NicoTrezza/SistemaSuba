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
      <div class="card-header" style="color:red;">Datos incorrectos - Intente de nuevo</div>
      <div class="card-body">
        <form method="post" action="/SubaWeb/Login">
          <div class="form-group">
            <label for="exampleInputEmail1" >Dirección de email</label>            	
            <input class="form-control" name="email" type="email" aria-describedby="emailHelp" placeholder="nombreapellido@suba.com">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Clave</label>
            <input class="form-control" name="clave" type="password" placeholder="Contraseña">
          </div>
          <input class="btn btn-primary btn-block" type="submit" value="Entrar">
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="registro.jsp">Registrarse</a>
        </div>
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