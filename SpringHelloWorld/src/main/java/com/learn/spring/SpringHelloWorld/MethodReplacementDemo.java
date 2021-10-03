package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Car;

/**
 * Replace or override the existing method in a Spring Bean 
 * by implementing MethodReplacer interface
 *
 */
public class MethodReplacementDemo {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context_methodReplacement.xml");
		Car car = (Car) context.getBean("car");
		car.design();
		car.breaks();
		context.close();
	}

}
