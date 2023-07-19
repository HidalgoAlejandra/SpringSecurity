package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.model.Asesoria;

/**
 * Servlet implementation class ListarAsesoria
 */



@Controller
@RequestMapping("/pro")
public class CasoAsesoriaController {
	
	@Autowired
	AsesoriaDAO as;
	
	//@WebServlet("/ListarCasoAsesoria")
	
	@RequestMapping(value="/ListarCasoAsesoria", method=RequestMethod.GET)
	public String listarCasoAsesoria(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Asesoria> lasesoria = new ArrayList<Asesoria>();
		
		lasesoria = as.obtenerListaCasoAse();
		
		request.setAttribute("listadoasesoria", lasesoria);
		return "pro/asesoria/ListadoCasoAsesoria";
	}
	

	//@WebServlet("/AceptarCaso")
	
	@RequestMapping(value="/AceptarCaso", method=RequestMethod.GET)
	public String aceptarCaso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie[] ck = request.getCookies();
		int id_profesional = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				id_profesional = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		int id_asesoria = Integer.parseInt(request.getParameter("id_asesoria"));
		
		Asesoria asesoria = as.obtenerAsesoria(id_asesoria);
		
		asesoria.setId_profesional(id_profesional);
		
		as.aceptarcaso(asesoria);

		/*
		 * String mensaje = "";
		 * 
		 * if (aceptar>0) mensaje = "El Caso de Asesoria fue aceptado exitosamente";
		 * else mensaje = "Ocurrió un error al aceptar el Caso";
		 * 
		 * request.setAttribute("cemensaje", mensaje);
		 */
		
		return "redirect:/pro/ListarCasoAsesoria";
		
	}
	
	
	//@WebServlet("/RechazarCaso")
	
	@RequestMapping(value="/RechazarCaso", method=RequestMethod.GET)
	public String rechazarCaso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
				
		int id_asesoria = Integer.parseInt(request.getParameter("id_asesoria"));
		
		Asesoria asesoria = new Asesoria();
				
		asesoria.setId_asesoria(id_asesoria);
		
		
		as.borrarAsesoria(asesoria);

		/*
		 * String mensaje = "";
		 * 
		 * if (rechazar>0) mensaje = "El Caso de Asesoria fue rechazado exitosamente";
		 * else mensaje = "Ocurri� un error al rechazar el Caso";
		 * 
		 * request.setAttribute("cemensaje", mensaje);
		 */

		return "redirect:/pro/ListarCasoAsesoria";
	}

}
