package com.Sales_Savvy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Sales_Savvy.entities.Customer;
import com.Sales_Savvy.entities.UsersEntities;
import com.Sales_Savvy.repository.CustomerRepository;
import com.Sales_Savvy.repository.UsersRepository;

@Service
public class CustomerServiceImplements implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
    private UsersRepository usersRepository;
	
//	public boolean updateCustomer(Long id, UsersEntities updatedCustomer) {
//        Optional<UsersEntities> optional = usersRepository.findById(id);
//
//        if (optional.isPresent()) {
//            UsersEntities existing = optional.get();
//            existing.setUsername(updatedCustomer.getUsername());
//            existing.setEmail(updatedCustomer.getEmail());
//            existing.setMobile(updatedCustomer.getMobile());
//            usersRepository.save(existing);
//            return true;
//        }
//        return false;
//    }

	public List<UsersEntities> listCustomer() {
        return usersRepository.findByRole("customer");
    }


	public ResponseEntity<String> deleteCustomer(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }

	@Override
	public boolean updateCustomer(Long id, Customer updatedCustomer) {
		Optional<UsersEntities> optional = usersRepository.findById(id);

        if (optional.isPresent()) {
            UsersEntities existing = optional.get();
            existing.setUsername(updatedCustomer.getName());
            existing.setEmail(updatedCustomer.getEmail());
            existing.setMobile(updatedCustomer.getPhone());
            usersRepository.save(existing);
            return true;
        }
        return false;
	}

}
