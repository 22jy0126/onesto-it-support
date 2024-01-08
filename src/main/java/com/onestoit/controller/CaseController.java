package com.onestoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Case;
import com.onestoit.model.CaseBase;
import com.onestoit.model.PaginationCaseBaseReq;
import com.onestoit.service.CaseService;

@RestController
@RequestMapping("/logged/case")
public class CaseController {
	
	@Autowired
	CaseService caseService;
	
	@PostMapping("/saveCase")
	Result saveCase(@RequestBody Case c) {
		return caseService.saveCase(c);
	}
	
	@PostMapping("/get")
	Result findOneCase(@RequestBody CaseBase cb) {
		return caseService.findOneCase(cb);
	}
	
	@PostMapping("/getByPage")
	Result findOneCaseByPage(@RequestBody PaginationCaseBaseReq pcbq) {
		return caseService.findCaseBaseByPage(pcbq);
	}
}
