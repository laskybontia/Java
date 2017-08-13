package com.lasky.product.repository;

import java.util.List;

import com.lasky.product.entity.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByItemCodes(List<String> itemCodes);
	void updateProducts(List<Product> listOfProducts);
}
