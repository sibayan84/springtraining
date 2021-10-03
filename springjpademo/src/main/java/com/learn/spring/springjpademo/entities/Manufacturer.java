package com.learn.spring.springjpademo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	
	@OneToMany(mappedBy="manufacturer", fetch=FetchType.LAZY)
	private Set<Product> products;

	public Manufacturer() {
		
	}
	
	public Manufacturer(String code,String name, String address, String email, String phone) {
		this.code=code;
		this.name=name;
		this.address=address;
		this.email=email;
		this.phone=phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return super.toString()+ "[Code: "+this.code+", Name : " + this.name + ", Address : " + this.address + ", Email : " + this.email + ", Phone="
				+ this.phone+" ]";
	}

}
