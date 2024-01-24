package com.onestoit.model;

import java.util.Date;

public class EmpBindedCase extends CaseBase {
	/*
	 * 社員Id
	 */
	private String employeeId;
	/*
	 * 案件と結び付けるかどうか
	 */
	private Boolean bind;
	/*
	 * 案件と結び付ける日付
	 */
	private Date bindDate;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
