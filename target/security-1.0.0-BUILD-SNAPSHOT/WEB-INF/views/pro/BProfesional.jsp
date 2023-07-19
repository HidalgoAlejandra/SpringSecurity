<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profesional</title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    
    <!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>
<div class="banner"></div>
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
					<li class="nav-item active bg-danger"><a class="nav-link"
						href="BProfesional">Bienvenida</a></li>
					<li class="nav-item "><a class="nav-link" href="QSomos">Quien
							Somos</a></li>
				</ul>
				<div>
					<form action="${pageContext.request.contextPath}/logout"
						method="post">
						<!-- CSRF Token -->
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div>
							<input type="submit" class="btn btn-success btn-block"
								value="Logout">
						</div>
					</form>
				</div>
			</div>
		</nav>
	</header>
<h1 class="bienvenida">Bienvenido Profesional</h1>

<div class="row">
<div class="col-md-2 text-center">
		<img width="60%" src="https://www.accuweather.com/images/weathericons/${pronostico.getDailyForecasts().get(0).getDay().getIcon()}.svg" alt="pronostico.getDailyForecasts().get(0).getDay().getIconPhrase()" /><br>
		</div>
		<div class="col-md-4">
		<h4 class="card-title">Concepción</h4>
		Máxima: ${pronostico.getDailyForecasts().get(0).getTemperature().getMaximum().getValue()}<br>
		Mínima: ${pronostico.getDailyForecasts().get(0).getTemperature().getMinimum().getValue()}<br>
	</div>
	</div>
<div style="background-image: url('${pageContext.request.contextPath}/resources/imagenes/security5.jpg');">
        <br />
        <div class="text-center">

<div class="btn-group-vertical">
	<a href="ListarAsesoria" class="btn btn-primary">Lista Asesoría</a><br/>
	<br/>
	<a href="ListarCapacitacion" class="btn btn-primary">Lista Capacitación</a><br/>
	<br/>
	<a href="ListarActividadMejora" class="btn btn-primary">Lista Actividad de Mejora</a><br/>
	<br/>
	<a href="ListarCasoAsesoria" class="btn btn-primary">Lista Caso de Asesoría</a><br/>
	<br/>
	<a href="ListarVisita" class="btn btn-primary">Lista de Visitas</a><br/>
	<br/>
	<a href="ListarChecklist" class="btn btn-primary">Lista de Checklist</a><br/>
	<br/>
</div>
</div>
</div>
	
 

 <footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
   
</body>
</html>