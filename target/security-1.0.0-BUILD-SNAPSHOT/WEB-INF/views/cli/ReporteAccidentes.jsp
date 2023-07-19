<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<!-- jQuery Validate -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
	<!-- jQuery Validate: métodos adicionales -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
	 <!-- datepicker-->

    <link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet" />
    <link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet" />
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
    
    
	<script src="${pageContext.request.contextPath}/resources/js/reporteaccidente.js"></script>
	<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
	<title>Reportar Accidente</title>
</head>
<body>
<div class="banner"></div>
		<div class=" justify-content-center align-items-center container">
		
		<form class="formulario mt-3 p-4 accidente-form" action="ReportarAccidente" method="POST">
			

                    <h1 class="text-center">Reportar accidente</h1>

			<hr>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Fecha
					de accidente</label>
				<div class="col-sm-10">
					<input type="text" id="fecha" class="form-control" name="fecha_accidente" required>
				</div>
			</div>
			<hr>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Involucrado</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="involucrado" required>
				</div>
			</div>

			<hr>
			<div class="form-group row">
				<label  class="col-sm-2 col-form-label">Lugar</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" 
						name="lugar" required>
				</div>
			</div>

			<hr>
			<div class="form-group row">
				<label  class="col-sm-2 col-form-label">Actividad</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" 
						name="actividad" required>
				</div>
			</div>

			<hr>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Descripcion</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" 
						name="descripcion" required>
				</div>
			</div>
			<input type="hidden" name="id_cliente" value="${id_cliente}" />
			<div class="form-group row">
				<div class="col-sm-10 text-right">
					<button class="btn btn-primary" type="submit">Enviar</button>
				</div>
			</div>
		</form>
		<div>
		<a class="btn btn-outline-primary"
		href="BCliente">Volver
		Inicio</a>
		</div>
	</div>
	<br/>
<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>
</html>