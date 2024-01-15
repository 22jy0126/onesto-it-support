package com.onestoit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Case;
import com.onestoit.model.CaseApply;
import com.onestoit.model.CaseBase;
import com.onestoit.model.CaseBind;
import com.onestoit.model.CaseWithCurrEmp;
import com.onestoit.model.Customer;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.PaginationCaseBaseReq;
import com.onestoit.model.User;
import com.onestoit.service.CaseService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/logged/case")
public class CaseController {
	
	@Autowired
	CaseService caseService;
	
	@PostMapping("/saveCase")
	Result saveCase(@RequestBody Case c) {
		return caseService.saveCase(c);
	}
	
	@GetMapping("/getbase/{caseId}")
	Result findCaseBase(@PathVariable Integer caseId) {
		CaseBase cb = new CaseBase();
		cb.setCaseId(caseId);
		return caseService.findCaseBase(cb);
	}
	
	@PostMapping("/get")
	Result findOneCase(@RequestBody CaseBase cb) {
		return caseService.findOneCase(cb);
	}
	
	@PostMapping("/getByPage")
	Result findOneCaseByPage(@RequestBody PaginationCaseBaseReq pcbq) {
		return caseService.findCaseBaseByPage(pcbq);
	}
	
	@PostMapping("/apply")
	Result apply(@RequestBody CaseBase cb, HttpSession session) {
		User loginUser = (User)session.getAttribute("userinfo");
		String employeeId = loginUser.getUsername();
		CaseApply ca = new CaseApply();
		ca.setCaseId(cb.getCaseId());
		ca.setEmployeeId(employeeId);
		return caseService.apply(ca);
	}
	
	@PostMapping("/getWithCurrEmp")
	Result findOneCaseWithCurrEmp(@RequestBody CaseBase cb, HttpSession session) {
		User loginUser = (User)session.getAttribute("userinfo");
		String employeeId = loginUser.getUsername();
		Result res1 = caseService.findOneCase(cb);
		Case c = (Case)res1.getData();
		
		CaseWithCurrEmp cwce = new CaseWithCurrEmp();
		cwce.setC(c);
		
		CaseApply tmpCa = new CaseApply();
		tmpCa.setCaseId(cb.getCaseId());
		tmpCa.setEmployeeId(employeeId);
		Result res2 = caseService.findCaseApply(tmpCa);
		ArrayList<CaseApply> caList = (ArrayList<CaseApply>)res2.getData();
		if (caList.size() == 1) {
			cwce.setCaseApply(caList.get(0));
		}
		return new Result(Code.GET_OK, cwce);
	}
	
	@GetMapping("/getHistory")
	Result findApplyHistory(HttpSession session) {
		User loginUser = (User)session.getAttribute("userinfo");
		String employeeId = loginUser.getUsername();
		EmployeeBase eb = new EmployeeBase();
		eb.setEmployeeId(employeeId);
		return caseService.findApplyHistory(eb);
	}
	
	@GetMapping("/getMyCases")
	Result findCaseWithCust(HttpSession session) {
		Customer c = (Customer)session.getAttribute("userinfo");
		return caseService.findCaseWithCust(c);
	}
	
	@PostMapping("/bind")
	Result caseBind(@RequestBody CaseBind cb) {
		return caseService.caseToBind(cb);
	}
}
