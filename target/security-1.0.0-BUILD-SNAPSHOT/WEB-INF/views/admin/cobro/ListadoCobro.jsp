<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   <!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Listado de Cobros</title>
</head>
<body>
<div class="banner"></div>
<h1 class="text-center">Controlar pago clientes</h1>

<c:if test="${cemensaje != null}">
	<c:out value="${cemensaje}" />
</c:if>
<div class="wrapper">
<table  class="text-center table table-bordered" id="grid">
	<tr>
		<th class="text-center">Id pago</th>
		<th class="text-center">Id Cliente</th>
		<th class="text-center">N Factura</th>
		<th class="text-center">Fecha Limite</th>
		<th class="text-center">Fecha Pago</th>
		<th class="text-center">Acciones</th>
	</tr>

<c:forEach items="${listadocobro}" var="cob">
	<tr>
		<td class="text-center">${cob.getId_pago()}</td>
		<td class="text-center">${cob.getId_cliente()}</td>
		<td class="text-center">${cob.getN_factura()}</td>
		<td class="text-center">${cob.getFecha_limite()}</td>
		<td class="text-center">${cob.getFecha_de_pago()}</td>
		<td class="text-center">
			<a class="btn btn-danger" href="EliminarCobro?id_pago=${cob.getId_pago()}">Eliminar</a>
			&nbsp;
			<a class="btn btn-warning" href="EditarCobro?id_pago=${cob.getId_pago()}">Editar</a>
		</td>
	</tr>
</c:forEach>	
	
</table>
</div>
<a class="btn btn-success" href="CrearCobro">Creación de cobros</a>
<a class="btn btn-outline-primary" href="BAdministrador">Volver al Administrador</a>
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