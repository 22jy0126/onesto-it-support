package com.onestoit.model;

public class CaseWithEmpApy extends CaseBase {
	/*
	 * 応募社員の社員番号
	 */
	private String employeeId;
	/*
	 * 応募社員と契約するか
	 */
	private Boolean bind;
	
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
}
