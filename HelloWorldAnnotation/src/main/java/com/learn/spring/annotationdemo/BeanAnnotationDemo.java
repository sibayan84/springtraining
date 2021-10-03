package com.learn.spring.annotationdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.spring.annotationdemo.bean.DBStore;
import com.learn.spring.annotationdemo.bean.HelloBean;
import com.learn.spring.annotationdemo.bean.LDAPStore;
import com.learn.spring.annotationdemo.jpa.entity.HelloBeanLazy;

/**
 * @Bean marks a factory method which instantiates a Spring bean:
The resulting bean has the same name as the factory method.
For different name use the value attribute

 *
 */
@Configuration

public class BeanAnnotationDemo 
{
	@Bean
	public HelloBean getHelloBean() {
		return new HelloBean();
	}
	
	@
	Bean
	public LDAPStore getLDAPStore() {
		return new LDAPStore();
	}
	
	@Bean("DatabaseStore")
	public DBStore getDBStore() {
		return new DBStore();
	}
	
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( BeanAnnotationDemo.class);
    	HelloBean helloBean1 = context.getBean(HelloBean.class); 
    	System.out.println(helloBean1);
    	LDAPStore ldapStore = context.getBean(LDAPStore.class); 
    	System.out.println(ldapStore);
    	DBStore dbStore = (DBStore)context.getBean("DatabaseStore"); 
    	System.out.println(dbStore);
    	DBStore dbStore2 = (DBStore)context.getBean(DBStore.class); 
    	System.out.println(dbStore2);
    	context.close();
	}
	
	public static void main( String[] args )
    {
		BeanAnnotationDemo obj=new BeanAnnotationDemo();
		obj.test();
    }
}
