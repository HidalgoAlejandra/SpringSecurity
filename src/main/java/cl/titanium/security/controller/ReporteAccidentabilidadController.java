package cl.titanium.security.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import cl.titanium.security.interfaces.AccidenteServicio;
import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.Accidente;
import cl.titanium.security.model.Cliente;

/**
 * Servlet implementation class AccidentabilidadServlet
 */
//@WebServlet("/ListarAccidentabilidad")

@Controller
@RequestMapping("/admin")
public class ReporteAccidentabilidadController {
	
	@Autowired
	AccidenteServicio as;
	@Autowired
	ClienteServicio cs;
	
    @RequestMapping(value="/ListarAccidentabilidad", method=RequestMethod.GET)
	public String listarAccidentabilidad(HttpServletRequest request, HttpServletResponse response) {
		
		// Obtener la fecha actual y restarle 3 meses
		Calendar c = Calendar.getInstance();
		java.util.Date fechaActual = new java.util.Date();
		c.setTime(fechaActual);
		Date fechaAct = new Date(c.getTimeInMillis());
		c.add(Calendar.MONTH, -3);
		Date fecha = new Date(c.getTimeInMillis());
		
		// Generaci�n de la lista de accidentes ocurridos en los �ltimos 30 d�as
		
		List<Accidente> listaAccidente = as.obtenerAccidentesPorFecha(fecha, fechaAct);
		
		// Obtneci�n de los datos de cliente (para mostrar el nombre)
		
		List<Cliente> listaCliente = cs.leerCliente();
		
		// Env�o de los datos a la vista
		request.setAttribute("accidentes", listaAccidente);
		request.setAttribute("clientes", listaCliente);
		return "admin/reporte/ListadoAccidentabilidad";
		
    }
}
