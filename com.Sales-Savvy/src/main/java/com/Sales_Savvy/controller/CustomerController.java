package com.Sales_Savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.repository.UsersRepository;
import com.Sales_Savvy.services.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@Autowired
	UsersRepository usersRepository;

	// GET only customers from UsersEntities table
	@GetMapping("/getAllCustomer")
	public List<UsersEntities> listCustomer() {
        return usersRepository.findByRole("customer");
    }

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody UsersEntities updatedUser) {
		return usersRepository.findById(id).map(existingUser -> {
			existingUser.setUsername(updatedUser.getUsername());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setMobile(updatedUser.getMobile());
			
			// Add more fields if needed			
			usersRepository.save(existingUser);
			
			return ResponseEntity.ok("Customer updated successfully.");
			
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
	    return service.deleteCustomer(id);
	}

}
