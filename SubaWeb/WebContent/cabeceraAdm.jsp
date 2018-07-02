<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
  	<img src="css/index.png" height="45" width="45">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <form class="navbar-nav navbar-sidenav" id="exampleAccordion">
      	<div class="nav-item" data-toggle="tooltip" data-placement="right" title="Menú principal">
          <a class="nav-link" href="indexAdm.jsp">
            <i class="fa fa-fw fa-home"></i>
            <span class="nav-link-text">Menú principal</span>
          </a>
        </div>
        <div class="nav-item" data-toggle="tooltip" data-placement="right" title="Estadisticas de viajes">
          <a class="nav-link" href="estadisticaAdm.jsp">
            <i class="fa fa-fw fa-area-chart"></i>
            <span class="nav-link-text">Estadísticas</span>
          </a>
        </div>
        <div class="nav-item" data-toggle="tooltip" data-placement="right" title="Movimientos realizados">
          <a class="nav-link" href="tablaAdm.jsp">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Movimientos</span>
          </a>
        </div>
      </form>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
      	<li class="nav-item">
            <a class="navbar-brand" href="index.jsp">Orientacion a Objetos II - Sistema Suba</a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
      	<li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Salir</a>
        </li>
      </ul>
    </div>
  </nav>