package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.Tarea;

public interface TareaServicio {
	
	Tarea obtenerTarea(int id_Tarea);
	
	List<Tarea> listar();
	
	void ingresarTarea(Tarea ta);
	
	void editarTarea(Tarea ta);
	
	void eliminarTarea(Tarea tar);

	List<Tarea> listarTareasPorChecklist(int id_checklist);

	int obtenerUltimoId();

	

}
