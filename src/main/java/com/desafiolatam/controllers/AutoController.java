package com.desafiolatam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Auto;
import com.desafiolatam.sevices.AutoService;

@Controller
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	AutoService autoService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Auto> listaAutos =  autoService.findAll();
		model.addAttribute("listaAutos", listaAutos);
		model.addAttribute("auto", new Auto());
		
		return "home.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearAuto(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult result,
			Model model) {
		
		boolean autoCreado = autoService.guardarAuto(auto);
		if(autoCreado) {
			model.addAttribute("msgError", "Error al crear auto");
		}
		
		return "redirect:/auto/home";
	}

}
