package com.Sales_Savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales_Savvy.entities.UsersEntities;

public interface UsersRepository extends JpaRepository<UsersEntities, Long> {
	
	UsersEntities findByUsername(String username);
	
	List<UsersEntities> findByRole(String role);

}
