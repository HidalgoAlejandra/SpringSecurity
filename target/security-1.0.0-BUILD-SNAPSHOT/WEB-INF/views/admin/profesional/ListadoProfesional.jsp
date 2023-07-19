<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Informacion de profesional</title>
</head>
<body>
<div class="banner"></div>
<section class="mt-5">
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h1>Buscar profesional</h1>
        <form id="formulario" class="form">
          <input class="form-control" type="text" name="txtbuscar">
          <input class="btn btn-primary btn-block mt-1" type="submit">
        </form>
      </div>
    </div>
  </div>
</section>

<section class="mt-5">
	<div class="container">
		<div class="row">
			<div class="col">
        
        <a class="btn btn-success" href="CrearProfesional">Agregar Nuevo</a>
        <br><br>
				<table id="dtVerticalScrollExample" class="table table-striped table-bordered table-sm" cellspacing="0"width="100%">
          <thead>
            <tr>
              <th class="th-sm">Nombre</th>
              <th class="th-sm">R.U.T</th>
              <th class="th-sm">Telefono Corp</th>
              <th class="th-sm">Email Corp</th>
              <th class="th-sm">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${listadoprofesional}" var="user">
            <tr>
            
              <td>${user.getNombre_profesional()}</td>
              <td>${user.getRut_profesional()}</td>
              <td>${user.getTelefono_corp()}</td>
              <td>${user.getEmail_corp()}</td>
              <td>
                <a class="btn btn-danger" href="EliminarProfesional?id_profesional=${user.getId_profesional()}">Eliminar</a>
                &nbsp;
                <a class="btn btn-warning" href="EditarProfesional?id_profesional=${user.getId_profesional()}">Editar</a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <a class="btn btn-outline-primary" href="BAdministrador">Volver al Administrador</a>
			</div>
		</div>
	</div>
</section>

<script>
$("#formulario").validate({
    rules: {
        txtbuscar: {
            required: true,
        }
    },
    messages: {
        txtbuscar: {
            required: "Debe ingresar un parametro",
        }
    }
});
</script>

<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<br/>
<footer>
        <p class="float-right ">
            <a href="# ">Ir arriba &nbsp;</a>
        </p>
        <p>Copyright® by Los Pro</p>
    </footer>
</body>
</html>