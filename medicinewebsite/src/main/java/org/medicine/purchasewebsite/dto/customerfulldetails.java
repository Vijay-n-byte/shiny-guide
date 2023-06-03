package org.medicine.purchasewebsite.dto;

import java.util.List;

import org.medicine.purchasewebsite.entities.Purchase;

public class customerfulldetails {
	private int customerid;
	private String name;
	private String address;
	private String phonenumber;
	private String adhaarno;
	private boolean ifpurchaseopen;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
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
	public boolean isIfpurchaseopen() {
		return ifpurchaseopen;
	}
	public void setIfpurchaseopen(boolean ifpurchaseopen) {
		this.ifpurchaseopen = ifpurchaseopen;
	}
	public customerfulldetails() {
		super();
	}
	

	
}
