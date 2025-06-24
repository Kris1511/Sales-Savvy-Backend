package com.Sales_Savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.services.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("/signup")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(service.addCustomer(customer));
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return service.listCustomer();
	}

}
