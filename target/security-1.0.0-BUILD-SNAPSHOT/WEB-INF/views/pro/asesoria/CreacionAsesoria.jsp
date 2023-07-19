<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Asesoria</title>
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    		<!-- jQuery Validate -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    		<!-- jQuery Validate: métodos adicionales -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
           
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
	<link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet" />
    <link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet" />
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
    

<script src="${pageContext.request.contextPath}/resources/js/Asesoria.js"></script>

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
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div class="container">
		<div class="col-lg-6">
	<h1>Crear Asesoría</h1>
	<div class="main_content" id="form1">
		<form action="CrearAsesoria" method="post" id="asesoriaform">
			<div>
				<label>ID cliente</label> 
				<select class="form-control" name="txtidcliente">	
				<c:forEach items="${cliente}" var="cli">
					<option value="${cli.getId_cliente()}">${cli.getId_cliente()} - ${cli.getRazon_social()}</option>
				</c:forEach>
			</select>
			</div>
			<div class="form-group">
				<label>Detalle Solicitud</label><br />
				<textarea name="txtdetallesol" rows="10" cols="50" required></textarea>
			</div>
			<div class="form-group">
				<label>Fecha Solicitud</label> <input type="text" placeholder="by Group los prrroo"
					class="form-control" name="txtfechasolicitud" id="fecha" required>
			</div>
			<div class="form-group">
				<label>Estado Asesoria</label> <input type="checkbox"
					name="txtestado">
			</div>
			<input type="submit" class="btn btn-primary" value="Crear Asesoria">
		</form>
	</div>
	<br/>
	<a class="btn btn-outline-primary"
		href="ListarAsesoria">Volver
		Listado Asesoria</a>
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