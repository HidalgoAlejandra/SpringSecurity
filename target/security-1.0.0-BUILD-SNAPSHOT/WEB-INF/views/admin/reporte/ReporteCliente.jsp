<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Reporte de cliente</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet"
		href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<!-- jQuery Validate -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
	<!-- jQuery Validate: métodos adicionales -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/reportecliente.js"></script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>

	
	<header>
		<h1 class="text-center">SECURITY TITANIUM</h1>

		<nav class="navbar navbar-expand-md bg-primary navbar-dark">
			<a class="navbar-brand" href="#">Menú</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="BAdministrador">Bienvenida</a></li>
					<li class="nav-item "><a class="nav-link" href="QSomos">Quien
							Somos</a></li>
					<li class="nav-item bg-danger active"><a class="nav-link" href="ReporteCliente">Reporte
							Cliente</a></li>
					<li class="nav-item"><a class="nav-link" href="ReporteGlobal">Reporte
							Global</a></li>
				</ul>
				<div>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/Logout">Log out</a>
				</div>
			</div>
		</nav>
	</header>

	<div>
		<h1 class="text-center">Reporte Cliente</h1>
	</div>

	<div id="form">
		<form action="ReporteCliente" method="POST" id="buscar-cliente-rut">
			<p>BUSCAR CLIENTE POR RUT:</p>
			<input class="selector-css" type="text" id="rut"
				name="rut_cliente" value="${cliente.getRut_empresa()}" required />
			<input type="hidden" name="tipo" value="rut">
			<input type="submit" class="btn btn-primary" name="accion" id="submit" value="Buscar por RUT">
		</form>
		<form action="ReporteCliente" method="POST" id="buscar-cliente-id">
			<p>BUSCAR CLIENTE POR ID:</p>
			<select name="id_cliente">
				<c:forEach items="${clientes}" var="c">
					<option value="${c.getId_cliente()}">${c.getId_cliente()} - ${c.getRazon_social()}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="tipo" value="id">
			<input type="submit" class="btn btn-primary" name="accion" value="Buscar por ID">
		</form>
	</div>
	<br>
	<!--<div class="board-column done">
    <div class="board-column-header">Completado</div>
    <div class="board-column-content" data-estado="completado">-->

	<a class="btn btn-outline-primary" href="BAdministrador">Volver al Administrador</a>
	
	<h1>Información de Cliente</h1>

	<table class="tablas">
		<thead>
			<tr>
				<th><b>Razon social</b></th>
				<th><b>Rut empresa</b></th>
				<th><b>Giro</b></th>
				<th><b>Dirección</b></th>
				<th><b>Fono contacto</b></th>
				<th><b>Representante legal</b></th>
				<th><b>Contacto</b></th>
				<th><b>Email contacto</b></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${cliente.razon_social}"></c:out></td>

				<td><c:out value="${cliente.rut_empresa}"></c:out></td>
				<td><c:out value="${cliente.giro}"></c:out></td>
				<td><c:out value="${cliente.direccion}"></c:out></td>

				<td><c:out value="${cliente.fono_contacto}"></c:out></td>
				<td><c:out value="${cliente.representante_legal}"></c:out></td>
				<td><c:out value="${cliente.contacto}"></c:out></td>

				<td><c:out value="${cliente.email_contacto}"></c:out></td>
			</tr>
		</tbody>
	</table>
	<br>
	<h1>Cobros</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>Número de factura</b></th>
				<th><b>Fecha límite</b></th>
				<th><b>Fecha de pago</b></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${cobro}" var="cob">
				<tr>
					<td><c:out value="${cob.getN_factura()}"></c:out></td>
					<td><c:out value="${cob.getFecha_limite()}"></c:out></td>
					<td><c:out value="${cob.getFecha_de_pago()}"></c:out></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<h1>Asesorias</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>ID de asesoría</b></th>
				<th><b>Profesional a cargo</b></th>
				<th><b>Fecha de solicitud</b></th>
				<th><b>Estado de asesoría</b></th>
				<th><b>Detalle solicitud</b></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${asesoria}" var="ases">
				<tr>
					<td><c:out value="${ases.getId_asesoria()}"></c:out></td>
					<c:forEach items="${profesional}" var="prof">
						<c:if
							test="${prof.getId_profesional() == ases.getId_profesional()}">
							<td><c:out value="${prof.getNombre_profesional()}"></c:out>
							</td>
						</c:if>
					</c:forEach>
					<td><c:out value="${ases.getFecha_solicitud()}"></c:out></td>
					<td><c:out value="${ases.isEstado_asesoria()}"></c:out></td>
					<td><c:out value="${ases.getDetalle_solicitud()}"></c:out>
					<!--Hay que transformar dato a legible-->
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<h1>Visitas</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>ID de visita</b></th>
				<th><b>ID de asesoria</b></th>
				<th><b>Fecha de visita</b></th>
				<th><b>Estado de visita</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${visita}" var="vis">
				<tr>
					<td><c:out value="${vis.getId_visita()}"></c:out></td>
					<td><c:out value="${vis.getId_asesoria()}"></c:out></td>
					<td><c:out value="${vis.getFecha_visita()}"></c:out></td>
					<td class="text-center"><c:choose>
							<c:when test="${vis.isEstado()}">Realizado</c:when>
							<c:when test="${!vis.isEstado()}">No Realizado</c:when>
						</c:choose></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<h1>Actividades de Mejora</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>ID de de actividad</b></th>
				<th><b>ID de asesoria</b></th>
				<th><b>Detalle de actividad</b></th>
				<th><b>Estado de actividad</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${actividadMejora}" var="act">
				<tr>
					<td><c:out value="${act.getId_actividad()}"></c:out></td>
					<td><c:out value="${act.getId_asesoria()}"></c:out></td>
					<td><c:out value="${act.getDetalle_actividad()}"></c:out></td>
					<td class="text-center"><c:choose>
							<c:when test="${act.isRealizado()}">Realizado</c:when>
							<c:when test="${!act.isRealizado()}">No Realizado</c:when>
						</c:choose></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<h1>Capacitaciones</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>ID de capacitación</b></th>
				<th><b>ID de actividad</b></th>
				<th><b>Tema</b></th>
				<th><b>Fecha</b></th>
				<th><b>Participantes</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${capacitacion}" var="cap">
				<tr>
					<td><c:out value="${cap.getId_capacitacion()}"></c:out></td>
					<td><c:out value="${cap.getId_actividad()}"></c:out></td>
					<td><c:out value="${cap.getTema()}"></c:out></td>
					<td><c:out value="${cap.getFecha_capacitacion()}"></c:out></td>
					<td><c:out value="${cap.getParticipantes()}"></c:out></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<h1>Checklists</h1>
	<table class="tablas">
		<thead>
			<tr>
				<th><b>ID de checklist</b></th>
				<th><b>ID de cliente</b></th>
				<th><b>Fecha de creación</b></th>
				<th><b>Fecha de cambio</b></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${checklist}" var="check">
				<tr>
					<td><c:out value="${check.getId_checklist()}"></c:out></td>
					<td><c:out value="${check.getId_cliente()}"></c:out></td>
					<td><c:out value="${check.getFecha_creacion()}"></c:out></td>
					<td><c:out value="${check.getFecha_cambio()}"></c:out></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>
</html>