package com.onestoit.model;

import java.util.Date;

public class CaseBase {
	/*
	 * 案件Id
	 */
	private Integer caseId;
	/*
	 *顧客Id
	 */
	private Integer customerId;
	/*
	 *案件名
	 */
	private String caseName;
	/*
	 *報酬
	 */
	private Double bonusMoney;
	/*
	 *報酬相談可否
	 */
	private boolean bonusMoneyNegotiable;
	/*
	 *希望開発ツール
	 */
	private String developTools;
	/*
	 *案件の説明
	 */
	private String description;
	/*
	 *開発期限
	 */
	private Date deadline;
	/*
	 *開発状態
	 *0 下書き
	 *1 求人中
	 *2 開始中
	 *3 終わり
	 */
	private Integer status;
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public Double getBonusMoney() {
		return bonusMoney;
	}
	public void setBonusMoney(Double bonusMoney) {
		this.bonusMoney = bonusMoney;
	}
	public boolean isBonusMoneyNegotiable() {
		return bonusMoneyNegotiable;
	}
	public void setBonusMoneyNegotiable(boolean bonusMoneyNegotiable) {
		this.bonusMoneyNegotiable = bonusMoneyNegotiable;
	}
	public String getDevelopTools() {
		return developTools;
	}
	public void setDevelopTools(String developTools) {
		this.developTools = developTools;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
