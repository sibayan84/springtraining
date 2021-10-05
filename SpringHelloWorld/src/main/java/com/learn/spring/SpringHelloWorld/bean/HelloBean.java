package com.learn.spring.SpringHelloWorld.bean;

public class HelloBean {

	private String name;
	
	public HelloBean() {
		System.out.println("HelloBean constructor..");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello ! " + name);
	}

	public void init() {
		System.out.println("HelloBean init");
	}

	public void destroy() {
		System.out.println("HelloBean destroy");
	}

}
