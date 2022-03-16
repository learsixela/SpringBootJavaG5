package com.desafiolatam.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Producto;
import com.desafiolatam.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}
}
