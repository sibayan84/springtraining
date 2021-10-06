package com.demo.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mvc.dao.AppDao;
import com.demo.mvc.model.CategoryAndManufacturer;

@Service
public class CategoryManufacturerServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(ManufacturerServiceImpl.class);
	
	@Autowired
	private AppDao appDao;
	
	public void save(CategoryAndManufacturer cmf) {
		logger.info("Entered save CategoryAndManufacturer");
		
		appDao.saveCategory(cmf.getCategory());
		appDao.saveManufacturer(cmf.getManufacturer());
		
	}

}
