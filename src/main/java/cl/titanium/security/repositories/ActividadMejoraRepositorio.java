package cl.titanium.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.ActividadMejora;



public interface ActividadMejoraRepositorio extends CrudRepository<ActividadMejora, Integer> {

	@Query(value="SELECT MAX(id_actividad) AS ultimo_id FROM actividad_de_mejora", nativeQuery = true)
	int findLastId();
	@Query(value="SELECT distinct id_actividad, acm.id_asesoria AS id_asesoria, realizado, detalle_actividad, "
			+ "id_cliente  FROM actividad_de_mejora acm JOIN asesoria ase ON (acm.id_asesoria = ase.id_asesoria) "
			+ "WHERE id_cliente=:id_cliente", nativeQuery = true)
	List<ActividadMejora> findAllByCliente(@Param(value="id_cliente") int id_cliente);
}
