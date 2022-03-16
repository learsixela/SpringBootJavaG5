package com.desafiolatam.sevices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Compra;
import com.desafiolatam.repositories.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	CompraRepository compraRepository;

	public Compra save(@Valid Compra compra) {
		return compraRepository.save(compra);
	}

	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return compraRepository.findAll();
	}
	
	

}
