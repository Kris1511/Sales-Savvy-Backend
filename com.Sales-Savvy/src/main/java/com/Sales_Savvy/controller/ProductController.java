package com.Sales_Savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Sales_Savvy.entities.CartData;
import com.Sales_Savvy.entities.Product;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.services.ProductService;
import com.Sales_Savvy.services.UsersService;

@CrossOrigin("*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	UsersService uService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		service.addProduct(product);
		return "Product added successfully";		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable long id) {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/searchProduct")
	public Product searchProduct(@RequestParam long id) {
		return service.searchProduct(id);
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return service.getAllProduct();
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody CartData data) {
		
		String username = data.getUsername();
		
		// returning username
		UsersEntities user = uService.getUser(username);
		
		// returning product
		Product p = service.searchProduct(data.getProductId());
		return "cart added";
		
	}

}








