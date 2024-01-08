package com.onestoit.model;

public class PaginationCaseBaseReq extends CaseBase {
	/*
	 * ページのサイズ
	 */
	private Integer pageSize;
	/*
	 * 今のページ番号
	 */
	private Integer fromNum;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getFromNum() {
		return fromNum;
	}
	public void setFromNum(Integer fromNum) {
		this.fromNum = fromNum;
	}
}
