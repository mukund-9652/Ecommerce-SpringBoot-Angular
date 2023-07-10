package com.project.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {
	

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
	public ProductDTO(long id, String sku, String name, String description, String unit_price, String image_url,
			boolean active, BigDecimal units_in_stock, Date date_created, Date last_updated, ProductCategoryDTO category) {
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

	public ProductDTO() {
		
	}
	
	private long id;
	
	private String sku;
	
	private String name;
	
	private String description;
	
	private String unit_price;
	
	private String image_url;
	
	private boolean active;
	
	private BigDecimal units_in_stock;
	
	private Date date_created;
	
	private Date last_updated;
	
	private ProductCategoryDTO category;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		return unit_price;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return image_url;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return the unitsInStock
	 */
	public BigDecimal getUnitsInStock() {
		return units_in_stock;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return date_created;
	}

	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return last_updated;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unit_price = unitPrice;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.image_url = imageUrl;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param unitsInStock the unitsInStock to set
	 */
	public void setUnitsInStock(BigDecimal unitsInStock) {
		this.units_in_stock = unitsInStock;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.date_created = dateCreated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.last_updated = lastUpdated;
	}

	/**
	 * @return the category
	 */
	public ProductCategoryDTO getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategoryDTO category) {
		this.category = category;
	}

	
	
}
