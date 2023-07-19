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
<title>Listado Tareas</title>
</head>
<body>
<div class="banner"></div>
	<h1 class="text-center">Tareas</h1>
	<div>${cemensaje}</div>
	<table  class="text-center table table-bordered">
		<thead>
			<tr>
				<th class="text-center"><b>ID de Tarea</b></th>
				<th class="text-center"><b>Nombre tarea</b></th>
				<th class="text-center"><b>Detalle de tarea</b></th>
				<th class="text-center"><b>Estado de Tarea</b></th>
				<th class="text-center"><b>Acciones</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${listadotarea}" var="tar">
				<tr>
					<td class="text-center"><c:out value="${tar.getId_tarea()}"></c:out></td>
					<td class="text-center"><c:out value="${tar.getNombre()}"></c:out></td>
					<td class="text-center"><c:out value="${tar.getDetalle_tarea()}"></c:out></td>
					<c:forEach items="${listadoestado }" var="est">
							<c:if test="${tar.getId_tarea() == est.getId_tarea() && est.getId_checklist() == id_checklist}">
								<td class="text-center">
									<c:out value="${est.isCompletado() ? \"Completado\" : \"No Completado\"}"></c:out>
								</td>
							</c:if>
					</c:forEach>
					<td class="text-center">
						<a class="btn btn-danger"
							href="EliminarTarea?id_tarea=${tar.getId_tarea()}&id_checklist=${id_checklist}">Eliminar</a>
						&nbsp; 
						<a class="btn btn-warning"
							href="EditarTarea?id_tarea=${tar.getId_tarea()}&id_checklist=${id_checklist}">Editar</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a class="btn btn-success"
		href="CrearTarea?id_checklist=${id_checklist}">Crear
		Tarea</a>
	<a class="btn btn-outline-primary" href="ListarChecklist?id_checklist=${id_checklist}">Volver
		al Listado Checklist</a>
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