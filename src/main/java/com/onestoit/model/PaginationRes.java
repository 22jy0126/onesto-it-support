package com.onestoit.model;

import java.util.ArrayList;

public class PaginationRes<T> {
	/*
	 * 検索の結果リスト
	 */
	private ArrayList<T> list;
	/*
	 * 検索の結果の合計数
	 */
	private Integer totalCount;
	
	public ArrayList<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
