package com.learn.spring.annotationdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
public class HelloPropertyBean {

	@Autowired
	ApplicationContext appContext;
	
	@Value("${db.host.url}")
	private String url;
	
	@Value("${target}")
	private String target = "";
	
	@Value("${language}")
	private String language="";

	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		System.out.println("Setting URL.....");
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public ApplicationContext getAppContext() {
		return appContext;
	}


	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}
	
	

}
