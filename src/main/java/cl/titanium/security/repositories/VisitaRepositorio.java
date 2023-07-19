package cl.titanium.security.repositories;

import cl.titanium.security.model.Visita;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VisitaRepositorio extends CrudRepository<Visita, Integer>{
	
	@Query(value="SELECT id_visita, visita.id_asesoria, fecha_visita, estado FROM visita "
			+ "JOIN asesoria ON (visita.id_asesoria = asesoria.id_asesoria) "
			+ "WHERE asesoria.id_cliente=:id_cliente", nativeQuery = true)
	List<Visita> findAllById_cliente(@Param(value="id_cliente")int id_cliente);

	@Query(value="SELECT id_visita, visita.id_asesoria, fecha_visita, estado FROM visita " 
			+ "JOIN asesoria ON (visita.id_asesoria = asesoria.id_asesoria) "
			+ "WHERE asesoria.id_profesional=:id_profesional", nativeQuery = true)
	List<Visita> findAllById_profesional(@Param(value="id_profesional") int id_profesional);
	
	@Query(value="SELECT id_visita,id_asesoria, fecha_visita, estado FROM visita "
			+ "WHERE fecha_visita >=:pMes and fecha_visita <:sMes ", nativeQuery = true)
	List<Visita> findAllByPmesSmes(@Param(value="pMes") Date pMes, @Param(value="sMes") Date sMes);

	@Query(value="SELECT MAX(id_visita) FROM visita", nativeQuery = true)
	int findLastId();

}