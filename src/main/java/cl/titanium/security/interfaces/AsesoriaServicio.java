package cl.titanium.security.interfaces;

import java.util.List;

import cl.titanium.security.model.Asesoria;

public interface AsesoriaServicio {
	
	void ingresarAsesoria(Asesoria asesoria);

	void borrarAsesoria(Asesoria asesoria);
	
	void modificarAsesoria(Asesoria asesoria);
	
	Asesoria obtenerAsesoria(int id_asesoria);
	
	int obtenerUltimoId();
	
	void solicitarAsesoria(Asesoria asesoria);

	List<Asesoria> asesoriames(String pMes, String sMes);

	List<Asesoria> clixpro();

	List<Asesoria> proxcli();

	List<Asesoria> obtenerListaAsesoriasPorCliente(int id_cliente);

	List<Asesoria> obtenerListaAsesoriasPorPro(int id_profesional);

	List<Asesoria> obtenerListaCasoAse();

	List<Asesoria> obtenerListaAsesorias();

	void aceptarcaso(Asesoria asesoria);
}
