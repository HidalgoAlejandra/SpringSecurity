package cl.titanium.security.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.CobroServicio;

import cl.titanium.security.model.Cliente;
import cl.titanium.security.model.Cobro;

@Controller
@RequestMapping("/admin")
public class CobroController {

	@Autowired
	CobroServicio cs;
	@Autowired
	ClienteServicio clis;
	
	Calendar c_flimite = Calendar.getInstance();
	Calendar c_fpago = Calendar.getInstance();

//	@WebServlet("/ListarCobro")
	@RequestMapping(value = "/ListarCobro", method = RequestMethod.GET)
	public String listarcobro(HttpServletRequest request, HttpServletResponse response) {

		List<Cobro> lcobro = new ArrayList<Cobro>();

		lcobro = cs.leerCobro();

		request.setAttribute("listadocobro", lcobro);
		return "admin/cobro/ListadoCobro";
	}

//@WebServlet("/CrearCobro")
	@RequestMapping(value = "/CrearCobro", method = RequestMethod.GET)
	public String nuevoCobro(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<Cliente> cliente = clis.leerCliente();
		model.addAttribute("cliente", cliente);
	
		return "admin/cobro/CreacionCobro";
	}

	@RequestMapping(value = "/CrearCobro", method = RequestMethod.POST)
	public String crearCobro(HttpServletRequest request, HttpServletResponse response) {

		int id_cliente = Integer.parseInt(request.getParameter("txtidcliente"));
		int n_factura = Integer.parseInt(request.getParameter("txtnfactura"));
		String fecha_limite = request.getParameter("txtfechalimite");
		String fecha_de_pago = request.getParameter("txtfechadepago");

		String[] fechal = fecha_limite.split("/");
		c_flimite.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date flimite = new Date(c_flimite.getTimeInMillis());
		Date fpago = null;

		if (!(fecha_de_pago == null || fecha_de_pago.equals(""))) {

			String[] fechap = fecha_de_pago.split("/");
			c_fpago.set(Integer.parseInt(fechap[2]), Integer.parseInt(fechap[0]) - 1, Integer.parseInt(fechap[1]));
			fpago = new Date(c_fpago.getTimeInMillis());
		}
		
		Cobro cob = new Cobro(id_cliente, n_factura, flimite, fpago);

		cs.crearCobro(cob);

		String mensaje = "";
		
		request.setAttribute("cemensaje", mensaje);
		
		return "redirect:/admin/ListarCobro";
	}

	// @WebServlet("/EditarCobro")
	@RequestMapping(value = "/EditarCobro", method = RequestMethod.GET)
	public String editarCobroform(HttpServletRequest request, HttpServletResponse response,Model model) {

		int cobid_pago = Integer.parseInt(request.getParameter("id_pago"));

		Cobro cob = new Cobro();
		cob = cs.obtenerCobro(cobid_pago);
		
		List<Cliente> cliente = clis.leerCliente();
		model.addAttribute("cliente", cliente);

		request.setAttribute("datoscobro", cob);
		return "admin/cobro/EditarCobro";
	}

	@RequestMapping(value = "/EditarCobro", method = RequestMethod.POST)
	public String editarCobro(HttpServletRequest request, HttpServletResponse response) {

		int id_cliente = Integer.parseInt(request.getParameter("txtidcliente"));
		int n_factura = Integer.parseInt(request.getParameter("txtnfactura"));
		String fecha_limite = request.getParameter("txtfechalimite");
		String fecha_de_pago = request.getParameter("txtfechadepago");

		String[] fechal = fecha_limite.split("/");
		c_flimite.set(Integer.parseInt(fechal[2]), Integer.parseInt(fechal[0]) - 1, Integer.parseInt(fechal[1]));
		Date flimite = new Date(c_flimite.getTimeInMillis());
		Date fpago = null;

		if (!(fecha_de_pago == null || fecha_de_pago.equals(""))) {

			String[] fechap = fecha_de_pago.split("/");
			c_fpago.set(Integer.parseInt(fechap[2]), Integer.parseInt(fechap[0]) - 1, Integer.parseInt(fechap[1]));
			fpago = new Date(c_fpago.getTimeInMillis());
		}
		int id_pago = Integer.parseInt(request.getParameter("hdnidpago"));

		Cobro cob = new Cobro(id_pago, id_cliente, n_factura, flimite, fpago);
		cs.editarCobro(cob);

		String mensaje = "";

		/*if (editar > 0)
			mensaje = "Cobro se ha editado exitosamente";
		else
			mensaje = "Ocurri� un error al editar Cobro";*/

		request.setAttribute("datoscobro", cob);
		request.setAttribute("cemensaje", mensaje);
		
		return "redirect:/admin/ListarCobro";

	}

//    @WebServlet("/EliminarCobro")
	@RequestMapping(value = "/EliminarCobro", method = RequestMethod.GET)
	public String EliminarCobro(HttpServletRequest request, HttpServletResponse response) {

		int cobid_pago = Integer.parseInt(request.getParameter("id_pago"));

		Cobro cob = new Cobro();
		cob.setId_pago(cobid_pago);

		cs.eliminarCobro(cob);

		List<Cobro> listadoeliminar = new ArrayList<Cobro>();
		listadoeliminar = cs.leerCobro();

		String mensaje = "";

		/*if (elimino > 0)
			mensaje = "Resgistro Cobro ha sido eliminado exitosamente";
		else
			mensaje = "Ocurri� un problema al eliminar Registro Cobro";*/

		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("listadocobro", listadoeliminar);
		
		return "redirect:/admin/ListarCobro";
	}

}// Fin CobroController
