package org.medicine.purchasewebsite.service;

import java.time.LocalDateTime;
import java.util.List;

import org.medicine.purchasewebsite.dto.customerdto;
import org.medicine.purchasewebsite.dto.customerfulldetails;
import org.medicine.purchasewebsite.entities.Customers;
import org.medicine.purchasewebsite.entities.ppkey;
import org.medicine.purchasewebsite.entities.LoginCredentials;
import org.medicine.purchasewebsite.entities.Products;
import org.medicine.purchasewebsite.entities.Purchase;
import org.medicine.purchasewebsite.entities.puchasedproducts;
import org.medicine.purchasewebsite.repository.customersrepo;
import org.medicine.purchasewebsite.repository.logincredentialsrepo;
import org.medicine.purchasewebsite.repository.productsrepo;
import org.medicine.purchasewebsite.repository.puchasedproductsrepo;
import org.medicine.purchasewebsite.repository.puchaserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customersservice {

	@Autowired
	private customersrepo cs;
	
	@Autowired
	private logincredentialsrepo lcr;
	
	@Autowired
	private productsrepo pr;
	
	@Autowired
	private puchaserepo purrep;
	
	@Autowired
	private puchasedproductsrepo ppr;
	
	public Purchase getcartpurchaseproductsincart(int r) {
		Purchase po=purrep.getuncheckedpurchase(r);
		if(po==null) {
			return null;
		}
		else {
			return po;
		}
	}
	
	public customerfulldetails sendfulldetails(String username) {
		Customers b=lcr.getlogins(username).getCc();
		customerfulldetails k=new customerfulldetails();
		k.setCustomerid(b.getCustid());
		k.setName(b.getName());
		k.setAddress(b.getAddress());
		k.setAdhaarno(b.getAdhaarno());
		k.setPhonenumber(b.getPhonenumber());
		Purchase p=purrep.getuncheckedpurchase(b.getCustid());
		boolean kp;
		if(p==null) {
			kp=false;
		}
		else {
			kp=true;
		}
		k.setIfpurchaseopen(kp);
		return k;
	}
	
	public void addcustomers(customerdto c) {
		Customers cus=new Customers();
		LoginCredentials lc=new LoginCredentials();
		cus.setName(c.getName());
		cus.setAddress(c.getAddress());
		cus.setAdhaarno(c.getAdhaarno());
		cus.setPhonenumber(c.getPhonenumber());
		cs.addc(cus);
	    lc.setUsername(c.getUsername());
	    lc.setPassword(c.getPassword());
	    lc.setCc(cus);
	    lcr.addonelogin(lc);
	}
	
	public Customers getonecustomerusingcid(int k) {
		return cs.getonec(k);
	}
	
	public Customers getcustomersusingusername(String u) {
		return lcr.getlogins(u).getCc();
		
	}
	
//	public void addproductstocart(int a,int b,int c) {
//	    Purchase pu=purrep.getuncheckedpurchase(a);
//	    System.out.println(pu);
//	    if(pu==null) {
//	    	Customers c1=cs.getonec(a);
//	    	pu=new Purchase();
//	    	pu.setC(c1);
//	    	pu.setPaymentstatus(0);
//	    	purrep.addnewpurchase(pu);
//	    	System.out.println(pu);
//	    }
//	    Products p=pr.getonep(b); 
//		int y=p.getCost()*c;
//		System.out.print("loooooooooopll");
//		ppkey mn=new ppkey();
//		mn.setPur(pu);
//		mn.setPro(p);
//		
//		puchasedproducts pp=new puchasedproducts();
//		pp.setK(mn);
//		pp.setCost(y);
//		pp.setQuantity(c);
//		ppr.addpuchasedproducts(pp);
//	}
	public void addproductstocart(int a,int b,int c) {
	    Purchase pu=purrep.getuncheckedpurchase(a);
	   //check if purchase is empty.
	    if(pu!=null) {
	    	int re=pu.getPurchaseid();
	    	puchasedproducts lop=ppr.ifproductspresentalready(re, b);
	    	System.out.println(lop);
	    	//check if products already in cart
	    	if(lop!=null) {
	    		//products already in cart.so update the quantity.+
	    		Products p=pr.getonep(b); 
	    		int r=p.getCost();
	    		lop.setCost(r*c);
	    		lop.setQuantity(c);
        		ppr.updateproducts(lop);
	    	}
	    	else {
	    		//product already not in cart.so add that product.+
	    		Products p=pr.getonep(b); 
				int y=p.getCost()*c;
				System.out.print("loooooooooopll");
				ppkey mn=new ppkey();
				mn.setPur(pu);
				mn.setPro(p);
				
				puchasedproducts pp=new puchasedproducts();
				pp.setK(mn);
				pp.setCost(y);
				pp.setQuantity(c);
				ppr.addpuchasedproducts(pp);
	    	}
	    	//between is sample
	    	long jue=ppr.gettotalcost(pu.getPurchaseid());
	    	pu.setTotalcost(jue);
	    	purrep.updatepurchase(pu);
	    	//between is sample
	    }
	    //create new purchsae first to accomodate purchasing option.then add the product.+
	    else {
	    	Customers c1=cs.getonec(a);
	    	pu=new Purchase();
	    	pu.setC(c1);
	    	pu.setPaymentstatus(0);
	    	purrep.addnewpurchase(pu);
	    	System.out.println(pu);
	    	
	    	Products p=pr.getonep(b); 
			int y=p.getCost()*c;
			System.out.print("loooooooooopll");
			ppkey mn=new ppkey();
			mn.setPur(pu);
			mn.setPro(p);
			
			puchasedproducts pp=new puchasedproducts();
			pp.setK(mn);
			pp.setCost(y);
			pp.setQuantity(c);
			ppr.addpuchasedproducts(pp);
			//between is sample
			long jue=ppr.gettotalcost(pu.getPurchaseid());
	    	pu.setTotalcost(jue);
	    	purrep.updatepurchase(pu);
	    	//between is sample
	    }
	}
	
	public void customerbookingconfirm(int y) {
		Purchase pu=purrep.getuncheckedpurchase(y);
		//long j=ppr.gettotalcost(pu.getPurchaseid());
	//	pu.setTotalcost(j);
		LocalDateTime k=LocalDateTime.now();
		pu.setD(k);
		pu.setPaymentstatus(1);
		purrep.updatepurchase(pu);
	}
	
}
