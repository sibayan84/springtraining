package com.learn.spring.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.SpringHelloWorld.bean.Bus;
import com.learn.spring.SpringHelloWorld.bean.Truck;

/**
 *  Lookup method injection is the ability of the container to 
 *  override methods on container managed beans, to return the 
 *  lookup result for another named bean in the container
 *  Lookup method: If a method not having any implementation or \
 *  if method required any dependencies, we can consider those methods as a lookup method.
 *  The Spring framework implements method injection by using bytecode generation
 *   from the CGLIB library to generate dynamically a subclass that overrides the method. 
 *   The lookup typically involves a prototype bean.

 *
 */
public class LookupMethodInjectionDemo {
	
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("app-context_lookupmethodinjection.xml");

		System.out.println("............BUS...........");
		Bus bus = (Bus) ap.getBean("bus");
		System.out.println(bus.myBusEngine().getName());

		System.out.println("............TRUCK...........");
		Truck truck = (Truck) ap.getBean("truck");
		System.out.println(truck.myTruckEngine().getName());
	}

}
