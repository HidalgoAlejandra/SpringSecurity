package cl.titanium.security.interfaces;

import cl.titanium.security.model.Usuario;

public interface UsuarioServicio {
	
	// Registra un usuario
	void ingresarUsuario(Usuario usuario);
	
	// Obtiene los datos de un usuario seg�n su id
	Usuario obtenerUsuario(int id_usuario);
	
	// Valida si un usuario est� registrado, entregando un objeto usuario como resultado
	Usuario validarUsuario(String usuario);
	
	// Cambia la contrase�a de un usuario por una nueva
	void cambiarPassword(Usuario usuario);

}
