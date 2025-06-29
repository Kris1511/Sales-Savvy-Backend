package com.Sales_Savvy.services;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.Product;
import com.Sales_Savvy.entities.UsersEntities;

public interface UsersService {
	
	// signup
	void signUp(UsersEntities user);
	
	// check existing user
	UsersEntities getUser(String username);
	
	// check if user is exist
	boolean validate(String username, String password);
	
	// update the user
	Cart updateCart(String username, Product product, int quantity);

}
