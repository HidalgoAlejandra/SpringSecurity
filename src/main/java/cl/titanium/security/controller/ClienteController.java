package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.Cliente;

@Controller
@RequestMapping("/admin")
public class ClienteController {

	@Autowired
	ClienteServicio cs;
	
    //@WebServlet("/ListarCliente")
	@RequestMapping(value="/ListarCliente", method=RequestMethod.GET)
	public String listarCliente(HttpServletRequest request, HttpServletResponse response){

		List<Cliente> lcliente = new ArrayList<Cliente>();
		
		lcliente = cs.leerCliente();
		
		request.setAttribute("listadocliente", lcliente);
		
        return "admin/cliente/ListadoCliente";
	}

	//@WebServlet("/CrearCliente")
	@RequestMapping(value="/CrearCliente", method=RequestMethod.GET)
	public String nuevoCliente(HttpServletRequest request, HttpServletResponse response) {

		return "admin/cliente/CreacionCliente";
	}

	@RequestMapping(value="/CrearCliente", method=RequestMethod.POST)
	public String crearCliente(HttpServletRequest request, HttpServletResponse response) {

		String razon_social = request.getParameter("txtrazon_social");
		int rut_empresa = Integer.parseInt(request.getParameter("txtrut_empresa"));
		String giro = request.getParameter("txtgiro");
		String direccion = request.getParameter("txtdireccion");
		String fono_contacto = request.getParameter("txtfono_contacto");
		String representante_legal = request.getParameter("txtrepresentante_legal");
		String contacto = request.getParameter("txtcontacto");
		String email_contacto = request.getParameter("txtemail_contacto");

		Cliente cli = new Cliente(razon_social, rut_empresa, giro, direccion, fono_contacto, representante_legal, contacto, email_contacto);
		
		cs.crearCliente(cli);
		
//		String mensaje = "";
//		
//		if (agregar > 0)
//			mensaje = "El Cliente se ha creado exitosamente";
//		else
//			mensaje = "Ocurri� un error al crear el Cliente";
//		
//		request.setAttribute("cemensaje", mensaje);
//		
		return "redirect:/admin/ListarCliente";	
	}
	
	//@WebServlet("/EditarCliente")
    @RequestMapping(value="/EditarCliente", method=RequestMethod.GET)
	public String editarClienteForm(HttpServletRequest request, HttpServletResponse response) {
	
		int cliid_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		
		Cliente cli = new Cliente();
		cli = cs.obtenerCliente(cliid_cliente);
		
		request.setAttribute("datoscliente", cli);
		
		return "admin/cliente/EditarCliente";	
    }

    @RequestMapping(value="/EditarCliente", method=RequestMethod.POST)
    public String editarCliente(HttpServletRequest request, HttpServletResponse response) {

		
		String razon_social = request.getParameter("txtrazon_social");
		int rut_empresa = Integer.parseInt(request.getParameter("txtrut_empresa"));
		String giro = request.getParameter("txtgiro");
		String direccion = request.getParameter("txtdireccion");
		String fono_contacto = request.getParameter("txtfono_contacto");
		String representante_legal = request.getParameter("txtrepresentante_legal");
		String contacto = request.getParameter("txtcontacto");
		String email_contacto = request.getParameter("txtemail_contacto");
		
		
		//no tocables
		int id_cliente = Integer.parseInt(request.getParameter("hdnid_cliente"));
		
		Cliente cli = new Cliente(id_cliente, razon_social, rut_empresa, giro, direccion, fono_contacto, representante_legal, contacto, email_contacto);

		cs.actualizarCliente(cli);
//		
//		String mensaje = "";
//		
//		if (editar > 0)
//			mensaje = "Cliente se ha editado exitosamente";
//		else
//			mensaje = "Ocurri� un error al editar Cliente";

		request.setAttribute("datoscliente", cli);
		//request.setAttribute("cemensaje", mensaje);
		//AQUI
		return "redirect:/admin/ListarCliente";			
	}

    //@WebServlet("/EliminarCliente")
    @RequestMapping(value="/EliminarCliente", method=RequestMethod.GET)
    public String eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
		
		int cliid_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		
		Cliente cli = new Cliente();
		cli.setId_cliente(cliid_cliente);
		
		cs.eliminarCliente(cli);
		
		List<Cliente> listadoeliminar = new ArrayList<Cliente>();
		listadoeliminar = cs.leerCliente();
		
//		String mensaje = "";
//		
//		if (elimino > 0)
//			mensaje = "Resgistro Cliente ha sido eliminado exitosamente";
//		else
//			mensaje = "Ocurri� un problema al eliminar Registro Cliente";
//		
//		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("listadocliente", listadoeliminar);
        //AQUI
		return "redirect:/admin/ListarCliente";		
	}

    
}
