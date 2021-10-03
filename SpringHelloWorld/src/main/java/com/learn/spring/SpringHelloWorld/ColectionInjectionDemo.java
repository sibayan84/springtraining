package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.CollectionInjectionBean;

public class ColectionInjectionDemo {
	
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("app-context_collections.xml");
	      CollectionInjectionBean cib=(CollectionInjectionBean)context.getBean("ciBean");

	      cib.getAddressList();
	      cib.getAddressSet();
	      cib.getAddressMap();
	      cib.getAddressProp();
	      cib.getMarksList();
	      cib.getEmail();
	      cib.getFax();
	      String p=null;
	}

}
