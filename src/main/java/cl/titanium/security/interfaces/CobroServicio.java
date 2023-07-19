package cl.titanium.security.interfaces;

import java.sql.Date;
import java.util.List;

import cl.titanium.security.model.Cobro;

public interface CobroServicio {
	
	void crearCobro(Cobro cob);
	List<Cobro> leerCobro();
	void editarCobro(Cobro cob);
	void eliminarCobro(Cobro cob);
	Cobro obtenerCobro(int id_pago);
	
	List<Cobro> reporteCobroNotificarAtrasos(Date fecha);
	List<Cobro> obtenerCobros(int id_cliente);
	List<Cobro> cobroipago();
	List<Cobro> cobroatraso();
	List<Cobro> cobroaldia();
	
}
	