package org.medicine.purchasewebsite.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class LoginCredentials {

	@Id
	private String username;
	@Column(nullable=false)
	private String password;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customers cc;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customers getCc() {
		return cc;
	}

	public void setCc(Customers cc) {
		this.cc = cc;
	}

	public LoginCredentials(String username, String password, Customers cc) {
		super();
		this.username = username;
		this.password = password;
		this.cc = cc;
	}

	public LoginCredentials() {
		super();
	}
	
	
	
	
}
