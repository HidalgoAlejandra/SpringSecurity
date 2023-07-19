package cl.titanium.security.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.titanium.security.interfaces.CapacitacionServicio;
import cl.titanium.security.model.Capacitacion;

@RestController
@RequestMapping("/Rest")
public class CapacitacionRestController {
	
	@Autowired
	CapacitacionServicio cs;
	
	@RequestMapping(value = "/cap/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Capacitacion getCapacitacionById(@PathVariable int id) {
		
		return cs.obtenerCapacitacion(id);
	}

	@RequestMapping(value = "/cap/all", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Capacitacion> getListaCapacitacion() {
		List<Capacitacion> lista = cs.listar();
		
		return lista;
	}
	
	@RequestMapping(value = "/cap/new", method = RequestMethod.POST, headers = "Accept=application/json")
	public void agregarCapacitacion(@RequestBody Capacitacion cap) {
		cs.crearCapacitacion(cap);
				
	}
	
	@RequestMapping(value = "/cap/edit", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void editarCapacitacion(@RequestBody Capacitacion cap) {
		cs.editarCapacitacion(cap);
				
	}
	
	@RequestMapping(value = "/cap/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void eliminarCapacitacion(@PathVariable int id) {
		 cs.eliminarCapacitacion(id);
				
	}
}
