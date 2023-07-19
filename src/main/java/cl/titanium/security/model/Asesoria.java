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
@SequenceGenerator(name="ASESORIA_SEQ", sequenceName="ASESORIA_SEQ")
public class Asesoria {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASESORIA_SEQ")
	int id_asesoria;
	@Column
	int id_cliente;
	@Column(insertable = false)
	Integer id_profesional;
	@Column
	Date fecha_solicitud;
	@Column
	boolean estado_asesoria;
	@Column
	String detalle_solicitud;
	
	public Asesoria(int id_cliente, Date fecha_solicitud, String detalle_solicitud) {
		super();
		this.id_cliente = id_cliente;
		this.fecha_solicitud = fecha_solicitud;
		this.detalle_solicitud = detalle_solicitud;
	}


	public Asesoria(int id_cliente, int id_profesional, Date fecha_solicitud, boolean estado_asesoria,
			String detalle_solicitud) {
		super();
		this.id_cliente = id_cliente;
		this.id_profesional = id_profesional;
		this.fecha_solicitud = fecha_solicitud;
		this.estado_asesoria = estado_asesoria;
		this.detalle_solicitud = detalle_solicitud;
	}


	public Asesoria(int id_asesoria, int id_cliente, int id_profesional, Date fecha_solicitud,
			boolean estado_asesoria, String detalle_solicitud) {
		super();
		this.id_asesoria = id_asesoria;
		this.id_cliente = id_cliente;
		this.id_profesional = id_profesional;
		this.fecha_solicitud = fecha_solicitud;
		this.estado_asesoria = estado_asesoria;
		this.detalle_solicitud = detalle_solicitud;
	}

	public Asesoria(int id_cliente, int id_profesional, Date fecha_solicitud, boolean estado_asesoria) {
		super();
		this.id_cliente = id_cliente;
		this.id_profesional = id_profesional;
		this.fecha_solicitud = fecha_solicitud;
		this.estado_asesoria = estado_asesoria;
	}

	public Asesoria() {
		super();
	}

	
	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_profesional() {
		return id_profesional;
	}

	public void setId_profesional(Integer id_profesional) {
		this.id_profesional = id_profesional;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public boolean isEstado_asesoria() {
		return estado_asesoria;
	}

	public void setEstado_asesoria(boolean estado_asesoria) {
		this.estado_asesoria = estado_asesoria;
	}


	public String getDetalle_solicitud() {
		return detalle_solicitud;
	}


	public void setDetalle_solicitud(String detalle_solicitud) {
		this.detalle_solicitud = detalle_solicitud;
	}
	

}
