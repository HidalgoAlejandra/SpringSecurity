<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CSS only -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<!-- CSS DataTables -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
    <!-- JS DatatTables -->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
	
	<title>Accidentabilidad</title>
	<style type="text/css">
		
	</style>
	<script>
		$(document).ready(function () {
		    let table = $('#tabla-accidentabilidad').DataTable();
		});
	</script>
	<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>
<body>
	<div class="accidentabilidad-wrapper">
		<h2>Lista de Accidentes En Los Últimos 3 Meses</h2>
		<table id="tabla-accidentabilidad">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Fecha</th>
					<th>Involucrado</th>
					<th>Actividad</th>
					<th>Lugar</th>
					<th>Descripción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accidentes}" var="accidente">
					
					<tr>
					
					<c:forEach items="${clientes}" var="cliente">
						
						<c:if test="${cliente.getId_cliente() == accidente.getId_cliente()}">
						
							<td>${cliente.getRazon_social()}</td>
							
						</c:if>
						
					</c:forEach>
						
						<td>${accidente.getFechaAccidente()}</td>
						<td>${accidente.getInvolucrado()}</td>
						<td>${accidente.getActividad()}</td>
						<td>${accidente.getLugar()}</td>
						<td>${accidente.getDescripcion()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			 <a class="btn btn-outline-primary" href="BAdministrador">Volver Inicio</a>
		</div>
	</div>
	<br/>
<br/>
<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>
</html>