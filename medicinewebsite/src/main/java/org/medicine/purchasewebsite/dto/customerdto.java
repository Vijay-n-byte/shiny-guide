package org.medicine.purchasewebsite.dto;

import org.springframework.web.multipart.MultipartFile;

public class customerdto {
	
	private String name;
	private String address;
	private String phonenumber;
	private String adhaarno;
	private String username;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdhaarno() {
		return adhaarno;
	}
	public void setAdhaarno(String adhaarno) {
		this.adhaarno = adhaarno;
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
	public customerdto(String name, String address, String phonenumber, String adhaarno, String username,
			String password) {
		super();
		
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.adhaarno = adhaarno;
		this.username = username;
		this.password = password;
	}
	public customerdto() {
		super();
	}
	
	

}
