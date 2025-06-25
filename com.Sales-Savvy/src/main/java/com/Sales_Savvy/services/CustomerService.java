package com.Sales_Savvy.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.entities.UsersEntities;

public interface CustomerService {
	
	// add customer
	boolean updateCustomer(Long id, Customer updatedCustomer);
	
	// all customer
	List<UsersEntities> listCustomer();
	
	// delete customer
	ResponseEntity<String> deleteCustomer(Long id);

}
