package com.onestoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Customer;
import com.onestoit.service.CustomerService;

@RestController
@RequestMapping("/register/cst")
public class CustomerRegisterController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save")
	Result save(@RequestBody Customer c) {
		return customerService.save(c);
	}
	
	@PostMapping("/exists")
	Result alreadyExists(@RequestBody Customer c) {
		return customerService.alreadyExists(c.getUsername());
	}
}
