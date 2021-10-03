package com.learn.spring.annotationdemo.bean;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class HelloBeanWrapper {

	@Inject
	HelloBean wrappedObject;

	public void checkWrappedObject() {
		System.out.println("Wrapped obj="+wrappedObject);

	}

}
