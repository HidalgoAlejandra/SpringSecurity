<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quienes Somos</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
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
				<c:choose>
					<c:when test="${tipo.equals('administrador')}">
						<li class="nav-item"><a class="nav-link"
						href="BAdministrador">Bienvenida</a></li>
					</c:when>
					<c:when test="${tipo.equals('profesional')}">
						<li class="nav-item"><a class="nav-link"
						href="BProfesional">Bienvenida</a></li>
					</c:when>
					<c:when test="${tipo.equals('cliente')}">
						<li class="nav-item"><a class="nav-link"
						href="BCliente">Bienvenida</a></li>
					</c:when>
				</c:choose>
					<li class="nav-item bg-danger"><a class="nav-link" href="QSomos">Quien
							Somos</a></li>
					<c:if test="${tipo.equals('administrador')}">
					<li class="nav-item"><a class="nav-link" href="ReporteCliente">Reporte
							Cliente</a></li>
					<li class="nav-item"><a class="nav-link" href="ReporteGlobal">Reporte
							Global</a></li>
					</c:if>
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

<main role="main">


        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Quienes Somos</h1>
                <br>
                <p class="lead text-muted">Jovenes desarrolladores de diversas areas que nos gusta la informática.</p>
                <p class="lead text-muted">La informática reúne a muchas de las técnicas que el hombre ha desarrollado con el objetivo de potenciar sus capacidades de pensamiento, memoria y comunicación. Su área de aplicación no tiene límites: la informática se utiliza en la gestión
                    de negocios, en el almacenamiento de información, en el control de procesos, en las comunicaciones, en los transportes, en la medicina y en muchos otros sectores.
                </p>
                <p class="lead text-muted">
                    La informática abarca también los principales fundamentos de las ciencias de la computación, como la programación para el desarrollo de software, la arquitectura de las computadoras y del hardware, las redes como Internet y la inteligencia artificial.
                    Incluso se aplica en varios temas de la electrónica.</p>
                <p>

                </p>
            </div>
        </section>

        <div class="album py-5 bg-light">
        
        
      
            <div class="container">

                <div class="row">
                
  
                    <div class="col-md-4" >
                        <div class="card mb-4 box-shadow">
                             <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/felipe.svg" alt="Card image cap"> 
                            <div class="card-body">
                                <h4 class="card-title">Felipe Kessi.</h4>
                                <p class="card-text"> Concepción.</p>
                                <p class="card-text"> Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ver+</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Email</button>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/ale.svg" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title">Alejandra Hidalgo.</h4>
                                <p class="card-text"> Concepción.</p>
                                <p class="card-text"> Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ver+</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Email</button>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/male.svg" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title">Maria Alejandra Canache. </h4>

                                <p class="card-text"> Concepción. </p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ver+</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Email</button>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/carly.svg" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title">Carlina Torres.</h4>
                                <p class="card-text">Concepción. </p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ver+</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Email</button>
                                    </div>
                                    <small class="text-muted">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/esteban.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Esteban Salas.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/jaime.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Jaime Reyes.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/claudio.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Clauido Torres.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/pamela.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Pamela Machino.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                                        <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/paola.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Paola Valdebenito.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>
                                        <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/imagenes/equipo/daniela.svg" alt=" Card image cap ">
                            <div class="card-body ">
                                <h4 class="card-title">Daniela Acuña.</h4>
                                <p class="card-text "> Concepción.</p>
                                <p class="card-text">Desarrollo de Aplicaciones Full Stack Java Trainee - 028</p>
                                <div class="d-flex justify-content-between align-items-center ">
                                    <div class="btn-group ">
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Ver+</button>
                                        <button type="button " class="btn btn-sm btn-outline-secondary ">Email</button>
                                    </div>
                                    <small class="text-muted ">9 mins</small>
                                </div>
                            </div>
                        </div>
                    </div>



                </div>
            </div>
            
        </div>


    </main>




</body>
</html>