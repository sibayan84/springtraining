package com.learn.spring.annotationdemo.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("StoreLDAP")
public class LDAPStore implements IStore {

	@Override
	public void store(int value) {
		System.out.println(value + " stored in LDAP..");
	}
}
