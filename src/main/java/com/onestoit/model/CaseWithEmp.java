package com.onestoit.model;

import java.util.Date;

public class CaseWithEmp extends CaseBase {
	// 社員番号
	private String employeeId;
	// 氏名
	private String name;
	// 性別
	private Integer gender;
	// 生年月日
	private Date birthday;
	// 経験開発言語
	private String skill;
	
	/*
	 * 案件と結び付けるかどうか
	 */
	private Boolean bind;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Boolean getBind() {
		return bind;
	}

	public void setBind(Boolean bind) {
		this.bind = bind;
	}
	
	
}
