package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.Capacitacion;


public interface CapacitacionServicio {
	
	List<Capacitacion> listar();
	void crearCapacitacion(Capacitacion cap);
	void editarCapacitacion(Capacitacion cap);
	void eliminarCapacitacion(int id);
	Capacitacion obtenerCapacitacion(int id_capacitacion);
	List<Capacitacion> listarPorCliente(int id_cliente);
	List<Capacitacion> listarPorProfesional(int id_profesional);
	
}
