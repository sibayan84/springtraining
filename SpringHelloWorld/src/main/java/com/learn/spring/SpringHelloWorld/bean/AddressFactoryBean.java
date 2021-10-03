package com.learn.spring.SpringHelloWorld.bean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class AddressFactoryBean extends AbstractFactoryBean<Object> {

	String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	protected Object createInstance() throws Exception {
		Address addr = new Address();
		if ("USA".equals(country)) {
			addr.setAddressLine1("Baker Street");
			addr.setCity("Atlanta");
			addr.setState("Georgia");
			addr.setCountry("USA");
		} else if ("Germany".equals(country)) {
			addr.setAddressLine1("Max Muller Street");
			addr.setCity("Stutgart");
			addr.setState("Baden-Württemberg");
			addr.setCountry("Germany");
		} else {
			addr.setAddressLine1("Broad Avenua");
			addr.setCity("Kolkata");
			addr.setState("West Bengal");
			addr.setCountry("India");
		}
		return addr;
	}

	@Override
	public Class<Address> getObjectType() {
		return Address.class;
	}

}
