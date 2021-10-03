package com.demo.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mvc.dao.AppDao;
import com.demo.mvc.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements ApplicationService<Category> {

	private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	AppDao appDao;

	@Override
	public Category findById(Integer id) {
		logger.info("Entered findCategoryById");
		return appDao.findCategoryById(id);
	}

	@Override
	public List<Category> findAll() {
		logger.info("Entered findAllCategory");
		return appDao.findAllCategory();
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
	public void delete(int id) {
		logger.info("Entered deleteCategory");
		appDao.deleteCategory(id);
	}

}
