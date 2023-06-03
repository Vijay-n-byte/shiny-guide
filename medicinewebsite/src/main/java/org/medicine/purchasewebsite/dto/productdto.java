package org.medicine.purchasewebsite.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public class productdto {
    private String productname;
	private String description;
	private int cost;
	private String category;
//	private MultipartFile img;
	@Override
	public String toString() {
		return "productdto [productname=" + productname + ", description=" + description + ", cost=" + cost
				+ ", category=" + category + "]";
	}
public productdto(String productname, String description, int cost, String category) {
	super();
	this.productname = productname;
	this.description = description;
	this.cost = cost;
	this.category = category;
}
public productdto() {
	super();
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

	

    
    
	
	
}
