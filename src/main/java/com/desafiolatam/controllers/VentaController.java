package com.desafiolatam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Venta;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("venta") Venta venta, Model model) {
		return "venta.jsp";
	}

}
