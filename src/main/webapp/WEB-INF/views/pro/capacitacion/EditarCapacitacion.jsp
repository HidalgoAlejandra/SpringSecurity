<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<!--para validar datos-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>

<!-- datepicker-->

<link
	href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css"
	rel="stylesheet" />
<link
	href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>

<style>
label.error {
	display: block;
	width: 100%;
	text-align: center;
	padding: 3px;
	margin: 3px 0;
	color: red;
	background-color: #edbbbb;
}
</style>
<script
	src="${pageContext.request.contextPath}/resources/js/Capacitacion.js"></script>
<!-- Enlace css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Editar Capacitación</title>
</head>
<body>

	<div class="container">
		<div class="col-lg-6">

			<h1 class="text-center">Editar Capacitacion</h1>

			<form class="formulario mt-3 p-4" action="EditarCapacitacion"
				method="post" name="form_capacitacion">
				Id Actividad <select class="form-control" name="txtidactividad">

					<option value="${capacitacion.getId_actividad()}">${capacitacion.getId_actividad()}</option>
					<c:forEach items="${actividad}" var="act">
						<option value="${act.getId_actividad()}">${act.getId_actividad()}</option>
					</c:forEach>
				</select><br /> Número Participantes <input type="number"
					class="form-control" id="participantes" name="txtparticipantes"
					value="<c:out value="${capacitacion.getParticipantes()}" />"><br />
				Tema <input type="text" class="form-control" id="tema"
					name="txttema" value="<c:out value="${capacitacion.getTema()}" />"><br />
				Fecha Capacitación <input type="text" class="form-control"
					id="fecha" name="txtfechacap"
					value="<c:out value="${capacitacion.getFecha_capacitacion()}" />"><br />
				<input type="hidden" name="hdnidcapacitacion"
					value="${capacitacion.getId_capacitacion()}" /><br /> <input
					class="btn btn-primary" type="submit" value="Editar Capacitación">
			</form>
			<a class="btn btn-outline-primary" href="ListarCapacitacion">Volver
				al Listado Capacitaciones</a>
		</div>
	</div>

	<br />
	<br />
	<footer>
		<p class="float-right ">
			<a href="# ">Ir arriba &nbsp;</a>
		</p>
		<p>Copyright® by Los Pro</p>
	</footer>

</body>
</html>