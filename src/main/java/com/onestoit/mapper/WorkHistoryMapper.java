package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.WorkHistory;

@Mapper
public interface WorkHistoryMapper {
	/**
	 * 社員の職歴を保存する
	 * @param workHistorys
	 * @return
	 */
	int batchSave(ArrayList<WorkHistory> workHistorys);
	
	/**
	 * 社員の職歴を検索する
	 * @param employeeId
	 * @return
	 */
	ArrayList<WorkHistory> getByEmployeeId(String employeeId);
}
