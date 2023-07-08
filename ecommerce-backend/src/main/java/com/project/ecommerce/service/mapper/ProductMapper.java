package com.project.ecommerce.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.model.ProductDTO;

@Service
public class ProductMapper {
	@Autowired
	ProductCategoryMapper categoryMapper;
	public Product convertDtoToEntity(ProductDTO productDTO) {
		Product result=new Product(
				productDTO.getId(),
				productDTO.getSku(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getUnitPrice(),
				productDTO.getImageUrl(),
				productDTO.isActive(),
				productDTO.getUnitsInStock(),
				productDTO.getDateCreated(),
				productDTO.getLastUpdated(),
				categoryMapper.convertDtoToEntity(productDTO.getCategory())
				);
		return result;
	}
	
	public ProductDTO convertEntityToDto(Product product) {
		ProductDTO result=new ProductDTO(
				product.getId(),
				product.getSku(),
				product.getName(),
				product.getDescription(),
				product.getUnit_price(),
				product.getImage_url(),
				product.isActive(),
				product.getUnits_in_stock(),
				product.getDate_created(),
				product.getLast_updated(),
				categoryMapper.convertEntityToDto(product.getCategory())
				);
		return result;
	}
}
