package com.learn.spring.SpringHelloWorld.aop;

import org.aspectj.lang.JoinPoint;

public class ExceptionLogger {
	
	private int failedQueries=0;
	public void logException(JoinPoint joinPoint, Exception excptn) {
		System.out.println("----logException----");
		excptn.printStackTrace();
		failedQueries++;
	}

}
