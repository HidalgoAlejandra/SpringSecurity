package cl.titanium.security.model;

public class Administrador {
	
	private int id_usuario;
	private String tipo;
	private String usuario;
	private String password;
	
	
	
	public Administrador() {
		
	}


	public Administrador(int id_usuario, String tipo, String usuario, String password) {
		super();
		this.id_usuario = id_usuario;
		this.tipo = tipo;
		this.usuario = usuario;
		this.password = password;
	}
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
