package com.Sales_Savvy.entities;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class CartItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference           // stops CartItem → Cart → CartItem loop
    private Cart cart;

    @ManyToOne
    @JsonIgnoreProperties("cart") // in case old Product rows still have cart_id
    private Product product;

    private int quantity;

    @Transient private String username;
    @Transient private Long   productId;
    
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Long id, Cart cart, Product product, int quantity, String username, Long productId) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.username = username;
		this.productId = productId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity
				+ ", username=" + username + ", productId=" + productId + "]";
	}

}
