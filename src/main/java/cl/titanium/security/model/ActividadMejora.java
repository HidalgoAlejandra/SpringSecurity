package cl.titanium.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="actividad_de_mejora")
@SequenceGenerator(name="ACTIVIDAD_DE_MEJORA_SEQ", sequenceName="ACTIVIDAD_DE_MEJORA_SEQ")
public class ActividadMejora {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVIDAD_DE_MEJORA_SEQ")
	private int id_actividad;
	@Column
	private int id_asesoria;
	@Column
	private boolean realizado;
	@Column
	private String detalle_actividad;
	
	public ActividadMejora(int id_actividad, int id_asesoria, boolean realizado, String detalle) {
		super();
		this.id_actividad = id_actividad;
		this.id_asesoria = id_asesoria;
		this.realizado = realizado;
		this.detalle_actividad = detalle;
	}

	public ActividadMejora(int id_asesoria, boolean realizado, String detalle) {
		super();
		this.id_asesoria = id_asesoria;
		this.realizado = realizado;
		this.detalle_actividad = detalle;
	}

	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public ActividadMejora() {
		super();
	}

	public int getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public String getDetalle_actividad() {
		return detalle_actividad;
	}

	public void setDetalle_actividad(String detalle_actividad) {
		this.detalle_actividad = detalle_actividad;
	}
	
	
	


	
}
