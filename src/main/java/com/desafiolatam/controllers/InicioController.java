package com.desafiolatam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	//http://localhost:8080/
	//2.- anotacion del path o ruta
	@RequestMapping("/")
	//3.- metodo que realiza la solicitud
	public String index(Model model) {
		model.addAttribute("titulo", "Mi pagina");
		return "index.jsp";
	} 
}
