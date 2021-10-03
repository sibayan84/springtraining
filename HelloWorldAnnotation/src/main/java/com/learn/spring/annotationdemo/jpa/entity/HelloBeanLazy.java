package com.learn.spring.annotationdemo.jpa.entity;

import java.beans.ConstructorProperties;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class HelloBeanLazy {
	private String name;
	

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("HelloBeanMisc ! " + name);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloBeanMisc init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("HelloBeanMisc destroy");
	}

	

}
