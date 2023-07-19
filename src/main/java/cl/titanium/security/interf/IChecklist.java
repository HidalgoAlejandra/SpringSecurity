package cl.titanium.security.interf;


import java.util.List;

import cl.titanium.security.model.Checklist;

public interface IChecklist {
	
	public Checklist obtenerChecklist(int id_checklist);
	public List<Checklist> listar();
	public int crearChecklist(Checklist che); 
	public int editarChecklist(Checklist che); 
	public int eliminarChecklist(int id);
	List<Checklist> seleccionarChecklistsCliente(int id_cliente);
	List<Checklist> seleccionarChecklistsProfesional(int id_profesional);

}
