package com.lasky.ejb.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.lasky.ejb.ProductRestBeanInterface;
import com.lasky.rest.model.Response;
import com.lasky.product.entity.Product;
import com.lasky.product.model.ProductToBuy;
import com.lasky.product.repository.ProductRepository;
import com.lasky.product.repository.ProductRepositoryImplentation;

@Stateless
public class ProductRestBean implements ProductRestBeanInterface {
	private static Logger logger = LogManager.getLogger(ProductRestBeanInterface.class);
	private final static int MAX_CHOICES = 5;
	
	@Override
	public Response getProducts() {
		Response response = new Response();
		String methodName = "getProducts()";
		ProductRestBean.logger.info(methodName + " {");
		
		ProductRepository productRepository = new ProductRepositoryImplentation();
		List<Product> productList = productRepository.getAllProducts();
		
		if (productList != null && !productList.isEmpty()) {
			response.setResponseCode(HttpStatus.OK.value());
			response.setData(productList);
		} else {
			response.setResponseCode(HttpStatus.NOT_FOUND.value());
		}
		
		ProductRestBean.logger.info("} " + methodName);
		return response;
	}
	
	@Override
	public Response buyProducts(List<ProductToBuy> productsToBuy) {
		Response response = new Response();
		String methodName = "buyProducts()";
		ProductRestBean.logger.info(methodName + " {");
		
		ProductRepository productRepository = new ProductRepositoryImplentation();
		TreeMap<String, ProductToBuy> productsToBuyMap = new TreeMap<String, ProductToBuy>();
		TreeMap<String, Product> productsMap = new TreeMap<String, Product>();
		List<Product> productList = null;
		List<String> itemCodes = new ArrayList<String>();
		ProductToBuy productToBuy = null;
		
		if (productsToBuy != null && !productsToBuy.isEmpty()) {
			for (int indexer = 0; indexer < productsToBuy.size(); indexer++) {
				productToBuy = productsToBuy.get(indexer);
				productsToBuyMap.put(productToBuy.getItemCode(), productToBuy);
			}
			
			itemCodes.addAll(productsToBuyMap.keySet());
			productList = productRepository.getProductsByItemCodes(itemCodes);
		}
		
		if (productList != null && !productList.isEmpty()) {
			for (Product product : productList) {
				productsMap.put(product.getItemCode(), product);
			}
			
			//range based loops has some penalty on the performance that's why I don't use this all the time
			Product currentProduct = null;
			int currentQuantity = 0;
			for (String itemCode : itemCodes) {
				productToBuy = productsToBuyMap.get(itemCode);
				currentProduct = productsMap.get(itemCode);
				if (productToBuy != null && currentProduct != null) {
					if (productToBuy.getQuantity() > 0) {
						currentQuantity = Math.max(currentProduct.getQuantityOnHand() - productToBuy.getQuantity(), 0);
						currentProduct.setQuantityOnHand(currentQuantity);
					}
				}
			}
			
			response.setResponseCode(HttpStatus.OK.value());
			response.setData(productList);
		} else {
			response.setResponseCode(HttpStatus.NOT_FOUND.value());
		}
		
		ProductRestBean.logger.info("} " + methodName);
		return response;
	}
	
	@Override
	public Response testGet() {
		Response response = new Response();
		String methodName = "testGet()";
		ProductRestBean.logger.info(methodName + " {");
		
		int choiceOfTheMoment = this.generateRandomNumber(MAX_CHOICES) % ProductRestBean.MAX_CHOICES;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Hello! From Lasky's Shopping Cart Web Application!");
		stringBuffer.append("\n[" + ProductRestBean.class.getSimpleName() + methodName + "]"
				+ " request made on: " + (new Date()).toString() + "\n");
		switch(choiceOfTheMoment) {
			case 0:
				stringBuffer.append("--Coke Zero*");
				break;
			case 1:
				stringBuffer.append("--One punch man!");
				break;
			case 2:
				stringBuffer.append("--Tic Tac Toe--");
				break;
			case 3:
				stringBuffer.append("^Pine Tree ^");
				break;
			case 4:
				stringBuffer.append("...Southern Lights...");
				break;
		}
		response.setResponseCode(HttpStatus.OK.value());
		response.setData(stringBuffer.toString());
		
		ProductRestBean.logger.info("} " + methodName);
		return response;
	}
	
	private int generateRandomNumber(int limit) {
		String methodName = "generateRandomNumber()";
		ProductRestBean.logger.info(methodName + " {");
		
		ProductRestBean.logger.info("Generating a random integer within the range 0.." + limit + ".");
	    
	    //note a single Random object is reused here
	    Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(limit);
	    ProductRestBean.logger.info("Generated : " + randomInt);
	    
	    ProductRestBean.logger.info("} " + methodName);
	    return randomInt;
	}
}
