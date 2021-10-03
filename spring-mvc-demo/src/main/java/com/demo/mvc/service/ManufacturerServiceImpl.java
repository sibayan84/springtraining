package com.demo.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mvc.dao.AppDao;
import com.demo.mvc.model.Manufacturer;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ApplicationService<Manufacturer> {
	
	private final Logger logger = LoggerFactory.getLogger(ManufacturerServiceImpl.class);
	
	@Autowired
	AppDao appDao;
	
	@Override
	public Manufacturer findById(Integer id) {
		logger.info("Entered findManufacturerById");
		return appDao.findManufacturerById(id);
	}

	@Override
	public List<Manufacturer> findAll() {
		logger.info("Entered findAllManufacturer");
		return appDao.findAllManufacturer();
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
	public void delete(int id) {
		logger.info("Entered deleteManufacturer");
		appDao.deleteManufacturer(id);
	}

}
