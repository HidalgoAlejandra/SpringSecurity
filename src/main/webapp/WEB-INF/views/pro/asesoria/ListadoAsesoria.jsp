<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">

<title>Listado de Asesoria</title>
</head>
<body>
<div class="banner"></div>
	


	<h1 class="text-center">Listado Asesoría</h1>

	<c:if test="${cemensaje != null}">
		<c:out value="${cemensaje}" />
	</c:if>
	<div class="wrapper">
		<table class="text-center table table-bordered" id="grid">
			<tr>
				<th class="text-center">Id Asesoría</th>
				<th class="text-center">Id Cliente</th>
				<th class="text-center">Id Profesional</th>
				<th class="text-center">Fecha Solicitud</th>
				<th class="text-center">Estado Asesoría</th>
				<th class="text-center">Detalle Solicitud</th>
				
			</tr>

			<c:forEach items="${listadoasesoriaporpro}" var="ase">
				<tr>
					<td class="text-center">${ase.getId_asesoria()}</td>
					<td class="text-center">${ase.getId_cliente()}</td>
					<td class="text-center">${ase.getId_profesional()}</td>
					<td class="text-center">${ase.getFecha_solicitud()}</td>
					<td class="text-center"><c:choose>
							<c:when test="${ase.isEstado_asesoria()}">Realizado</c:when>
							<c:when test="${!ase.isEstado_asesoria()}">No Realizado</c:when>
						</c:choose></td>
					<td class="text-center">${ase.getDetalle_solicitud()}</td>
					
				</tr>
			</c:forEach>

		</table>
	</div>
	<a class="btn btn-success"
		href="CrearAsesoria">Creación de
		Asesoria</a>
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