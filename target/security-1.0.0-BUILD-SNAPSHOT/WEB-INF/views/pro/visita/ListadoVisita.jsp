<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Listado Visita</title>
</head>
<body>
<div class="banner"></div>

	<h1 class="text-center">Visitas</h1>
	<div class="wrapper">
	<table class="table table-bordered dt-responsive nowrap">
		<thead>
			<tr>
				<th class="text-center"><b>ID Visita</b></th>
				<th class="text-center"><b>ID asesoria</b></th>
				<th class="text-center"><b>Fecha Visita</b></th>
				<th class="text-center"><b>Estado Visita</b></th>
				<th class="text-center"><b>Acciones</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${Visita}" var="vis">
				<tr>
					<td class="text-center"><c:out value="${vis.getId_visita()}"></c:out></td>
					<td class="text-center"><c:out value="${vis.getId_asesoria()}"></c:out></td>
					<td class="text-center"><c:out value="${vis.getFecha_visita()}"></c:out></td>
					<td class="text-center"><c:choose>
							<c:when test="${vis.isEstado()}">Realizado</c:when>
							<c:when test="${!vis.isEstado()}">No Realizado</c:when>
						</c:choose></td>
					<td>
					<a class="btn btn-danger"
							href="EliminarVisita?id_visita=${vis.getId_visita()}">Eliminar</a>
						&nbsp; 
						<a class="btn btn-warning"
							href="EditarVisita?id_visita=${vis.getId_visita()}">Editar</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	</div>
	<a class="btn btn-success"
		href="CrearVisita">Crear
		Visita</a>
	<a class="btn btn-outline-primary" href="BProfesional">Volver
		al Profesional</a>
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