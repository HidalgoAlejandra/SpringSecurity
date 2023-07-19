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
@Table(name="visita")
@SequenceGenerator(name="VISITA_SEQ", sequenceName="VISITA_SEQ")

public class Visita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VISITA_SEQ")
	@Column(name="id_visita")
	int id_visita;
	@Column
	int id_asesoria;
	@Column
	Date fecha_visita;
	@Column
	boolean estado;
	
	public Visita() {
		super();
	}

	public Visita(int id_visita, int id_asesoria, Date fecha_visita, boolean estado) {
		super();
		this.id_visita = id_visita;
		this.id_asesoria = id_asesoria;
		this.fecha_visita = fecha_visita;
		this.estado = estado;
	}

	public Visita(int id_asesoria, Date fecha_visita, boolean estado) {
		super();
		this.id_asesoria = id_asesoria;
		this.fecha_visita = fecha_visita;
		this.estado = estado;
	}

	public int getId_visita() {
		return id_visita;
	}

	public void setId_visita(int id_visita) {
		this.id_visita = id_visita;
	}

	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public Date getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(Date fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}

