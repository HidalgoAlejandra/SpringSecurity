<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Editar Cliente</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
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
<script src="${pageContext.request.contextPath}/resources/js/Cliente.js"></script>
<!-- Enlace css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>
	<div class="container">
		<div class="col-lg-6">

			<h1 class="text-center">Editar Cliente</h1>

			<c:if test="${cemensaje != null}">
				<c:out value="${cemensaje}" />
			</c:if>

			<form action="EditarCliente" method="post" id="clientelog">


				Razon Social: <input class="form-control" type="text"
					name="txtrazon_social" value="${datoscliente.getRazon_social()}" />
				<br /> Rut Empresa: <input class="form-control" type="text"
					name="txtrut_empresa" id="rut"
					value="${datoscliente.getRut_empresa()}" /> <br /> Giro: <input
					class="form-control" type="text" name="txtgiro"
					value="${datoscliente.getGiro()}" /><br /> Direccion: <input
					class="form-control" type="text" name="txtdireccion"
					value="${datoscliente.getDireccion()}" /><br /> Fono Contacto: <input
					class="form-control" type="text" name="txtfono_contacto"
					value="${datoscliente.getFono_contacto()}" /><br /> Representante
				Legal: <input class="form-control" type="text"
					name="txtrepresentante_legal"
					value="${datoscliente.getRepresentante_legal()}" /><br />
				Contacto: <input class="form-control" type="text" name="txtcontacto"
					value="${datoscliente.getContacto()}" /><br /> Email Contacto: <input
					class="form-control" type="text" name="txtemail_contacto"
					value="${datoscliente.getEmail_contacto()}" /><br /> <input
					type="hidden" name="hdnid_cliente"
					value="${datoscliente.getId_cliente()}" /><br /> <input
					class="btn btn-success" type="submit" value="Editar Cliente"
					id="submit" />


			</form>

			<a class="btn btn-outline-primary" href="ListarCliente">Volver al
				Registro de Cliente</a>
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