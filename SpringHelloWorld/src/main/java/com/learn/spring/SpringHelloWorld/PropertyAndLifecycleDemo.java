package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.HelloPropertyBean;

public class PropertyAndLifecycleDemo {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context2.xml");

		System.out.println(context);

		HelloPropertyBean obj = (HelloPropertyBean) context.getBean("helloPropertyBean");
		
		System.out.println("URL="+obj.getUrl());
		System.out.println("Target="+obj.getTarget());
		System.out.println("Language="+obj.getLanguage());
		
		System.out.println(obj);
		context.close();
		
	}

}
