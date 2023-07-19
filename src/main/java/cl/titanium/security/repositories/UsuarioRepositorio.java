package cl.titanium.security.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer> {

	
	@Query(value="SELECT id_usuario, tipo, usuario, password FROM usuario WHERE usuario=:user",nativeQuery=true)
	Usuario findByUsername(@Param(value="user") String usuario);
	
	
}
