package com.desafiolatam.sevices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.ProductoVenta;
import com.desafiolatam.repositories.ProductoVentaRepository;

@Service
public class ProductoVentaService {
	
	@Autowired
	ProductoVentaRepository productoVentaRepository;

	public ProductoVenta save(@Valid ProductoVenta productoVenta) {
		
		return productoVentaRepository.save(productoVenta);
	}

	public List<ProductoVenta> findAllVentaId(Long idVenta) {
		return productoVentaRepository.findAllProductoVentaWhereVenta(idVenta);
	}

	public List<Object[]> findAllProductoFiltro(Long idVenta) {
		return productoVentaRepository.findAllProductoFiltro(idVenta);
	}

	public ProductoVenta findById(Long id) {
		return productoVentaRepository.findById(id).get();
	}

	public void eliminarProductoVenta(Long id) {
		productoVentaRepository.deleteById(id);
		
	}

}
