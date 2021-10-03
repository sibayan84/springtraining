package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.ConstructorConfusionBean;

public class ConstructorConfusionDemo {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("constructor_confusion.xml");

		ConstructorConfusionBean obj = (ConstructorConfusionBean) context.getBean("ConstructorConfusionBean");
		System.out.println(obj);
	}

}
