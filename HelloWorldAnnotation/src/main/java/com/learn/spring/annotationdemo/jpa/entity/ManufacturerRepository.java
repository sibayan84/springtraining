package com.learn.spring.annotationdemo.jpa.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

	// public List<Manufacturer> findByName(String name);
	public Manufacturer findById(int id);

}