package com.learn.spring.SpringHelloWorld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Address;

public class FactoryBeanInstanceMethodDemo {
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("app-context_factorybean_instancemethod.xml");  
	      
	    Address us_addr=(Address)ctx.getBean("address");
	    System.out.println(us_addr);
	    
	    ctx.close();
	
	}

}
