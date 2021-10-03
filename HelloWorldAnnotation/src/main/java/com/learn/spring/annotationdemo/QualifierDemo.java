package com.learn.spring.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learn.spring.annotationdemo.bean.DBStore;
import com.learn.spring.annotationdemo.bean.LDAPStore;
import com.learn.spring.annotationdemo.bean.StoreService;

@Configuration
@ComponentScan(basePackages = "com.learn.spring.annotationdemo.bean")
public class QualifierDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(QualifierDemo.class);
		System.out.println(ctx.getBean(LDAPStore.class));
		System.out.println(ctx.getBean("StoreLDAP"));
		System.out.println(ctx.getBean(DBStore.class));
		System.out.println(ctx.getBean("DBStore"));
		
		StoreService srv=(StoreService)ctx.getBean(StoreService.class);
		srv.increment();
	}
}
