package com.Sales_Savvy.services;

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
	public Cart updateCart(String username, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
