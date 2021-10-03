package com.learn.spring.SpringHelloWorld.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjectionBean {

	List<String> addressList;
	Set<String> addressSet;
	Map<String, String> addressMap;
	Properties addressProp;
	List<Integer> marksList;
	
	String email;
	String fax;

	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	public List getAddressList() {
		System.out.println("List Elements :" + addressList);
		return addressList;
	}

	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	public Set getAddressSet() {
		System.out.println("Set Elements :" + addressSet);
		return addressSet;
	}

	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	public Map getAddressMap() {
		System.out.println("Map Elements :" + addressMap);
		return addressMap;
	}

	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}

	public Properties getAddressProp() {
		System.out.println("Property Elements :" + addressProp);
		return addressProp;
	}
	
	
	public List<Integer> getMarksList() {
		System.out.println("List Elements :"+marksList);
		return marksList;
	}

	public void setMarksList(List<Integer> marksList) {
		this.marksList = marksList;
	}

	public String getEmail() {
		System.out.println("Email is "+email);
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		System.out.println("Fax is "+fax);
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
