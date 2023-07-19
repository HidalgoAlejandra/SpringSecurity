<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Tarea</title>
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

<script src="${pageContext.request.contextPath}/resources/js/tarea.js"></script>
 <!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>


<body>
	
	<div class="container">
                <div class="col-lg-6">

                    <h1 class="text-center">Editar Tarea</h1>
	<div>${cemensaje}</div>
	<form action="EditarTarea" method="POST" class="tarea-form">
		<input type="hidden" name="hdnidtarea" value="${tarea.getId_tarea()}">
		<input type="hidden" name="hdnidchecklist" value="${estado.getId_checklist()}">
		
		<div class="form-group">
			<label>Nombre</label>
			<input class="form-control" type="text" name="txtnombre" value="${tarea.getNombre()}" required>
		</div>
		<div class="form-group">
			<label>Detalle</label>
			<input class="form-control" type="text" name="txtdetalletarea" value="${tarea.getDetalle_tarea()}" required>
		</div>
<!-- 		Traer estado -->
		<div class="checkbox">
			<label>Estado</label>
			<input type="checkbox" name="chkestado" ${estado.isCompletado() ? "checked" : ""}>
		</div>
		<input class="btn btn-success" type="submit" value="Editar Tarea">
	</form>
	<a class="btn btn-outline-primary" href="ListarTarea?id_checklist=${id_checklist}">Volver al Listado Tareas</a>
</div>
</div>
<br/>
<br/>
<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>