package org.medicine.purchasewebsite.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productno;
	
	@Column(nullable=false)
	private String productname;
	
	private String description;
	private int cost;
	
	@Column(nullable=false)
	private String category;
	
	@Column(columnDefinition="mediumtext")
	private String img;
	
	//1 indicates active.zero indicates not active.
	private int isactive;
	
	//private int status;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="k.pro")
	private List<puchasedproducts> pp1;

	public Products() {
		super();
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

//	public List<puchasedproducts> getPp1() {
//		return pp1;
//	}
	
//	public void setPp1(puchasedproducts pp) {
//	    this.pp1.add(pp);
//	}
	
	
	
	public Products(String productname, String description, int cost, String category) {
		this.productno = productno;
		this.productname = productname;
		this.description = description;
		this.cost = cost;
		this.category = category;
	}

	public Products(String productname, String description, int cost, String category, String img,
			List<puchasedproducts> pp1) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.description = description;
		this.cost = cost;
		this.category = category;
		this.img = img;
		this.pp1 = pp1;
	}

	@Override
	public String toString() {
		return "Products [productno=" + productno + ", productname=" + productname + ", description=" + description
				+ ", cost=" + cost + ", category=" + category + ", img=" + img + ", pp1=" + pp1 + "]";
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
	
	
	
	
	
}
