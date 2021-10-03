package com.learn.spring.annotationdemo.bean;

import org.springframework.stereotype.Component;

@Component
public class DBStore implements IStore {

	@Override
	public void store(int value) {
		System.out.println(value + " Stored in DB");
	}

}
