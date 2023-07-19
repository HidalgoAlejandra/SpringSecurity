package cl.titanium.security.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.ProfesionalServicio;
import cl.titanium.security.model.Profesional;
import cl.titanium.security.repositories.ProfesionalRepositorio;

@Service
public class ProfesionalServicioImpl implements ProfesionalServicio {
	
	@Autowired
	ProfesionalRepositorio pr;

	@Override
	public List<Profesional> listar() {
		
		return (List<Profesional>) pr.findAll();
	}

	@Override
	public void add(Profesional pro) {
		pr.save(pro);
		
	}

	@Override
	public void edit(Profesional pro) {
		pr.save(pro);
		
	}

	@Override
	public void eliminar(int id) {
		pr.delete(id);
		
	}

	@Override
	public Profesional obtenerProfesional(int id_profesional) {
		return pr.findOne(id_profesional);
		
	}

	@Override
	public int obtenerIdProfesional(String rut) {
		return pr.findIdProfesional(rut);
	}
	

}
