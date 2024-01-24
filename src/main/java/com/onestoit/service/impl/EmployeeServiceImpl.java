package com.onestoit.service.impl;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.EmployeeBaseMapper;
import com.onestoit.mapper.WorkHistoryMapper;
import com.onestoit.model.EmpCaseCount;
import com.onestoit.model.Employee;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.PaginationEmpReq;
import com.onestoit.model.PaginationRes;
import com.onestoit.model.User;
import com.onestoit.model.WorkHistory;
import com.onestoit.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeBaseMapper employeeBaseMapper;
	
	@Autowired
	WorkHistoryMapper workHistoryMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public Result save(Employee e) {
		EmployeeBase eb = (EmployeeBase)e;
		
		//　パスワード暗号化
		String pwdraw = eb.getPassword();
		String pwd = DigestUtils.sha256Hex(pwdraw);
		eb.setPassword(pwd);
		
		ArrayList<WorkHistory> whs = e.getWorkHistorys();
		
		Result re1 = saveBase(eb);
		
		if (re1.getCode() == Code.SAVE_ERROR || whs.size() == 0) {
			return re1;
		}
		return batchWorkHistorySave(whs);
	}

	@Override
	public Result saveBase(EmployeeBase eb) {
		int res;
		try {
			res = employeeBaseMapper.save(eb);
		} catch (Exception e) {
			LOGGER.error("社員の基本情報保存のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null, "データベースのエラーです");
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result batchWorkHistorySave(ArrayList<WorkHistory> workHistorys) {
		int res;
		try {
			res = workHistoryMapper.batchSave(workHistorys);
		} catch (Exception e) {
			return new Result(Code.SAVE_ERROR, null, "データベースのエラーです");
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result alreadyExists(String EmployeeId) {
		int res = employeeBaseMapper.alreadyExists(EmployeeId);
		return new Result(Code.GET_OK, res);
	}

	@Override
	public Result login(User u) {
		EmployeeBase res = employeeBaseMapper.login(u);
		return new Result(Code.LOGIN_OK, res);
	}

	@Override
	public Result getWorkHistorysByEmployeeId(String employeeId) {
		ArrayList<WorkHistory> res = workHistoryMapper.getByEmployeeId(employeeId);
		return new Result(Code.GET_OK, res);
	}

	@Override
	public Result assembleToEmployee(EmployeeBase eb, ArrayList<WorkHistory> workHistorys) {
		Employee e = new Employee();
		e.setType(eb.getType());
		e.setUsername(eb.getUsername());
		e.setEmployeeId(eb.getEmployeeId());
		e.setName(eb.getName());
		e.setGender(eb.getGender());
		e.setBirthday(eb.getBirthday());
		e.setTel(eb.getTel());
		e.setEmail(eb.getEmail());
		e.setSkill(eb.getSkill());
		e.setWorkHistorys(workHistorys);
		return new Result(Code.GET_OK, e);
	}

	@Override
	public Result getEmployeeBaseById(String employeeId) {
		EmployeeBase eb = employeeBaseMapper.getById(employeeId);
		ArrayList<WorkHistory> workHistorys = workHistoryMapper.getByEmployeeId(employeeId);
		return assembleToEmployee(eb, workHistorys);
	}

	@Override
	public Result findEmployeeByPage(PaginationEmpReq emp) {
		PaginationRes<EmpCaseCount> data = new PaginationRes<>();
		ArrayList<EmpCaseCount> list = employeeBaseMapper.findEmployeeByPage(emp);
		data.setList(list);
		EmpCaseCount e = (EmpCaseCount)emp;
		Integer totalCount = employeeBaseMapper.employeeCount(e);
		data.setTotalCount(totalCount);
		return new Result(Code.GET_OK, data);
	}
	
}
