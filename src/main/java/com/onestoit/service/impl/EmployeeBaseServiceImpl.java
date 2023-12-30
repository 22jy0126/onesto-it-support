package com.onestoit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.mapper.EmployeeBaseMapper;
import com.onestoit.model.EmployeeBase;
import com.onestoit.service.EmployeeBaseService;

@Service
public class EmployeeBaseServiceImpl implements EmployeeBaseService {
	@Autowired
	EmployeeBaseMapper mapper;
	
	@Override
	public int save(EmployeeBase eb) {
		return mapper.save(eb);
	}

}
