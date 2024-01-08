package com.onestoit.model;

import java.util.ArrayList;

public class Case extends CaseBase {
	/*
	 * 案件機能リスト
	 */
	private ArrayList<CaseFunction> functions;

	public ArrayList<CaseFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(ArrayList<CaseFunction> functions) {
		this.functions = functions;
	}
}
