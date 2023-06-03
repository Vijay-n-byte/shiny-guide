package org.medicine.purchasewebsite.dto;

public class logindto {
	private String username;
	private String password;
	public logindto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public logindto() {
		super();
	}
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
	
	
}
