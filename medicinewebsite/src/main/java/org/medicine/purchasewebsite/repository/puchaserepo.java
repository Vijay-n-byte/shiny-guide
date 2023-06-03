package org.medicine.purchasewebsite.repository;

import java.util.List;

import org.medicine.purchasewebsite.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class  puchaserepo{
    @Autowired
	private EntityManager em;
    
    public Purchase getuncheckedpurchase(int c) {
    	try {
    		Query q=em.createQuery("select e from Purchase e where e.c.custid=:a and e.paymentstatus=0", Purchase.class);
    		q.setParameter("a", c);
    		Purchase f=(Purchase) q.getSingleResult();
    		return f;
    		}
    		catch(Exception e) {
    			return null;
    		}
    }
    public List<Purchase> getallpurchase(int y){
    	try {
    		Query q=em.createQuery("select e from Purchase e where e.c.custid=:a", Purchase.class);
    		q.setParameter("a", y);
    		List<Purchase> f=q.getResultList();
    		return f;
    		}
    		catch(Exception e) {
    			return null;
    		}
    }
    
    public void addnewpurchase(Purchase p) {
    	em.persist(p);
    }
    
    public void updatepurchase(Purchase p) {
    	em.merge(p);
    }
    public Purchase getpurchaseincart(int y) {
    	return em.find(Purchase.class,y);
    }
    
    
}
