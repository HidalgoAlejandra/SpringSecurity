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

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.model.Asesoria;


@Controller("/SolicitarAsesoria")
@RequestMapping("/cli")
public class SolicitarAsesoriaController {       

	@Autowired
	AsesoriaDAO as;
	
	Calendar c_fecha = Calendar.getInstance();
	
    @RequestMapping(value="/SolicitarAsesoria", method=RequestMethod.GET)
	public String solicitarAsesoriaGet(HttpServletRequest request, HttpServletResponse response) {
		
		return "/cli/SolicitudAsesoria";
	}

	
    @RequestMapping(value="/SolicitarAsesoria", method=RequestMethod.POST)
	public String solicitarAsesoria(HttpServletRequest request, HttpServletResponse response) {

		
		Cookie[] ck = request.getCookies();
		int id = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				System.out.println(ck[i].getName());
				id = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		System.out.println("id=" + id);
				
		String fecha_solicitud = request.getParameter("txtfechasolicitud");
		String detalle_solicitud =request.getParameter("txtdetallesol");
		
		String[] fechal = fecha_solicitud.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		Asesoria ase = new Asesoria(id, fecha, detalle_solicitud);
		ase.setEstado_asesoria(false);
		
		as.solicitarAsesoria(ase);
		
//		String mensaje = "";
//		
//		if (agregar>0)
//			mensaje = "Solicitud se ha creado exitosamente";
//		else
//			mensaje = "Ocurrió un error al crear Solicitud";
//		
//		request.setAttribute("cemensaje", mensaje);
		return "/cli/BCliente";
		
	}

}
