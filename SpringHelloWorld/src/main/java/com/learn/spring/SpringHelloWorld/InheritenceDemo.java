package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Student;

public class InheritenceDemo {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("app-context_inheritence.xml");  
	      
	    Student s=(Student)ctx.getBean("s2");  
	    s.show();  
	}

}
