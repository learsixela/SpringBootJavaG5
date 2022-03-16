package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Auto;
import com.desafiolatam.models.Compra;
import com.desafiolatam.sevices.ClienteService;
import com.desafiolatam.sevices.CompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	CompraService compraService;
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping("")
	public String compra(Model model) {
		model.addAttribute("listaClientes", clienteService.findAll());
		model.addAttribute("compra", new Compra());
		
		return "compras.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearCompra(@Valid @ModelAttribute("compra") Compra compra,
			BindingResult result,
			Model model) {
		
		Compra compraCreada = compraService.save(compra);
		if(compraCreada == null) {
			model.addAttribute("msgError", "Error al registrar la compra");
		}
		
		return "redirect:/compra";
	}
	
	
}
