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
<link rel="stylesheet" >
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">

<title>Listado de Capacitación</title>
</head>
<body>
<div class="banner"></div>
	<h1 class="text-center">Controlar Capacitaciones</h1>

	<c:if test="${cemensaje != null}">
		<c:out value="${cemensaje}" />
	</c:if>
	<div class="wrapper">
		

		<table class="text-center table table-bordered" id="grid">
			<thead>
				<tr>
					<th class="text-center"><b>ID de Capacitación</b></th>
					<th class="text-center"><b>ID de Actividad</b></th>
					<th class="text-center"><b>Cliente</b></th>
					<th class="text-center"><b>Tema</b></th>
					<th class="text-center"><b>Fecha</b></th>
					<th class="text-center"><b>Participantes</b></th>
					<th class="text-center"><b>Acciones</b></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${capacitacion}" var="cap">

					<tr>
						<td class="text-center"><c:out value="${cap.getId_capacitacion()}"></c:out></td>
						<td class="text-center"><c:out value="${cap.getId_actividad()}"></c:out></td>
						<c:forEach items="${actividad}" var="act">
							<c:forEach items="${asesoria}" var="ase">
								<c:forEach items="${cliente}" var="cli">
									<c:if test="${cap.getId_actividad() == act.getId_actividad()}">
										<c:if test="${act.getId_asesoria() == ase.getId_asesoria()}">
											<c:if test="${ase.getId_cliente() == cli.getId_cliente()}">
												<td class="text-center"><c:out value="${cli.getRazon_social()}"></c:out></td>
											</c:if>
										</c:if>
									</c:if>
								</c:forEach>
							</c:forEach>
						</c:forEach>
						<td class="text-center"><c:out value="${cap.getTema()}"></c:out></td>
						<td class="text-center"><c:out value="${cap.getFecha_capacitacion()}"></c:out></td>
						<td class="text-center"><c:out value="${cap.getParticipantes()}"></c:out></td>
						<td class="text-center">
							<a class="btn btn-warning"
								href="EditarCapacitacion?id_capacitacion=${cap.getId_capacitacion()}">Editar</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<a class="btn btn-success"
		href="CrearCapacitacion">Crear
		Capacitación</a>
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