package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.HelloBean;


public class HelloSpring 
{
    public static void main( String[] args )
    {
    	 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                 "application-context.xml");
    	 
    	 System.out.println(context);
    	 
         HelloBean obj1 = (HelloBean) context.getBean("helloBean");
         obj1.printHello();
         HelloBean obj2 = (HelloBean) context.getBean("helloSpring");
         obj2.printHello();
         HelloBean obj3 = (HelloBean) context.getBean("helloWorldSpring");
         obj3.printHello();
         HelloBean obj4 = (HelloBean) context.getBean(HelloBean.class);
         obj4.printHello();
         
         System.out.println(obj1);
         System.out.println(obj2);
         System.out.println(obj3);
         System.out.println(obj4);
         
         context.close();
        
    }
}
