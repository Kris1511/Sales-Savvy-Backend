package com.Sales_Savvy.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Orders {
	
	@Id                         // Razorpay order-id (e.g. "order_LuF...")
    String id;

    int    amount;      // paise
    String currency;    // "INR"
    String status;      // CREATED | PAID
    String receipt;     // optional

    String paymentId;   // Razorpay payment-id after success

    @ManyToOne
    UsersEntities user;

    @OneToMany(cascade = CascadeType.ALL)
    List<CartItem> items;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String id, int amount, String currency, String status, String receipt, String paymentId,
			UsersEntities user, List<CartItem> items) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.status = status;
		this.receipt = receipt;
		this.paymentId = paymentId;
		this.user = user;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public UsersEntities getUser() {
		return user;
	}

	public void setUser(UsersEntities user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", amount=" + amount + ", currency=" + currency + ", status=" + status
				+ ", receipt=" + receipt + ", paymentId=" + paymentId + ", user=" + user + ", items=" + items + "]";
	} 

}
