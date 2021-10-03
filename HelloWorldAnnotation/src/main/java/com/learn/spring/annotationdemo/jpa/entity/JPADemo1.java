package com.learn.spring.annotationdemo.jpa.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class JPADemo1 {

	//@Autowired
	//ManufacturerRepository manufacturerrepo;
	
	@Autowired
	Manufacturer manufaturer;

	public Manufacturer getManufaturer() {
		return manufaturer;
	}

	public void setManufaturer(Manufacturer manufaturer) {
		this.manufaturer = manufaturer;
	}

	public void testGET() {
		//manufacturerrepo.findById(1);
		//System.out.println("0");
	}

	/*public ManufacturerRepository getManufacturerrepo() {
		return manufacturerrepo;
	}

	public void setManufacturerrepo(ManufacturerRepository manufacturerrepo) {
		this.manufacturerrepo = manufacturerrepo;
	}*/
	
	
	

}
