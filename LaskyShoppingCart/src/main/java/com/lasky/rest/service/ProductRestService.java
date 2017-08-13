package com.lasky.rest.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lasky.controller.ProductRestController;
import com.lasky.product.model.ProductToBuy;
import com.lasky.rest.model.BadRequestException;
import com.lasky.rest.model.Response;
import com.lasky.rest.utils.HTTPUtils;

@RestController
public class ProductRestService {
	private static Logger logger = LogManager.getLogger(ProductRestService.class);
	
	
	@RequestMapping(
			value = "/test/service",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<Response> testGet() throws BadRequestException {
		Response response = new Response();
		String methodName = "get";
		
		ProductRestService.logger.info(ProductRestService.class.getName() + methodName + "() called!");
		
		//Using EJB
		response = (new ProductRestController()).testGet();
		
		return new ResponseEntity<Response>(response, HTTPUtils.getHttpStatus(response.getResponseCode()));
	}
	
	@RequestMapping(
			value = "/products/all",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE/*,
			consumes = MediaType.APPLICATION_JSON_VALUE*/
		)
	public ResponseEntity<Response> getAllProducts() throws BadRequestException {
		Response response = new Response();
		String methodName = "get";
		
		ProductRestService.logger.info(ProductRestService.class.getName() + methodName + "() called!");
		
		//Using EJB
		response = (new ProductRestController()).getProducts();
		
		return new ResponseEntity<Response>(response, HTTPUtils.getHttpStatus(response.getResponseCode()));
	}
	
	@RequestMapping(
			value = "/products/buy",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<Response> getAllProducts(@RequestBody List<ProductToBuy> productsToBuy) throws BadRequestException {
		Response response = new Response();
		String methodName = "get";
		
		ProductRestService.logger.info(ProductRestService.class.getName() + methodName + "() called!");
		
		//Using EJB
		response = (new ProductRestController()).buyProducts(productsToBuy);
		
		return new ResponseEntity<Response>(response, HTTPUtils.getHttpStatus(response.getResponseCode()));
	}
}
