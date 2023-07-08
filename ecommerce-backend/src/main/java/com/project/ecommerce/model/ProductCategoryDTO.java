package com.project.ecommerce.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductCategoryDTO {
	/**
	 * @param id
	 * @param categoryName
	 */
	public ProductCategoryDTO(long id, String categoryName) {
		super();
		this.id = id;
		this.category_name = categoryName;
	}
	
	public ProductCategoryDTO() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String category_name;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return category_name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.category_name = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategoryDTO [id=" + id + ", categoryName=" + category_name + "]";
	}
	
	
	
}
