package com.onestoit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.CaseBaseMilestones;
import com.onestoit.model.CaseBaseProc;
import com.onestoit.model.Milestone;
import com.onestoit.service.MilestoneService;
import com.onestoit.service.NotificationService;

@RestController
@RequestMapping("/logged/milestone")
public class MilestoneController {
	
	@Autowired
	MilestoneService milestoneService;
	
	@Autowired
	NotificationService notificationEmployeeService;
	
	@PostMapping("/update")
	Result saveMilestones(@RequestBody ArrayList<Milestone> milestones) {
		return milestoneService.caseMilestonesSave(milestones);
	}
	
	@PostMapping("/emp/edit/finish")
	Result empEditFinish(@RequestBody CaseBaseMilestones cbm) {
		return milestoneService.empEditFinish(cbm);
	}
	
	@GetMapping("/get/{caseId}")
	Result getMilestones(@PathVariable Integer caseId) {
		return milestoneService.getCaseMilestones(caseId);
	}
	
	@PostMapping("/cust/edit/confirmed")
	Result editConfirmed(@RequestBody CaseBaseMilestones cbm) {
		return milestoneService.editConfirmed(cbm);
	}
	
	@PostMapping("/cust/edit/res")
	Result editRes(@RequestBody CaseBaseMilestones cbm) {
		return milestoneService.editRes(cbm);
	}
	
	@PostMapping("/updateOne")
	Result updateOne(@RequestBody Milestone m) {
		return milestoneService.updateOne(m);
	}
	
	@PostMapping("/emp/proc/update")
	Result empProcUpdate(@RequestBody CaseBaseProc cbp) {
		return milestoneService.empProcUpdate(cbp);
	}
	
	@PostMapping("/cust/proc/res")
	Result custProcRes(@RequestBody CaseBaseProc cbp) {
		return milestoneService.custProcRes(cbp);
	}
	
	@PostMapping("/cust/proc/confirmed")
	Result custProcConfirmed(@RequestBody CaseBaseProc cbp) {
		return milestoneService.custProcConfirmed(cbp);
	}
}
