package cl.titanium.security.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.interfaces.AccidenteServicio;
import cl.titanium.security.model.Accidente;


//@WebServlet("/ReportarAccidente")

	

@Controller
@RequestMapping("/cli")
public class ReportarAccidenteController {

	@Autowired
	AccidenteServicio as;
	Calendar c_flimite = Calendar.getInstance();
	
	@RequestMapping(value="/ReportarAccidente", method=RequestMethod.GET)
	public String crearReporteAccidente(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] ck = request.getCookies();
		int id = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				System.out.println(ck[i].getName());
				id = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		System.out.println(id);
		
		request.setAttribute("id_cliente", id);
		return "/cli/ReporteAccidentes";
		
	}

    @RequestMapping(value="/ReportarAccidente", method=RequestMethod.POST)
	public String ingresarReporteAccidente(HttpServletRequest request, HttpServletResponse response) {
		
		int id_cliente =Integer.parseInt(request.getParameter("id_cliente"));   
        String fecha_hora = request.getParameter("fecha_accidente");
		String involucrado = request.getParameter("involucrado");
		String lugar = request.getParameter("lugar");
		String actividad = request.getParameter("actividad");
		String descripcion = request.getParameter("descripcion");
		
		String[] fechal = fecha_hora.split("/");
		c_flimite.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date flimite = new Date(c_flimite.getTimeInMillis());
		
		Accidente nuevoUsuario = new Accidente(id_cliente, flimite, involucrado, lugar, actividad, descripcion);
		as.ingresarAccidente(nuevoUsuario);
		
		return "/cli/BCliente";
	}


}
