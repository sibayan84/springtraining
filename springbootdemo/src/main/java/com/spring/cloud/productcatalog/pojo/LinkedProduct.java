package com.spring.cloud.productcatalog.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.hateoas.RepresentationModel;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkedProduct /*extends RepresentationModel<LinkedProduct>*/ {

	private int productID;
	private String productName;
	private String type;

	public LinkedProduct() {

	}
	
	public LinkedProduct(Product p) {
		this.productID=p.getProductID();
		this.productName=p.getProductName();
		this.type=p.getType();
	}

	public LinkedProduct(int productID, String productName, String type) {
		this.productID = productID;
		this.productName = productName;
		this.type = type;
	}
	
	

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ProductID-" + this.productID + ", Name-" + this.productName + ", Type=" + this.type;
	}
	
	@Override
	public int hashCode() {
		return this.productName.hashCode();
	}
	
}
