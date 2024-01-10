package com.onestoit.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.Employee;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.User;
import com.onestoit.model.WorkHistory;

@Transactional
public interface EmployeeService {
	/**
	 * 社員の基本情報保存
	 * @param eb
	 * @return
	 */
	Result saveBase(EmployeeBase eb);
	
	/**
	 * 社員の職歴保存
	 * @param workHistorys
	 * @return
	 */
	Result batchWorkHistorySave(ArrayList<WorkHistory> workHistorys);
	
	/**
	 * 社員Id既に登録したかどうか調べる
	 * @param EmployeeId
	 * @return
	 */
	Result alreadyExists(String EmployeeId);
	
	/**
	 * 社員ログイン
	 * @param eb
	 * @return
	 */
	Result login(User u);
	
	/**
	 * 社員情報保存
	 * @param e
	 * @return
	 */
	Result save(Employee e);
	
	/**
	 * 社員番号で職歴を検索する
	 * @param EmployeeId
	 * @return
	 */
	Result getWorkHistorysByEmployeeId(String EmployeeId);
	
	/**
	 * 社員の基本情報と社員の職歴から社員の完全情報に組み立てる
	 * @param eb
	 * @param workHistorys
	 * @return
	 */
	Result assembleToEmployee(EmployeeBase eb, ArrayList<WorkHistory> workHistorys);
	
	/**
	 * 社員Idで社員の基本情報をゲット
	 * @param employeeId
	 * @return
	 */
	Result getEmployeeBaseById(String employeeId);
	
	
}
