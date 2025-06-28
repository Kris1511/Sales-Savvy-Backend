package com.Sales_Savvy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Cart;
import com.Sales_Savvy.repository.CartRepository;

@Service
public class CartServiceImplements implements CartService {
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public void addCart(Cart cart) {
		cartRepo.save(cart);
	}

}
