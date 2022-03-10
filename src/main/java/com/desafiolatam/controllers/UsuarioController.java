package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.sevices.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	//inyeccion de dependencia
	@Autowired
	UsuarioService usuarioService;
	
	
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
	//http://localhost:8080/usuario/registro
	@RequestMapping("/registro")
	public String registro(Model model, @ModelAttribute("usuario") Usuario usuario ) {
		model.addAttribute("titulo", "Mi pagina");
		return "registro.jsp";
	}
	
	@RequestMapping("/formulario")
	public String formulario(@Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("msgError", "Debe ingresar todos los campos");
			return "registro.jsp";
		}else {
			usuarioService.guardarUsuario(usuario);
			return "redirect:/usuario/showlogin";
		}
	}
		
	
	//mostrar el jsp
	@RequestMapping("/showlogin")
	public String showlogin(Model model) {
		model.addAttribute("titulo", "Mi pagina");
		return "login.jsp";
	}
	
	//capturar los datos desde el jsp
	@RequestMapping("/login")
	public String login(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password) {
		System.out.println("password "+ password);
		System.out.println("email "+ email);
		return "login.jsp";
	}
	
}
