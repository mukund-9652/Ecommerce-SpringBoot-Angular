package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
		
		@Query(value = "SELECT * FROM PRODUCT WHERE NAME LIKE %:name% ", nativeQuery = true)
		List<Product> findAllByName(String name);
		
		@Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY_ID = :id ", nativeQuery = true)
		List<Product> findAllByCategory(long id);
}
