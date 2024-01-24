package com.onestoit.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.NotificationCustomerMapper;
import com.onestoit.mapper.NotificationEmployeeMapper;
import com.onestoit.model.NotificationCust;
import com.onestoit.model.NotificationEmp;
import com.onestoit.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationEmployeeMapper notificationEmployeeMapper;
	
	@Autowired
	NotificationCustomerMapper notificationCustomerMapper;

	@Override
	public Result getEmpNotReadNoticeCount(String employeeId) {
		int cnt = notificationEmployeeMapper.notReadCount(employeeId);
		return new Result(Code.GET_OK, cnt);
	}

	@Override
	public Result getEmpNoticeList(String employeeId) {
		ArrayList<NotificationEmp> data = notificationEmployeeMapper.findByEmployeeId(employeeId);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result setEmpReaded(Integer id) {
		int res = notificationEmployeeMapper.toReaded(id);
		return new Result(Code.UPDATE_OK, res);
	}

	@Override
	public Result getCustNotReadNoticeCount(Integer customerId) {
		int cnt = notificationCustomerMapper.notReadCount(customerId);
		return new Result(Code.GET_OK, cnt);
	}

	@Override
	public Result getCustNoticeList(Integer customerId) {
		ArrayList<NotificationCust> data = notificationCustomerMapper.findByCustomerId(customerId);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result setCustReaded(Integer id) {
		int res = notificationCustomerMapper.toReaded(id);
		return new Result(Code.UPDATE_OK, res);
	}
	
}
