package cl.titanium.security.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Asesoria;


public interface AsesoriaRepositorio extends CrudRepository<Asesoria, Integer>{
	
	
	@Query(value="SELECT MAX(id_asesoria) AS ultimo_id FROM asesoria", nativeQuery = true)
	int findLastID();

	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
			" FROM asesoria WHERE fecha_solicitud >= :pMes AND fecha_solicitud <:sMes ", nativeQuery = true)
	List<Asesoria> findAllByMes(@Param(value="pMes") String pMes, @Param(value="sMes") String sMes);

	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
        " FROM asesoria order by id_profesional", nativeQuery = true)
	List<Asesoria> clixpro();

	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
			" FROM asesoria order by id_cliente", nativeQuery = true)
	List<Asesoria> proxcli();
	
	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
			" FROM asesoria WHERE id_cliente=:id_cliente", nativeQuery = true)
	List<Asesoria> findAllByCliente(@Param(value="id_cliente") int id_cliente);
	
	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
			" FROM asesoria WHERE id_profesional=:id_profesional", nativeQuery = true)
	List<Asesoria> findAllByProfesional(@Param(value="id_profesional") int id_profesional);
	
	@Query(value="SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud " + 
			" FROM asesoria WHERE id_profesional IS null", nativeQuery = true)
	List<Asesoria> findAllCasoAse();

	@Query(value="INSERT INTO asesoria (id_cliente, fecha_solicitud, estado_asesoria, detalle_solicitud) " + 
			" VALUES (:id_cliente, :fecha_solicitud, :estado_asesoria, :detalle_solicitud)", nativeQuery = true)
	void solicitarAsesoria(@Param(value="id_cliente") int id_cliente, @Param(value="fecha_solicitud") Date fecha,
			@Param(value="estado_asesoria") boolean estado, @Param(value="detalle_solicitud") String detalle);	

	

}
