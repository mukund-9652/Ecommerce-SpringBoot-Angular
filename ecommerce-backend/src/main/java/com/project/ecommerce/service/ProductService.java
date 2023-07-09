package com.project.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.ProductDTO;

@Service
public interface ProductService {
	boolean createProduct(ProductDTO productDTO);
	ProductDTO getProductById(long id);
	List<ProductDTO> getAllProductByName(String name);
	List<ProductDTO> getAllProduct();
	boolean updateProduct(ProductDTO productDTO);
	boolean deleteProduct(long id);
	List<ProductDTO> getAllProductByCategory(long id);

}
