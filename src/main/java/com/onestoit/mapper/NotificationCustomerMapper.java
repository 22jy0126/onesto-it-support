package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.NotificationCust;

@Mapper
public interface NotificationCustomerMapper {
	/**
	 * 通知の追加
	 * @param nc
	 * @return
	 */
	int addOne(NotificationCust nc);
	
	/**
	 * 通知を読んだ
	 * @param id
	 * @return
	 */
	int toReaded(Integer id);
	
	/**
	 * 社員の通知を検索
	 * @param customerId
	 * @return
	 */
	ArrayList<NotificationCust> findByCustomerId(Integer customerId);
	
	/**
	 * 未読通知数
	 * @param customerId
	 * @return
	 */
	int notReadCount(Integer customerId);
}
