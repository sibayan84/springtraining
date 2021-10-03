package com.learn.spring.SpringHelloWorld.bean;

public class AddressFactoryBeanInstanceMethod {

	protected Object createInstance(String addrLine1, String city, String state, String country) throws Exception {
		
		Address addr = new Address(addrLine1,city,state,country);
		return addr;
	}

}
