package com.learn.spring.SpringHelloWorld.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloPropertyBean implements ApplicationContextAware {

	private String url = "";
	private String target = "";
	private String language="";
	
	ApplicationContext ctx;
	
	public HelloPropertyBean(String url, String target, String language) {
		System.out.println("HelloPropertyBean Constructor");
		this.url=url;
		this.target=target;
		this.language=language;
	}
	
	public HelloPropertyBean() {
		System.out.println("HelloPropertyBean Default Constructor");
	}
	
	public void init() {
		System.out.println("HelloPropertyBean init");
	}
	public void destroy() {
		System.out.println("HelloPropertyBean destroy");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("HelloPropertyBean setUrl");
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		System.out.println("HelloPropertyBean setTarget");
		this.target = target;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		System.out.println("HelloPropertyBean setLanguage");
		this.language = language;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("HelloPropertyBean setApplicationContext");
		this.ctx=ctx;
	}
	
	
	public ApplicationContext getApplicationContext() {
		return this.ctx;
	}
	

}
