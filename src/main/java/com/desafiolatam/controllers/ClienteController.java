package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.sevices.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService cService;
	
	@RequestMapping("")
	public String show(Model model) {
		model.addAttribute("cliente", new Cliente());
		
		return "cliente.jsp";
	}
	
	@RequestMapping("/crear")
	public String crear(@Valid @ModelAttribute("cliente") Cliente cliente,
			BindingResult result,
			Model model) {
		
		Cliente clienteNuevo = cService.save(cliente);
		model.addAttribute("cliente", clienteNuevo);
		return "redirect:/direccion";
	}

	@RequestMapping("/mostrar")
	public String mostrar() {
		return "";
	}
	
	@RequestMapping("/editar")
	public String editar() {
		return "";
	}
	
	@RequestMapping("/actualizar")
	public String actualizar() {
		return "";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar() {
		return "";
	}
}
