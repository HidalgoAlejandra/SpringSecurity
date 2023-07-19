package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.TareaServicio;
import cl.titanium.security.model.Tarea;
import cl.titanium.security.repositories.TareaRepositorio;

@Service
public class TareaServicioImpl implements TareaServicio{

	@Autowired
	TareaRepositorio ts;
	
	@Override
	public Tarea obtenerTarea(int id_Tarea) {
		return ts.findOne(id_Tarea);
	}

	@Override
	public List<Tarea> listar() {
		return (List<Tarea>) ts.findAll();
	}

	@Override
	public void ingresarTarea(Tarea ta) {
		ts.save(ta);
	}

	@Override
	public void editarTarea(Tarea ta) {
		ts.save(ta);
	}

	@Override
	public void eliminarTarea(Tarea tar) {
		ts.delete(tar);
	}

	@Override
	public List<Tarea> listarTareasPorChecklist(int id_checklist) {
		return ts.findAllLista(id_checklist);
	}

	@Override
	public int obtenerUltimoId() {
		return ts.findLastId();
	}

}
