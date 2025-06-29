package com.Sales_Savvy.entities;

import java.util.ArrayList;
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
	List<CartItem> cartItems = new ArrayList<>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long id, UsersEntities users, List<CartItem> cartItems) {
		super();
		this.id = id;
		this.users = users;
		this.cartItems = cartItems;
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

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", users=" + users + ", cartItems=" + cartItems + "]";
	}
}
