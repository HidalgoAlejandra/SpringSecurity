<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ingresar Visita</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link
	href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css"
	rel="stylesheet" />
<link
	href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
<!-- Enlace css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>
<script src="${pageContext.request.contextPath}/resources/js/Visita.js"></script>
<body>

	<div class="container">
		<div class="col-lg-6">

			<h1 class="text-center">Ingresar Visita</h1>
			<div>${cemensaje}</div>
			<form action="CrearVisita" method="POST" id="visitaforma">

				<label>Id Asesoria</label> <select class="form-control"
					name="txtidasesoria">
					<c:forEach items="${asesorias}" var="ase">
						<option value="${ase.getId_asesoria()}">${ase.getId_asesoria()}</option>
					</c:forEach>
				</select>
				<div class="checkbox">
					<label>Estado</label> <input type="checkbox" name="chkestado">
				</div>
				<div class="form-group">
					<label>Fecha Visita</label> <input class="form-control" type="text"
						placeholder="by Group los prrroo" name="txtfechavisita" id="fecha"
						required>
				</div>
				<input class="btn btn-success" type="submit" value="Ingresar Visita">
			</form>
			<a class="btn btn-outline-primary" href="ListarVisita">Volver al
				Listado Visitas</a>
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