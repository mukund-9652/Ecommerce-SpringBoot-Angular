package com.project.ecommerce.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.exception.DuplicateResourceException;
import com.project.ecommerce.exception.InvalidResourceException;
import com.project.ecommerce.exception.ResourceNotFoundException;
import com.project.ecommerce.model.ProductDTO;
import com.project.ecommerce.repository.ProductRepository;
import com.project.ecommerce.service.ProductService;
import com.project.ecommerce.service.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public boolean createProduct(ProductDTO productDTO) throws InvalidResourceException, DuplicateResourceException {
		// TODO Auto-generated method stub
		boolean checkDataSingle=productRepository.findById(productDTO.getId()).isPresent();
		boolean checkDataMultiple=productRepository.findAllByName(productDTO.getName()).isEmpty();
		if(checkDataSingle && !checkDataMultiple) {
			throw new DuplicateResourceException("Data already found in database");
		}
		else {
			productRepository.save(productMapper.convertDtoToEntity(productDTO));
			return true;
		}
	}

	@Override
	public List<ProductDTO> getAllProductByName(String name) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(name.contains("+")) {
			name=name.replace('+', ' ');
		}
		List<Product> resultEntity=this.productRepository.findAllByName(name);
		if(resultEntity.isEmpty()) {
			throw new ResourceNotFoundException("Resource not found for given name");
		}
		List<ProductDTO> result=new ArrayList<ProductDTO>();
		resultEntity.forEach(product -> result.add(productMapper.convertEntityToDto(product)));
		return result;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> resultEntity=this.productRepository.findAll();
		List<ProductDTO> result=new ArrayList<ProductDTO>();
		resultEntity.forEach(product -> result.add(productMapper.convertEntityToDto(product)));
		return result;
	}

	@Override
	public ProductDTO getProductById(long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> checkDataSingle=productRepository.findById(id);
		if(checkDataSingle.isPresent()) {
			return productMapper.convertEntityToDto(checkDataSingle.get());
		}
		else {
			throw new ResourceNotFoundException("Data Not found in database");
		}
	}

	@Override
	public boolean updateProduct(ProductDTO productDTO) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> checkDataSingle=productRepository.findById(productDTO.getId());
		if(checkDataSingle.isPresent()) {
			productRepository.save(productMapper.convertDtoToEntity(productDTO));
			return true;
		}
		else {
			throw new ResourceNotFoundException("Data Not found in database");
		}
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		Optional<Product> checkDataSingle=productRepository.findById(id);
		if(checkDataSingle.isPresent()) {
			productRepository.delete(checkDataSingle.get());
			return true;
		}
		else {
			throw new ResourceNotFoundException("Data Not found in database");
		}
	}

}