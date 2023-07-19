package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.ChecklistServicio;
import cl.titanium.security.model.Checklist;
import cl.titanium.security.repositories.ChecklistRepositorio;

@Service
public class ChecklistServicioImpl implements ChecklistServicio {

	@Autowired
	ChecklistRepositorio cr;
	
	@Override
	public Checklist obtenerChecklist(int id_checklist) {
		return cr.findOne(id_checklist);
	}

	@Override
	public List<Checklist> listar() {
		return (List<Checklist>) cr.findAll();
	}

	@Override
	public void crearChecklist(Checklist che) {
		cr.save(che);
	}

	@Override
	public void editarChecklist(Checklist che) {
		cr.save(che);
	}

	@Override
	public void eliminarChecklist(int id) {
		cr.delete(id);
	}

	@Override
	public List<Checklist> seleccionarChecklistsCliente(int id_cliente) {
		return cr.findAllById_cliente(id_cliente);
	}

	@Override
	public List<Checklist> seleccionarChecklistsProfesional(int id_profesional) {
		return cr.findAllById_profesional(id_profesional);
	}

}
