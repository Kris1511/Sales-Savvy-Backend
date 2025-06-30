package com.Sales_Savvy.services;

import java.util.List;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.CartItem;

public interface CartService {
	
	void addCart(Cart cart);
	
	void clearCart(String username);

	List<CartItem> getItems(String username);
	
	List<CartItem> cloneItems(String username);

}
