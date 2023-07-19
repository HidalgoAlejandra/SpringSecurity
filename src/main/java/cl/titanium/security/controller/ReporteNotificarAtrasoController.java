package cl.titanium.security.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.interfaces.CobroServicio;
import cl.titanium.security.model.Cliente;
import cl.titanium.security.model.Cobro;

@Controller
@RequestMapping("/admin")
public class ReporteNotificarAtrasoController {
	
	@Autowired
	CobroServicio cobs;
	@Autowired
	ClienteServicio clis;
	
	//@WebServlet("/ReporteNotificarAtraso")
    @RequestMapping(value="/ReporteNotificarAtraso", method=RequestMethod.GET)
	public String reporteNotificarAtraso(HttpServletRequest request, HttpServletResponse response) {

		Calendar c = Calendar.getInstance();
		java.util.Date fechaActual = new java.util.Date();
		c.setTime(fechaActual);
	
		Date fecha = new Date(c.getTimeInMillis());
		
		
		List<Cobro> lreportecobro = new ArrayList<Cobro>();
		lreportecobro = cobs.reporteCobroNotificarAtrasos(fecha);
		
		
		List<Cliente> listaCliente = clis.leerCliente();
		
		request.setAttribute("listadoreportecobro", lreportecobro);
		request.setAttribute("clientes", listaCliente);
		//AQUI
		return "admin/reporte/ReporteNotificarAtrasos";
	}

    //@WebServlet("/ImprimirCobro")
    @RequestMapping(value="/ImprimirCobro", method=RequestMethod.GET)
	public String imprimirCobro(HttpServletRequest request, HttpServletResponse response) {

		int id_pago = Integer.parseInt(request.getParameter("id_pago"));
		
		
		Cobro cob = new Cobro();
		cob = cobs.obtenerCobro(id_pago);
		
		
		List<Cliente> listaCliente = clis.leerCliente();
		
		request.setAttribute("impcobro", cob);
		request.setAttribute("clientes", listaCliente);
		//AQUI
		return "admin/reporte/ReporteImpCobro";
	}

}
