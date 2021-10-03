package com.demo.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mvc.dao.AppDao;
import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.Product;

@Service("appService")
public class AppServiceImpl implements AppService {

	private final Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

	@Autowired
	AppDao appDao;

	@Override
	public Manufacturer findManufacturerById(Integer id) {
		logger.info("Entered findManufacturerById");
		return appDao.findManufacturerById(id);
	}

	@Override
	public Category findCategoryById(Integer id) {
		logger.info("Entered findCategoryById");
		return appDao.findCategoryById(id);
	}

	@Override
	public Product findProductById(Integer id) {
		logger.info("Entered findProductById");
		return appDao.findProductById(id);
	}

	@Override
	public List<Manufacturer> findAllManufacturer() {
		logger.info("Entered findAllManufacturer");
		return appDao.findAllManufacturer();
	}

	@Override
	public List<Category> findAllCategory() {
		logger.info("Entered findAllCategory");
		return appDao.findAllCategory();
	}

	@Override
	public List<Product> findAllProduct() {
		logger.info("Entered findAllProduct");
		return appDao.findAllProduct();
	}

	@Override
	public void saveOrUpdate(Manufacturer m) {
		logger.info("Entered saveOrUpdate manufacturer");
		Manufacturer existing = appDao.findManufacturerById(m.getId());
		logger.info("Existing manufacturer with id " + m.getId() + " is " + existing);
		if (existing == null) {
			appDao.saveManufacturer(m);
		} else {
			appDao.updateManufacturer(m);
		}
	}

	@Override
	public void saveOrUpdate(Category c) {
		logger.info("Entered saveOrUpdate Category");
		Category existing = appDao.findCategoryById(c.getId());
		logger.info("Existing Category with id " + c.getId() + " is " + existing);
		if (existing == null) {
			appDao.saveCategory(c);
		} else {
			appDao.updateCategory(c);
		}
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
	public void deleteManufacturer(int id) {
		logger.info("Entered deleteManufacturer");
		appDao.deleteManufacturer(id);
	}

	@Override
	public void deleteCategory(int id) {
		logger.info("Entered deleteCategory");
		appDao.deleteCategory(id);
	}

	@Override
	public void deleteProduct(int id) {
		logger.info("Entered deleteProduct");
		appDao.deleteProduct(id);
	}

}