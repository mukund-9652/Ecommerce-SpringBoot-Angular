package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>  {

}
