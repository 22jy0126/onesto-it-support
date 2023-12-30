package com.onestoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Employee;
import com.onestoit.service.EmployeeService;

@RestController
@RequestMapping("/register/emp")
public class EmployeeRegisterController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/save")
	Result save(@RequestBody Employee e) {
		boolean res = service.save(e);
		Integer code = res ? Code.SAVE_OK : Code.SAVE_ERROR;
		String msg = res ? "OK" : "只今、保存できません、少し後でもう一度お試してください";
		return new Result(code, res, msg);
	}
}
