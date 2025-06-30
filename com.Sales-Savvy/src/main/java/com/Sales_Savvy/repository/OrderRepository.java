package com.Sales_Savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales_Savvy.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

}
