package cl.titanium.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Tarea;

public interface TareaRepositorio extends CrudRepository<Tarea, Integer>{

	@Query(value="SELECT id_tarea, nombre, detalle_tarea from tarea WHERE id_tarea IN "
			+ "(SELECT id_tarea FROM estado WHERE id_checklist=:id_checklist)", nativeQuery = true)
	List<Tarea> findAllLista(@Param(value="id_checklist") int id_checklist);

	@Query(value="SELECT MAX(id_tarea) FROM tarea", nativeQuery = true)
	int findLastId();

}
