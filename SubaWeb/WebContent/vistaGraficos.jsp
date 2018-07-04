<%@page import="java.util.GregorianCalendar"%>
<%@page import="funciones.Funciones"%>
<%@page import="negocio.EstadisticaABM"%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawChart);
	
	<% String f1 = (String)request.getAttribute("fecha1");
	String f2 = (String)request.getAttribute("fecha2");
	GregorianCalendar fecha1 = Funciones.traerFechaInput(f1);
	GregorianCalendar fecha2 = Funciones.traerFechaInput(f2);%>
	
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
	          ['Transporte', 'Monto'],
	          ['Tren', <%= EstadisticaABM.getInstancia().traerMontoEnTren(fecha1, fecha2) %>],
	          ['Colectivo', <%= EstadisticaABM.getInstancia().traerMontoEnColectivo(fecha1, fecha2) %>],
	          ['Subte', <%= EstadisticaABM.getInstancia().traerMontoEnSubte(fecha1, fecha2) %>]
	        ]);
	        var options = {
	          'width':600, 
	          'height':300,
	          is3D: true,
	        };
	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	        chart.draw(data, options);
	
		var data2 = google.visualization.arrayToDataTable([
	        ['Transporte', 'Viajes'],
	        ['Tren', <%= EstadisticaABM.getInstancia().traerViajesEnTren(fecha1, fecha2) %>],
	        ['Colectivo', <%= EstadisticaABM.getInstancia().traerViajesEnColectivo(fecha1, fecha2) %>],
	        ['Subte', <%= EstadisticaABM.getInstancia().traerViajesEnSubte(fecha1, fecha2) %>]
	      ]);
	      var options2 = {
	        'width':600, 
	        'height':300,
	        is3D: true,
	      };
	      var chart = new google.visualization.PieChart(document.getElementById('piechart_3d2'));
	      chart.draw(data2, options2);
	}
</script>

<div class="row">
  <div class="col-lg-6">
    <div class="card mb-3">
      <div class="card-header" style="background:#81BEF7;">
        <i class="fa fa-pie-chart"></i> Monto de viajes por transporte</div>
      	<div id="piechart_3d"></div>
      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
    </div>
  </div>
  <div class="col-lg-6">
    <div class="card mb-3">
      <div class="card-header" style="background:#81BEF7;">
        <i class="fa fa-pie-chart"></i> Cantidad de viajes por transporte</div>
      	<div id="piechart_3d2"></div>
      <div class="card-footer small text-muted">Última actualización <%= Funciones.traerFechaCortaHora(new GregorianCalendar()) %></div>
    </div>
  </div>
 </div>