package cl.titanium.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.titanium.security.interfaces.UsuarioServicio;
import cl.titanium.security.model.Usuario;
import cl.titanium.security.repositories.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	UsuarioRepositorio ur;
	
	@Override
	public void ingresarUsuario(Usuario usuario) {
		ur.save(usuario);
		
	}

	@Override
	public Usuario obtenerUsuario(int id_usuario) {
		return ur.findOne(id_usuario);
	}

	@Override
	public Usuario validarUsuario(String usuario) {
		return ur.findByUsername(usuario);
	}

	@Override
	public void cambiarPassword(Usuario usuario) {
		ur.save(usuario);
		
	}
	

}
