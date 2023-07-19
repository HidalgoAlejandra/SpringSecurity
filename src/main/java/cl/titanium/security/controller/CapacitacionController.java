package cl.titanium.security.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.interfaces.ActividadMejoraServicio;
import cl.titanium.security.interfaces.CapacitacionServicio;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.ActividadMejora;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.model.Capacitacion;
import cl.titanium.security.model.Cliente;

	

@Controller
@RequestMapping("/pro")
public class CapacitacionController {

	@Autowired
	CapacitacionServicio cs;
	@Autowired
	ActividadMejoraServicio acts;
	@Autowired
	AsesoriaDAO ases;
	@Autowired
	ClienteServicio clis;
	
	Calendar c_fecha = Calendar.getInstance();
	
	
	@RequestMapping(value="/ListarCapacitacion", method=RequestMethod.GET)
	public String listarCapacitacion(HttpServletRequest request, HttpServletResponse response) {
	
		Cookie[] ck = request.getCookies();
		int id_profesional = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				System.out.println(ck[i].getName());
				id_profesional = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		System.out.println(id_profesional);
		
		List<Capacitacion> lcap = new ArrayList<>(); 
		List<ActividadMejora> lact = new ArrayList<>();
		List<Asesoria> lase = new ArrayList<>();
		List<Cliente> lcli = new ArrayList<>();
		
		lcap = cs.listarPorProfesional(id_profesional);
		lact = acts.obtenerListaAcm();
		lase = ases.obtenerListaAsesorias();
		lcli = clis.leerCliente();
		
		request.setAttribute("capacitacion", lcap);
		request.setAttribute("actividad", lact);
		request.setAttribute("asesoria", lase);
		request.setAttribute("cliente", lcli);
		
		return"pro/capacitacion/ListadoCapacitacion";
	}
	
	@RequestMapping(value="/CrearCapacitacion", method=RequestMethod.GET)
	public String nuevaCapacitacion(HttpServletRequest request, HttpServletResponse response) {
		
		List<ActividadMejora> lact = new ArrayList<>();
		lact = acts.obtenerListaAcm();
		request.setAttribute("actividad", lact);	
		return "pro/capacitacion/CreacionCapacitacion";
	}
	
	@RequestMapping(value="/CrearCapacitacion", method=RequestMethod.POST)
	public String crearCapacitacion (HttpServletRequest request, HttpServletResponse response) {
		
		int id_actividad = Integer.parseInt(request.getParameter("txtidactividad"));
		int participantes = Integer.parseInt(request.getParameter("txtparticipantes"));
		String tema = request.getParameter("txttema");
		String fecha_capacitacion = request.getParameter("txtfechacap");
		
		
		String[] fechal = fecha_capacitacion.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		Capacitacion cap = new Capacitacion(id_actividad, participantes, tema, fecha);
		
		
		cs.crearCapacitacion(cap);

	
		return "redirect:/pro/ListarCapacitacion";
	}

	@RequestMapping(value="/EditarCapacitacion", method=RequestMethod.GET)
	public String editarCapacitacionForm(HttpServletRequest request, HttpServletResponse response) {
	

		int capid_capacitacion = Integer.parseInt(request.getParameter("id_capacitacion"));
		
		Capacitacion cap = new Capacitacion();
		System.out.println(cap.getId_actividad());
		cap = cs.obtenerCapacitacion(capid_capacitacion);
		
		List<ActividadMejora> lact = new ArrayList<>();
		lact = acts.obtenerListaAcm();
		
		request.setAttribute("actividad", lact);		
		request.setAttribute("capacitacion", cap);
		
		return "pro/capacitacion/EditarCapacitacion";
	}
	
	@RequestMapping(value="/EditarCapacitacion", method=RequestMethod.POST)
	public String editarCapacitacion(HttpServletRequest request, HttpServletResponse response) {
		
		int id_actividad = Integer.parseInt(request.getParameter("txtidactividad"));
		int participantes = Integer.parseInt(request.getParameter("txtparticipantes"));
		String tema = request.getParameter("txttema");
		String fecha_capacitacion = request.getParameter("txtfechacap");
		

		String[] fechal = fecha_capacitacion.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		//no tocables
		int id_capacitacion = Integer.parseInt(request.getParameter("hdnidcapacitacion"));
		
		Capacitacion cap = new Capacitacion(id_capacitacion, id_actividad, participantes, tema, fecha);
		cs.editarCapacitacion(cap);
		
		String mensaje = "";
		/*
		if (editar>0)
			mensaje = "Capacitacion se ha editado exitosamente";
		else
			mensaje = "Ocurri� un error al editar Capacitacion";
		*/
		request.setAttribute("capacitacion", cap);
		request.setAttribute("cemensaje", mensaje);
		
		return "redirect:/pro/ListarCapacitacion";
	}
	
}

