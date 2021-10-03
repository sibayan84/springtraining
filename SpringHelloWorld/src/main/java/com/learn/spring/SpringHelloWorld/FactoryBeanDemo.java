package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Address;
import com.learn.spring.SpringHelloWorld.bean.AddressFactoryBean;
import com.learn.spring.SpringHelloWorld.bean.Student;

public class FactoryBeanDemo {
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("app-context_factorybean.xml");  
	      
	    Address us_addr=(Address)ctx.getBean("us_address");
	    System.out.println(us_addr);
	    
	    Address ger_addr=(Address)ctx.getBean("ger_address");
	    System.out.println(ger_addr);
	    
	    Address others=(Address)ctx.getBean("rest_of_world_address");
	    System.out.println(others);
	    
	    // The actual Factory bean can be obtained by adding an &
	    AddressFactoryBean addr=(AddressFactoryBean)ctx.getBean("&us_address");
	    System.out.println(addr);
	    System.out.println(addr.getCountry());
	    System.out.println(addr.getObject());
	    System.out.println(addr.getObjectType());
	    
	    ctx.close();
	    
	
	}

}
