package com.learn.spring.SpringHelloWorld.aop;

public class SchoolFinanceDesk {

	public boolean isFeesPaid(int rollNumber) {
		if (rollNumber < 0 || rollNumber > 1000) {
			throw new RuntimeException("Roll number not registered");
		} else if (rollNumber == 10 || rollNumber == 11 || rollNumber == 12) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getOutstandingLoanAmount(String callerName) {
		return 20000;
	}
	
	public int getProfit(String callerName) {
		return 5000;
	}

}
