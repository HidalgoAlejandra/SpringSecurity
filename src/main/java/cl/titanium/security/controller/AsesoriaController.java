package cl.titanium.security.controller;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.model.Cliente;

/**
 * Servlet implementation class ListarAsesoria
 */

//@WebServlet("/ListarAsesoria")

@Controller
@RequestMapping("/pro")
public class AsesoriaController {
	
	@Autowired
	AsesoriaDAO as;
	@Autowired
	ClienteServicio clis;
	
	Calendar c_fecha = Calendar.getInstance();
	
	@RequestMapping(value="/ListarAsesoria", method=RequestMethod.GET)
	public String listarAsesoria(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] ck = request.getCookies();
		int id_profesional = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {

				id_profesional = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		
		List<Asesoria> lasesoria = new ArrayList<Asesoria>();
		
		lasesoria = as.obtenerListaAsesoriasPorPro(id_profesional);
		
		request.setAttribute("listadoasesoriaporpro", lasesoria);
		return "pro/asesoria/ListadoAsesoria";
		
	}
	
	//@WebServlet("/CrearAsesoria")
	@RequestMapping(value="/CrearAsesoria", method=RequestMethod.GET)
	public String nuevaAsesoria(HttpServletRequest request, HttpServletResponse response) {
		
		List<Cliente> lcli = new ArrayList<>();
		
		lcli = clis.leerCliente();
		
		request.setAttribute("cliente", lcli);
		
		return "pro/asesoria/CreacionAsesoria";
	}
	
	@RequestMapping(value="/CrearAsesoria", method=RequestMethod.POST)
	public String crearAsesoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Cookie[] ck = request.getCookies();
		int id_profesional = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				id_profesional = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		int id_cliente = Integer.parseInt(request.getParameter("txtidcliente"));
		String fecha_solicitud = request.getParameter("txtfechasolicitud");
		String detalle_solicitud = request.getParameter("txtdetallesol");
		
		String[] fechal = fecha_solicitud.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		String es = request.getParameter("txtestado");
		boolean estado_asesoria = false;
		try {
		if(es.equals("on")) {
			estado_asesoria = true;
		}
		} catch (Exception e) {
			
		}
		

		Asesoria ase = new Asesoria(id_cliente, id_profesional, fecha, estado_asesoria, detalle_solicitud);
		
		
		as.ingresarAsesoria(ase);
		

		return "redirect:/pro/ListarAsesoria"; 
		
	}
	
	
	
	
}
