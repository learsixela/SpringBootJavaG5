package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, Long>{

	//JPQL, NO USAR *, no se llama a la tabla, se utiliza el objeto
	@Query("SELECT pv FROM ProductoVenta pv WHERE pv.venta.id = ?1")
	List<ProductoVenta> findAllProductoVentaWhereVenta(Long idVenta);
	
	//QUERY NATIVAS
	@Query(value="Select * from productos_ventas where venta_id=?1 ", nativeQuery = true)
	List<ProductoVenta> findAllProductoVenta(Long idVenta);
	
	@Query(value="Select id, venta_id, producto_id from productos_ventas where venta_id=?1 ", nativeQuery = true)
	List<Object[]> findAllProductoFiltro(Long idVenta);
}
