package com.onestoit.model;

import java.util.Date;

public class CaseApply {
	/*
	 * 案件Id
	 */
	private Integer caseId;
	/*
	 * 社員Id
	 */
	private String employeeId;
	/*
	 * 応募日付
	 */
	private Date applyDate;
	/*
	 * 案件と結び付けるかどうか
	 */
	private Boolean bind;
	/*
	 * 案件と結び付ける日付
	 */
	private Date bindDate;
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Boolean getBind() {
		return bind;
	}
	public void setBind(Boolean bind) {
		this.bind = bind;
	}
	public Date getBindDate() {
		return bindDate;
	}
	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
	}
}
