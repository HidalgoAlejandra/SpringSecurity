package cl.titanium.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.ClienteServicio;
import cl.titanium.security.model.Cliente;
import cl.titanium.security.repositories.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	ClienteRepositorio cr;
	
	@Override
	public void crearCliente(Cliente cli) {
		cr.save(cli);	
	}

	@Override
	public List<Cliente> leerCliente() {
		return (List<Cliente>) cr.findAll();
	}

	@Override
	public void actualizarCliente(Cliente cli) {
		cr.save(cli);
		
	}

	@Override
	public void eliminarCliente(Cliente cli) {
		cr.delete(cli);
		
	}

	@Override
	public Cliente obtenerCliente(int id_cliente) {
		return cr.findOne(id_cliente);
	}

	@Override
	public int obtenerIdCliente(String rut) {
		return cr.findIdCliente(rut);
	}

	@Override
	public Cliente obtenerClienteRut(String Rut_cliente) {
		return cr.findRutCliente(Rut_cliente);
	}

}
