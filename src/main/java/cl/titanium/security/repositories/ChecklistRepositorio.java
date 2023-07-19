package cl.titanium.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Checklist;

public interface ChecklistRepositorio extends CrudRepository<Checklist, Integer>{
	
	@Query(value="select id_checklist, id_cliente, fecha_creacion, fecha_cambio from checklist"
			+ " WHERE id_cliente=:id_cliente", nativeQuery = true)
	List<Checklist> findAllById_cliente(@Param(value="id_cliente") int id_cliente);
	
	@Query(value="select distinct id_checklist, checklist.id_cliente AS id_cliente, fecha_creacion,"
			+ " fecha_cambio from checklist join asesoria on checklist.id_cliente = asesoria.id_cliente"
			+ " where asesoria.id_profesional = :id_profesional", nativeQuery = true)
	List<Checklist> findAllById_profesional(@Param(value="id_profesional") int id_profesional);

}
