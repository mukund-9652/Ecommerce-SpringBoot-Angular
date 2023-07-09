package com.project.ecommerce.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.entity.ProductCategory;
import com.project.ecommerce.model.ProductCategoryDTO;
import com.project.ecommerce.repository.ProductCategoryRepository;
import com.project.ecommerce.service.ProductCategoryService;
import com.project.ecommerce.service.mapper.ProductCategoryMapper;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	ProductCategoryMapper mapper;

	@Override
	public List<ProductCategoryDTO> getProductCategories() {
		// TODO Auto-generated method stub
		List<ProductCategory> resultEntity = this.productCategoryRepository.findAll();
		List<ProductCategoryDTO> result = new ArrayList<>();
		resultEntity.forEach(category -> result.add(mapper.convertEntityToDto(category)));
		return result;
	}

}
