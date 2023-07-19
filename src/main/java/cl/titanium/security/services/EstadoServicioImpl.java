package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.EstadoServicio;
import cl.titanium.security.model.Estado;
import cl.titanium.security.repositories.EstadoRepositorio;

@Service
public class EstadoServicioImpl implements EstadoServicio{
	
	@Autowired
	EstadoRepositorio er;

	@Override
	public List<Estado> listar() {
		return (List<Estado>) er.findAll();
	}

	@Override
	public void crearEstado(Estado est) {
		er.save(est);
	}

	@Override
	public void editarEstado(Estado est) {
		er.save(est);
	}

	@Override
	public void eliminarEstado(Estado est) {
		er.delete(est);
	}

	@Override
	public Estado obtenerEstado(int id_t, int id_c) {
		return er.findOneEstado(id_t, id_c);
	}

}
