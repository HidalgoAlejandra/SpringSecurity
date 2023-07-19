package cl.titanium.security.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Accidente;

public interface AccidenteRepositorio extends CrudRepository<Accidente, Integer> {
	
	@Query(value="SELECT id_accidente, id_cliente, fecha_accidente, involucrado, lugar,"
	+" actividad, descripcion FROM accidente WHERE id_cliente=:id_cliente", nativeQuery = true)
	List<Accidente> findAllByCliente(@Param(value="id_cliente") int id_cliente);

	@Query(value="SELECT id_accidente, id_cliente, fecha_accidente, " 
			+ "involucrado, lugar, actividad, descripcion FROM accidente "
			+ "WHERE id_cliente=:id_cliente AND fecha_accidente>:fecha", nativeQuery = true)
	List<Accidente> findAllByClienteFecha(@Param(value="id_cliente") int id_cliente, @Param(value="fecha") Date fecha);

	@Query(value="SELECT id_accidente, id_cliente, fecha_accidente, " 
			+ "involucrado, lugar, actividad, descripcion FROM accidente WHERE fecha_accidente>:fecha AND fecha_accidente <= :fecha_actual", nativeQuery = true)
	List<Accidente> findAllByFecha(@Param(value="fecha") Date fecha, @Param(value="fecha_actual") Date fechaActual);
	
	@Query(value="SELECT id_accidente, id_cliente, fecha_accidente, " 
				+ "involucrado, lugar, actividad, descripcion FROM accidente WHERE id_cliente IN(" 
				+ "SELECT id_cliente FROM asesoria WHERE id_profesional=:pro) "
				+ "AND fecha_accidente>:fecha", nativeQuery = true)
	List<Accidente> findAllByProFecha(@Param(value="pro") int id_profesional, @Param(value="fecha")Date fecha);
	
	@Query(value="SELECT id_accidente, id_cliente, fecha_accidente, " 
			+ "involucrado, lugar, actividad, descripcion FROM accidente WHERE id_cliente IN("
			+ "SELECT id_cliente FROM asesoria WHERE id_profesional=:pro)", nativeQuery = true)
	List<Accidente> findAllbyPro(@Param(value="pro")int id_profesional);

}
