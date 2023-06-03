package org.medicine.purchasewebsite.repository;

import java.util.List;

import org.medicine.purchasewebsite.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
@Component
public class productsrepo {
	
	@Autowired
	private EntityManager em;
	
	public void addp(Products p){
		em.persist(p);		
	}
	
	public void deletep(Products p) {
		em.remove(p);
	}
	public void updatep(Products l) {
		System.out.print("merged");
		em.merge(l);
	}
	public Products getonep(int i) {
		return em.find(Products.class, i);
	}
	public List<Products> getallp(){
		TypedQuery<Products> q=em.createQuery("select p from Products p", Products.class);
		List<Products> j=q.getResultList();
		return j;
	}
}
