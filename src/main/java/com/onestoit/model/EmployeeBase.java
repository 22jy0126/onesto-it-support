package com.onestoit.model;

import java.util.Date;

public class EmployeeBase extends User {
	// 社員番号
	private String employeeId;
	// 氏名
	private String name;
	// 性別
	private Integer gender;
	// 生年月日
	private Date birthday;
	// 電話番号
	private String tel;
	// メールアドレス
	private String email;
	// 経験開発言語
	private String skill;
	
	public EmployeeBase() {
		super();
	}
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
