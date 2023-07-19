<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- jQuery Validate -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<!-- jQuery Validate: métodos adicionales -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
	 <!-- datepicker-->

    <link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet" />
    <link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet" />
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
    
 
<script src="${pageContext.request.contextPath}/resources/js/Cobro.js"></script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Editar Cobro</title>
</head>
<body>
<div class="container">
<div class="col-lg-6">

<h1 class="text-center">Editar Cobro</h1>

<c:if test="${cemensaje != null}">
	<c:out value="${cemensaje}" />
</c:if>

<form action="EditarCobro" method="post" id="cobroform">
<label>Id pago</label>
	<input class="form-control" type="text" name="hdnidpago" value="${datoscobro.getId_pago()}" readonly/><br/>
<label>Id cliente:</label>
	<select class="form-control" name="txtidcliente">
<%-- 	<option  value="${datoscobro.getId_cliente()}">${datoscobro.getId_cliente()}</option> --%>
		<c:forEach items="${cliente}" var="cli">
			<option value="${cli.getId_cliente()}"  ${datoscobro.getId_cliente() == cli.getId_cliente() ? "selected" : "" }>${cli.getId_cliente()} - ${cli.getRazon_social()}</option>
		</c:forEach>
	</select> 
<label>N Factura:</label>
<input class="form-control" type="number"  name="txtnfactura" value="${datoscobro.getN_factura()}" /> <br/>
<label>Fecha limite:</label>
<input class="fecha form-control" type="text" id="fecha" name="txtfechalimite" value="${datoscobro.getFecha_limite()}"  placeholder="by Group los prrroo"/> <br/>
<label>Fecha de pago:</label>
<input class="fecha form-control" type="text"  id="fecha1" name="txtfechadepago" value="${datoscobro.getFecha_de_pago()}"  placeholder="by Group los prrroo"/><br/>
<input class="btn btn-success" type="submit" value="Editar Cobro" />
</form>
<a class="btn btn-outline-primary" href="ListarCobro">Volver al Listado de Cobro</a>

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