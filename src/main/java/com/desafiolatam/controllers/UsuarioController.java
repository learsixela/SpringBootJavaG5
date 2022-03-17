package com.desafiolatam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.models.Venta;
import com.desafiolatam.sevices.UsuarioService;
import com.desafiolatam.sevices.VentaService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	//inyeccion de dependencia
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	VentaService ventaService;
	
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
			boolean resultado = usuarioService.guardarUsuario(usuario);
			if(resultado) {
				
				return "redirect:/usuario/showlogin";
			}else {
				model.addAttribute("msgError", "Correo ya existe");
				return "registro.jsp";
			}
		}
	}
		
	
	//mostrar el jsp
	@RequestMapping("/showlogin")
	public String showlogin(Model model) {
		Venta venta = new Venta();
		Venta ventaInsertada = ventaService.save(venta);
		
		model.addAttribute("titulo", "Mi pagina");
		return "login.jsp";
	}
	
	//capturar los datos desde el jsp
	@RequestMapping("/login")
	public String login(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,Model model,
			HttpSession session) {
		
		System.out.println("password "+ password);
		System.out.println("email "+ email);
		if(email.equals("")|| password.equals("")) {
			model.addAttribute("msgError", "Correo y Password Obligatorios");
			return "login.jsp";
		}
		boolean logueado = usuarioService.login(email, password);
		
		if(logueado) {//si es true, enviar a su home
			session.setAttribute("emailUsuario", email);
			
			return "redirect:/auto/home";
			
		}else {//datos erroneos
			model.addAttribute("msgError", "Error al ingresar al sistema");
			return "login.jsp";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
