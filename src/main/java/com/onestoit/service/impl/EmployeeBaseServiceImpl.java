package com.onestoit.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.EmployeeBaseMapper;
import com.onestoit.model.EmployeeBase;
import com.onestoit.service.EmployeeBaseService;

@Service
public class EmployeeBaseServiceImpl implements EmployeeBaseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeBaseServiceImpl.class);
	
	@Autowired
	EmployeeBaseMapper mapper;
	
	@Override
	public Result save(EmployeeBase eb) {
		int res;
		try {
			res = mapper.save(eb);
		} catch (Exception e) {
			LOGGER.error("社員の基本情報保存のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null, "データベースのエラーです");
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result alreadyExists(String EmployeeId) {
		int res = mapper.alreadyExists(EmployeeId);
		return new Result(Code.GET_OK, res);
	}

}
