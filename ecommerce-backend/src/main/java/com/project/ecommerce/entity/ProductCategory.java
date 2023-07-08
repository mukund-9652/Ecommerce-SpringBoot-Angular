package com.project.ecommerce.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product_category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductCategory {
	
	/**
	 * @param id
	 * @param category_name
	 */
	public ProductCategory(long id, String category_name) {
		super();
		this.id = id;
		this.category_name = category_name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="category_name")
	private String category_name;
	
	@OneToMany(mappedBy="category")
	private List<Product> products;
	
}
