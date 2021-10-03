package com.demo.mvc.model;

import java.util.List;

public class Manufacturer {
	// form:hidden - hidden value
	Integer id;
	
	String code;

	// form:input - textbox
	String name;

	// form:textarea - textarea
	String address;

	// form:input - textbox
	String email;

	// form:input - phone
	String phone;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", code="+code+", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + "]" + isNew();
	}

}
