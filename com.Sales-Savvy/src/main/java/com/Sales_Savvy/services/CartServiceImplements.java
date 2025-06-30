package com.Sales_Savvy.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.entities.CartItem;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.repository.CartRepository;
import com.Sales_Savvy.repository.UsersRepository;

@Service
public class CartServiceImplements implements CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	UsersRepository userRepo;

	@Override
	public void addCart(Cart cart) {
		cartRepo.save(cart);
	}
	
	 @Override
	    public void clearCart(String username) {
	        UsersEntities u = userRepo.findByUsername(username);
	        if (u != null && u.getCart() != null) {
	            u.getCart().getCartItems().clear();
	            cartRepo.save(u.getCart());
	        }
	    }
	
	@Override
    public List<CartItem> getItems(String username) {
        UsersEntities u = userRepo.findByUsername(username);
        if (u == null || u.getCart() == null) {
            return Collections.emptyList();
        }
        return u.getCart().getCartItems();
    }
    
    @Override
    public List<CartItem> cloneItems(String username) {
        return getItems(username).stream().map(src -> {
            CartItem copy = new CartItem();
            copy.setProduct(src.getProduct());   // keep the same product ref
            copy.setQuantity(src.getQuantity());
            copy.setCart(null);                  // detach from cart
            return copy;
        }).toList();
    }

}
