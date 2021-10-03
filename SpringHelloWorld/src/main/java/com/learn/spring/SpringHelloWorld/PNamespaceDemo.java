package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Student;

public class PNamespaceDemo {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context_p_namespace.xml");

		Student s = (Student) ctx.getBean("s1");
		s.show();

	}

}
