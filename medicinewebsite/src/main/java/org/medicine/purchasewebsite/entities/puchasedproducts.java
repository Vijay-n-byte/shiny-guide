package org.medicine.purchasewebsite.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
@Component
@AssociationOverrides({@AssociationOverride(name = "k.pro",joinColumns=@JoinColumn(name="products")),@AssociationOverride(name = "k.pur",joinColumns=@JoinColumn(name="purchase"))})
public class puchasedproducts implements Serializable {
	
	@EmbeddedId
	private ppkey k;
	private int quantity;
	private int cost;
	
	public puchasedproducts() {
		super();
	}

	public ppkey getK() {
		return k;
	}

	public void setK(ppkey k) {
		this.k = k;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "puchasedproducts [quantity=" + quantity + ", cost=" + cost + "]";
	}
}
