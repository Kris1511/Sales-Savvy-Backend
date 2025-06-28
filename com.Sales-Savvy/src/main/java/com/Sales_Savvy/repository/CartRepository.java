package com.Sales_Savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales_Savvy.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
