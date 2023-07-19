package cl.titanium.security.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="checklist")
@SequenceGenerator(name="CHECKLIST_SEQ", sequenceName="CHECKLIST_SEQ")
public class Checklist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHECKLIST_SEQ")
	@Column(name="id_checklist")
	private int id_checklist;
	@Column
	private int id_cliente;
	@Column
	private Date fecha_creacion;
	@Column
	private Date fecha_cambio;
	
	public Checklist(int id_checklist, int id_cliente, Date fecha_creacion, Date fecha_cambio) {
		super();
		this.id_checklist = id_checklist;
		this.id_cliente = id_cliente;
		this.fecha_creacion = fecha_creacion;
		this.fecha_cambio = fecha_cambio;
	}
	
	public Checklist(int id_cliente, Date fecha_creacion, Date fecha_cambio) {
		super();
		this.id_cliente = id_cliente;
		this.fecha_creacion = fecha_creacion;
		this.fecha_cambio = fecha_cambio;
	}

	public Checklist() {
		super();
	}

	public int getId_checklist() {
		return id_checklist;
	}

	public void setId_checklist(int id_checklist) {
		this.id_checklist = id_checklist;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_cambio() {
		return fecha_cambio;
	}

	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}

	
	
}
