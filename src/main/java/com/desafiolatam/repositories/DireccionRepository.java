package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Long>{

	List<Direccion> findAll();
}
