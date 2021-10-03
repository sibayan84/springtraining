package com.learn.spring.springjpademo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.springjpademo.entities.Manufacturer;

@Service
public class ManufacturerCrudRepositoryService {

	@Autowired
	private ManufacturerCrudRepository mfRepository;

	public void add(Manufacturer manufacturer) {
		mfRepository.save(manufacturer);
	}
	
	public Manufacturer findByCode(String mfCode) {
		return mfRepository.findByCode(mfCode);
	}
	
	public List<Manufacturer> findByEmailAndPhone(String email, String phone) {
		return mfRepository.findByEmailAndPhone(email, phone);
	}

	public Manufacturer findById(Integer id) {
		Optional<Manufacturer> opt= mfRepository.findById(id);
		return opt.get();
	}

	public void deleteById(Integer id) {
		mfRepository.deleteById(id);
	}

}
