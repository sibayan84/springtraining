package com.learn.spring.springjpademo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learn.spring.springjpademo.entities.Manufacturer;

/**
 * CRUD methods of CrudRepository are transactional by default. 
 * They are annotated with @Transactional annotation with default settings 
 * in implementation class at runtime.
 */
public interface ManufacturerCrudRepository extends CrudRepository<Manufacturer, Integer> {

	Manufacturer findByCode(String manufacturerCode);
	
	//@Query(value = "SELECT m FROM Manufacturer m as WHERE m.email= ?1 and m.phone= ?2")
	@Query("FROM Manufacturer m where m.email=?1 and m.phone=?2")
	List<Manufacturer> findByEmailAndPhone(String email, String phone);

}
