package com.learn.spring.SpringHelloWorld.bean;

public class CircularDependency1 {
	CircularDependency2 cdependency2;

	public CircularDependency1(CircularDependency2 cdependency2) {
		this.cdependency2 = cdependency2;
	}

	public CircularDependency1() {

	}

	public CircularDependency2 getCdependency2() {
		return cdependency2;
	}

	public void setCdependency2(CircularDependency2 cdependency2) {
		this.cdependency2 = cdependency2;
	}

}
