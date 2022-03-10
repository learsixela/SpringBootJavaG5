package com.desafiolatam.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	//Se realiza la logica de negocio
	@Autowired
	UsuarioRepository usuarioRepository;

	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	
}
