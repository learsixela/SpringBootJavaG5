package com.desafiolatam.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//1.- nos permite capturar ruta
@RestController
public class HomeController {


	//http://localhost:8080/hola
	@RequestMapping("/hola")
	public String saludo() {
		return "Hola desde el metodo saludo";
	}
	
	//http://localhost:8080/parametro?nombre=ISRA&apellido=Palma
	@RequestMapping("/parametro")
	public String parametro(@RequestParam(value="nombre") String nombre,
			@RequestParam(value="apellido") String apellido) {
		return "Hola, "+nombre+ " "+apellido;
	}
	
	//CAPTURANDO VARIABLES DESDE EL PATH(ruta)
	
	//http://localhost:8080/fecha/anio/2022/mes/3/dia/7
	@RequestMapping("/fecha/anio/{anio}/mes/{mes}/dia/{dia}")
	public String obtenerFecha(@PathVariable("anio") Integer anio,
			@PathVariable("mes") Integer mes,
			@PathVariable("dia") Integer dia) {
		
		return "Fecha de hoy: "+ dia+"/"+mes+"/"+anio;//Fecha de hoy: 7/3/2022
		
	}
	//http://localhost:8080/fecha/2022/3/7
	@RequestMapping("/fecha/{anio}/{mes}/{dia}")
	public String obtenerFecha2(@PathVariable("anio") Integer anio,
			@PathVariable("mes") Integer mes,
			@PathVariable("dia") Integer dia) {
		
		return "Fecha de hoy: "+ dia+"/"+mes+"/"+anio;//Fecha de hoy: 7/3/2022
	}
}
