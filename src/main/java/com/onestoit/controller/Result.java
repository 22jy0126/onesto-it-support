package com.onestoit.controller;

public class Result {
	/**
	 * 結果のデータ
	 */
	private Object data;
	/**
	 * 成功または例外を示すコード
	 */
	private Integer code;
	/**
	 * 成功または例外の原因を示すメッセージ
	 */
	private String msg;
	/**
	 * パラメーターなしのコンストラクター
	 */
	public Result() {
		super();
	}
	/**
	 * パラメーターありのコンストラクター
	 * @param data
	 * @param code
	 * @param msg
	 */
	public Result(Integer code, Object data, String msg) {
		super();
		this.data = data;
		this.code = code;
		this.msg = msg;
	}
	/**
	 * パラメーターありのコンストラクター
	 * @param data
	 * @param code
	 */
	public Result(Integer code, Object data) {
		super();
		this.data = data;
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Result [data=" + data + ", code=" + code + ", msg=" + msg + "]";
	}
	
	
}