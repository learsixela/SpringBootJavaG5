package com.desafiolatam.controllers;

import java.util.ArrayList;
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
		
		List<ProductoVenta> listaProductoVenta = new ArrayList<ProductoVenta>();
		model.addAttribute("listaProductoVenta", listaProductoVenta);
		
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
		
		//ACTUALIZAR LA VENTA
		if(venta.getMontoTotal()== null) {
			venta.setMontoTotal(0d);
		}
		venta.setMontoTotal(venta.getMontoTotal() + precioVenta);
		venta = ventaService.save(venta);
		
		//llenar el objeto ProductoVenta
		ProductoVenta productoVenta= new ProductoVenta(cantidad,producto.getPrecio(),precioVenta,producto,venta);
		
		//guardamos
		ProductoVenta productoVentaInsertada = productoVentaService.save(productoVenta);
		
		//Llamanos nuevamente al JSP
		List<Producto> listaProducto = productoService.findAll();
		model.addAttribute("listaProducto", listaProducto);
		model.addAttribute("venta", venta);
		
		List<ProductoVenta> listaProductoVenta = productoVentaService.findAllVentaId(idVenta);
		model.addAttribute("listaProductoVenta", listaProductoVenta);
		
		//CONSULTA SELECCTIVA POR ALGUNAS COLUMNAS DE LAS TABLAS
		List<Object[]> objetos =productoVentaService.findAllProductoFiltro(idVenta);
		//Acceder al primer objeto
		Object[] objeto = objetos.get(0);
		Object objetoId = objeto[0];
		Object objetoVentaId = objeto[1];
		Object objetoProductoId = objeto[2];
		
		
		return "productoVenta.jsp";
	}
	
	@RequestMapping("/formActualizar/{id}")
    public String regProdVenta(@PathVariable("id") Long id,
            Model model) {
        // Buscar datos
        Venta venta = ventaService.findById(id);
        model.addAttribute("venta", venta);
        List<Producto> listaProductos = productoService.findAll();
        model.addAttribute("listaProductos", listaProductos);
        List<ProductoVenta> listaProductoVenta = productoVentaService.findAllVentaId(id);
        model.addAttribute("listaProductoVenta", listaProductoVenta);
        model.addAttribute("titulo", "Registro de ProductoVenta");
        model.addAttribute("msgError", "Producto Eliminado");
        return "productoVenta.jsp";

    }
	
	@RequestMapping("/{venta_id}/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, @PathVariable("venta_id") Long venta_id, Model model) {
        model.addAttribute("msgError", "Producto Eliminado");
        ProductoVenta productoVenta = productoVentaService.findById(id);
        productoVentaService.eliminarProductoVenta(id);
        Venta venta = ventaService.findById(venta_id);
        if (venta.getMontoTotal() == null) {
            venta.setMontoTotal(0d);
        }
        venta.setMontoTotal(venta.getMontoTotal() - productoVenta.getPrecioVenta());
        ventaService.save(venta);
        return "redirect:/productoVenta/formActualizar/" + venta_id;

    }

}
