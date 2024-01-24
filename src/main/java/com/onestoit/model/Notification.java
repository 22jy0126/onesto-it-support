package com.onestoit.model;

import java.util.Date;

public class Notification {
	/*
	 * 通知ID
	 */
	private Integer id;
	/*
	 * 通知日付
	 */
	private Date createDate;
	/*
	 * 通知タイプ
	 */
	private Integer type;
	/*
	 * 関連案件ID
	 */
	private Integer caseId;
	/*
	 * 関連案件名
	 */
	private String caseName;
	/**
	 * 通知既に読んだか
	 * @param 0 読んでない
	 * @param 1 読んだ
	 */
	private Integer readed;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public Integer getReaded() {
		return readed;
	}
	public void setReaded(Integer readed) {
		this.readed = readed;
	}
}
