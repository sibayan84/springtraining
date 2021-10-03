package com.demo.mvc.model;

import java.util.List;

public class Product {
	// form:hidden - hidden value
	Integer id;

	String code;
	
	// form:input - textbox
	String name;

	// form:input - textarea
	String desc;

	String weight;

	String batch;

	String pkgdt;

	String expirydt;

	String mrp;

	String discount;

	String offerPrice;

	String stock;

	Category category;

	Manufacturer manufacturer;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getPkgdt() {
		return pkgdt;
	}

	public void setPkgdt(String pkgdt) {
		this.pkgdt = pkgdt;
	}

	public String getExpirydt() {
		return expirydt;
	}

	public void setExpirydt(String expirydt) {
		this.expirydt = expirydt;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", code="+code+", name=" + name + ", batch=" + batch + ", pkgdt=" + pkgdt + ", stock=" + stock + "]"
				+ isNew();
	}

}
