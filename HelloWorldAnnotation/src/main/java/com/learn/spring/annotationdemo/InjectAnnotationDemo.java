package com.learn.spring.annotationdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learn.spring.annotationdemo.bean.HelloBeanWrapper;

@Configuration
@ComponentScan
public class InjectAnnotationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InjectAnnotationDemo.class);
		HelloBeanWrapper wrapper=ctx.getBean(HelloBeanWrapper.class);
		wrapper.checkWrappedObject();
		ctx.close();
	}
}
