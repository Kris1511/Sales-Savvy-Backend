package com.Sales_Savvy.services;

import java.util.List;

import com.Sales_Savvy.entities.Product;

public interface ProductService {
	
	// add product
	String addProduct(Product product);
	
	// search product
	Product searchProduct(long id);
	Product searchProduct(String name);
	Product searchProductByCategory(String category);
	
	// update product
	String updateProduct(Product product);
	
	// delete product
	String deleteProduct(long id);
	
	// List of product
	List<Product> getAllProduct();

}
