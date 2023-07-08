package com.project.ecommerce.service.mapper;

import org.springframework.stereotype.Service;

import com.project.ecommerce.entity.ProductCategory;
import com.project.ecommerce.model.ProductCategoryDTO;

@Service
public class ProductCategoryMapper {
	public ProductCategory convertDtoToEntity(ProductCategoryDTO productCategoryDTO) {
		ProductCategory result=new ProductCategory(
					productCategoryDTO.getId(),
					productCategoryDTO.getCategoryName()
				);
		return result;
	}
	
	public ProductCategoryDTO convertEntityToDto(ProductCategory productCategory) {
		ProductCategoryDTO result=new ProductCategoryDTO(
					productCategory.getId(),
					productCategory.getCategory_name()
				);
		return result;
	}
}
