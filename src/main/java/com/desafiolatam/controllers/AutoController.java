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
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	AutoService autoService;
	
	@Autowired
	ClienteService clienteService;
	
	
	@RequestMapping("/home")
	public String home(Model model,HttpSession session) {
		String emailSession= (String) session.getAttribute("emailUsuario");
		if(session.getAttribute("emailUsuario") != null || emailSession != null) {
			List<Auto> listaAutos =  autoService.findAll();
			model.addAttribute("listaAutos", listaAutos);
			model.addAttribute("auto", new Auto());
			
			model.addAttribute("listaClientes", clienteService.findAll());
			
		return "home.jsp";
		}else {
			return "redirect:/usuario/showlogin";
		}
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

		
		@RequestMapping("/insertar")
		public String insertar(@Valid @ModelAttribute("auto") Auto auto,
				BindingResult resultado) {
			if(resultado.hasErrors()) {
				//retornar mensaje de error
				
			}else {
				//insertar en base datos el objeto
				autoService.guardarAuto(auto);
			}
			
			return "redirect:/auto/home";
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
			
			return "redirect:/auto/home";
		}
		
		
		//autito/eliminar/{id}
		@RequestMapping("/eliminar/{id}")
		public String eliminar(@PathVariable("id") Long id) {
			autoService.deleteById(id);
			return "redirect:/auto/home";
		}

}
