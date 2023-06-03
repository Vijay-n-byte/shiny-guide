package org.medicine.purchasewebsite.controllers;

import org.medicine.purchasewebsite.dto.addtocartdto;
import org.medicine.purchasewebsite.dto.customerdto;
import org.medicine.purchasewebsite.dto.customerfulldetails;
import org.medicine.purchasewebsite.dto.logindto;
import org.medicine.purchasewebsite.entities.Customers;
import org.medicine.purchasewebsite.entities.Purchase;
import org.medicine.purchasewebsite.service.customersservice;
import org.medicine.purchasewebsite.service.logincredentialsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value="/customers")
public class customerscontrollers {
	
	@Autowired
	private customersservice cs;
	
	@PostMapping
	public void customersaddc(@RequestBody customerdto c) {
		cs.addcustomers(c);
	}
	
	@GetMapping(value="full/{user}")
	public customerfulldetails getfull(@PathVariable String user) {
		
		return cs.sendfulldetails(user);
		
	}
	
	@GetMapping(value="cart/{id}")
	public Purchase getcartactivepurchase(@PathVariable int id) {
		System.out.print("lllooo");
		return cs.getcartpurchaseproductsincart(id);
		
	}
	
	
	
	@GetMapping(value="/{user}")
	public Customers getonecustomercon(@PathVariable String user) {
		return cs.getcustomersusingusername(user);
	}
	
	//need to be deleted
	@PostMapping(value="/customerno={a},productno={b},quantity={c}")
	public void addproductsincustomercart(@PathVariable int a,@PathVariable int b,@PathVariable int c) {
		System.out.println("looooooooo");
		cs.addproductstocart(a,b,c);

		//if pur present,we need to check if specific product exists
		//if pur present and particular product exists,then update with quantity you got
		//if pur present and particular product doesnt exists,add that product and persist.
		//if pur null,it will create new pur and add that given product to it.
		
	}
	
	@PostMapping(value="/cartadd/{id}")
	public void addproductsincustomercart1(@PathVariable int id,@RequestBody addtocartdto d) {
		
		System.out.println("looooooooo");
		cs.addproductstocart(id,d.getProductnumber(),d.getQuantity());

		//if pur present,we need to check if specific product exists
		//if pur present and particular product exists,then update with quantity you got
		//if pur present and particular product doesnt exists,add that product and persist.
		//if pur null,it will create new pur and add that given product to it.
		
	}
	
	@PostMapping(value="/{customerno}/confirm")
	public void confirmbooking(@PathVariable int customerno) {
		System.out.println(customerno);
		cs.customerbookingconfirm(customerno);
	}	
}
