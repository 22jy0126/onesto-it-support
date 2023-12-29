package com.onestoit.model;

import java.util.Date;

public class WorkHistory {
	// 経歴Id
	private Integer id;
	// 経歴名
	private String workName;
	// 開発開始時期
	private Date workStart;
	// 開発期間
	private Integer workPeriod;
	// 担当内容
	private String workCharge;
	// 概要
	private String workContent;
	
	public WorkHistory(Integer id, String workName, Date workStart, Integer workPeriod, String workCharge,
			String workContent) {
		super();
		this.id = id;
		this.workName = workName;
		this.workStart = workStart;
		this.workPeriod = workPeriod;
		this.workCharge = workCharge;
		this.workContent = workContent;
	}

	public WorkHistory() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Date getWorkStart() {
		return workStart;
	}

	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	public Integer getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Integer workPeriod) {
		this.workPeriod = workPeriod;
	}

	public String getWorkCharge() {
		return workCharge;
	}

	public void setWorkCharge(String workCharge) {
		this.workCharge = workCharge;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	@Override
	public String toString() {
		return "WorkHistory [id=" + id + ", workName=" + workName + ", workStart=" + workStart + ", workPeriod="
				+ workPeriod + ", workCharge=" + workCharge + ", workContent=" + workContent + "]";
	}
	
	
}
