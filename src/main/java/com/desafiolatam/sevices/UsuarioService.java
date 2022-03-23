package com.desafiolatam.sevices;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	// Se realiza la logica de negocio
	@Autowired
	UsuarioRepository usuarioRepository;

	public boolean guardarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (usuarioRetorno == null) {
			//password encriptado
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			//1234 -> $223tgf4vt45tvt534dsvhdj
			usuario.setPassword(passHashed);
			
			usuarioRepository.save(usuario);
			return true;
		}else {
			return false;
		}
	}

	public boolean login(String email, String password) {
		// buscar si existe con ese email
		Usuario usuario = usuarioRepository.findByCorreo(email);
		
		if (usuario != null) {//si existe o no el correo
			//if (usuario.getPassword().equals(password)) {//si password son iguales
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;//pasword distintos
			}
		}else {
			return false;//no existe ese correo
		}
	}

}
