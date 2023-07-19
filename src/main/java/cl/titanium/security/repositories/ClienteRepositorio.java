package cl.titanium.security.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente,Integer> {

	@Query(value="SELECT id_cliente FROM cliente WHERE rut_empresa=:rut", nativeQuery = true)
	int findIdCliente(@Param(value="rut") String rut);

	@Query(value="SELECT id_cliente, razon_social, rut_empresa, giro, direccion, fono_contacto, representante_legal,"
			+ " contacto, email_contacto  FROM cliente WHERE rut_empresa=:rut_cliente", nativeQuery = true)
	Cliente findRutCliente(@Param(value="rut_cliente") String rut_cliente);

	
}
