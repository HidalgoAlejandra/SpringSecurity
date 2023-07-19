package cl.titanium.security.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.titanium.security.interfaces.CobroServicio;
import cl.titanium.security.repositories.CobroRepositorio;
import cl.titanium.security.model.Cobro;

@Service
public class CobroServicioImpl implements CobroServicio{

	@Autowired
	CobroRepositorio cr;
	
	
	@Override
	public void crearCobro(Cobro cob) {
		cr.save(cob);
	}
	
	@Override
	public List<Cobro> leerCobro(){
		return (List<Cobro>) cr.findAll();
		
	}
	
	@Override
	public void editarCobro(Cobro cob) {
		cr.save(cob);
	}
	
	@Override
	public void eliminarCobro(Cobro cob) {
		cr.delete(cob);
	}
	
	@Override
	public Cobro obtenerCobro(int id_pago) {
		return cr.findOne(id_pago);
	}
		
		
	@Override
	public List<Cobro> reporteCobroNotificarAtrasos(Date fecha){
		return (List<Cobro>) cr.findAllNotificarAtraso(fecha);
		
	}
	
	@Override
	public List<Cobro> obtenerCobros(int id_cliente){
		return (List<Cobro>) cr.findAllById_cliente(id_cliente);
		
	}
	
	@Override
	public List<Cobro> cobroipago(){
		return (List<Cobro>) cr.findAllCobroImpago();
		
	}
	
	@Override
	public List<Cobro> cobroatraso(){
		return (List<Cobro>) cr.findAllCobroAtraso();
		
	}
	
	@Override
	public List<Cobro> cobroaldia(){
		return (List<Cobro>) cr.findAllCobroAlDia();
		
	}


}
