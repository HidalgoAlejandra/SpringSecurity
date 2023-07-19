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
@Table
@SequenceGenerator(name="ACCIDENTE_SEQ", sequenceName="ACCIDENTE_SEQ")
public class Accidente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCIDENTE_SEQ")
	@Column(name="id_accidente")
	private int id;
	@Column
	private int id_cliente;
	@Column(name="fecha_accidente")
	private Date fechaAccidente;
	@Column
	private String involucrado;
	@Column
	private String lugar;
	@Column
	private String actividad;
	@Column
	private String descripcion;

	public Accidente() {
		super();
	}

	public Accidente(int id_cliente, Date fechaAccidente, String involucrado, String lugar, String actividad,
			String descripcion) {
		super();
		this.id_cliente = id_cliente;
		this.fechaAccidente = fechaAccidente;
		this.involucrado = involucrado;
		this.lugar = lugar;
		this.actividad = actividad;
		this.descripcion = descripcion;
	}

	public Accidente(int id, int id_cliente, Date fechaAccidente, String involucrado, String lugar, String actividad,
			String descripcion) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.fechaAccidente = fechaAccidente;
		this.involucrado = involucrado;
		this.lugar = lugar;
		this.actividad = actividad;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getFechaAccidente() {
		return fechaAccidente;
	}

	public void setFechaAccidente(Date fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}

	public String getInvolucrado() {
		return involucrado;
	}

	public void setInvolucrado(String involucrado) {
		this.involucrado = involucrado;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
