package com.learn.spring.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.learn.spring.annotationdemo.bean.HelloPropertyBean;

@Configuration
@ComponentScan(basePackages = "com.learn.spring.annotationdemo.bean")
@PropertySources({ @PropertySource(value = "classpath:file1.properties"),
		@PropertySource(value = "classpath:file2.properties"),
		@PropertySource(value = "file:C:\\sibadata\\personal\\training\\spring\\properties\\external.properties") })

public class PropertyDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyDemo.class);
		HelloPropertyBean bean = ctx.getBean(HelloPropertyBean.class);
		System.out.println("Url=" + bean.getUrl());
		System.out.println("Target=" + bean.getTarget());
		System.out.println("Language=" + bean.getLanguage());
		System.out.println("AppContext="+bean.getAppContext());
		System.out.println("ctx="+ctx);

	}

	/*
	 * Without configuring PropertyPlaceholderConfigurer the property is not
	 * resolved. It prints ${db.host.url} instead of its value
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertSource() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
