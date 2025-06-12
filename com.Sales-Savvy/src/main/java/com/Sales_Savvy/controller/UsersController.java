package com.Sales_Savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Sales_Savvy.entities.UserLoginData;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.services.UsersService;

@CrossOrigin("*")
@RestController
public class UsersController {
	
	@Autowired
	UsersService service;
	
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
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody UserLoginData user) {
		String msg = "";
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		UsersEntities u = service.getUser(username);
		
		if (u == null) {			// means no user was found
			msg = "User doesn't exist";
		} else {
			boolean status = service.validate(username, password);
			
			if (status == true) {
				if (u.getRole().equals("admin")) {
					msg = "admin";
				} else {
					msg = "customer";
				}
			}
			else {
				msg = "wrong password";
			}
		}
		return msg;
	}

}










