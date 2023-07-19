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
@SequenceGenerator(name="USUARIO_SEQ", sequenceName="USUARIO_SEQ")
public class Usuario {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_SEQ")
	private int id_usuario;
	private String tipo;
	@Column(name="usuario")
	private String username;
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Usuario(String tipo, String username, String password) {
		super();
		this.tipo = tipo;
		this.username = username;
		this.password = password;
	}

	public Usuario(int id, String tipo, String username, String password) {
		super();
		this.id_usuario = id;
		this.tipo = tipo;
		this.username = username;
		this.password = password;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id) {
		this.id_usuario = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
