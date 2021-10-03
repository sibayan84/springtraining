package com.learn.spring.SpringHelloWorld.bean;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class NewBreak implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// new property of Car.breaks() method.
		System.out.println("New car break.");
		return obj;
	}

}
