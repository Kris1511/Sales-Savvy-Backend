package com.Sales_Savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales_Savvy.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);

	Product findByCategory(String category);

}
