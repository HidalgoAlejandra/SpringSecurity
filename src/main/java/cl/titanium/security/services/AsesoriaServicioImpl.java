package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.AsesoriaServicio;
import cl.titanium.security.model.Asesoria;
import cl.titanium.security.repositories.AsesoriaRepositorio;

@Service
public class AsesoriaServicioImpl implements AsesoriaServicio {
	
	@Autowired
	AsesoriaRepositorio as;

	@Override
	public void ingresarAsesoria(Asesoria asesoria) {
		as.save(asesoria);
	}

	@Override
	public void borrarAsesoria(Asesoria asesoria) {
		as.delete(asesoria);
	}

	@Override
	public void modificarAsesoria(Asesoria asesoria) {
		as.save(asesoria);	
	}

	@Override
	public Asesoria obtenerAsesoria(int id_asesoria) {
		return as.findOne(id_asesoria);
	}

	@Override
	public int obtenerUltimoId() {
		return as.findLastID();
	}

	@Override
	public void solicitarAsesoria(Asesoria asesoria) {
		as.save(asesoria);	
	}

	@Override
	public List<Asesoria> asesoriames(String pMes, String sMes) {
		
		return as.findAllByMes(pMes,sMes);
	}

	@Override
	public List<Asesoria> clixpro() {
		
		return as.clixpro();
	}

	@Override
	public List<Asesoria> proxcli() {
		
		return as.proxcli();
	}

	@Override
	public List<Asesoria> obtenerListaAsesoriasPorCliente(int id_cliente) {
		
		return as.findAllByCliente(id_cliente);
	}

	@Override
	public List<Asesoria> obtenerListaAsesoriasPorPro(int id_profesional) {
		
		return as.findAllByProfesional(id_profesional);
	}

	@Override
	public List<Asesoria> obtenerListaCasoAse() {
		
		return as.findAllCasoAse();
	}

	@Override
	public List<Asesoria> obtenerListaAsesorias() {
		
		return (List<Asesoria>) as.findAll();
		
	}

	@Override
	public void aceptarcaso(Asesoria asesoria) {
		as.save(asesoria);
		
	}

}
