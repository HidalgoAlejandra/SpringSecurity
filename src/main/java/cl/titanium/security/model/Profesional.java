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
@SequenceGenerator(name="PROFESIONAL_SEQ", sequenceName="PROFESIONAL_SEQ")
public class Profesional {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESIONAL_SEQ")
	int id_profesional;
	@Column
	String nombre_profesional;
	@Column
	String rut_profesional;
	@Column
	String telefono_corp;
	@Column
	String email_corp;
	
	public Profesional() {
		super();
	}
	
	public Profesional(String nombre_profesional, String rut_profesional, String telefono_corp, String email_corp) {
		super();
		this.nombre_profesional = nombre_profesional;
		this.rut_profesional = rut_profesional;
		this.telefono_corp = telefono_corp;
		this.email_corp = email_corp;
	}

	public Profesional(int id_profesional, String nombre_profesional, String rut_profesional, String telefono_corp,
			String email_corp) {
		super();
		this.id_profesional = id_profesional;
		this.nombre_profesional = nombre_profesional;
		this.rut_profesional = rut_profesional;
		this.telefono_corp = telefono_corp;
		this.email_corp = email_corp;
	}

	public int getId_profesional() {
		return id_profesional;
	}

	public void setId_profesional(int id_profesional) {
		this.id_profesional = id_profesional;
	}

	public String getNombre_profesional() {
		return nombre_profesional;
	}

	public void setNombre_profesional(String nombre_profesional) {
		this.nombre_profesional = nombre_profesional;
	}

	public String getRut_profesional() {
		return rut_profesional;
	}

	public void setRut_profesional(String rut_profesional) {
		this.rut_profesional = rut_profesional;
	}

	public String getTelefono_corp() {
		return telefono_corp;
	}

	public void setTelefono_corp(String telefono_corp) {
		this.telefono_corp = telefono_corp;
	}

	public String getEmail_corp() {
		return email_corp;
	}

	public void setEmail_corp(String email_corp) {
		this.email_corp = email_corp;
	}
	

	
	
}
