package com.desafiolatam.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Auto;
import com.desafiolatam.repositories.AutoRepository;

@Service
public class AutoService {
	@Autowired
	AutoRepository autoRepository;
	
	public List<Auto> findAll(){
		return autoRepository.findAll();
	}
}
