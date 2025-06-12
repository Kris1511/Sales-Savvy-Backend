package com.Sales_Savvy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class UsersEntities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String username;
	String email;
	String password;
	String gender;
	String dob;
	String mobile;
	String role;
	
	public UsersEntities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersEntities(Long id, String username, String email, String password, String gender, String dob,
			String mobile, String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsersController [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile + ", role=" + role + "]";
	}

}
