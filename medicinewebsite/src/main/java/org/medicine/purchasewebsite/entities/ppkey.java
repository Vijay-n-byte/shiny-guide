package org.medicine.purchasewebsite.entities;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Embeddable
@Component
public class ppkey implements  Serializable{
	
	@ManyToOne
	@JoinColumn(name="productsid")
	private Products pro;
	
	@ManyToOne
	@JoinColumn(name="purchseid")
	private Purchase pur;

	public ppkey() {
		super();
	}

	public Products getPro() {
		return pro;
	}

	public void setPro(Products pro) {
		this.pro = pro;
	}

//	public Purchase getPur() {
//		return pur;
//	}

	public void setPur(Purchase pur) {
		this.pur = pur;
	}

	public ppkey(Products pro, Purchase pur) {
		super();
		this.pro = pro;
		this.pur = pur;
	}
}
