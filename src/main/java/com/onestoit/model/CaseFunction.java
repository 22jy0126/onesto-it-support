package com.onestoit.model;

public class CaseFunction {
	/*
	 * 機能Id
	 */
	private Integer id;
	/*
	 * 案件Id
	 */
	private Integer caseId;
	/*
	 * 機能説明
	 */
	private String functionDesc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getFunctionDesc() {
		return functionDesc;
	}
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}
}
