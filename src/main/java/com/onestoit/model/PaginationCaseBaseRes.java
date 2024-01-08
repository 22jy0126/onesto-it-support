package com.onestoit.model;

import java.util.ArrayList;

public class PaginationCaseBaseRes {
	/*
	 * 検索の結果リスト
	 */
	private ArrayList<CaseBase> list;
	/*
	 * 検索の結果の合計数
	 */
	private Integer totalCount;
	
	public ArrayList<CaseBase> getList() {
		return list;
	}
	public void setList(ArrayList<CaseBase> list) {
		this.list = list;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
