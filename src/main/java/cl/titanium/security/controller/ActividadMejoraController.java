package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.interfaces.ActividadMejoraServicio;
import cl.titanium.security.model.ActividadMejora;
import cl.titanium.security.model.Asesoria;

@Controller
@RequestMapping("/pro")
public class ActividadMejoraController {
	
	@Autowired
	ActividadMejoraServicio ams;
	@Autowired
	AsesoriaDAO as;
	
	//Ruta del controlador
	//@WebServlet("/ListarActividadMejora")
    @RequestMapping(value="/ListarActividadMejora", method=RequestMethod.GET)
	public String listarActividadMejora(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<ActividadMejora> listaActividadMejora = ams.obtenerListaAcm();

		request.setAttribute("ActividadMejora", listaActividadMejora);
		
		// Colocar el return con la vista a la cual se está referenciando y luego eliminar esta linea
//		RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoActividadMejora.jsp");
//		dispatcher.forward(request, response);
		
		return "pro/actividad/ListadoActividadMejora";
		
	}
    
    //@WebServlet("/CrearActividadMejora")
    @RequestMapping(value="/CrearActividadMejora", method=RequestMethod.GET)
    public String nuevaActividadMejora(HttpServletRequest request, HttpServletResponse response, Model model) {
		
    	Cookie[] ck = request.getCookies();
		int id_profesional = 0;

		for (int i = 0; i < ck.length; i++) {

			if (ck[i].getName().equals("id")) {
				id_profesional = Integer.parseInt(ck[i].getValue());

			}

		}
    	
		
		List<Asesoria> asesorias = as.obtenerListaAsesoriasPorPro(id_profesional);
		model.addAttribute("asesorias", asesorias);
    	
		return "pro/actividad/CreacionActividadMejora";
	}
    
    @RequestMapping(value="/CrearActividadMejora", method=RequestMethod.POST)
    public String crearActividadMejora(HttpServletRequest request, HttpServletResponse response) {
		
		int id_asesoria = Integer.parseInt( request.getParameter("txtidasesoria"));
		String txtrealizado = "";
		boolean realizado = false;
		
		try {
			
			txtrealizado = request.getParameter("chkrealizado");
			
			if (txtrealizado.equals("on")) {
				realizado = true;
			}
			
		} catch (Exception e) {}
		
		String detalle = request.getParameter("txtdetalleactividad");
		ActividadMejora nuevoActividadMejora = new ActividadMejora(id_asesoria, realizado, detalle);
		
		ams.ingresarActividadMejora(nuevoActividadMejora);
		
//		String mensaje = "";
		
//		if (agregar>0)
//			mensaje = "La actividad se ha creado exitosamente";
//		else
//			mensaje = "Ocurri� un error al crear la actividad";
//		
//		request.setAttribute("cemensaje", mensaje);
//		
		return "redirect:/pro/ListarActividadMejora";
		
	}
    
    //@WebServlet("/EditarActividadMejora")
    @RequestMapping(value="/EditarActividadMejora", method=RequestMethod.GET)
    public String editarActividadMejoraForm(HttpServletRequest request, HttpServletResponse response) {
		
    	Cookie[] ck = request.getCookies();
		int id_profesional = 0;

		for (int i = 0; i < ck.length; i++) {

			if (ck[i].getName().equals("id")) {
				id_profesional = Integer.parseInt(ck[i].getValue());

			}

		}
		
		int id_actividad = Integer.parseInt(request.getParameter("id_actividad"));
		ActividadMejora actividad = ams.obtenerActividadMejora(id_actividad);
		request.setAttribute("actividadMejora", actividad);
		
		Asesoria ases = as.obtenerAsesoria(actividad.getId_asesoria());
		
		List<Asesoria> las = new ArrayList<>();
		las = as.obtenerListaAsesoriasPorClienteYPro(ases.getId_cliente(), id_profesional);

		request.setAttribute("asesoria", las);

		return "pro/actividad/EditarActividadMejora";
	}
    
    @RequestMapping(value="/EditarActividadMejora", method=RequestMethod.POST)
    public String editarActividadMejora(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		int id_actividad = Integer.parseInt(request.getParameter("hdnidactividad"));
		int id_asesoria = Integer.parseInt( request.getParameter("txtidasesoria"));
		String txtrealizado = "";
		boolean realizado = false;
		
		try {
			
			txtrealizado = request.getParameter("chkrealizado");
			
			if (txtrealizado.equals("on")) {
				realizado = true;
			}
			
		} catch (Exception e) {}

		String detalle = request.getParameter("txtdetalleactividad");
		ActividadMejora book = new ActividadMejora(id_actividad, id_asesoria, realizado, detalle);
		ams.modificarActividadMejora(book);
		
//		String mensaje = "";
		
//		if (editar>0)
//			mensaje = "La actividad se ha editado exitosamente";
//		else
//			mensaje = "Ocurrió un error al editar la actividad";
//
//		request.setAttribute("cemensaje", mensaje);
		return "redirect:/pro/ListarActividadMejora";
		
	}
    
    //@WebServlet("/EliminarActividadMejora")
    @RequestMapping(value="/EliminarActividadMejora", method=RequestMethod.GET)
    public String eliminarActividaMejora(HttpServletRequest request, HttpServletResponse response) {
		
		
		ActividadMejora acm = new ActividadMejora();
		int id_actividad = Integer.parseInt(request.getParameter("id_actividad"));
		acm.setId_actividad(id_actividad);
		ams.borrarActividadMejora(acm);
		
		
//		String mensaje = "";
		
//		if (elimino>0)
//			mensaje = "Resgistro Actividad ha sido eliminado exitosamente";
//		else
//			mensaje = "Ocurri� un problema al eliminar Registro Actividad";
//		
//		request.setAttribute("cemensaje", mensaje);
		return "redirect:/pro/ListarActividadMejora";
		
	}

}
