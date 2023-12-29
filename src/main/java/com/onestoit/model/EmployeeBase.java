package com.onestoit.model;

import java.util.Date;

public class EmployeeBase {
	// 社員番号
	private Integer employeeId;
	// 氏名
	private String name;
	// 性別
	private Integer gender;
	// 生年月日
	private Date birthday;
	// パスワード
	private String password;
	// 電話番号
	private String tel;
	// メールアドレス
	private String email;
	// 経験開発言語
	private String skill;
	
	public EmployeeBase(Integer employeeId, String name, Integer gender, Date birthday, String password, String tel,
			String email, String skill) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.skill = skill;
	}
	public EmployeeBase() {
		super();
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "EmployeeBase [employeeId=" + employeeId + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", password=" + password + ", tel=" + tel + ", email=" + email + ", skill=" + skill + "]";
	}
	
	
}
