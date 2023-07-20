package org.sid.dao;

import java.util.List;

import org.sid.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends JpaRepository<Product, Long> {
		
	@Query("select p from Product p where p.nom like %:x%")
	public List<Product> findByName(@Param("x") String nom);
	
	@Query("select p from Product p where p.prixUnitaire <= :x")
	public List<Product> findByPrice(@Param("x") double price );
}
