package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.CapacitacionServicio;
import cl.titanium.security.model.Capacitacion;
import cl.titanium.security.repositories.CapacitacionRepositorio;

@Service
public class CapacitacionServicioImpl implements CapacitacionServicio {
	@Autowired
	CapacitacionRepositorio cr;
	
	@Override
	public List<Capacitacion> listar() {
		return (List<Capacitacion>) cr.findAll();
	}

	@Override
	public void crearCapacitacion(Capacitacion cap) {
		cr.save(cap);	
	}

	@Override
	public void editarCapacitacion(Capacitacion cap) {
		cr.save(cap);
		
	}
	@Override
	public void eliminarCapacitacion(int id) {
		cr.delete(id);
		
	}
	@Override
	public Capacitacion obtenerCapacitacion(int id_capacitacion) {
		return cr.findOne(id_capacitacion);
	}

	@Override
	public List<Capacitacion> listarPorCliente(int id_cliente) {
		return cr.findAllById_cliente(id_cliente);
	}

	@Override
	public List<Capacitacion> listarPorProfesional(int id_profesional) {
		return cr.findAllById_profesional(id_profesional);
	}
	

}
