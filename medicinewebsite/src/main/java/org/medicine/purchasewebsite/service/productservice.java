package org.medicine.purchasewebsite.service;

import java.util.List;

import org.medicine.purchasewebsite.entities.Products;
import org.medicine.purchasewebsite.repository.productsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class productservice {
	
	@Autowired
	private productsrepo pr;
	
	public void addproducts(Products p){
		pr.addp(p);
	}
	
	public void deleteproducts(int i) {
		Products p=pr.getonep(i);
		pr.deletep(p);
	}
	public void updateproducts(int p,Products y) {
		Products pp=pr.getonep(p);
		if(pp!=null) {
			pr.updatep(y);
		}
	}
	public List<Products> getallproducts() {
		return pr.getallp();
	}
	public Products getoneproduct(int i) {
		return pr.getonep(i);
	}
}
