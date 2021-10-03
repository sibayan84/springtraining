package com.learn.spring.annotationdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependency1 {
	
	CircularDependency2 cdependency2;

	//@Autowired
	public CircularDependency1(CircularDependency2 cdependency2) {
		this.cdependency2 = cdependency2;
	}

	public CircularDependency1() {

	}

	public CircularDependency2 getCdependency2() {
		return cdependency2;
	}

	@Autowired
	public void setCdependency2(CircularDependency2 cdependency2) {
		this.cdependency2 = cdependency2;
	}

}
