package com.onestoit.service;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.model.EmployeeBase;

@Transactional
public interface EmployeeBaseService {
	/**
	 * 社員の基本情報保存
	 * @param eb
	 * @return
	 */
	int save(EmployeeBase eb);
}
