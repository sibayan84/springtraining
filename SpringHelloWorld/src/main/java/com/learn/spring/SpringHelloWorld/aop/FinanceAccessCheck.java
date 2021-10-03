package com.learn.spring.SpringHelloWorld.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class FinanceAccessCheck {
	
	private List<String> validUsers=new ArrayList<>();
	
	public FinanceAccessCheck() {
		validUsers.add("Jeorge");
		validUsers.add("Lei");
		validUsers.add("Alex");
	}
	
	public void checkAccess(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
		System.out.println(joinPoint.getArgs());
		System.out.println(joinPoint.getSignature().getName());
		String caller=(String)joinPoint.getArgs()[0];
		if(!this.validUsers.contains(caller)) {
			throw new RuntimeException("Caller has no access to this method");
		}
	}

}
