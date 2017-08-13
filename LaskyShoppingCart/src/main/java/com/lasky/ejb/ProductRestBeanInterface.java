package com.lasky.ejb;

import java.util.List;

import javax.ejb.Local;

import com.lasky.product.model.ProductToBuy;
import com.lasky.rest.model.Response;

@Local
public interface ProductRestBeanInterface {
	Response testGet();
	Response getProducts();
	Response buyProducts(List<ProductToBuy> productsToBuy);
}
