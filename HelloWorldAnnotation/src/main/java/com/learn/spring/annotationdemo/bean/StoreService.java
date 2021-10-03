package com.learn.spring.annotationdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * Most frequently used bean should be annotated with @Primary.
 * it will be chosen on unqualified injection
 */
@Service
public class StoreService {

	@Autowired
	//@Qualifier("DBStore")
	@Qualifier("StoreLDAP")
	IStore store;
	
	@Autowired
	IStore store2;

	private int counter = 0;

	public void increment() {
		counter+=1;
		this.store.store(counter);
		this.store2.store(counter);
	}

}
