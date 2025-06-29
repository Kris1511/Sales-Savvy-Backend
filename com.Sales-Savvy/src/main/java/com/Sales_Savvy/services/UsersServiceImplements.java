package com.Sales_Savvy.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.Product;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.repository.UsersRepository;

@Service
public class UsersServiceImplements implements UsersService {
	
	@Autowired
	UsersRepository repo;


	public void signUp(UsersEntities user) {
		repo.save(user);		
	}

	public UsersEntities getUser(String username) {
		return repo.findByUsername(username);
	}

	public boolean validate(String username, String password) {
		
		UsersEntities user = getUser(username);
		String dbPassword = user.getPassword();
		
		return (password.equals(dbPassword));
	}

	@Override
	public Cart updateCart(String username, Product product, int quantity) {
	    UsersEntities user = repo.findByUsername(username);
	    if (user == null) {
	        throw new RuntimeException("User not found: " + username);
	    }

	    Cart cart = user.getCart(); // Check if user already has a cart

	    if (cart == null) {
	        // First time: create new cart
	        cart = new Cart();
	        cart.setUsers(user); // associate user with cart

	        List<Product> productList = new ArrayList<>();
	        for (int i = 0; i < quantity; i++) {
	            productList.add(product); // add product multiple times based on quantity
	        }

	        cart.setProductList(productList); // set product list to cart
	        user.setCart(cart);               // link cart to user
	    } else {
	        // Reuse existing cart
	        List<Product> productList = cart.getProductList();
	        for (int i = 0; i < quantity; i++) {
	            productList.add(product); // add to same cart
	        }
	    }

	    repo.save(user); // persist user and updated cart
	    return cart;
	}
}
