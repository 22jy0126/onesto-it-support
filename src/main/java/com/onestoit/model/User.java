package com.onestoit.model;

public class User {
	// ユーザーのタイプ
	private Integer type;
	// ユーザ名・社員番号
	private String username;
	// パスワード
	private String password;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [type=" + type + ", username=" + username + ", password=" + password + "]";
	}
	
}
