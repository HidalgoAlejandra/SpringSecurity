package cl.titanium.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.EstadoDAO;
import cl.titanium.security.dao.TareaDAO;
import cl.titanium.security.model.Estado;
import cl.titanium.security.model.Tarea;

//*@WebServlet("/CrearTarea")

@Controller
@RequestMapping("/pro")
public class TareaController {

	@Autowired
	TareaDAO ts;
	@Autowired
	EstadoDAO es;

	@RequestMapping(value = "/CrearTarea", method = RequestMethod.GET)
	public String nuevaTarea(HttpServletRequest request, HttpServletResponse response) {

		int id_checklist = Integer.parseInt(request.getParameter("id_checklist"));
		request.setAttribute("id_checklist", id_checklist);
		return "pro/tarea/CreacionTarea";
	}

	@RequestMapping(value = "/CrearTarea", method = RequestMethod.POST)
	public String crearTarea(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("txtnombre");
		String detalle = request.getParameter("txtdetalletarea");
		int id_checklist = Integer.parseInt(request.getParameter("hdnidchecklist"));

		Tarea nuevoTarea = new Tarea(nombre, detalle);

		ts.ingresarTarea(nuevoTarea);
		int id_tarea = 0;

		id_tarea = ts.obtenerUltimoId();
		Estado est = new Estado(id_checklist, id_tarea, false);
		es.crearEstado(est);

		String mensaje = "";

		/*
		 * if (agregar>0 && agregarest>0) mensaje =
		 * "La tarea se ha creado exitosamente"; else mensaje =
		 * "Ocurrió un error al crear la tarea";
		 */

		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("id_checklist", id_checklist);
		
		return "redirect:/pro/ListarTarea?id_checklist=" + id_checklist;

	}

	// *@WebServlet("/EditarTarea")

	@RequestMapping(value = "/EditarTarea", method = RequestMethod.GET)
	public String editarTareaForm(HttpServletRequest request, HttpServletResponse response) {

		int id_tarea = Integer.parseInt(request.getParameter("id_tarea"));
		int id_checklist = Integer.parseInt(request.getParameter("id_checklist"));

		Tarea existe = ts.obtenerTarea(id_tarea);

		Estado existe1 = es.obtenerEstado(id_tarea, id_checklist);

		request.setAttribute("tarea", existe);
		request.setAttribute("id_checklist", id_checklist);
		request.setAttribute("estado", existe1);

		return "pro/tarea/EditarTarea";
	}

	@RequestMapping(value = "/EditarTarea", method = RequestMethod.POST)
	public String editarTarea(HttpServletRequest request, HttpServletResponse response) {

		int id_tarea = Integer.parseInt(request.getParameter("hdnidtarea"));
		int id_checklist = Integer.parseInt(request.getParameter("hdnidchecklist"));

		String nombre = request.getParameter("txtnombre");
		String detalle_tarea = request.getParameter("txtdetalletarea");

		String txtestado = "";
		boolean estado = false;

		try {

			txtestado = request.getParameter("chkestado");
			// no seleccionado on
			if (txtestado.equals("on")) {
				estado = true;
			}

		} catch (Exception e) {
		}

		Tarea ta = new Tarea(id_tarea, nombre, detalle_tarea);
		ts.editarTarea(ta);

		Estado est = new Estado(id_checklist, id_tarea, estado);
		es.editarEstado(est);
		String mensaje = "";

		/*
		 * if (editar>0 && editarest>0) mensaje = "La tarea se ha editado exitosamente";
		 * else mensaje = "Ocurrió un error al editar la tarea";
		 */

		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("id_checklist", id_checklist);
		
		return "redirect:/pro/ListarTarea?id_checklist=" + id_checklist;

	}

	// *@WebServlet("/ListarTarea")

	@RequestMapping(value = "/ListarTarea", method = RequestMethod.GET)
	public String listarTareaForm(HttpServletRequest request, HttpServletResponse response) {

		int id_checklist = Integer.parseInt(request.getParameter("id_checklist"));

		List<Tarea> ltarea = new ArrayList<Tarea>();

		ltarea = ts.listarTareasPorChecklist(id_checklist);

		request.setAttribute("listadotarea", ltarea);

		List<Estado> lestado = new ArrayList<>();

		lestado = es.listar();
		request.setAttribute("listadoestado", lestado);
		request.setAttribute("id_checklist", id_checklist);

		return "pro/tarea/ListadoTarea";
	}

	// *@WebServlet("/EliminarTarea")

	@RequestMapping(value = "/EliminarTarea", method = RequestMethod.GET)
	public String EliminarTareaForm(HttpServletRequest request, HttpServletResponse response) {

		int tarid_tarea = Integer.parseInt(request.getParameter("id_tarea"));
		int id_checklist = Integer.parseInt(request.getParameter("id_checklist"));

		Estado est = new Estado(id_checklist, tarid_tarea, false);
		es.eliminarEstado(est);

		Tarea tar = new Tarea();
		tar.setId_tarea(tarid_tarea);

		ts.eliminarTarea(tar);

		List<Tarea> listadoeliminar = new ArrayList<Tarea>();
		listadoeliminar = ts.listarTareasPorChecklist(id_checklist);
		List<Estado> listaestado = es.listar();

		String mensaje = "";

		/*
		 * if (eliminoest>0 && elimino>0) mensaje =
		 * "Resgistro Tarea ha sido eliminado exitosamente"; else mensaje =
		 * "Ocurrió un problema al eliminar Registro Tarea";
		 */

		request.setAttribute("cemensaje", mensaje);
		request.setAttribute("listadotarea", listadoeliminar);
		request.setAttribute("listadoestado", listaestado);
		request.setAttribute("id_checklist", id_checklist);
		
		return "redirect:/pro/ListarTarea?id_checklist=" + id_checklist;

	}

}
