package com.learn.spring.SpringHelloWorld.bean;

public class AddressFactoryBeanStaticMethod {
	
	private static final Address INSTANCE = new Address();

	public static Address createInstance(String addrLine1, String city, String state, String country) throws Exception {
		INSTANCE.setAddressLine1(addrLine1);
		INSTANCE.setCity(city);
		INSTANCE.setState(state);
		INSTANCE.setCountry(country);
		return INSTANCE;
	}
}
