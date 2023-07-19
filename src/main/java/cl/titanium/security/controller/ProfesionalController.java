package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.model.Profesional;


@Controller
@RequestMapping("/admin")
public class ProfesionalController {
	
	@Autowired
	ProfesionalServicio ps;
	
	//Ruta del controlador
		//@WebServlet("/ListarProfesional")
	    @RequestMapping(value="/ListarProfesional", method=RequestMethod.GET)
		public String listarProfesional(HttpServletRequest request, HttpServletResponse response) {
			
	    	
			List<Profesional> lprofesional = new ArrayList<Profesional>();
			lprofesional = ps.listar();
			request.setAttribute("listadoprofesional", lprofesional);
			
			return "admin/profesional/ListadoProfesional";
			
		}
	
	  //@WebServlet("/CrearProfesional")
	    @RequestMapping(value="/CrearProfesional", method=RequestMethod.GET)
	    public String nuevoProfesional(HttpServletRequest request, HttpServletResponse response) {
			
			return "admin/profesional/CreacionProfesional";
		}
	
	   @RequestMapping(value="/CrearProfesional", method=RequestMethod.POST)
	   public String Profesional(HttpServletRequest request, HttpServletResponse response){

		   String nombre_profesional = request.getParameter("txtnombre_profesional");
			String rut_profesional = request.getParameter("txtrut_profesional");
			String telefono_corp = request.getParameter("txttelefono_corp");
			String email_corp = request.getParameter("txtemail_corp");
	    
	        Profesional prof = new Profesional(/*id_profesional,*/ nombre_profesional, rut_profesional, telefono_corp, email_corp);
			
			
			ps.add(prof);
			
//			String mensaje = "";
//	        
//			if (agregar>0)
//				mensaje = "El Profesional se ha creado exitosamente";
//			else
//				mensaje = "Ocurri� un error al crear el Profesional";
//			
//			request.setAttribute("cemensaje", mensaje);
			
			return "redirect:/admin/ListarProfesional";
			
		}
	    
	    	    
	    //@WebServlet("/EditarProfesional")
	    @RequestMapping(value="/EditarProfesional", method=RequestMethod.GET)
	    public String editarProfesionalform(HttpServletRequest request, HttpServletResponse response) {
	    	
	    	int profid_profesional = Integer.parseInt(request.getParameter("id_profesional"));
			
			
			Profesional prof = new Profesional();
			prof = ps.obtenerProfesional(profid_profesional);
			
			request.setAttribute("datosprofesional", prof);
		    return "admin/profesional/EditarProfesional";
		}
	
	    @RequestMapping(value="/EditarProfesional", method=RequestMethod.POST)
	    public String editarProfesional(HttpServletRequest request, HttpServletResponse response) {
	    	
	    	String nombre_profesional = request.getParameter("txtnombre_profesional");
			String rut_profesional = request.getParameter("txtrut_profesional");
			String telefono_corp = request.getParameter("txttelefono_corp");
			String email_corp = request.getParameter("txtemail_corp");
			
			
			//no tocables
			int id_profesional = Integer.parseInt(request.getParameter("hdnid_profesional"));
			
			Profesional prof = new Profesional(id_profesional, nombre_profesional, rut_profesional, telefono_corp, email_corp);

			
			ps.edit(prof);
			
//			String mensaje = "";
//			
//			if (editar>0)
//				mensaje = "Profesional se ha editado exitosamente";
//			else
//				mensaje = "Ocurri� un error al editar Profesional";
//			request.setAttribute("cemensaje", mensaje);
			
			request.setAttribute("datosprofesional", prof);
			
			return "redirect:/admin/ListarProfesional";
	    		
	    	
	    }
	
	  //@WebServlet("/EliminarProfesional")
	    @RequestMapping(value="/EliminarProfesional", method=RequestMethod.GET)
	    public String eliminarProfesional(HttpServletRequest request, HttpServletResponse response) {
	    	
	    	int profid_profesional = Integer.parseInt(request.getParameter("id_profesional"));
			
			Profesional prof = new Profesional();
			prof.setId_profesional(profid_profesional);
			
			
			ps.eliminar(profid_profesional);
			
			List<Profesional> listadoeliminar = new ArrayList<Profesional>();
			listadoeliminar = ps.listar();
			
//			String mensaje = "";
//			
//			if (elimino>0)
//				mensaje = "Resgistro Profesional ha sido eliminado exitosamente";
//			else
//				mensaje = "Ocurri� un problema al eliminar Registro Profesional";
//			
//			request.setAttribute("cemensaje", mensaje);
			request.setAttribute("listadoprofesional", listadoeliminar);
	    	
			return "redirect:/admin/ListarProfesional";
	    	
	    }
}
