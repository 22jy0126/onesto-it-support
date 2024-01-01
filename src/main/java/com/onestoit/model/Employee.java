package com.onestoit.model;

import java.util.ArrayList;

public class Employee extends EmployeeBase {
	// 社員の職歴
	private ArrayList<WorkHistory> workHistorys;

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
