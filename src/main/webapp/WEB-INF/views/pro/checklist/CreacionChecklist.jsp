<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Checklist.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Ingresar Checklist</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>
	<div class="container">
   <div class="col-lg-6">
	<h1 class="text-center">Ingresar Checklist</h1>
	
	<div>${cemensaje}</div>
	<form action="CrearChecklist" method="POST" name="checklistform">
		<div class="form-group">
			<label>Id Cliente</label>
			<select class="form-control" name="txtidcliente">	
				<c:forEach items="${cliente}" var="cli">
					<option value="${cli.getId_cliente()}">${cli.getId_cliente()}</option>
				</c:forEach>
			</select>
		</div>
		<input class="btn btn-success" type="submit" value="Crear Checklist">
	</form>
	<a class="btn btn-outline-primary" href="ListarChecklist">Volver al Listado Checklists</a>
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
</html>