package com.onestoit.model;

import java.util.Date;

public class Milestone {
	/*
	 * マイルストーンId
	 */
	private Integer id;
	/*
	 * 案件Id
	 */
	private Integer caseId;
	/**
	 * マイルストーンの編集状態
	 * @param 0 社員編集中
	 * @param 1 顧客確認中
	 * @param 2 顧客確認済み（変更できない）
	 */
	private Integer editStatus;
	/**
	 * マイルストーンの状態
	 * 
	 * @param 0 編集中
	 * @param 1 作業未開始
	 * @param 2 作業中
	 * @param 3 確認待ち
	 * @param 4 確認済み
	 */
	private Integer status;
	/*
	 * タイトル
	 */
	private String name;
	/*
	 * 詳細
	 */
	private String description;
	/*
	 * 顧客からのコメントがあるかどうか
	 */
	private Boolean isComment;
	/*
	 * 顧客からのコメント
	 */
	private String comment;
	/*
	 * 生成日付
	 */
	private Date createData;
	/*
	 * 更新日付
	 */
	private Date updateDate;
	
	/*
	 * 削除必要
	 */
	private Boolean isDel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsComment() {
		return isComment;
	}

	public void setIsComment(Boolean isComment) {
		this.isComment = isComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateData() {
		return createData;
	}

	public void setCreateData(Date createData) {
		this.createData = createData;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(Integer editStatus) {
		this.editStatus = editStatus;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
	
}
