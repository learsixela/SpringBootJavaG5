package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Direccion;
import com.desafiolatam.sevices.ClienteService;
import com.desafiolatam.sevices.DireccionService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	DireccionService direService;
	@Autowired
	ClienteService cService;
	
	@RequestMapping("")
	public String show(Model model) {
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("clientes", cService.findAll());
		
		return "direccion.jsp";
	}
	
	@RequestMapping("/crear")
	public String crear(@Valid @ModelAttribute("direccion") Direccion direccion,
			BindingResult result,
			Model model) {
		
		Direccion direccionNuevo = direService.save(direccion);
		model.addAttribute("direccion", direccionNuevo);
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
