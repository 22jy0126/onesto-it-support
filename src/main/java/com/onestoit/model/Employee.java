package com.onestoit.model;

import java.util.ArrayList;
import java.util.Date;

public class Employee extends EmployeeBase {
	// 社員の職歴
	private ArrayList<WorkHistory> workHistorys;
	
	public Employee(String employeeId, String name, Integer gender, Date birthday, String password, String tel,
			String email, String skill, ArrayList<WorkHistory> workHistorys) {
		super(employeeId, name, gender, birthday, password, tel, email, skill);
		this.workHistorys = workHistorys;
	}

	public Employee() {
		super();
	}

	public ArrayList<WorkHistory> getWorkHistorys() {
		return workHistorys;
	}

	public void setWorkHistorys(ArrayList<WorkHistory> workHistorys) {
		this.workHistorys = workHistorys;
	}
}
