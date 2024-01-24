package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.NotificationEmp;

@Mapper
public interface NotificationEmployeeMapper {
	/**
	 * 通知の追加
	 * @param ne
	 * @return
	 */
	int addOne(NotificationEmp ne);
	
	/**
	 * 通知を読んだ
	 * @param id
	 * @return
	 */
	int toReaded(Integer id);
	
	/**
	 * 社員の通知を検索
	 * @param employeeId
	 * @return
	 */
	ArrayList<NotificationEmp> findByEmployeeId(String employeeId);
	
	/**
	 * 未読通知数
	 * @param employeeId
	 * @return
	 */
	int notReadCount(String employeeId);
}
