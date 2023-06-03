package org.medicine.purchasewebsite.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.medicine.purchasewebsite.dto.productdto;
import org.medicine.purchasewebsite.entities.Products;
import org.medicine.purchasewebsite.repository.productsrepo;
import org.medicine.purchasewebsite.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value="/products")
public class productcontroller {
	
	@Autowired
	private productservice ps;
	
	@Autowired
	private productsrepo pu;
	
	@GetMapping
	public List<Products> getallproductsc() {
		return ps.getallproducts();
	}
	
	@GetMapping(value="/{id}")
	public Products getoneproductc(@PathVariable int id) {
		return ps.getoneproduct(id);
	}
	@PostMapping(value="/dummy/{id}")
	public void addproductcyy(@RequestParam("sample") MultipartFile p,@PathVariable int id) throws IOException {
		System.out.println("looooooo");
		System.out.println(p.getSize());
		Products pl=ps.getoneproduct(id);
		if(!p.isEmpty()) {
			System.out.println("hello");	
			byte[] y=p.getBytes();
			String ii=Base64.getEncoder().encodeToString(y);
			String h="data:image/jpeg;base64,"+ii;
			System.out.println(h);
			pl.setImg(h);
			pu.updatep(pl);
		}
	}
	
	@PostMapping
	public void addproductcyy(@RequestBody String p) throws IOException {
		System.out.println(p);
		Gson g=new Gson();
		productdto pp=g.fromJson(p, productdto.class);
		System.out.print(pp);
		Products pmn=new Products();
		pmn.setProductname(pp.getProductname());
		pmn.setDescription(pp.getDescription());
		pmn.setCost(pp.getCost());
		pmn.setCategory(pp.getCategory());
		ps.addproducts(pmn);
	}
	

	
	@DeleteMapping(value="/{id}")
	public void deleteproductc(@PathVariable int id) {
		ps.deleteproducts(id);
	}
	
	@PutMapping(value="/products/{id}")
	public void updateproductc(@PathVariable int id,@RequestBody Products p) {
		System.out.print("llllll");
		ps.updateproducts(id,p);
	}
}
