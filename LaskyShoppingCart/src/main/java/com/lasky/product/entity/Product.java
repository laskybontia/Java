package com.lasky.product.entity;

import java.math.BigDecimal;

public class Product {
	private int id;
	private String itemCode;
	private String brand;
	private String name;
	private String description;
	private int quantityOnHand;
	private BigDecimal price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void update(Product updatedProduct) {
		if (this.id == updatedProduct.id) {
			this.itemCode = updatedProduct.itemCode;
			this.brand = updatedProduct.brand;
			this.name = updatedProduct.name;
			this.description = updatedProduct.description;
			this.quantityOnHand = updatedProduct.quantityOnHand;
			this.price = updatedProduct.price;
		}
	}
}


