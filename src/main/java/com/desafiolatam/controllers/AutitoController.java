package com.desafiolatam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Auto;
import com.desafiolatam.sevices.AutoService;
import com.desafiolatam.sevices.ClienteService;

@Controller
@RequestMapping("/autito")
public class AutitoController {
	@Autowired
	AutoService autoService;
	
	@Autowired
	ClienteService cService;
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		List<Auto> listaAutos = autoService.findAll();
		model.addAttribute("listaAutos", listaAutos);
		model.addAttribute("listaClientes", cService.findAll());
		return "home.jsp";


	}
	//despliegue jsp
	@RequestMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("auto", new Auto());
		return "crearAuto.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado) {
		if(resultado.hasErrors()) {
			//retornar mensaje de error
			
		}else {
			//insertar en base datos el objeto
			autoService.guardarAuto(auto);
		}
		
		return "redirect:/autito/home";
	}
	
	
	//autito/editar/{id}89
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,Model model) {
		//obtener el auto con el id
		Auto auto = autoService.findById(id);
		model.addAttribute("auto", auto);
		return "editarAuto.jsp";
	}
	
	@RequestMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado) {
		if(resultado.hasErrors()) {
			//retornar mensaje de error
			
		}else {
			//actualizar en base datos el objeto
			autoService.updateAuto(auto);
		}
		
		return "redirect:/autito/home";
	}
	
	
	//autito/eliminar/{id}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		autoService.deleteById(id);
		return "redirect:/autito/home";
	}
}
