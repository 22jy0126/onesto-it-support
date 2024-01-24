package com.onestoit.model;

public class CaseWithCurrEmp {
	/*
	 * 案件情報
	 */
	private Case c;
	/*
	 * 案件と現在の社員の応募関連情報
	 */
	private CaseApply caseApply;
	
	private Customer cust;
	
	public Case getC() {
		return c;
	}
	public void setC(Case c) {
		this.c = c;
	}
	public CaseApply getCaseApply() {
		return caseApply;
	}
	public void setCaseApply(CaseApply caseApply) {
		this.caseApply = caseApply;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
