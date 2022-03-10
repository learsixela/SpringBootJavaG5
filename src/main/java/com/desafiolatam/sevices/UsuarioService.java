package com.desafiolatam.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	// Se realiza la logica de negocio
	@Autowired
	UsuarioRepository usuarioRepository;

	public void guardarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (usuarioRetorno != null) {
			usuarioRepository.save(usuario);
		}
	}

	public boolean login(String email, String password) {
		// buscar si existe con ese email
		Usuario usuario = usuarioRepository.findByCorreo(email);
		
		if (usuario != null) {//si existe o no el correo
			if (usuario.getPassword().equals(password)) {//si password son iguales
				return true;
			} else {
				return false;//pasword distintos
			}
		}else {
			return false;//no existe ese correo
		}
	}

}
