<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Editar CheckList</title>
</head>
<body>
	<div class="container">
   <div class="col-lg-6">
	<h1 class="text-center">Editar CheckList</h1>
	<div>${cemensaje}</div>
	<form action="EditarChecklist" method="POST" name="checklistform">
		<input type="hidden" name="hdnidchecklist" value="${checklist.getId_checklist()}">
		<div class="form-group">
			<label>Id Cliente</label>
			<select class="form-control" name="txtidcliente">	
				<c:forEach items="${cliente}" var="cli">
					<option value="${cli.getId_cliente()}" ${cli.getId_cliente() == checklist.getId_cliente() ? "selected" : "" }>${cli.getId_cliente()}</option>
				</c:forEach>
			</select>
		</div>
		<input class="btn btn-success" type="submit" value="Editar Checklist">
	</form>
	<a class="btn btn-outline-primary" href="ListarChecklist">Volver al Listado Checklist</a>
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