package com.desafiolatam.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Venta;
import com.desafiolatam.repositories.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	VentaRepository ventaRepository;

	public Venta save(Venta venta) {
		return ventaRepository.save(venta);
	}

	public Venta findById(Long idVenta) {
		// TODO Auto-generated method stub
		return ventaRepository.findById(idVenta).get();
	}

}
