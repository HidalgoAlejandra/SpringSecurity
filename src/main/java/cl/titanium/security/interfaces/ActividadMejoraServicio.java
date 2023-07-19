package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.ActividadMejora;

public interface ActividadMejoraServicio {

	void ingresarActividadMejora(ActividadMejora actividad);

	void borrarActividadMejora(ActividadMejora actividad);

	void modificarActividadMejora(ActividadMejora actividad);

	ActividadMejora obtenerActividadMejora(int id_actividad);

	int obtenerUltimoId();

	List<ActividadMejora> obtenerListaAcm();

	List<ActividadMejora> obtenerListaAcmCliente(int id_cliente);
	
}
