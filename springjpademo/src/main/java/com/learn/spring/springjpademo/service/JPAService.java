package com.learn.spring.springjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learn.spring.springjpademo.dao.CategoryDao;
import com.learn.spring.springjpademo.dao.ManufacturerDao;
import com.learn.spring.springjpademo.dao.ProductDao;
import com.learn.spring.springjpademo.entities.Category;
import com.learn.spring.springjpademo.entities.Manufacturer;
import com.learn.spring.springjpademo.entities.Product;

@Service
public class JPAService {

	@Autowired
	ManufacturerDao mdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CategoryDao cdao;

	@Transactional(propagation = Propagation.REQUIRED, isolation =Isolation.DEFAULT)
	public void addManufacturer(Manufacturer manufacturer) {
		mdao.persist(manufacturer);
	}
	
	@Transactional
	public void addAllManufacturer(List<Manufacturer> manufacturers) {
		manufacturers.forEach(each -> mdao.persist(each));
	}
	
	
	//@Transactional
	public void updateManufacturer(Manufacturer manufacturer) {
		mdao.update(manufacturer);
	}
	
	//@Transactional
	public List<Manufacturer> findAllManufacturer() {
		return mdao.findAll();
	}
	
	//@Transactional
	public Manufacturer findManufacturerById(int id) {
		return mdao.findById(id);
	}
	
	@Transactional
	public Manufacturer findManufacturerByCode(String code) {
		return mdao.findByCode(code);
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation =Isolation.DEFAULT)
	public void addProduct(Product product) {
		System.out.println("Entered JPAService@addProduct..");
		pdao.persist(product);
	}
	
	//@Transactional
	public Product findProductById(int id) {
		return pdao.findById(id);
	}
	
	@Transactional
	public void addProductOnly(Product product, int categoryID, int manufacturerID) {
		Manufacturer m=mdao.findById(manufacturerID);
		Category c=cdao.findById(categoryID);
		product.setManufacturer(m);
		product.setCategory(c);
		pdao.persist(product);
		System.out.println("Done");
	}

}
