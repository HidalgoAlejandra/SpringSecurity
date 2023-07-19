package cl.titanium.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="TAREA_SEQ", sequenceName="TAREA_SEQ")
public class Tarea {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAREA_SEQ")
	int id_tarea;
	@Column
	String nombre;
	@Column
	String detalle_tarea;
	
	public Tarea() {
		super();
	}
	
	public Tarea(String nombre, String detalle_tarea) {
		super();
		this.nombre = nombre;
		this.detalle_tarea = detalle_tarea;
	}

	public Tarea(int id_tarea, String nombre, String detalle_tarea) {
		super();
		this.id_tarea = id_tarea;
		this.nombre = nombre;
		this.detalle_tarea = detalle_tarea;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle_tarea() {
		return detalle_tarea;
	}

	public void setDetalle_tarea(String detalle_tarea) {
		this.detalle_tarea = detalle_tarea;
	}
	
	
	

}
