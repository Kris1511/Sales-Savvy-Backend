package com.Sales_Savvy.entities;

import jakarta.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String name;
	String email;
	String phone;
	String address;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long id, String name, String email, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + "]";
	}
}
