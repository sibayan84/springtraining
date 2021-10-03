package com.learn.spring.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.learn.spring.annotationdemo.bean.HelloBean;
import com.learn.spring.annotationdemo.jpa.entity.HelloBeanLazy;

@Configuration
@ComponentScan
public class HelloBeanDemo 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( HelloBeanDemo.class);
    	HelloBean helloBean1 = context.getBean(HelloBean.class); 
    	HelloBean helloBean2 = context.getBean(HelloBean.class);
    	System.out.println(helloBean1);
    	System.out.println(helloBean2);
    	helloBean1.printHello();
    	HelloBeanLazy helloBeanlazy = context.getBean(HelloBeanLazy.class);
    	System.out.println(helloBeanlazy);
    	
    	context.close();
    }
}
