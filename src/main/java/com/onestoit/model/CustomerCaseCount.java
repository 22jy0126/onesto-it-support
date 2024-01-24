package com.onestoit.model;

public class CustomerCaseCount extends Customer {
	/**
	 * 登録した有効な案件数
	 */
	private Integer caseCount;

	public Integer getCaseCount() {
		return caseCount;
	}

	public void setCaseCount(Integer caseCount) {
		this.caseCount = caseCount;
	}
	
}
