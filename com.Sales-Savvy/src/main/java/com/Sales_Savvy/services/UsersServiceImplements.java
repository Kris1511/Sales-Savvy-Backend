package com.Sales_Savvy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.repository.UsersRepository;

@Service
public class UsersServiceImplements implements UsersService {
	
	@Autowired
	UsersRepository repo;

	@Override
	public void signUp(UsersEntities user) {
		repo.save(user);		
	}

	@Override
	public UsersEntities getUser(String username) {
		return repo.findByUsername(username);
	}

}
