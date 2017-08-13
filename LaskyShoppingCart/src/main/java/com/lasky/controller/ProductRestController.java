package com.lasky.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.lasky.common.utils.EJB3;
import com.lasky.ejb.ProductRestBeanInterface;
import com.lasky.ejb.beans.ProductRestBean;
import com.lasky.product.model.ProductToBuy;
import com.lasky.rest.model.Response;

public class ProductRestController {
	private static Logger logger = LogManager.getLogger(ProductRestController.class);
	private static ProductRestBeanInterface productRestBean = null;
	
	public ProductRestController() {
		String methodName = "TestRestController()";
		ProductRestController.logger.info(methodName + " {");
		
		if (productRestBean == null) {
			ProductRestController.logger.info("Creating " + ProductRestBeanInterface.class.getSimpleName() + " (via EJB3)");
			ProductRestController.productRestBean = EJB3.getInstance().objectLookUp(ProductRestBeanInterface.class, ProductRestBean.class);
		} else {
			ProductRestController.logger.info(ProductRestController.productRestBean + " has been created already.");
		}
		
		ProductRestController.logger.info("} " + methodName);
	}
	
	public Response testGet() {
		Response response = new Response();
		String methodName = "testGet()";
		
		ProductRestController.logger.info(methodName + " {");
		
		if (ProductRestController.productRestBean != null) {
			response = ProductRestController.productRestBean.testGet();
		} else {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setData(ProductRestBeanInterface.class + " was not loaded!");
		}
		
		ProductRestController.logger.info("} " + methodName);
		return response;
	}
	
	public Response getProducts() {
		Response response = new Response();
		String methodName = "getProducts()";
		
		ProductRestController.logger.info(methodName + " {");
		
		if (ProductRestController.productRestBean != null) {
			response = ProductRestController.productRestBean.getProducts();
		} else {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setData(ProductRestBeanInterface.class + " was not loaded!");
		}
		
		ProductRestController.logger.info("} " + methodName);
		return response;
	}
	
	public Response buyProducts(List<ProductToBuy> productsToBuy) {
		Response response = new Response();
		String methodName = "buyProducts()";
		
		ProductRestController.logger.info(methodName + " {");
		
		if (ProductRestController.productRestBean != null) {
			response = ProductRestController.productRestBean.buyProducts(productsToBuy);
		} else {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setData(ProductRestBeanInterface.class + " was not loaded!");
		}
		
		ProductRestController.logger.info("} " + methodName);
		return response;
	}
}
