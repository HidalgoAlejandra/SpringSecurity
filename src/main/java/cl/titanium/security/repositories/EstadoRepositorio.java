package cl.titanium.security.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Estado;

public interface EstadoRepositorio extends CrudRepository<Estado, Integer>{

	@Query(value="SELECT id_tarea, id_checklist, completado FROM estado WHERE id_tarea=:id_tarea AND id_checklist=:id_checklist",
			nativeQuery = true)
	Estado findOneEstado(@Param(value="id_tarea")int id_t, @Param(value="id_checklist")int id_c);

}
