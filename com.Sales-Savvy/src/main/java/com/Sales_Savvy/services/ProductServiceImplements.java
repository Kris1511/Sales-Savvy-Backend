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
		// TODO Auto-generated method stub
		return null;
	}

	public Product searchProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteProduct(long id) {
		return "Deleted successfully";
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
