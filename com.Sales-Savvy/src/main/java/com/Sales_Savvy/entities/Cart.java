package com.Sales_Savvy.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@OneToOne			// one user have one cart 
	@JoinColumn(name = "user_id", unique = true)
    @JsonBackReference   
	UsersEntities users;
	
	@OneToMany(
	        mappedBy = "cart",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )							// one cart have the multiple product
	    @JsonManagedReference       			
	List<Product> productList;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long id, UsersEntities users, List<Product> productList) {
		super();
		this.id = id;
		this.users = users;
		this.productList = productList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsersEntities getUsers() {
		return users;
	}

	public void setUsers(UsersEntities users) {
		this.users = users;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", users=" + users + ", productList=" + productList + "]";
	}

}
