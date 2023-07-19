package cl.titanium.security.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.AccidenteServicio;
import cl.titanium.security.model.Accidente;
import cl.titanium.security.repositories.AccidenteRepositorio;

@Service
public class AccidenteServicioImpl implements AccidenteServicio{
	
	@Autowired
	AccidenteRepositorio ar;
	
	@Override
	public void ingresarAccidente(Accidente accidente) {
		ar.save(accidente);
	}

	@Override
	public Accidente obtenerAccidente(int id_accidente) {	
		return ar.findOne(id_accidente);
	}

	/*@Override
	public List<Accidente> obtenerAccidentes(int id_cliente) {
		
		return (List<Accidente>) ar.findAll();
	}*/
	
	@Override
	public List<Accidente> obtenerAccidentesPorCliente(int id_cliente) {
		
		return ar.findAllByCliente(id_cliente);
	}

	@Override
	public List<Accidente> obtenerAccidentesPorClienteYFecha(int id_cliente, Date fecha) {
		// TODO Auto-generated method stub
		return ar.findAllByClienteFecha(id_cliente, fecha);
	}

	@Override
	public List<Accidente> obtenerAccidentesPorProfesional(int id_profesional) {
		// TODO Auto-generated method stub
		return ar.findAllbyPro(id_profesional);
	}

	@Override
	public List<Accidente> obtenerAccidentesPorProfesionalYFecha(int id_profesional, Date fecha) {
		// TODO Auto-generated method stub
		return ar.findAllByProFecha(id_profesional, fecha);
	}

	@Override
	public List<Accidente> obtenerAccidentesPorFecha(Date fecha, Date fechaActual) {
		// TODO Auto-generated method stub
		return ar.findAllByFecha(fecha, fechaActual);
	}

	@Override
	public void modificarAccidente(Accidente accidente) {
			ar.save(accidente);
	}
		
}
