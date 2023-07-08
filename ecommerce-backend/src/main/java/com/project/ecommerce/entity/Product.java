package com.project.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	
	/**
	 * @param id
	 * @param sku
	 * @param name
	 * @param description
	 * @param unit_price
	 * @param image_url
	 * @param active
	 * @param units_in_stock
	 * @param date_created
	 * @param last_updated
	 * @param category
	 */
	public Product(long id, 
			String sku, 
			String name, 
			String description, String unit_price, String image_url,
			boolean active, BigDecimal units_in_stock, Date date_created,
			Date last_updated, ProductCategory category) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unit_price = unit_price;
		this.image_url = image_url;
		this.active = active;
		this.units_in_stock = units_in_stock;
		this.date_created = date_created;
		this.last_updated = last_updated;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="unit_price")
	private String unit_price;

	@Column(name="image_url")
	private String image_url;

	@Column(name="active")
	private boolean active;

	@Column(name="units_in_stock")
	private BigDecimal units_in_stock;

	@Column(name="date_created")
	@CreationTimestamp
	private Date date_created;

	@Column(name="last_updated")
	@UpdateTimestamp
	private Date last_updated;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	private ProductCategory category;
	
	
}
