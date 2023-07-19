package cl.titanium.security.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.VisitaServicio;
import cl.titanium.security.model.Visita;
import cl.titanium.security.repositories.VisitaRepositorio;

@Service
public class VisitaServicioImpl implements VisitaServicio{

	@Autowired
	VisitaRepositorio vr;
	
	@Override
	public void ingresarVisita(Visita visita) {
		vr.save(visita);
		
	}

	@Override
	public void borrarVisita(Visita visita) {
		vr.delete(visita);
	}
	
	@Override
	public void borrarVisita(int id) {
		vr.delete(id);
	}

	@Override
	public void modificarVisita(Visita visita) {
		vr.save(visita);
	}

	@Override
	public Visita obtenerVisita(int id_visita) {
		return vr.findOne(id_visita);
	}

	@Override
	public List<Visita> listarVisitas() {
	return (List<Visita>) vr.findAll();
	
	}

	@Override
	public List<Visita> obtenerListaVisitaPorCliente(int id_cliente) {
		return vr.findAllById_cliente(id_cliente);
	}

	@Override
	public void modificarIdAsesoria(Visita visita) {
		vr.save(visita);
		//REVISAR
	}

	@Override
	public int obtenerUltimoId() {
		return vr.findLastId();
		
	}

	@Override
	public List<Visita> obtenerListaVisitaPorProfesional(int id_profesional) {
		return vr.findAllById_profesional(id_profesional);
	}

	@Override
	public List<Visita> visitames(Date pMes, Date sMes) {
		return vr.findAllByPmesSmes(pMes, sMes);
		
	}

	
}
