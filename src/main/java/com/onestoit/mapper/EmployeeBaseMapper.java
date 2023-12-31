package com.onestoit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.EmployeeBase;

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
}
