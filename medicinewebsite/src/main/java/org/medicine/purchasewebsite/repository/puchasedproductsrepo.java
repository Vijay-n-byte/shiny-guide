package org.medicine.purchasewebsite.repository;


import java.util.Optional;

import org.medicine.purchasewebsite.entities.puchasedproducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;


@Repository
@Transactional
public class puchasedproductsrepo {
	
	@Autowired
	private EntityManager em;
	
	public void updateproducts(puchasedproducts p) {
		em.merge(p);
	}
	
	public void addpuchasedproducts(puchasedproducts p) {
		em.persist(p);
	}
	
	public long gettotalcost(int p) {
		Query q=em.createQuery("select sum(p.cost) from puchasedproducts p where p.k.pur.purchaseid=:a", puchasedproducts.class);
		q.setParameter("a", p);
		long l=(long)q.getSingleResult();
		System.out.println(l);
		return l;
	}	
	
	public puchasedproducts ifproductspresentalready(int x,int y) {
		Query q=em.createQuery("select e from puchasedproducts e where e.k.pur.purchaseid=:a and e.k.pro.productno=:b", puchasedproducts.class);
		q.setParameter("a",x);
		q.setParameter("b",y);
		puchasedproducts l;
		try {
		l=(puchasedproducts) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		System.out.println(l);
		return l;
	}
}
