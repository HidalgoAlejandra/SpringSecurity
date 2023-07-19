<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ingresar Actividad de Mejora</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/ActividadMejora.js"></script>
<!-- Enlace css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>

	<div class="container">
		<div class="col-lg-6">

			<h1 class="text-center">Ingresar Actividad de Mejora</h1>
			<div>${cemensaje}</div>
			<form action="CrearActividadMejora" method="POST" id="form-act">
				<div class="form-group">
					<label>Id Asesoría</label>
					<!-- 			<input class="form-control" type="number" name="txtidasesoria" required> -->
					<select class="form-control" name="txtidasesoria">
						<c:forEach items="${asesorias}" var="ase">
							<option value="${ase.getId_asesoria()}">${ase.getId_asesoria()}
								- ${ase.getFecha_solicitud()} - ${ase.getDetalle_solicitud() }</option>
						</c:forEach>
					</select>
				</div>
				<div class="checkbox">
					<label>Realizado</label> <input type="checkbox" name="chkrealizado">
				</div>
				<div class="form-group">
					<label>Detalle</label>
					<textarea class="form-control" aria-label="With textarea"
						name="txtdetalleactividad" required></textarea>
				</div>
				<input class="btn btn-success" type="submit"
					value="Ingresar Actividad">
			</form>
			<a class="btn btn-outline-primary" href="ListarActividadMejora">Volver
				al Listado Actividades</a>
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