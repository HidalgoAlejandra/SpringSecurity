<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrador</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
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
					<li class="nav-item bg-danger"><a class="nav-link"
						href="BAdministrador">Bienvenida</a></li>
					<li class="nav-item "><a class="nav-link" href="QSomos">Quien
							Somos</a></li>
					<li class="nav-item"><a class="nav-link" href="ReporteCliente">Reporte
							Cliente</a></li>
					<li class="nav-item"><a class="nav-link" href="ReporteGlobal">Reporte
							Global</a></li>
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
	<section>
		<h1 class="bienvenida">Bienvenido Administrador</h1>
		
		
		<div style="background-image: url('${pageContext.request.contextPath}/resources/imagenes/security3.jpg');">
        <br />
        <div class="text-center">
		<div class="btn-group-vertical ">
			<a class="btn btn-primary" href="ListarCliente">Mantener
				Información Cliente</a><br /> <br /> <a class="btn btn-primary"
				href="ListarProfesional">Mantener Información Profesional</a><br />
			<br /> <a class="btn btn-primary" href="ListarCobro">Controlar
				Pagos</a><br /> <br /> <a class="btn btn-primary"
				href="ReporteNotificarAtraso">Notificar Atraso</a><br /> <br /> <a
				class="btn btn-primary" href="ListarAccidentabilidad">Calcular
				Accidentabilidad</a><br />
		</div>
		</div>
		</div>
	</section>
	
	<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>
</html>
