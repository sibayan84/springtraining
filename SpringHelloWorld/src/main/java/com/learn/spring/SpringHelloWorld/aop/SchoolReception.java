package com.learn.spring.SpringHelloWorld.aop;

import org.springframework.util.StringUtils;

public class SchoolReception {

	SchoolFinanceDesk financeDesk;
	
	public SchoolFinanceDesk getFinanceDesk() {
		return financeDesk;
	}

	public void setFinanceDesk(SchoolFinanceDesk financeDesk) {
		this.financeDesk = financeDesk;
	}

	public String querySchoolAddress() {
		return "19, Grand Avenue";
	}

	public String queryEmailByDeprtment(String dept) {
		if (!StringUtils.isEmpty(dept)) {
			if ("finance".equals(dept)) {
				return "finance_myschool@yahoo.com";
			} else if ("highscool".equals(dept)) {
				return "highscool_myschool@yahoo.com";
			} else if ("juniorscool".equals(dept)) {
				return "juniorscool_myschool@yahoo.com";
			} else {
				return queryEmailID();
			}
		}else {
			return queryEmailID();
		}
	}

	public String queryEmailID() {
		return "myschool@yahoo.com";
	}

	public boolean isAdmissionAvailable(String standard) {
		if ("5".equals(standard) || "6".equals(standard)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFeesPaid(int rollNumber) {
		return this.financeDesk.isFeesPaid(rollNumber);
	}

	public int getOutstandingLoanAmount(String callerName) {
		return this.financeDesk.getOutstandingLoanAmount(callerName);
	}

	public int getProfit(String callerName) {
		return this.financeDesk.getProfit(callerName);
	}

}
