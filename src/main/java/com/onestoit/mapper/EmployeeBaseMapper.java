package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.EmpCaseCount;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.PaginationEmpReq;
import com.onestoit.model.User;

@Mapper
public interface EmployeeBaseMapper {
	/**
	 * 社員の基本情報保存
	 * @param eb
	 * @return
	 */
	int save(EmployeeBase eb);
	
	/**
	 * 社員Id既に登録したかどうか調べる
	 * @param employeeId
	 * @return
	 */
	int alreadyExists(String employeeId);
	
	/**
	 * 社員ログイン
	 * @param eb
	 * @return
	 */
	EmployeeBase login(User u);
	
	/**
	 * 社員Idで社員の基本情報をゲット
	 * @param employeeId
	 * @return
	 */
	EmployeeBase getById(String employeeId);
	
	/**
	 * 社員検索
	 * @param emp
	 * @return
	 */
	ArrayList<EmpCaseCount> findEmployeeByPage(PaginationEmpReq emp);
	
	/**
	 * 社員検索の合計数
	 * @param emp
	 * @return
	 */
	int employeeCount(EmpCaseCount emp);
}
