package cl.titanium.security.interfaces;


import java.util.List;

import cl.titanium.security.model.Estado;


public interface EstadoServicio {

	List<Estado> listar();
	void crearEstado(Estado est); 
	void editarEstado(Estado est);
	void eliminarEstado(Estado est);
	Estado obtenerEstado(int id_t,int id_c);
	
}
