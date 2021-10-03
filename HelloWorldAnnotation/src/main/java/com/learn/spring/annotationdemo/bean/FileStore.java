package com.learn.spring.annotationdemo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FileStore implements IStore {

	@Override
	public void store(int value) {
		System.out.println(value + " stored in File..");
	}
}
