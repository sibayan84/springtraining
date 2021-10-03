package com.learn.spring.SpringHelloWorld.bean;

/**
 * Constructor Confusion may occur when
 * <ul>
 * <li>Class has more than 1 constructor
 * <li>Number of arguments in constructor is same
 * </ul>
 * <p>
 * Solution is to specify index and/or type arguments
 * 
 * @author Sibayan A
 *
 */
public class ConstructorConfusionBean {

	private String employeeName;
	private String employeeApartmentNo;
	private int employeeAge;

	

	public ConstructorConfusionBean(String employeeName, int employeeAge, String employeeApartmentNo) {
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeApartmentNo = employeeApartmentNo;
	}
	
	public ConstructorConfusionBean(String employeeName, String employeeApartmentNo, int employeeAge) {
		this.employeeName = employeeName;
		this.employeeApartmentNo = employeeApartmentNo;
		this.employeeAge = employeeAge;
	}

	public String toString() {
		return "Employee Name : " + this.employeeName + ", Employee Appartment No:" + this.employeeApartmentNo + ", Employee Age:"
				+ this.employeeAge;
	}

}
