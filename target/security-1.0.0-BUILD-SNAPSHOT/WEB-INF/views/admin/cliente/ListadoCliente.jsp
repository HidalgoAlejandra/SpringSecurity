<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
 

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width" />

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
 
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
    
    <script>
        $(document).ready(function() {
        	let table =    $('#grid').DataTable();
        });
    </script>
    <!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
    
<title>Mantenedor Informacion CLIENTE</title>
</head>
<body>
<div class="banner"></div>
<div class="container">
<h1 class="text-center">Buscar Datos de Cliente</h1>

<c:if test="${cemensaje != null}">
	<c:out value="${cemensaje}" />
</c:if>
<div class="wrapper">
<table id="grid" class="table table-bordered dt-responsive nowrap">
<thead >
	<tr>
		<th class="text-center">ID Cliente</th>
		<th class="text-center">Razón social</th>
		<th class="text-center">R.U.T</th>
		<th class="text-center">Giro comercial</th>
		<th class="text-center">Direción</th>
		<th class="text-center">Fono contacto</th>
		<th class="text-center">Representante legal</th>
		<th class="text-center">Contacto</th>
		<th class="text-center">Email contacto</th>
		<th></th>
	</tr>
</thead>
            
<c:forEach items="${listadocliente}" var="cli">	
	<tr>
		<td class="text-center">${cli.getId_cliente()} </td>
		<td class="text-center">${cli.getRazon_social()}</td>
		<td class="text-center">${cli.getRut_empresa()}</td>
		<td class="text-center">${cli.getGiro()}</td>
		<td class="text-center">${cli.getDireccion()}</td>
		<td class="text-center">${cli.getFono_contacto()}</td>
		<td class="text-center">${cli.getRepresentante_legal()}</td>
		<td class="text-center">${cli.getContacto()}</td>
		<td class="text-center">${cli.getEmail_contacto()}</td>
		<td>
			<a class="btn btn-warning" href="EditarCliente?id_cliente=${cli.getId_cliente()}">Editar</a>
			&nbsp;	
			<a class="btn btn-danger" href="EliminarCliente?id_cliente=${cli.getId_cliente()}">Bloquear</a>
		</td>
	</tr>
	 </c:forEach>
	
	
</table>

 </div>
<a class="btn btn-success" href="CrearCliente">Creación Cliente</a>
<a class="btn btn-outline-primary" href="BAdministrador">Volver al Administrador</a>
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