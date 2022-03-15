package com.desafiolatam.sevices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository cRepository;

	public Cliente save(@Valid Cliente cliente) {
		return cRepository.save(cliente);
		
	}

	public List<Cliente> findAll() {
		return cRepository.findAll();
	}
	
	
}
