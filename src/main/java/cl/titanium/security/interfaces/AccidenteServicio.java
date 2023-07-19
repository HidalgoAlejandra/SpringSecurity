package cl.titanium.security.interfaces;

import java.sql.Date;
import java.util.List;

import cl.titanium.security.model.Accidente;

public interface AccidenteServicio {
	
	// Ingresa un accidente al registro
	void ingresarAccidente(Accidente accidente);
	
	// Obtiene los datos de un accidente seg�n su id
	Accidente obtenerAccidente(int id_accidente);
	
	// Obtiene los accidentes asociados a un cliente
	 List<Accidente> obtenerAccidentesPorCliente(int id_cliente);
	
	// Obtiene los accidentes asociados a un cliente desde una fecha espec�fica
	 List<Accidente> obtenerAccidentesPorClienteYFecha(int id_cliente, Date fecha);
	
	// Obtiene los accidentes asociados a un (cliente asignado a un) profesional
	 List<Accidente> obtenerAccidentesPorProfesional(int id_profesional);

	// Obtiene los accidentes asociados a un profesional desde una fecha espec�fica
	 List<Accidente> obtenerAccidentesPorProfesionalYFecha(int id_profesional, Date fecha);
	
	// Obtiene los accidentes ocurridos desde una fecha espec�fica
	 List<Accidente> obtenerAccidentesPorFecha(Date fecha, Date fechaActual);
	
	// Modifica los datos de un accidente registrado
	void modificarAccidente(Accidente accidente);
	
}
