package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.CircularDependency1;
import com.learn.spring.SpringHelloWorld.bean.CircularDependency2;
import com.learn.spring.SpringHelloWorld.bean.HelloBean;

public class CircularDemo {
	
	public static void main(String[] args) {
		
		 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                 "circular-context.xml");
    	 
    	 System.out.println(context);
    	 
    	 CircularDependency1 obj1 = (CircularDependency1) context.getBean("CircularDependency1Bean");
    	 CircularDependency2 obj2= (CircularDependency2) context.getBean("CircularDependency2Bean");
    	 
    	 System.out.println(obj1);
    	 System.out.println(obj2);
    	 
	}

}
