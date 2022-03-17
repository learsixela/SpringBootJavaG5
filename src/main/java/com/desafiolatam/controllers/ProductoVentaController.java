package com.desafiolatam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.Producto;
import com.desafiolatam.models.ProductoVenta;
import com.desafiolatam.models.Venta;
import com.desafiolatam.sevices.ProductoService;
import com.desafiolatam.sevices.ProductoVentaService;
import com.desafiolatam.sevices.VentaService;

@Controller
@RequestMapping("/productoVenta")
public class ProductoVentaController {
	@Autowired
	ProductoVentaService productoVentaService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ProductoService productoService;
	
	//SOLO EL DEPLIEGUE INICIAL, PARA QUE GENERE LA VENTA, Y PODER USAR EL ID DE LA VENTA
	@RequestMapping("")
	public String inicio(@ModelAttribute("ProductoVenta") ProductoVenta productoVenta, Model model) {
		Venta venta = new Venta();
		Venta ventaInsertada = ventaService.save(venta);
		//crear la venta vacia
		model.addAttribute("venta", ventaInsertada);
		
		List<Producto> listaProducto = productoService.findAll();
		model.addAttribute("listaProducto", listaProducto);
		
		return "productoVenta.jsp";
	}
	
	
	@RequestMapping("/insertar/{id}")
	public String insertar(@PathVariable("id") Long idVenta,
			@RequestParam(value="producto") Long idProducto,
			@RequestParam(value="cantidad") Integer cantidad,
			Model model) {
		//TODO validar 
		System.out.println("Parametros: "+ idVenta +" "+ idProducto+" "+cantidad);
		
		//imprimir los parametros
		//buscar los datos
		Venta venta = ventaService.findById(idVenta);
		Producto producto = productoService.findById(idProducto);
		
		//calculo de precio venta
		double precioVenta = producto.getPrecio() * cantidad;
		
		//llenar el objeto ProductoVenta
		ProductoVenta productoVenta= new ProductoVenta(cantidad,producto.getPrecio(),precioVenta,producto,venta);
		
		//guardamos
		ProductoVenta productoVentaInsertada = productoVentaService.save(productoVenta);
		
		//Llamanos nuevamente al JSP
		List<Producto> listaProducto = productoService.findAll();
		model.addAttribute("listaProducto", listaProducto);
		model.addAttribute("venta", venta);
		
		List<ProductoVenta> listaProductoVenta = productoVentaService.findAllVentaId(idVenta);
		List<Object[]> objetos =productoVentaService.findAllProductoFiltro(idVenta);
		//Acceder al primer objeto
		Object[] objeto = objetos.get(0);
		Object objetoId = objeto[0];
		Object objetoVentaId = objeto[1];
		Object objetoProductoId = objeto[2];
		
		model.addAttribute("listaProductoVenta", listaProductoVenta);
		
		
		return "productoVenta.jsp";
	}

}
