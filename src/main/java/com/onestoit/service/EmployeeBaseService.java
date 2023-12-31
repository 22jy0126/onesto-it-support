package com.onestoit.service;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.EmployeeBase;

@Transactional
public interface EmployeeBaseService {
	/**
	 * 社員の基本情報保存
	 * @param eb
	 * @return
	 */
	Result save(EmployeeBase eb);
	
	/**
	 * 社員Id既に登録したかどうか調べる
	 * @param EmployeeId
	 * @return
	 */
	Result alreadyExists(String EmployeeId);
}
