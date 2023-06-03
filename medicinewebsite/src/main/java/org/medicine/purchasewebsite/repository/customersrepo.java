package org.medicine.purchasewebsite.repository;

import org.medicine.purchasewebsite.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class customersrepo {
	
	@Autowired
	private EntityManager em;
	
	public void addc(Customers c) {
		em.persist(c);
	}
	
	//using cid
	public Customers getonec(int j) {
		return em.find(Customers.class,j);
	}
	

	
	
	
}
