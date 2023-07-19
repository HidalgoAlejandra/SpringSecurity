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
<title>Listado Actividad Mejora</title>
</head>
<body>
<div class="banner"></div>
	<h1 class="text-center">Actividades de Mejora</h1>
	<div>${cemensaje}</div>
	<table  class="text-center table table-bordered">
		<thead>
			<tr>
				<th class="text-center"><b>ID de de actividad</b></th>
				<th class="text-center"><b>ID de asesoria</b></th>
				<th class="text-center"><b>Detalle de actividad</b></th>
				<th class="text-center"><b>Estado de actividad</b></th>
				<th class="text-center"><b>Acciones</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${ActividadMejora}" var="act">
				<tr>
					<td class="text-center"><c:out value="${act.getId_actividad()}"></c:out></td>
					<td class="text-center"><c:out value="${act.getId_asesoria()}"></c:out></td>
					<td class="text-center"><c:out value="${act.getDetalle_actividad()}"></c:out></td>
					<td class="text-center"><c:choose>
							<c:when test="${act.isRealizado()}">Realizado</c:when>
							<c:when test="${!act.isRealizado()}">No Realizado</c:when>
						</c:choose></td>
					<td class="text-center">
						<a class="btn btn-danger"
							href="EliminarActividadMejora?id_actividad=${act.getId_actividad()}">Eliminar</a>
						&nbsp; 
						<a class="btn btn-warning"
							href="EditarActividadMejora?id_actividad=${act.getId_actividad()}">Editar</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a class="btn btn-success"
		href="CrearActividadMejora">Crear
		Actividad de Mejora</a>
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