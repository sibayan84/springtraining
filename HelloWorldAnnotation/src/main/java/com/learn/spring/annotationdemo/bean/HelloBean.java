package com.learn.spring.annotationdemo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class HelloBean {
	private String name;
	

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello ! " + name);
	}
	
	/**
	 * @PostConstruct only called once, just after the initialization of bean properties. 
	 * These methods run even if there is nothing to initialize.
	 * The method annotated with @PostConstruct can have any access level 
	 * but it can't be static.
	 */
	@PostConstruct
	public void init() {
		System.out.println("HelloBean init");
	}
	
	/**
	 * @PreDestroy runs only once, just before Spring removes our bean from the application context.
	 * Can have any access level but can't be static.
	 */
	@PreDestroy
	public static void destroy() {
		System.out.println("HelloBean destroy");
	}

}
