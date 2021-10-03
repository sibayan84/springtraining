package com.learn.spring.annotationdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learn.spring.annotationdemo.bean.CircularDependency1;
import com.learn.spring.annotationdemo.bean.CircularDependency2;

@Configuration
@ComponentScan(basePackages = "com.learn.spring.annotationdemo.bean")
public class CircularDemo {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( CircularDemo.class);
		CircularDependency1 obj1=context.getBean(CircularDependency1.class);
		CircularDependency2 obj2=context.getBean(CircularDependency2.class);
		System.out.println(obj1);
		System.out.println(obj2);
		context.close();
	}
	

}
