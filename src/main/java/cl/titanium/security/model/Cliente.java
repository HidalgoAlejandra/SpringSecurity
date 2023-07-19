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
@SequenceGenerator(name="CLIENTE_SEQ", sequenceName="CLIENTE_SEQ")
public class Cliente {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_SEQ")
	int id_cliente;
	@Column
	String razon_social;
	@Column
	int	rut_empresa;
	@Column
	String giro;
	@Column
	String direccion;
	@Column
	String fono_contacto;
	@Column
	String representante_legal;
	@Column
	String contacto;
	@Column
	String email_contacto;
	
	//Constructor vacío
	public Cliente() {
	}
	
	//contructor lleno
	public Cliente(int id_cliente, String razon_social, int rut_empresa, String giro, String direccion,
			String fono_contacto, String representante_legal, String contacto, String email_contacto) {
		
		this.id_cliente = id_cliente;
		this.razon_social = razon_social;
		this.rut_empresa = rut_empresa;
		this.giro = giro;
		this.direccion = direccion;
		this.fono_contacto = fono_contacto;
		this.representante_legal = representante_legal;
		this.contacto = contacto;
		this.email_contacto = email_contacto;
	}

	public Cliente(String razon_social, int rut_empresa, String giro, String direccion, String fono_contacto,
			String representante_legal, String contacto, String email_contacto) {
		super();
		this.razon_social = razon_social;
		this.rut_empresa = rut_empresa;
		this.giro = giro;
		this.direccion = direccion;
		this.fono_contacto = fono_contacto;
		this.representante_legal = representante_legal;
		this.contacto = contacto;
		this.email_contacto = email_contacto;
	}

	//getters and setters
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public int getRut_empresa() {
		return rut_empresa;
	}

	public void setRut_empresa(int rut_empresa) {
		this.rut_empresa = rut_empresa;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFono_contacto() {
		return fono_contacto;
	}

	public void setFono_contacto(String fono_contacto) {
		this.fono_contacto = fono_contacto;
	}

	public String getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(String representante_legal) {
		this.representante_legal = representante_legal;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail_contacto() {
		return email_contacto;
	}

	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}
	
	
	
	
	
	
}
