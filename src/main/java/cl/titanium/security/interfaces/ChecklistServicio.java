package cl.titanium.security.interfaces;


import java.util.List;

import cl.titanium.security.model.Checklist;

public interface ChecklistServicio {
	
	Checklist obtenerChecklist(int id_checklist);
	List<Checklist> listar();
	void crearChecklist(Checklist che); 
	void editarChecklist(Checklist che); 
	void eliminarChecklist(int id);
	List<Checklist> seleccionarChecklistsCliente(int id_cliente);
	List<Checklist> seleccionarChecklistsProfesional(int id_profesional);

}
