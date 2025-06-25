package com.Sales_Savvy.services;

import java.util.List;

import com.Sales_Savvy.entities.Customer;

public interface CustomerService {
	
	// add customer
	boolean updateCustomer(Long id, Customer updatedCustomer);
	
	// all customer
	List<Customer> listCustomer();

}
