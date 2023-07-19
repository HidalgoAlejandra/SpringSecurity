package cl.titanium.security.controller;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.dao.AsesoriaDAO;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.CobroServicio;
import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.interfaces.VisitaServicio;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.model.Cliente;
import cl.titanium.security.model.Cobro;
import cl.titanium.security.model.Profesional;
import cl.titanium.security.model.Visita;

@Controller
@RequestMapping("/admin")
public class ReporteGlobalController {

	@Autowired
	ClienteServicio clis;
	@Autowired
	ProfesionalServicio pros;
	@Autowired
	CobroServicio cs;
	@Autowired
	AsesoriaDAO ases;
	@Autowired
	VisitaServicio vs;
	
	

	@RequestMapping(value="/ReporteGlobal", method=RequestMethod.GET)
	public String reporteGlobal(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cks = request.getCookies();

		String tipo_user = "";

		for (int i = 0; i < cks.length; i++) {

			if (cks[i].getName().equals("tipo")) {

				tipo_user = cks[i].getValue();
			}
		}

		if (tipo_user.equalsIgnoreCase("administrador")) {

			// A la fecha actual le pongo el día 1
			Calendar calendar = Calendar.getInstance();
			java.util.Date fechaActual = new java.util.Date();
			calendar.setTime(fechaActual);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date pMes = new Date(calendar.getTimeInMillis());
			// Se le agrega 1 mes
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
			Date sMes = new Date(calendar.getTimeInMillis());

			List<Cliente> listaCliente = clis.leerCliente();
			List<Profesional> listaProfesional = pros.listar();
			List<Cobro> cobroAlDia = cs.cobroaldia();
			List<Cobro> cobroAtraso = cs.cobroatraso();
			List<Cobro> cobroImpago = cs.cobroipago();
			List<Asesoria> ProXCli = ases.proxcli();
			List<Asesoria> CliXPro = ases.clixpro();
			List<Asesoria> asesoriaMes = ases.asesoriames(pMes, sMes);
			List<Visita> visitaMes = vs.visitames(pMes, sMes);

			request.setAttribute("clientes", listaCliente);
			request.setAttribute("profesionales", listaProfesional);
			request.setAttribute("cobroaldia", cobroAlDia);
			request.setAttribute("cobroatraso", cobroAtraso);
			request.setAttribute("cobroimpago", cobroImpago);
			request.setAttribute("proxcli", ProXCli);
			request.setAttribute("clixpro", CliXPro);
			request.setAttribute("asesoriames", asesoriaMes);
			request.setAttribute("visitaMes", visitaMes);


		}
		
		return "/admin/reporte/ReporteGlobals";

	}

}
