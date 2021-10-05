package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Address;
import com.learn.spring.SpringHelloWorld.bean.HelloBean;


public class BeanFactoryPostProcessDemo 
{
    public static void main( String[] args )
    {
    	 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                 "application-context_beanFactorypostprocess.xml");
    	 
    	 System.out.println(context);
    	 
         HelloBean obj1 = (HelloBean) context.getBean("helloBean");
         obj1.printHello();
         System.out.println("Hello Bean"+obj1);
         
         Address addr1 = (Address) context.getBean("address");
         
         System.out.println("Affress is : "+addr1);
         
         
         context.close();
        
    }
}
