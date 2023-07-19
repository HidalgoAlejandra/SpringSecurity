package cl.titanium.security.interf;


import java.util.List;

import cl.titanium.security.model.Estado;


public interface IEstado {

	public List<Estado> listar();
	public int crearEstado(Estado est); 
	public int editarEstado(Estado est);
	public int eliminarEstado(Estado est);
	public Estado obtenerEstado(int id_t,int id_c);
	
}
