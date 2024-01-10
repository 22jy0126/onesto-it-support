package com.onestoit.model;

import java.util.ArrayList;

public class CaseWithCurrCust {
	/*
	 * 案件
	 */
	private CaseBase cb;
	/*
	 * 応募者リスト
	 */
	private ArrayList<EmployeeBase> apylist;
	
	public CaseBase getCb() {
		return cb;
	}
	public void setCb(CaseBase cb) {
		this.cb = cb;
	}
	public ArrayList<EmployeeBase> getApylist() {
		return apylist;
	}
	public void setApylist(ArrayList<EmployeeBase> apylist) {
		this.apylist = apylist;
	}
}
