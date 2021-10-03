package com.learn.spring.springjpademo.service;

import java.util.List;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.learn.spring.springjpademo.dao.ProductDao;
import com.learn.spring.springjpademo.entities.Product;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;

	//@Transactional
	public void add(Product product) {
		productDao.persist(product);
	}
	
	@Transactional
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDao.persist(product);
		}
	}

	@Transactional(readOnly = true)
	public List<Product> listAll() {
		return productDao.findAll();
	}
	

}