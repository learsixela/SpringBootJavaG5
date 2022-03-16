package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Producto;
import com.desafiolatam.sevices.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String show(Model model) {
		model.addAttribute("producto", new Producto());
		return "producto.jsp";
	}

	@RequestMapping("/insertar")
	public String insertar(@Valid @ModelAttribute("producto") Producto producto,
			BindingResult result,
			Model model) {
		
		Producto productoNuevo = productoService.save(producto);
		model.addAttribute("producto", productoNuevo);
		return "redirect:/producto";
	}
}
