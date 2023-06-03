package org.medicine.purchasewebsite.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int purchaseid;
	
	@Nullable
	private Long totalcost;
	
	@Nullable
	private int paymentstatus;
	

	@Column(name="purchasedate",nullable=true)
	private LocalDateTime d;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customers c;
	
	@OneToMany(mappedBy="k.pur")
	private List<puchasedproducts> pp;

	public Purchase() {
		super();
	}

	public Purchase(int purchaseid, Long totalcost, int paymentstatus, LocalDateTime d, Customers c,
		List<puchasedproducts> pp) {
		super();
		this.purchaseid = purchaseid;
		this.totalcost = totalcost;
		this.paymentstatus = paymentstatus;
		this.d = d;
		this.c = c;
		this.pp = pp;
	}

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public Long getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}

	public int getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public LocalDateTime getD() {
		return d;
	}

	public void setD(LocalDateTime d) {
		this.d = d;
	}

//	public Customers getC() {
//		return c;
//	}

	public void setC(Customers c) {
		this.c = c;
	}

	public List<puchasedproducts> getPp() {
		return pp;
	}

	public void setPp(ArrayList<puchasedproducts> pp) {
		this.pp = pp;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseid=" + purchaseid + ", totalcost=" + totalcost + ", paymentstatus=" + paymentstatus
				+ ", d=" + d + ", c=" + c + ", pp=" + pp + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
