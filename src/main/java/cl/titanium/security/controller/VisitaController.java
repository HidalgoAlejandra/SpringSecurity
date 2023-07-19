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
import cl.titanium.security.interfaces.VisitaServicio;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.model.Visita;

@Controller
@RequestMapping("/pro")
public class VisitaController {
	
	@Autowired
	VisitaServicio vs;
	@Autowired
	AsesoriaDAO as;
	
	Calendar c_fecha = Calendar.getInstance();
	
	@RequestMapping(value="/ListarVisita", method=RequestMethod.GET)
	public String listarVisita(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] ck = request.getCookies();
		int id_profesional = 0;
		
		for (int i = 0; i < ck.length; i++) {
			
			if (ck[i].getName().equals("id")) {
				System.out.println(ck[i].getName());
				id_profesional = Integer.parseInt(ck[i].getValue());
				
			}
			
		}
		
		List<Visita> listaVisita = vs.obtenerListaVisitaPorProfesional(id_profesional);

		request.setAttribute("Visita", listaVisita);

		return "pro/visita/ListadoVisita";
	}
	
	@RequestMapping(value="/CrearVisita", method=RequestMethod.GET)
	public String nuevaVisita(HttpServletRequest request, HttpServletResponse response) {
		
		List<Asesoria> las = new ArrayList<>();
		las = as.obtenerListaAsesorias();
		request.setAttribute("asesorias", las);
		
		return "pro/visita/CreacionVisita";
		
	}
	
	@RequestMapping(value="/CrearVisita", method=RequestMethod.POST)
	public String crearVisita (HttpServletRequest request, HttpServletResponse response) {
		
		int id_asesoria = Integer.parseInt( request.getParameter("txtidasesoria"));
		String txtestado = "";
		boolean estado = false;
		
		try {
			
			txtestado = request.getParameter("chkestado");
			
			if (txtestado.equals("on")) {
				estado = true;
			}
			
		} catch (Exception e) {}
		
		String fecha_visita = request.getParameter("txtfechavisita");
		
		String[] fechal = fecha_visita.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		Visita visita = new Visita(id_asesoria, fecha, estado);
		
		vs.ingresarVisita(visita);
		
//		String mensaje = "";
//		
//		if (agregar>0)
//			mensaje = "La visita se ha creado exitosamente";
//		else
//			mensaje = "Ocurri� un error al crear la visita";
//		
//		request.setAttribute("cemensaje", mensaje);
		return "redirect:/pro/ListarVisita";
	}
	
	@RequestMapping(value="/EditarVisita", method=RequestMethod.GET)
	public String editarVisitaForm(HttpServletRequest request, HttpServletResponse response) {
		
		
		int id_visita = Integer.parseInt(request.getParameter("id_visita"));
		Visita existe = vs.obtenerVisita(id_visita);
		
		request.setAttribute("visita", existe);
		return "pro/visita/EditarVisita";
		
	}
	
	@RequestMapping(value="/EditarVisita", method=RequestMethod.POST)
	public String editarVisata(HttpServletRequest request, HttpServletResponse response) {
		
		
		int id_visita = Integer.parseInt(request.getParameter("hdnidvisita"));
		int id_asesoria = Integer.parseInt( request.getParameter("txtidasesoria"));
		String txtestado = "";
		boolean estado = false;
		
		try {
			
			txtestado = request.getParameter("chkestado");
			
			if (txtestado.equals("on")) {
				estado = true;
			}
			
		} catch (Exception e) {}

		String fecha_visita = request.getParameter("txtfechavisita");
		
		String[] fechal = fecha_visita.split("/");
		c_fecha.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		Visita vis = new Visita(id_visita, id_asesoria, fecha, estado);
		vs.modificarVisita(vis);
		
//		String mensaje = "";
//		
//		if (editar>0)
//			mensaje = "La visita se ha editado exitosamente";
//		else
//			mensaje = "Ocurri� un error al editar la visita";
//
//		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("visita", vis);
		
		return "redirect:/pro/ListarVisita";
	}
	
	 @RequestMapping(value="/EliminarVisita", method=RequestMethod.GET)
	 public String eliminarVisita(HttpServletRequest request, HttpServletResponse response) {
		 
		 
			Visita vis = new Visita();
			int id_visita = Integer.parseInt(request.getParameter("id_visita"));
			vis.setId_visita(id_visita);
			vs.borrarVisita(vis);
						
//			String mensaje = "";
//			
//			if (elimino>0)
//				mensaje = "Resgistro Visita ha sido eliminado exitosamente";
//			else
//				mensaje = "Ocurri� un problema al eliminar Registro Visita";
//			
//			request.setAttribute("cemensaje", mensaje);
			return "redirect:/pro/ListarVisita";
	 }

	
}
