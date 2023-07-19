package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.Cliente;

public interface ClienteServicio {
	
			void crearCliente(Cliente cli);
			List<Cliente> leerCliente();
			void actualizarCliente(Cliente cli);
			void eliminarCliente(Cliente cli);
			Cliente obtenerCliente(int id_cliente);
			int obtenerIdCliente(String rut);
			Cliente obtenerClienteRut(String Rut_cliente);
}
