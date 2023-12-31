package com.onestoit.service.impl;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.model.Employee;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.WorkHistory;
import com.onestoit.service.EmployeeBaseService;
import com.onestoit.service.EmployeeService;
import com.onestoit.service.WorkHistoryService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeBaseService employeeBaseService;
	
	@Autowired
	WorkHistoryService workHistoryService;
	
	@Override
	public Result save(Employee e) {
		EmployeeBase eb = (EmployeeBase)e;
		
		//　パスワード暗号化
		String pwdraw = eb.getPassword();
		String pwd = DigestUtils.sha256Hex(pwdraw);
		eb.setPassword(pwd);
		
		ArrayList<WorkHistory> whs = e.getWorkHistorys();
		
		Result re1 = employeeBaseService.save(eb);
		
		if (re1.getCode() == Code.SAVE_ERROR || whs.size() == 0) {
			return re1;
		}
		return workHistoryService.batchSave(whs);
	}

}
