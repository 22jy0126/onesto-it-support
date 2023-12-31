package com.onestoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Employee;
import com.onestoit.service.EmployeeBaseService;
import com.onestoit.service.EmployeeService;

@RestController
@RequestMapping("/register/emp")
public class EmployeeRegisterController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeBaseService employeeBaseService;
	
	@PostMapping("/save")
	Result save(@RequestBody Employee e) {
		return employeeService.save(e);
	}
	
	@GetMapping("/alreadyExists/{employeeId}")
	Result alreadyExists(@PathVariable String employeeId) {
		return employeeBaseService.alreadyExists(employeeId);
	}
}
