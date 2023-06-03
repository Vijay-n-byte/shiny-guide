package org.medicine.purchasewebsite.entities;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@Component
public class Customers {
	@Id
	@Column(name="customerid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custid;
	
	private String name;
	private String address;
	private String phonenumber;
	private String adhaarno;
	
//	@OneToOne(mappedBy="cc")
//	private LoginCredentials lc;
	
	@OneToMany
	private List<Purchase> p;

	public Customers() {
		super();
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
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

	@Override
	public String toString() {
		return "Customers [custid=" + custid + ", name=" + name + ", address=" + address + ", phonenumber="
				+ phonenumber + ", adhaarno=" + adhaarno + ", p=" + p + "]";
	}

	public Customers(int custid, String name, String address, String phonenumber, String adhaarno, List<Purchase> p) {
		super();
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.adhaarno = adhaarno;
		this.p = p;
	}


	
	
	
	


	
	

	

	
	
	
}
