package com.desafiolatam.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	//http://localhost:8080/usuario/
	@RequestMapping("/")
	public String inicioUsuario() {
		return "Hola desde el controlador Usuario";
	}
	//http://localhost:8080/usuario/editar
	@RequestMapping("/editar")
	public String editar() {
		return "metodo editar en UsuarioController";
	}

	@RequestMapping("/editar/bloqueos")
	public String editarBloqueos() {
		return "metodo editarBloqueos en UsuarioController";
	}
}
