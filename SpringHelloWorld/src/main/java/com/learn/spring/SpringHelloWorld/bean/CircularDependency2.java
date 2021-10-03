package com.learn.spring.SpringHelloWorld.bean;

public class CircularDependency2 {
	CircularDependency1 cdependency1;

	public CircularDependency2() {

	}

	public CircularDependency2(CircularDependency1 cdependency1) {
		this.cdependency1 = cdependency1;
	}

	public CircularDependency1 getCdependency1() {
		return cdependency1;
	}

	public void setCdependency1(CircularDependency1 cdependency1) {
		this.cdependency1 = cdependency1;
	}
	
}
