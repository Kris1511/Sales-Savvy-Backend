package com.Sales_Savvy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.repository.CustomerRepository;

@Service
public class CustomerServiceImplements implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	public List<Customer> listCustomer() {
		return repo.findAll();
	}

}
