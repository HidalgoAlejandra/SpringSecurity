<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Editar Profesional</title>
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    		<!-- jQuery Validate -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    		<!-- jQuery Validate: métodos adicionales -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
<script src="${pageContext.request.contextPath}/resources/js/Profesional.js"></script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
</head>

<body>
<div class="container">
                <div class="col-lg-6">

	<h1 class="text-center">Editar Profesional</h1>

	<c:if test="${cemensaje != null}">
		<c:out value="${cemensaje}" />
	</c:if>

	<form action="EditarProfesional" method="post" id="profesional-form">

		Nombre Profesional: <input class="form-control" type="text" name="txtnombre_profesional"
			value="${datosprofesional.getNombre_profesional()}" /> <br /> Rut
		Profesional: <input class="form-control" type="text" name="txtrut_profesional" id="rut"
			value="${datosprofesional.getRut_profesional()}" /> <br /> Teléfono Corp: <input class="form-control"
			type="text" name="txttelefono_corp"
			value="${datosprofesional.getTelefono_corp()}" /><br /> Email
		Contacto: <input class="form-control" type="text" name="txtemail_corp"
			value="${datosprofesional.getEmail_corp()}" /><br /> <input
			type="hidden" name="hdnid_profesional"
			value="${datosprofesional.getId_profesional()}" /><br /> <input
			type="submit" class="btn btn-success" value="Editar Profesional" id="submit" />


	</form>

	<a class="btn btn-outline-primary" href="ListarProfesional">Volver
		al Registro de Profesional</a>
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