package cl.titanium.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.titanium.security.model.Capacitacion;


public interface CapacitacionRepositorio extends CrudRepository<Capacitacion, Integer> {

	
@Query(value="SELECT id_capacitacion, participantes, tema, fecha_capacitacion, id_actividad FROM capacitacion WHERE id_actividad IN "
		+ "(SELECT id_actividad FROM actividad_de_mejora WHERE id_asesoria IN "
		+ "(SELECT id_asesoria FROM asesoria WHERE id_cliente=:id_cliente))", nativeQuery = true)
List<Capacitacion> findAllById_cliente(@Param(value="id_cliente") int id_cliente);

@Query(value = "SELECT id_capacitacion, participantes, tema, fecha_capacitacion, id_actividad FROM capacitacion WHERE id_actividad IN "
		+ "(SELECT id_actividad FROM actividad_de_mejora WHERE id_asesoria IN "
		+ "(SELECT id_asesoria FROM asesoria WHERE id_profesional=:id_profesional))",nativeQuery = true)
List<Capacitacion> findAllById_profesional(@Param(value="id_profesional") int id_profesional);
}

