package com.onestoit.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CaseMilestoneMapper;
import com.onestoit.model.Milestone;
import com.onestoit.service.MilestoneService;

@Service
public class MilestoneServiceImpl implements MilestoneService {
	@Autowired
	CaseMilestoneMapper caseMilestoneMapper;

	@Override
	public Result caseMilestonesSave(ArrayList<Milestone> milestones) {
		ArrayList<Milestone> saveList = new ArrayList<>();
		ArrayList<Integer> delList = new ArrayList<>();
		ArrayList<Milestone> updList = new ArrayList<>();
		for (Milestone m : milestones) {
			boolean isDel = m.getIsDel();
			if (isDel) {
				delList.add(m.getId());
				continue;
			}
			if (m.getId() != null) {
				m.setUpdateDate(new Date());
				updList.add(m);
				continue;
			}
			m.setCreateData(new Date());
			saveList.add(m);
		}
		if (delList.size() > 0) {
			caseMilestoneMapper.deleteByIds(delList);
		}
		if (saveList.size() > 0) {
			caseMilestoneMapper.saveBatch(saveList);
		}
		for (Milestone milestone : updList) {
			milestone.setUpdateDate(new Date());
			caseMilestoneMapper.updateOne(milestone);
		}
		
		return new Result(Code.SAVE_OK, null);
	}

	@Override
	public Result getCaseMilestones(Integer caseId) {
		ArrayList<Milestone> milestones = caseMilestoneMapper.findByCaseId(caseId);
		return new Result(Code.GET_OK, milestones);
	}

}
