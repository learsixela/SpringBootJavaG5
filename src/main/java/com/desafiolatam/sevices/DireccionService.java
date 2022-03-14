package com.desafiolatam.sevices;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Direccion;
import com.desafiolatam.repositories.DireccionRepository;

@Service
public class DireccionService {

	@Autowired
	DireccionRepository direRepository;

	public Direccion save(@Valid Direccion direccion) {
		return direRepository.save(direccion);
		
	}
	
	
}
