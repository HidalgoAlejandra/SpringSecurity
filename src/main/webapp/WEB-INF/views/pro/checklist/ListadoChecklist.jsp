<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Listado Checklist</title>
</head>
<body>
<div class="banner"></div>
	<h1  class="text-center">Listado de Checklists</h1>
	<c:if test="${cemensaje != null}">
	<c:out value="${cemensaje}" />
</c:if>
<div class="wrapper">
<table class="table table-bordered dt-responsive nowrap">
	<thead>
		<tr>
			<th class="text-center"><b>ID Checklist</b></th>
			<th class="text-center"><b>ID Cliente</b></th>
			<th class="text-center"><b>Fecha Creación</b></th>
			<th class="text-center"><b>Fecha Cambio</b></th>
			<th class="text-center"><b>Acciones</b></th>
		</tr>
	</thead>
	<tbody>

<c:forEach items="${Checklist}" var="check">
			<tr>
				<td class="text-center"><c:out
							value="${check.getId_checklist()}"></c:out></td>
				<td class="text-center"><c:out
							value="${check.getId_cliente()}"></c:out></td>
				<td class="text-center"><c:out
							value="${check.getFecha_creacion()}"></c:out></td>
				<td class="text-center"><c:out 
						    value="${check.getFecha_cambio()}"></c:out></td>
				<td class="text-center"><a class="btn btn-primary"
						href="ListarTarea?id_checklist=${check.getId_checklist()}">Ver Tareas</a>
						&nbsp; <a class="btn btn-warning"
						href="EditarChecklist?id_checklist=${check.getId_checklist()}">Editar</a>
				</td>
			</tr>
</c:forEach>

		</tbody>
	</table>
</div>
<a class="btn btn-success" href="CrearChecklist">Crear Checklist</a>
<a class="btn btn-outline-primary" href="BProfesional">Volver al Profesional</a>
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