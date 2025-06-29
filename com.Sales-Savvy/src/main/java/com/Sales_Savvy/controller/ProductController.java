package com.Sales_Savvy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.CartData;
import com.Sales_Savvy.entities.Product;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.services.CartService;
import com.Sales_Savvy.services.ProductService;
import com.Sales_Savvy.services.UsersService;

@CrossOrigin("*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	UsersService uService;
	
	@Autowired
	CartService cService;
	
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
//	public String addToCart(@RequestBody CartData data) {
//		
//		String username = data.getUsername();
//		
//		// returning username
//		UsersEntities user = uService.getUser(username);
//		
//		// returning product
//		Product p = service.searchProduct(data.getProductId());
//		if (p == null) return "product not found";
//		
//		Cart c = null;
//		
//		// if the cart is null can add the product
//		if (user.getCart() == null) {
//			c = new Cart();
//			c.setUsers(user);
//			List<Product> listProduct = new ArrayList<>();
//			listProduct.add(p);
//		}
//		// if the cart already present add the same cart
//		else {
//			c = user.getCart();
//			c.getProductList().add(p);
//		}
//		
//		user.setCart(c);
//		
//		cService.addCart(c);
//		
//		return "cart added";
//		
//	}
	public String addToCart(@RequestBody CartData data) {
		String username = data.getUsername();
	    int quantity = data.getQuantity();

	    Product product = service.searchProduct(data.getProductId());
	    
	    if (product == null) return "Product not found";

	    uService.updateCart(username, product, quantity);

	    return "Product added to cart successfully";
    }

}








