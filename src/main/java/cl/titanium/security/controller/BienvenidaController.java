package cl.titanium.security.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.titanium.security.accuweather.access.AccesoAccuWeather;
import cl.titanium.security.accuweather.model.Pronostico;

@Controller
public class BienvenidaController {
	
	// Código AccuWeather para Concepción: 57655
	private static final int COD_CIUDAD = 57655;

	@RequestMapping("/pro/BProfesional")
	public String bienvenidaProfesional(Model model) {
		
		Pronostico pronostico = AccesoAccuWeather.getPronostico(COD_CIUDAD);
		model.addAttribute("pronostico", pronostico);
		
		return "pro/BProfesional";
	}

	@RequestMapping("/cli/BCliente")
	public String bienvenidaCliente() {
		return "cli/BCliente";
	}
	
	@RequestMapping("/admin/BAdministrador")
	public String bienvenidaAdministrador() {
		return "admin/BAdministrador";
	}
	
	@RequestMapping(path = {"pro/QSomos", "cli/QSomos", "admin/QSomos"})
	public String qsomos(HttpServletRequest request) {
		
		Cookie[] ck = request.getCookies();
		String tipo = "";

		for (int i = 0; i < ck.length; i++) {

			if (ck[i].getName().equals("tipo")) {
				System.out.println(ck[i].getName());
				tipo = ck[i].getValue();

			}

		}
		
		request.setAttribute("tipo", tipo);
		return "general/qsomos";
		
	}
}
