package cl.titanium.security.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import cl.titanium.security.model.Cobro;

public interface CobroRepositorio extends CrudRepository<Cobro, Integer> {

	@Query(value="select id_pago, id_cliente, n_factura, fecha_limite, fecha_de_pago from cobro"
			+ " WHERE id_cliente=:id_cliente", nativeQuery = true)
	List<Cobro> findAllById_cliente(@Param(value="id_cliente") int id_cliente);
	
	@Query(value="SELECT id_Pago, id_cliente, n_factura, fecha_limite, fecha_de_pago FROM Cobro WHERE fecha_de_pago is null AND fecha_limite < :fecha",
			nativeQuery = true)
	List<Cobro> findAllNotificarAtraso(@Param(value="fecha") Date fecha);
	
	@Query(value="select id_Pago, id_cliente, n_factura, fecha_limite, fecha_de_pago from cobro where fecha_de_pago is null",
			nativeQuery = true)
	List<Cobro> findAllCobroImpago();
	
	@Query(value= "select id_Pago, id_cliente, n_factura, fecha_limite, fecha_de_pago from cobro where fecha_de_pago is not null and fecha_de_pago > fecha_limite",
			nativeQuery = true)
	List<Cobro> findAllCobroAtraso();
	
	@Query(value= "select id_Pago, id_cliente, n_factura, fecha_limite, fecha_de_pago from cobro where fecha_de_pago is not null and fecha_de_pago <= fecha_limite",
			nativeQuery = true)
	List<Cobro> findAllCobroAlDia();

}
