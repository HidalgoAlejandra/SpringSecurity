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
@SequenceGenerator(name="ESTADO_SEQ", sequenceName="ESTADO_SEQ")
public class Estado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_SEQ")
	int id_checklist;
	@Column
	int id_tarea;
	@Column
	boolean completado;
	
	public Estado() {
		super();
	}
	
	public Estado(int id_checklist, int id_tarea, boolean completado) {
		super();
		this.id_checklist = id_checklist;
		this.id_tarea = id_tarea;
		this.completado = completado;
	}
	
	public int getId_checklist() {
		return id_checklist;
	}
	
	public void setId_checklist(int id_checklist) {
		this.id_checklist = id_checklist;
	}
	
	public int getId_tarea() {
		return id_tarea;
	}
	
	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	
	public boolean isCompletado() {
		return completado;
	}
	
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	
	
	

}
