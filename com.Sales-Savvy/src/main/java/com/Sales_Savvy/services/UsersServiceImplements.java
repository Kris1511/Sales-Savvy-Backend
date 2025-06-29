package com.Sales_Savvy.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.CartItem;
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

	    Cart cart = user.getCart();

	    // Create new cart if none exists
	    if (cart == null) {
	        cart = new Cart();
	        cart.setUsers(user);
	        user.setCart(cart); // associate cart with user
	    }

	    List<CartItem> cartItems = cart.getCartItems();
	    if (cartItems == null) cartItems = new ArrayList<>();

	    // Check if product already in cart
	    boolean found = false;
	    for (CartItem item : cartItems) {
	        if (item.getProduct().getId().equals(product.getId())) {
	            item.setQuantity(item.getQuantity() + quantity); // update quantity
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        CartItem newItem = new CartItem();
	        newItem.setCart(cart);
	        newItem.setProduct(product);
	        newItem.setQuantity(quantity);
	        cartItems.add(newItem);
	    }

	    cart.setCartItems(cartItems);
	    repo.save(user); // cascade saves cart and cartItems

	    return cart;
	}

}
