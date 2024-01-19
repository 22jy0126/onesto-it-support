package com.onestoit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Milestone;
import com.onestoit.service.MilestoneService;

@RestController
@RequestMapping("/logged/milestone")
public class MilestoneController {
	
	@Autowired
	MilestoneService milestoneService;
	
	@PostMapping("/update")
	Result saveMilestones(@RequestBody ArrayList<Milestone> milestones) {
		return milestoneService.caseMilestonesSave(milestones);
	}
	
	@GetMapping("/get/{caseId}")
	Result getMilestones(@PathVariable Integer caseId) {
		return milestoneService.getCaseMilestones(caseId);
	}
	
	@PostMapping("/editConfirmed")
	Result editConfirmed(@RequestBody ArrayList<Milestone> milestones) {
		return milestoneService.editConfirmed(milestones);
	}
	
	@PostMapping("/updateOne")
	Result updateOne(@RequestBody Milestone m) {
		return milestoneService.updateOne(m);
	}
}
