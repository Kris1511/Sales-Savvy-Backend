package com.Sales_Savvy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Product;
import com.Sales_Savvy.repository.ProductRepository;

@Service
public class ProductServiceImplements implements ProductService {
	
	@Autowired
	ProductRepository repo;


	public String addProduct(Product product) {
		repo.save(product);
		return "Product added successfully";
	}

	public Product searchProduct(long id) {
		
		return repo.findById(id).get();
	}

	public Product searchProduct(String name) {
		return repo.findByName(name);
	}

	public Product searchProductByCategory(String category) {
		return repo.findByCategory(category);
	}

	public String updateProduct(Product product) {
		repo.save(product);
		return "Product updated successfully";
	}

	public String deleteProduct(long id) {
		return "Deleted successfully";
	}

	public List<Product> getAllProduct() {
		return repo.findAll();
	}
	
	
}
