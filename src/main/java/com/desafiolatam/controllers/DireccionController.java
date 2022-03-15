package com.desafiolatam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.models.Direccion;
import com.desafiolatam.sevices.ClienteService;
import com.desafiolatam.sevices.DireccionService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	DireccionService direService;
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping("")
	public String show(@ModelAttribute("direccion") Direccion direccion,
			Model model) {
		List<Cliente> listaClientes= clienteService.findAll();
		model.addAttribute("listaClientes", listaClientes);
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
