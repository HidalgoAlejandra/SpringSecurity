<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    		<!-- jQuery Validate -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
    		<!-- jQuery Validate: métodos adicionales -->
    		<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/additional-methods.js"></script>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
            <title>Crear Cliente</title>
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
			<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
    		<script src="${pageContext.request.contextPath}/resources/js/Cliente.js"></script>
    		<!-- Enlace css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        </head>

        <body>
            <div class="container">
                <div class="col-lg-6">

                    <h1 class="text-center">Crear Cliente</h1>

                    <form action="CrearCliente" method="post" id="clientelog">
                        <!-- Id Cliente: <input class="form-control" type="number" name="txtid_cliente" /><br/> -->
                        Razón Social: <input class="form-control" type="text" name="txtrazon_social" required /> <br/> 
                        Rut Empresa: <input class="form-control" type="text" name="txtrut_empresa" id="rut" required /> <br/> 
                        Giro: <input class="form-control" type="text" name="txtgiro" required /> <br/> 
                        Dirección: <input class="form-control" type="text" name="txtdireccion" required /><br/> 
                        Teléfono Contacto: <input class="form-control" type="text" name="txtfono_contacto" required /><br/> 
                        Representante Legal: <input class="form-control" type="text" name="txtrepresentante_legal" required /><br/> 
                        Contacto: <input class="form-control" type="text" name="txtcontacto" required /><br/> 
                        Email Contacto: <input class="form-control" type="email" name="txtemail_contacto" required /><br/>
                        <input class="btn btn-success" type="submit" id="submit" value="Agregar Cliente" />
                    </form>

                    <a class="btn btn-outline-primary" href="ListarCliente">Volver al Registro de Clientes</a>
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