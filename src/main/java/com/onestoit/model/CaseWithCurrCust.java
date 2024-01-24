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
	private ArrayList<CaseWithEmp> apylist;
	
	public CaseBase getCb() {
		return cb;
	}
	public void setCb(CaseBase cb) {
		this.cb = cb;
	}
	public ArrayList<CaseWithEmp> getApylist() {
		return apylist;
	}
	public void setApylist(ArrayList<CaseWithEmp> apylist) {
		this.apylist = apylist;
	}
}
