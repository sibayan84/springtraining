package com.demo.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mvc.dao.AppDao;
import com.demo.mvc.model.Product;

@Service("productService")
public class ProductServiceImpl implements ApplicationService<Product>{
	
	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	AppDao appDao;
	
	@Override
	public Product findById(Integer id) {
		logger.info("Entered findById");
		return appDao.findProductById(id);
	}

	@Override
	public List<Product> findAll() {
		logger.info("Entered findAllProduct");
		return appDao.findAllProduct();
	}

	@Override
	public void saveOrUpdate(Product p) {
		logger.info("Entered saveOrUpdate Product");
		Product existing = appDao.findProductById(p.getId());
		logger.info("Existing Product with id " + p.getId() + " is " + existing);
		if (existing == null) {
			appDao.saveProduct(p);
		} else {
			appDao.updateProduct(p);
		}
		
	}

	@Override
	public void delete(int id) {
		logger.info("Entered deleteProduct");
		appDao.deleteProduct(id);
	}

}
