package com.Sales_Savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales_Savvy.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
