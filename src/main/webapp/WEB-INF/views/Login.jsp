<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<!-- Bootstrap CSS only -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <!-- jQuery Validate -->
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    <!-- jQuery Validate: métodos adicionales -->
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
    <!-- JS propio -->
    <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
	<title>Login</title>
	<style type="text/css">
		.login-wrapper h2 {
			text-align: center;
		}
		.login-container {
			max-width: 350px;
			margin: auto;
		}
		/* Validación formularios */
		label.error {
		    display: block;
		    width: 100%;
		    text-align: center;
		    padding: 3px;
		    margin: 3px 0;
		    color: red;
		    background-color: #edbbbb;
		}
		div.error {
            color: #ff0000;
            font-weight: bold;
            }           
        .msg {
            color: #008000;
            font-weight: bold;
        }
	</style>
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>
<body class="login">
<section>
        <div class="banner"></div>
    </section>
	<div class="login-wrapper pt-5">
		<h2>Iniciar sesión</h2>
		<!-- invalid credentials error msg -->
        <c:if test="${not empty error}">
            <div class="error text-center">${error}</div>
        </c:if>
         
        <!-- logged out msg -->
        <c:if test="${not empty msg}">
            <div class="msg text-center">${msg}</div>
        </c:if>
		<div class="login-container p-3">
			<form action="login" method="post" id="login-form">
				<div class="form-group">
					<label for="rut">R.U.T.</label>
					<input type="text" class="form-control" name="username" id="rut" placeholder="14.156.123-8" required autofocus>
				</div>
				<div class="form-group">
					<label for="password">CONTRASEÑA</label>
					<input type="password" class="form-control" name="password" id="password" placeholder="* * * * * * * * * *" autocomplete="current-password" required>
				</div>
				<!-- CSRF Token -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div><input type="submit" id="login-submit" class="btn btn-primary btn-block" value="INICIAR SESIÓN"></div>
			</form>
		</div>
		<div>${mensaje}</div>
	</div>
	
	
</body>
</html>