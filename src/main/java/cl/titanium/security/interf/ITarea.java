package cl.titanium.security.interf;

import java.util.List;

import cl.titanium.security.model.Tarea;

public interface ITarea {
	
	public Tarea obtenerTarea(int id_Tarea);
	
	public List<Tarea> listar();
	
	public int ingresarTarea(Tarea ta);
	
	public int editarTarea(Tarea ta);
	
	int eliminarTarea(Tarea tar);

	List<Tarea> listarTareasPorChecklist(int id_checklist);

	int obtenerUltimoId();

	

}
