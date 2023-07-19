package cl.titanium.security.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import cl.titanium.security.model.Profesional;

public interface ProfesionalRepositorio extends CrudRepository<Profesional,Integer> {
	
	@Query(value="SELECT id_profesional FROM profesional WHERE rut_profesional=:rut", nativeQuery = true)
	int findIdProfesional(@Param(value="rut") String rut);


}

