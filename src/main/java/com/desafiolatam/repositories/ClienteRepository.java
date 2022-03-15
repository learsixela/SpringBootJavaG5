package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	List<Cliente> findAll();
	
}
