package cl.titanium.security.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.titanium.security.interfaces.VisitaServicio;
import cl.titanium.security.model.Visita;

@RestController
@RequestMapping("/Rest")
public class VisitaRestController {
	
	@Autowired
	VisitaServicio vs;
	
	@RequestMapping(value = "/vis/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Visita getVisitaById(@PathVariable int id) {
		
		return vs.obtenerVisita(id);
	}

	@RequestMapping(value = "/vis/all", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Visita> getListaVisita() {
		List<Visita> lista = vs.listarVisitas();
		
		return lista;
	}
	
	@RequestMapping(value = "/vis/new", method = RequestMethod.POST, headers = "Accept=application/json")
	public void agregarVisita(@RequestBody Visita vis) {
		vs.ingresarVisita(vis);;
				
	}
	
	@RequestMapping(value = "/vis/edit", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void editarVisita(@RequestBody Visita vis) {
		vs.modificarVisita(vis);
				
	}
	
	@RequestMapping(value = "/vis/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void eliminarVisita(@PathVariable int id) {
		 vs.borrarVisita(id);
				
	}
}
