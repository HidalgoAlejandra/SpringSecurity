package cl.titanium.security.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.interfaces.UsuarioServicio;

@Controller
public class LoginController {

	@Autowired
	UsuarioServicio us;
	@Autowired
	ClienteServicio cs;
	@Autowired
	ProfesionalServicio ps;

	private Logger logger = Logger.getLogger(LoginController.class);

	// Formulario de login
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView m = new ModelAndView();
		if (error != null) {
			m.addObject("error", "Usuario y contraseña no válidos.");
		}

		if (logout != null) {
			m.addObject("msg", "Has cerrado sesión con éxito.");
		}

		m.setViewName("Login");
		return m;
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] ck = request.getCookies();

		for (int i = 0; i < ck.length; i++) {
			ck[i].setValue("");
			ck[i].setMaxAge(0);
			response.addCookie(ck[i]);
		}

		logger.info("Usuario desconectado.");

		return "Login";
	}

}