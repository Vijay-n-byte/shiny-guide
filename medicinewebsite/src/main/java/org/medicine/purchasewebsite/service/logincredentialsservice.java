package org.medicine.purchasewebsite.service;

import org.medicine.purchasewebsite.dto.logindto;
import org.medicine.purchasewebsite.entities.LoginCredentials;
import org.medicine.purchasewebsite.entities.admin;
import org.medicine.purchasewebsite.repository.logincredentialsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class logincredentialsservice {
	
	@Autowired
	private logincredentialsrepo lcr;
	
	
	public logindto validateusername(String s) {
		LoginCredentials l=lcr.getlogins(s);
		logindto ld=new logindto();
		if(l==null) {
			ld=null;
			return ld;
		}
		else {
			ld.setUsername(l.getUsername());
			ld.setPassword(l.getPassword());
			return ld;
		}
	
	}
	
	public logindto validateadminusername(String s) {
	    admin l=lcr.getadminlogins(s);
		logindto ld=new logindto();
		if(l==null) {
			ld=null;
			return ld;
		}
		else {
			ld.setUsername(l.getUsername());
			ld.setPassword(l.getPassword());
			return ld;
		}
	
	}
	
	public void updateadminpass(logindto l) {
		admin a=lcr.getadminlogins(l.getUsername());
		a.setPassword(l.getPassword());
		lcr.updateadminlogins(a);
		
	}

	
}
