package com.learn.spring.SpringHelloWorld.aop;

public class QueryCounter {

	private int queryCount = 0;

	public int getQueryCount() {
		return queryCount;
	}

	public void setQueryCount(int queryCount) {
		this.queryCount = queryCount;
	}

	public void incrementCounter() {
		System.out.println("Incrementing Counter....");
		this.queryCount++;
	}

}
