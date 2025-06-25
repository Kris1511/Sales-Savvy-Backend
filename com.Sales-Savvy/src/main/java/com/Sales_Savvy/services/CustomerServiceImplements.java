package com.Sales_Savvy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.repository.CustomerRepository;

@Service
public class CustomerServiceImplements implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public boolean updateCustomer(Long id, Customer updateCustomer) {
		Optional<Customer> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			Customer existing = optional.get();
			
			existing.setName(updateCustomer.getName());
			existing.setEmail(updateCustomer.getEmail());
			existing.setPhone(updateCustomer.getPhone());
			
			repo.save(existing);
			
			return true;
		}
		
		return false;
	}

	public List<Customer> listCustomer() {
		return repo.findAll();
	}

}
