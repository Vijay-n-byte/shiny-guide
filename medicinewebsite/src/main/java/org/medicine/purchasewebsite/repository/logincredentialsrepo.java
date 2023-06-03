package org.medicine.purchasewebsite.repository;

import org.medicine.purchasewebsite.entities.admin;
import org.medicine.purchasewebsite.dto.logindto;
import org.medicine.purchasewebsite.entities.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class logincredentialsrepo {
	
	@Autowired
	private EntityManager em;
	
	public void addonelogin(LoginCredentials lc){
		em.persist(lc);
	}
	
	public LoginCredentials getlogins(String h) {
		return em.find(LoginCredentials.class, h);
		
	}
	public admin getadminlogins(String h) {
		return em.find(admin.class, h);
	}
	
	public void updateadminlogins(admin h) {
		em.merge(h);
	}
}
