package com.onestoit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.EmployeeBase;

@Mapper
public interface EmployeeBaseMapper {
	int save(EmployeeBase eb);
	
	int alreadyExists(String employeeId);
}
