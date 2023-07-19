package cl.titanium.security.interf;

import java.sql.Date;
import java.util.List;

import cl.titanium.security.model.Asesoria;

public interface IAsesoria {
	
	public int ingresarAsesoria(Asesoria asesoria);

	public int borrarAsesoria(Asesoria asesoria);
	
	public int modificarAsesoria(Asesoria asesoria);
	
	public Asesoria obtenerAsesoria(int id_asesoria);
	
	public int obtenerUltimoId();
	
	public int solicitarAsesoria(Asesoria asesoria);

	List<Asesoria> asesoriames(Date pMes, Date sMes);

	List<Asesoria> clixpro();

	List<Asesoria> proxcli();

	List<Asesoria> obtenerListaAsesoriasPorCliente(int id_cliente);

	List<Asesoria> obtenerListaAsesoriasPorPro(int id_profesional);

	List<Asesoria> obtenerListaCasoAse();

	List<Asesoria> obtenerListaAsesorias();

	int aceptarcaso(Asesoria asesoria);

	List<Asesoria> obtenerListaAsesoriasPorClienteYPro(int id_cliente, int id_profesional);
}
