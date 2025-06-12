package com.Sales_Savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.services.UsersServiceImplements;

@RestController
public class UsersController {
	
	@Autowired
	UsersServiceImplements service;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody UsersEntities user) {
		
		String msg = "";
		
		String username = user.getUsername();
		
		UsersEntities un = service.getUser(username);
		
		if (un == null) {
			service.signUp(user);
			msg = "User create successfully..";
		} else {
			msg = "Username already exists!";
		}
		return msg;
		
	}

}
