package com.learn.spring.annotationdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependency2 {
	CircularDependency1 cdependency1;

	public CircularDependency2() {

	}
	
	//@Autowired
	public CircularDependency2(CircularDependency1 cdependency1) {
		this.cdependency1 = cdependency1;
	}

	public CircularDependency1 getCdependency1() {
		return cdependency1;
	}
	
	@Autowired
	public void setCdependency1(CircularDependency1 cdependency1) {
		this.cdependency1 = cdependency1;
	}
	
}
