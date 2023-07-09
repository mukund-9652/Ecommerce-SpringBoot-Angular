package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.ProductCategoryDTO;
import com.project.ecommerce.service.implementation.ProductCategoryServiceImpl;

@Validated
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins ="http://localhost:4200")
public class ProductCategoryController {
	@Autowired
	ProductCategoryServiceImpl productCategoryServiceImpl;
	
	@GetMapping
	public List<ProductCategoryDTO> getAllCategories(){
		return productCategoryServiceImpl.getProductCategories();
	}
}
