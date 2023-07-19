package cl.titanium.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cl.titanium.security.controller.LoginController;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.interfaces.UsuarioServicio;
import cl.titanium.security.model.Usuario;

@Component
public class ProcesarLogin implements AuthenticationSuccessHandler {

	@Autowired
	UsuarioServicio userdao;
	@Autowired
	ClienteServicio cdao;
	@Autowired
	ProfesionalServicio prodao;

	private Logger logger = Logger.getLogger(LoginController.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		// Obtenci�n de par�metros enviados desde el formulario
		String rut = request.getParameter("username");

		// Normalizaci�n del rut ingresado
		rut = rut.replace(".", "");
		rut = rut.replace("-", "");

		// Acceso a la base de datos para extraer los datos
		Usuario user = userdao.validarUsuario(rut);

		// Validaci�n de las credenciales entregadas

		String tipo = user.getTipo();
		String url = "";
		String id = "";

		if (tipo.equalsIgnoreCase("cliente")) {

			url = request.getContextPath() + "/cli/BCliente";
			// Obtener id de cliente
			id = "" + cdao.obtenerIdCliente(user.getUsername());

		} else if (tipo.equalsIgnoreCase("profesional")) {

			url = request.getContextPath() + "/pro/BProfesional";
			// Obtener id de profesional
			id = "" + prodao.obtenerIdProfesional(rut);

		} else if (tipo.equalsIgnoreCase("administrador")) {

			url = request.getContextPath() + "/admin/BAdministrador";
			id = "" + user.getId_usuario();

		}

		// Creaci�n de las cookies (duraci�n de una hora)
		Cookie ckIdUsuario = new Cookie("id", id);
		Cookie ckTipoUsuario = new Cookie("tipo", tipo);
		ckIdUsuario.setMaxAge(3600);
		ckTipoUsuario.setMaxAge(3600);
		response.addCookie(ckIdUsuario);
		response.addCookie(ckTipoUsuario);

		logger.info("Usuario RUT " + rut + " (" + tipo + "): Acceso concedido.");

		// Derivaci�n a la p�gina de bienevenida respectiva

		response.sendRedirect(url);
	}
}
