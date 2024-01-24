package com.onestoit.service;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;

@Transactional
public interface NotificationService {
	/**
	 * 社員の未読通知数
	 * @param employeeId
	 * @return
	 */
	Result getEmpNotReadNoticeCount(String employeeId);
	
	/**
	 * 社員の通知を検索
	 * @param employeeId
	 * @return
	 */
	Result getEmpNoticeList(String employeeId);
	
	/**
	 * 社員の通知を既読にする
	 * @param id
	 * @return
	 */
	Result setEmpReaded(Integer id);
	
	/**
	 * 顧客の未読通知数
	 * @param customerId
	 * @return
	 */
	Result getCustNotReadNoticeCount(Integer customerId);
	
	/**
	 * 顧客の通知を検索
	 * @param employeeId
	 * @return
	 */
	Result getCustNoticeList(Integer customerId);
	
	/**
	 * 顧客の通知を既読にする
	 * @param id
	 * @return
	 */
	Result setCustReaded(Integer id);
}
