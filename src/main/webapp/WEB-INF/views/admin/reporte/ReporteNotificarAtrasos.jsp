<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
 
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script>
        $(document).ready(function() {
        	let table =    $('#grid').DataTable();
        });
    </script>
    <!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
   
<title>Notificar Atrasos</title>
</head>
<body>
<div class="container">
<h1 class="text-center">Notificar Atrasos</h1>

<c:if test="${cemensaje != null}">
	<c:out value="${cemensaje}" />
</c:if>
<div class="wrapper">
<table id="grid" class="text-center table table-bordered" id="grid">
<thead >
	<tr>
		<th class="text-center">Id pago</th>
		<th class="text-center">Id Cliente</th>
		<th class="text-center">Razon Social</th>
		<th class="text-center">Fono Contacto</th>
		<th class="text-center">N Factura</th>
		<th class="text-center">Fecha Limite</th>
		<th class="text-center">Acciones</th>
	</tr>
</thead >
<c:forEach items="${listadoreportecobro}" var="cob">
	<tr>
		<td class="text-center">${cob.getId_pago()}</td>
		<td class="text-center">${cob.getId_cliente()}</td>
		
						<c:forEach items="${clientes}" var="cliente">
						<c:if test="${cliente.getId_cliente() == cob.getId_cliente()}">
							<td>${cliente.getRazon_social()}</td>
							<td>${cliente.getFono_contacto()}</td>
						</c:if>
						</c:forEach>
		<td class="text-center">${cob.getN_factura()}</td>
		<td class="text-center">${cob.getFecha_limite()}</td>
		<td class="text-center">
			<a class="btn btn-danger" href="ImprimirCobro?id_pago=${cob.getId_pago()}">Imprimir</a>
		</td>
	</tr>
</c:forEach>	
	
</table>
</div>
<a class="btn btn-outline-primary" href="BAdministrador">Volver al Administrador</a>
</div>
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