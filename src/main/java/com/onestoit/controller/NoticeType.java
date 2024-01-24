package com.onestoit.controller;

public class NoticeType {
	/*
	 * 社員へ・案件開始
	 */
	public static final Integer EMP_CASE_START = 1001;
	/*
	 * 社員へ・マイルストーン編集チェック返信
	 */
	public static final Integer EMP_MILESTONE_EDIT_RES = 1002;
	/*
	 * 社員へ・マイルストーン編集確認完了
	 */
	public static final Integer EMP_MILESTONE_EDIT_RESOK = 1003;
	/*
	 * 社員へ・マイルストーン進捗更新チェック返信
	 */
	public static final Integer EMP_MILESTONE_PROC_RES = 1004;
	/*
	 * 社員へ・マイルストーン進捗更新確認完了
	 */
	public static final Integer EMP_MILESTONE_PROC_RESOK = 1005;
	/*
	 * 社員へ・案件作業完了
	 */
	public static final Integer EMP_CASE_FINISH = 1006;
	
	/*
	 * 顧客へ・案件に応募がある
	 */
	public static final Integer CUST_CASE_NEW_APPLY = 2001;
	/*
	 * 顧客へ・マイルストーンの確認リクエストが届く
	 */
	public static final Integer CUST_MILESTONE_EDIT_REQ = 2002;
	/*
	 * 顧客へ・マイルストーン案件作業の確認リクエストが届く
	 */
	public static final Integer CUST_MILESTONE_PROC_REQ = 2003;
	/*
	 * 顧客へ・案件作業完了
	 */
	public static final Integer CUST_CASE_FINISH = 2004;
}
