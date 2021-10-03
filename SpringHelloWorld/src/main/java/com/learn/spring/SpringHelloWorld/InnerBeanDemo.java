package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Student;

/*
 * If a bean is used for only one particular property, 
 * it’s advise to declare it as an inner bean.
 * The inner bean is supported both in setter injection ‘property‘ 
 * and constructor injection ‘constructor-arg‘.
 */
public class InnerBeanDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("app-context_innerbean.xml");

		System.out.println(context);

		Student s = (Student) context.getBean("student");
		s.show();

		context.close();

	}
}
