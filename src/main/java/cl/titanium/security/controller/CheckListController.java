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

import cl.titanium.security.dao.ChecklistDAO;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.Checklist;
import cl.titanium.security.model.Cliente;

//Ruta del Controlador
//@WebServlet("/ListarChecklist")

@Controller
@RequestMapping("/pro")
public class CheckListController {

	@Autowired
	ChecklistDAO cs;
	@Autowired
	ClienteServicio clis;
	
	Calendar c_fecha = Calendar.getInstance();
	
	@RequestMapping(value = "/ListarChecklist", method = RequestMethod.GET)
	public String listarChecklist(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] ck = request.getCookies();
		int id_profesional = 0;

		for (int i = 0; i < ck.length; i++) {

			if (ck[i].getName().equals("id")) {
				System.out.println(ck[i].getName());
				id_profesional = Integer.parseInt(ck[i].getValue());

			}

		}

		
		List<Checklist> listaChecklist = cs.seleccionarChecklistsProfesional(id_profesional);

		request.setAttribute("Checklist", listaChecklist);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoChecklist.jsp");
//		dispatcher.forward(request, response);

		return "pro/checklist/ListadoChecklist";
	}

	// @WebServlet("/CrearChecklist")
	@RequestMapping(value = "/CrearChecklist", method = RequestMethod.GET)
	public String nuevoChecklist(HttpServletRequest request, HttpServletResponse response) {

		List<Cliente> lcli = new ArrayList<>();
		
		lcli = clis.leerCliente();
		
		request.setAttribute("cliente", lcli);

		return "pro/checklist/CreacionChecklist";
	}

	@RequestMapping(value = "/CrearChecklist", method = RequestMethod.POST)
	public String crearChecklist(HttpServletRequest request, HttpServletResponse response) {

		int id_cliente = Integer.parseInt(request.getParameter("txtidcliente"));
		c_fecha.setTime(new java.util.Date());
		Date fecha = new Date(c_fecha.getTimeInMillis());
		
		Checklist checklist = new Checklist(id_cliente, fecha, fecha);
		
		cs.crearChecklist(checklist);

		return "redirect:/pro/ListarChecklist";

	}

	// @WebServlet("/EditarChecklist")
	@RequestMapping(value = "/EditarChecklist", method = RequestMethod.GET)
	public String editarChecklistForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		
		int id_checklist = Integer.parseInt(request.getParameter("id_checklist"));
		Checklist existe = cs.obtenerChecklist(id_checklist);
		request.setAttribute("checklist", existe);
		
		List<Cliente> lcli = new ArrayList<>();
		
		lcli = clis.leerCliente();
		
		request.setAttribute("cliente", lcli);


		return "pro/checklist/EditarChecklist";

	}

	@RequestMapping(value = "/EditarChecklist", method = RequestMethod.POST)
	public String editarChecklist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// doGet(request, response);

		int id_checklist = Integer.parseInt(request.getParameter("hdnidchecklist"));
		int id_cliente = Integer.parseInt(request.getParameter("txtidcliente"));
		
		c_fecha.setTime(new java.util.Date());
		Date fecha = new Date(c_fecha.getTimeInMillis());

		Checklist book = new Checklist(id_cliente, fecha, fecha);

		book.setId_checklist(id_checklist);

		cs.editarChecklist(book);

//		String mensaje = "";
//
//		if (editar>0)
//			mensaje = "La Checklist se ha editado exitosamente";
//		else
//			mensaje = "Ocurri� un error al editar la Checklist";
//
//		request.setAttribute("cemensaje", mensaje);

		return "redirect:/pro/ListarChecklist";

	}
	

}
