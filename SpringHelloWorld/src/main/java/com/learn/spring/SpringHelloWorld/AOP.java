package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.aop.QueryCounter;
import com.learn.spring.SpringHelloWorld.aop.SchoolReception;

public class AOP {

	public static void main(String[] args) {
		System.out.println("Entered AOP-main");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

		System.out.println(context);

		SchoolReception reception = (SchoolReception) context.getBean("schoolReception");
		QueryCounter counter = (QueryCounter) context.getBean("queryCounterAspectBean");
		
		boolean admAvailable=reception.isAdmissionAvailable("6");
		System.out.println("Admission Available ="+admAvailable);
		
		String schoolAddress=reception.querySchoolAddress();
		System.out.println("School Address ="+schoolAddress);
		
		String email1=reception.queryEmailByDeprtment(null);
		System.out.println("queryEmailByDeprtment ="+email1);
		
		String email2=reception.queryEmailID();
		System.out.println("queryEmail ="+email2);
		
		//int profit=reception.getProfit("Jeorge1");
		//System.out.println("Profit ="+profit);
		
		System.out.println("Number of queries so far is "+counter.getQueryCount());
		context.close();
	}
}
