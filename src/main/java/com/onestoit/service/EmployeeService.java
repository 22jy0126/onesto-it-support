package com.onestoit.service;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.model.Employee;

@Transactional
public interface EmployeeService {
	/**
	 * 社員情報保存
	 * @param e
	 * @return
	 */
	boolean save(Employee e);
}
