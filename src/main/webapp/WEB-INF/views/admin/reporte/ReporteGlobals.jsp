<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		let table = $('#grid').DataTable();
	});
</script>
<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
<title>Reporte Global</title>

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
					<li class="nav-item"><a class="nav-link"
						href="BAdministrador">Bienvenida</a></li>
					<li class="nav-item "><a class="nav-link" href="QSomos">Quien
							Somos</a></li>
					<li class="nav-item"><a class="nav-link" href="ReporteCliente">Reporte
							Cliente</a></li>
					<li class="nav-item active bg-danger"><a class="nav-link" href="ReporteGlobal">Reporte
							Global</a></li>
				</ul>
				<div>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/Logout">Log out</a>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">
	<div>
		<h1>Reporte Global</h1>
	</div>
	
		<h1 class="text-center">Lista de Clientes</h1>
		<div class="wrapper">
			<table id="grid" class="table table-bordered dt-responsive nowrap">
				<thead>
					<tr>

						<th class="text-center">Razón social</th>
						<th class="text-center">R.U.T</th>
						<th class="text-center">Giro comercial</th>
						<th class="text-center">Direción</th>
						<th class="text-center">Fono contacto</th>
						<th class="text-center">Representante legal</th>
						<th class="text-center">Contacto</th>
						<th class="text-center">Email contacto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>${cliente.getRazon_social()}</td>
							<td>${cliente.getRut_empresa()}</td>
							<td>${cliente.getGiro()}</td>
							<td>${cliente.getDireccion()}</td>
							<td>${cliente.getFono_contacto()}</td>
							<td>${cliente.getRepresentante_legal()}</td>
							<td>${cliente.getContacto()}</td>
							<td>${cliente.getEmail_contacto()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<h1 class="text-center">Lista de Profesionales</h1>
		<div class="wrapper">
			<table id="grid" class="table table-bordered dt-responsive nowrap">
				<thead>
					<tr>
						<th class="text-center">Nombre</th>
						<th class="text-center">Rut</th>
						<th class="text-center">Fono</th>
						<th class="text-center">Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${profesionales}" var="profesional">
						<tr>
							<td>${profesional.getNombre_profesional()}</td>
							<td>${profesional.getRut_profesional()}</td>
							<td>${profesional.getTelefono_corp()}</td>
							<td>${profesional.getEmail_corp()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<h1 class="text-center">Clientes Cobro al Dia</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Id Cobro</th>
						<th class="text-center">Cliente</th>
				
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${cobroaldia}" var="cobro1">
						<tr>
							<c:forEach items="${clientes}" var="cliente1">
								<c:if
									test="${cliente1.getId_cliente() == cobro1.getId_cliente()}">
									<td>${cobro1.getId_pago()}</td>
									<td>${cliente1.getRazon_social()}</td>
									
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<h1 class="text-center">Clientes Cobro Pago en Mora</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Id Cobro</th>
						<th class="text-center">Cliente</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${cobroatraso}" var="cobro2">
						<tr>
							<c:forEach items="${clientes}" var="cliente2">
								<c:if
									test="${cliente2.getId_cliente() == cobro2.getId_cliente()}">
									<td>${cobro2.getId_pago()}</td>
									<td>${cliente2.getRazon_social()}</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<h1 class="text-center">Clientes Cobro no Pago</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Id Cobro</th>
						<th class="text-center">Cliente</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${cobroimpago}" var="cobro3">
						<tr>
							<c:forEach items="${clientes}" var="cliente3">
								<c:if
									test="${cliente3.getId_cliente() == cobro3.getId_cliente()}">
									<td>${cobro3.getId_pago()}</td>
									<td>${cliente3.getRazon_social()}</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="container">
		<h1 class="text-center">Lista de Profesionales por Cliente</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Cliente</th>
						<th class="text-center">Profesional</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${clientes}" var="cliente">

						<tr>

							<td>${cliente.getRazon_social()}</td>
							<c:set var="rowcount" value="${0}"></c:set>
							<c:forEach items="${profesionales}" var="profesional"
								varStatus="status">
								<c:set var="count" value="${0}"></c:set>
								<c:forEach items="${proxcli}" var="pxc">
									
									<c:if
										test="${cliente.getId_cliente() == pxc.getId_cliente() && profesional.getId_profesional() == pxc.getId_profesional() && count==0}">
										<c:set var="count" value="${count+1}"></c:set>
										<c:set var="rowcount" value="${rowcount+1}"></c:set>
										<c:if test="${rowcount > 1}">

											<td></td><td>${profesional.getNombre_profesional()}</td>
						</tr>
						

						</c:if>
						<c:if test="${rowcount == 1}">

							<td>${profesional.getNombre_profesional()}</td>
							</tr>

						</c:if>
						</c:if>

					</c:forEach>
					</c:forEach>

					</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>

	<c:set var="comd" value="${0}"></c:set>
	<c:set var="cont" value="${0}"></c:set>



	<div class="container">
		<h1 class="text-center">Lista de Clientes por Profesional</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Profesional</th>
						<th class="text-center">Cliente</th>
					</tr>
				</thead>

				<tbody>
				<c:forEach items="${profesionales}" var="profesional">
						<tr>
							<td>${profesional.getNombre_profesional()}</td>
							<c:set var="rowcount" value="${0}"></c:set>
							
							<c:forEach items="${clientes}" var="cliente"
								varStatus="status">
								<c:set var="count" value="${0}"></c:set>
								
								<c:forEach items="${clixpro}" var="cxp">
									
									<c:if
										test="${cliente.getId_cliente() == cxp.getId_cliente() && profesional.getId_profesional() == cxp.getId_profesional() && count==0}">
										<c:set var="count" value="${count+1}"></c:set>
										<c:set var="rowcount" value="${rowcount+1}"></c:set>
										<c:if test="${rowcount > 1}">

											<td></td><td>${cliente.getRazon_social()}</td></tr>
						

						</c:if>
						<c:if test="${rowcount == 1}">

							<td>${cliente.getRazon_social()}</td>
							</tr>

						</c:if>
						</c:if>

					</c:forEach>
					
					</c:forEach>

					
					</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>





	<div class="container">
		<h1 class="text-center">Visitas por Mes</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Id Visita</th>
						<th class="text-center">Cliente</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${visitaMes}" var="visitam">
						<tr>
							<c:forEach items="${proxcli}" var="pxc">
								<c:forEach items="${clientes}" var="clientev">
									<c:if
										test="${pxc.getId_asesoria() == visitam.getId_asesoria() && pxc.getId_cliente() == clientev.getId_cliente()}">
										<td>${visitam.getId_visita()}</td>
										<td>${clientev.getRazon_social()}</td>
									</c:if>
								</c:forEach>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>





	<div class="container">
		<h1 class="text-center">Asesorias por Mes</h1>
		<div class="wrapper">
			<table class="text-center table table-bordered" id="grid">
				<thead>
					<tr>
						<th class="text-center">Id Asesoria</th>
						<th class="text-center">Cliente</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${asesoriames}" var="asesoriam">
						<tr>
							<c:forEach items="${clientes}" var="clientea">
								<c:if
									test="${clientea.getId_cliente() == asesoriam.getId_cliente()}">
									<td>${asesoriam.getId_asesoria()}</td>
									<td>${clientea.getRazon_social()}</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a class="btn btn-outline-primary"
					href="BAdministrador">Volver
					Inicio</a>
			</div>

		</div>
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