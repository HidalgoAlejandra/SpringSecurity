<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>C O B R O</title>
</head>
<body>
<div class="container">
	<h1 class="text-center">C O B R O</h1>

	<c:if test="${cemensaje != null}">
		<c:out value="${cemensaje}" />
	</c:if>

	<c:set var="cob" value="${impcobro}"></c:set>

	<hr>
	<div class="row">
		<div class="col-3">Id Pago</div>
		<div class="col">${cob.getId_pago()}</div>
	</div>
	<div class="row">
		<div class="col-3">Cliente</div>
		<div class="col">${cob.getId_cliente()}</div>
	</div>
		<c:forEach items="${clientes}" var="cliente">
			<c:if test="${cliente.getId_cliente() == cob.getId_cliente()}">
				<div class="row">
					<div class="col-3">Razón Social</div>
					<div class="col">${cliente.getRazon_social()}</div>
				</div>
				<div class="row">
					<div class="col-3">Fono Contacto</div>
					<div class="col">${cliente.getFono_contacto()}</div>
				</div>
			</c:if>
		</c:forEach>
		
	<div class="row">
		<div class="col-3">Numero Factura</div>
		<div class="col">${cob.getN_factura()}</div>
	</div>
	<div class="row">
		<div class="col-3">Fecha Limite</div>
		<div class="col">${cob.getFecha_limite()}</div>
	</div>
	<hr>
	<a class="btn btn-outline-primary" href="ReporteNotificarAtraso">Volver</a>
	<button class="btn btn-outline-primary" onclick="window.print()">Imprimir</button>
</div>

</body>
</html>