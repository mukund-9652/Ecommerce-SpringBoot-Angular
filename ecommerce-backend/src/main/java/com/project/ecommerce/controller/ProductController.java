package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.ProductDTO;
import com.project.ecommerce.service.implementation.ProductServiceImpl;

@Validated
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins ="http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@GetMapping
	public List<ProductDTO> getAllProduct(){
		return productServiceImpl.getAllProduct();
	}
	
	@GetMapping("/name:{name}")
	public List<ProductDTO> getAllProductByName(@PathVariable String name){
		return productServiceImpl.getAllProductByName(name);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		boolean insertData=productServiceImpl.createProduct(productDTO);
		if(insertData) {
			return ResponseEntity.ok("Data Has Been Inserted");
		}
		else {
			return ResponseEntity.badRequest().body("Some Error While inserting Check code!");
		}
	}
	
	@GetMapping("/id:{id}")
	public ProductDTO getProductById(@PathVariable long id){
		return productServiceImpl.getProductById(id);
	}
	
	@PutMapping("/id:{id}")
	public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO){
		boolean updateData=productServiceImpl.updateProduct(productDTO);
		if(updateData) {
			return ResponseEntity.ok("Data Has Been Updated");
		}
		else {
			return ResponseEntity.badRequest().body("Some Error While Updating Check code!");
		}
	}
	
	@DeleteMapping("/id:{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		boolean updateData=productServiceImpl.deleteProduct(id);
		if(updateData) {
			return ResponseEntity.ok("Data Has Been Deleted");
		}
		else {
			return ResponseEntity.badRequest().body("Some Error While Deleting. Check code!");
		}
	}
}
