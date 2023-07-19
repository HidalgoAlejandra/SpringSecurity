package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.ActividadMejoraServicio;
import cl.titanium.security.model.ActividadMejora;
import cl.titanium.security.repositories.ActividadMejoraRepositorio;

@Service
public class ActividadMejoraImpl implements ActividadMejoraServicio{

	@Autowired
	ActividadMejoraRepositorio amr;
	
	@Override
	public void ingresarActividadMejora(ActividadMejora actividad) {
		amr.save(actividad);
	}

	@Override
	public void borrarActividadMejora(ActividadMejora actividad) {
		amr.delete(actividad);
		
	}

	@Override
	public void modificarActividadMejora(ActividadMejora actividad) {
		amr.save(actividad);
	}

	@Override
	public ActividadMejora obtenerActividadMejora(int id_actividad) {
		// TODO Auto-generated method stub
		return amr.findOne(id_actividad);
	}

	@Override
	public int obtenerUltimoId() {
		// TODO Auto-generated method stub
		return amr.findLastId();
	}

	@Override
	public List<ActividadMejora> obtenerListaAcm() {
		// TODO Auto-generated method stub
		return (List<ActividadMejora>) amr.findAll();
	}

	@Override
	public List<ActividadMejora> obtenerListaAcmCliente(int id_cliente) {
		// TODO Auto-generated method stub
		return amr.findAllByCliente(id_cliente);
	}
	

}
