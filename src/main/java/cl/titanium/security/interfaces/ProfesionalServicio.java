package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.Profesional;

public interface ProfesionalServicio {
	
	 List<Profesional> listar();
	 void add(Profesional pro);
	 void edit(Profesional pro);
	 void eliminar(int id);
	 Profesional obtenerProfesional(int id_profesional);
	 int obtenerIdProfesional(String rut); 
}
