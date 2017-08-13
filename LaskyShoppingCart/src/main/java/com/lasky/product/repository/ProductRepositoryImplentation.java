package com.lasky.product.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.lasky.product.entity.Product;

public class ProductRepositoryImplentation implements ProductRepository {
	private static Product iPhone7 = new Product();
	private static Product galaxyS8 = new Product();
	private static ArrayList<Product> products = new ArrayList<Product>();
	private static TreeMap<String, Product> productsMap = new TreeMap<String, Product>();
	
	static {
		
		ProductRepositoryImplentation.iPhone7.setId(1);
		ProductRepositoryImplentation.iPhone7.setItemCode("IPHONE7128GB");
		ProductRepositoryImplentation.iPhone7.setBrand("Apple");
		ProductRepositoryImplentation.iPhone7.setName("iPhone 7 128GB");
		ProductRepositoryImplentation.iPhone7.setDescription("Apple iPhone 7 128GB");
		ProductRepositoryImplentation.iPhone7.setQuantityOnHand(20);
		ProductRepositoryImplentation.iPhone7.setPrice(new BigDecimal(1300.00));
		
		ProductRepositoryImplentation.galaxyS8.setId(2);
		ProductRepositoryImplentation.galaxyS8.setItemCode("SAMSUNGGALAXYS864GB");
		ProductRepositoryImplentation.galaxyS8.setBrand("Samsung");
		ProductRepositoryImplentation.galaxyS8.setName("Galaxy S8 64GB");
		ProductRepositoryImplentation.galaxyS8.setDescription("Samsung Galaxy S8 64G");
		ProductRepositoryImplentation.galaxyS8.setQuantityOnHand(10);
		ProductRepositoryImplentation.galaxyS8.setPrice(new BigDecimal(1000.00));
		
		ProductRepositoryImplentation.products.add(iPhone7);
		ProductRepositoryImplentation.products.add(galaxyS8);
		
		productsMap.put(iPhone7.getItemCode(), iPhone7);
		productsMap.put(galaxyS8.getItemCode(), galaxyS8);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return ProductRepositoryImplentation.products;
	}
	
	@Override
	//item codes are expected not to be repeated here
	public List<Product> getProductsByItemCodes(List<String> itemCodes) {
		List<Product> productList = new ArrayList<Product>();
		
		if (itemCodes != null && !itemCodes.isEmpty()) {
			Product currentProduct = null;
			String currentItemCode = null;
			for (int indexer = 0; indexer < itemCodes.size(); indexer++) {
				currentItemCode = itemCodes.get(indexer);
				if (currentItemCode != null && !currentItemCode.isEmpty()) {
					currentProduct = ProductRepositoryImplentation.productsMap.get(currentItemCode);
					if (currentProduct != null) {
						productList.add(currentProduct);
					}
				}
			}
		}
		
		return productList;
	}
	
	@Override
	//products are expected not to be repeated here
	public void updateProducts(List<Product> listOfProducts) {
		if (listOfProducts != null && !listOfProducts.isEmpty()) {
			for (int indexer = 0; indexer < listOfProducts.size(); indexer++) {
				
			}
		}
	}
}



