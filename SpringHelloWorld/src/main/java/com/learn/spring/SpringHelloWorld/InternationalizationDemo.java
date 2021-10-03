package com.learn.spring.SpringHelloWorld;

import java.util.Locale;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternationalizationDemo {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context_message.xml");
		System.out.println("-------Locale English--------");
		String msg1=context.getMessage("welcome", null, "Default", new Locale("en"));
		String msg2=context.getMessage("NotEmpty.userForm.name", null, "Default", null);
		System.out.println("welcome Msg - "+msg1);
		System.out.println("NotEmpty Mgg - "+msg2);
		
		System.out.println("-------Locale German--------");
		msg1=context.getMessage("welcome", null, "Default", new Locale("de"));
		msg2=context.getMessage("NotEmpty.userForm.name", null, "Default", new Locale("de"));
		System.out.println("welcome Msg - "+msg1);
		System.out.println("NotEmpty Msg - "+msg2);
		context.close();
		
		
	}
}
