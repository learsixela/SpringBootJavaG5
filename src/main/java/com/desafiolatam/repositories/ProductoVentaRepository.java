package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, Long>{

	@Query()
	List<ProductoVenta> findAllProductoVentaWhereVenta(Long idVenta);
	
	

}
