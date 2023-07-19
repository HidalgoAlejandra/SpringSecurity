package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.dao.ChecklistDAO;
import cl.titanium.security.interfaces.ActividadMejoraServicio;
import cl.titanium.security.interfaces.CapacitacionServicio;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.CobroServicio;
import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.interfaces.VisitaServicio;
import cl.titanium.security.model.ActividadMejora;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.model.Capacitacion;
import cl.titanium.security.model.Checklist;
import cl.titanium.security.model.Cliente;
import cl.titanium.security.model.Cobro;
import cl.titanium.security.model.Profesional;
import cl.titanium.security.model.Visita;

@Controller
@RequestMapping("/admin")
public class ReporteClienteController {

	@Autowired
	ClienteServicio clis;
	@Autowired
	CobroServicio cs;
	@Autowired
	AsesoriaDAO ases;
	@Autowired
	VisitaServicio vs;
	@Autowired
	ProfesionalServicio pro;
	@Autowired
	ActividadMejoraServicio ams;
	@Autowired
	CapacitacionServicio cse;
	@Autowired
	ChecklistDAO chs;

	@RequestMapping(value = "/ReporteCliente", method = RequestMethod.GET)
	public String direccionReporteCliente(HttpServletRequest request, HttpServletResponse response) {
		List<Cliente> clientes = new ArrayList<>();
		clientes = clis.leerCliente();
		request.setAttribute("clientes", clientes);
		return "/admin/reporte/ReporteCliente";
	}

	@RequestMapping(value = "/ReporteCliente", method = RequestMethod.POST)
	public String reporteCliente(HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		Cliente cliente = new Cliente();
		int id_cliente = 0;

		String tipo = request.getParameter("tipo");

		if (tipo.equals("rut")) {

			String rut_cliente = request.getParameter("rut_cliente");
			cliente = clis.obtenerClienteRut(rut_cliente);

		} else {

			id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
			cliente = clis.obtenerCliente(id_cliente);

		}

		request.setAttribute("cliente", cliente);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes = clis.leerCliente();
		request.setAttribute("clientes", clientes);

		if (cliente != null) {

			id_cliente = cliente.getId_cliente();
			
			List<Cobro> cobro = new ArrayList<Cobro>();
			cobro = cs.obtenerCobros(id_cliente);
			request.setAttribute("cobro", cobro);

			List<Asesoria> asesoria = new ArrayList<>();
			asesoria = ases.obtenerListaAsesoriasPorCliente(id_cliente);

			request.setAttribute("asesoria", asesoria);

			List<Visita> visita = new ArrayList<>();
			visita = vs.obtenerListaVisitaPorCliente(id_cliente);

			List<Profesional> p = new ArrayList<>();

			p = pro.listar();

			request.setAttribute("profesional", p);

			request.setAttribute("visita", visita);

			List<ActividadMejora> actividadMejora = new ArrayList<>();
			actividadMejora = ams.obtenerListaAcmCliente(id_cliente);

			request.setAttribute("actividadMejora", actividadMejora);

			List<Capacitacion> capacitacion = new ArrayList<>();
			capacitacion = cse.listarPorCliente(id_cliente);

			request.setAttribute("capacitacion", capacitacion);

			// Mostrar capacitacion
			List<Checklist> checklist = new ArrayList<>();
			checklist = chs.seleccionarChecklistsCliente(id_cliente);
			request.setAttribute("checklist", checklist);

		}

		return "/admin/reporte/ReporteCliente";

	}

}
