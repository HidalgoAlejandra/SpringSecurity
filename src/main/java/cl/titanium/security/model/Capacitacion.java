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
@SequenceGenerator(name="CAPACITACION_SEQ", sequenceName="CAPACITACION_SEQ")
public class Capacitacion {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAPACITACION_SEQ")
  int id_capacitacion;
	@Column
  int id_actividad;
	@Column
  int participantes;
	@Column
  String tema;
	@Column
  Date fecha_capacitacion;

public Capacitacion() {
	super();
}


public Capacitacion(int id_actividad, int participantes, String tema, Date fecha_capacitacion) {
	super();
	this.id_actividad = id_actividad;
	this.participantes = participantes;
	this.tema = tema;
	this.fecha_capacitacion = fecha_capacitacion;
}


public Capacitacion(int id_capacitacion, int id_actividad, int participantes, String tema, Date fecha_capacitacion) {
	super();
	this.id_capacitacion = id_capacitacion;
	this.id_actividad = id_actividad;
	this.participantes = participantes;
	this.tema = tema;
	this.fecha_capacitacion = fecha_capacitacion;
}


public int getId_capacitacion() {
	return id_capacitacion;
}


public void setId_capacitacion(int id_capacitacion) {
	this.id_capacitacion = id_capacitacion;
}


public int getId_actividad() {
	return id_actividad;
}


public void setId_actividad(int id_actividad) {
	this.id_actividad = id_actividad;
}


public int getParticipantes() {
	return participantes;
}


public void setParticipantes(int participantes) {
	this.participantes = participantes;
}


public String getTema() {
	return tema;
}


public void setTema(String tema) {
	this.tema = tema;
}


public Date getFecha_capacitacion() {
	return fecha_capacitacion;
}


public void setFecha_capacitacion(Date fecha_capacitacion) {
	this.fecha_capacitacion = fecha_capacitacion;
}


}
