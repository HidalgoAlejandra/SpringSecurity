package cl.titanium.security.interfaces;

import java.sql.Date;
import java.util.List;

import cl.titanium.security.model.Visita;

public interface VisitaServicio {
	
	void ingresarVisita(Visita visita);
	void borrarVisita(Visita visita);	
	void modificarVisita(Visita visita);	
	Visita obtenerVisita(int id_visita);	
	List<Visita> listarVisitas();	
	List<Visita> obtenerListaVisitaPorCliente(int id_cliente);
	void modificarIdAsesoria(Visita visita);	
	int obtenerUltimoId();
	List<Visita> obtenerListaVisitaPorProfesional(int id_profesional);
	List<Visita> visitames(Date pMes, Date sMes);
	void borrarVisita(int id);
	
}
