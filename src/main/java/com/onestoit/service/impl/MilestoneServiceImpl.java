package com.onestoit.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.NoticeType;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CaseBaseMapper;
import com.onestoit.mapper.CaseMilestoneMapper;
import com.onestoit.mapper.NotificationCustomerMapper;
import com.onestoit.mapper.NotificationEmployeeMapper;
import com.onestoit.model.CaseBase;
import com.onestoit.model.CaseBaseMilestones;
import com.onestoit.model.CaseBaseProc;
import com.onestoit.model.Milestone;
import com.onestoit.model.NotificationCust;
import com.onestoit.model.NotificationEmp;
import com.onestoit.service.CaseService;
import com.onestoit.service.MilestoneService;

@Service
public class MilestoneServiceImpl implements MilestoneService {
	@Autowired
	CaseMilestoneMapper caseMilestoneMapper;

	@Autowired
	CaseBaseMapper caseBaseMapper;

	@Autowired
	NotificationEmployeeMapper notificationEmployeeMapper;

	@Autowired
	NotificationCustomerMapper notificationCustomerMapper;

	@Autowired
	CaseService caseService;

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

	@Override
	public Result editConfirmed(CaseBaseMilestones cbm) {
		ArrayList<Milestone> milestones = cbm.getMilestones();

		// マイルストーンのデータ更新
		caseMilestonesSave(milestones);

		// 案件のマイルストーン状態更新
		CaseBase cb = (CaseBase) cbm;
		cb.setMilestoneStatus(1);
		caseBaseMapper.updateCaseStatusOrMoney(cb);

		// 社員に通知する
		Integer caseId = cbm.getCaseId();
		Result caRes = caseService.findCaseBindEmployeeId(caseId);
		String employeeId = (String) caRes.getData();
		NotificationEmp ne = new NotificationEmp();
		ne.setCaseId(caseId);
		ne.setCaseName(cbm.getCaseName());
		ne.setEmployeeId(employeeId);
		ne.setType(NoticeType.EMP_MILESTONE_EDIT_RESOK);
		ne.setCreateDate(new Date());
		ne.setReaded(0);
		notificationEmployeeMapper.addOne(ne);
		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result editRes(CaseBaseMilestones cbm) {
		ArrayList<Milestone> milestones = cbm.getMilestones();

		// マイルストーンのデータ更新
		caseMilestonesSave(milestones);

		// 社員に通知する
		Integer caseId = cbm.getCaseId();
		Result caRes = caseService.findCaseBindEmployeeId(caseId);
		String employeeId = (String) caRes.getData();
		NotificationEmp ne = new NotificationEmp();
		ne.setCaseId(caseId);
		ne.setCaseName(cbm.getCaseName());
		ne.setEmployeeId(employeeId);
		ne.setType(NoticeType.EMP_MILESTONE_EDIT_RES);
		ne.setCreateDate(new Date());
		ne.setReaded(0);
		notificationEmployeeMapper.addOne(ne);
		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result updateOne(Milestone m) {
		int res = caseMilestoneMapper.updateOne(m);
		return new Result(Code.UPDATE_OK, res);
	}

	@Override
	public Result empEditFinish(CaseBaseMilestones cbm) {
		// クライアントに通知
		ArrayList<Milestone> milestones = cbm.getMilestones();
		NotificationCust nc = new NotificationCust();
		nc.setCaseId(cbm.getCaseId());
		nc.setCaseName(cbm.getCaseName());
		nc.setCustomerId(cbm.getCustomerId());
		nc.setType(NoticeType.CUST_MILESTONE_EDIT_REQ);
		nc.setCreateDate(new Date());
		nc.setReaded(0);
		notificationCustomerMapper.addOne(nc);

		// マイルストーン更新
		caseMilestonesSave(milestones);
		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result empProcUpdate(CaseBaseProc cbp) {
		// マイルストーン更新
		Milestone m = cbp.getMilestone();
		caseMilestoneMapper.updateOne(m);

		// クライアントに通知
		NotificationCust nc = new NotificationCust();
		nc.setCaseId(cbp.getCaseId());
		nc.setCaseName(cbp.getCaseName());
		nc.setCustomerId(cbp.getCustomerId());
		nc.setType(NoticeType.CUST_MILESTONE_PROC_REQ);
		nc.setCreateDate(new Date());
		nc.setReaded(0);
		notificationCustomerMapper.addOne(nc);
		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result custProcRes(CaseBaseProc cbp) {
		// マイルストーン更新
		Milestone m = cbp.getMilestone();
		caseMilestoneMapper.updateOne(m);

		// 社員に通知
		Integer caseId = cbp.getCaseId();
		Result caRes = caseService.findCaseBindEmployeeId(caseId);
		String employeeId = (String) caRes.getData();
		NotificationEmp ne = new NotificationEmp();
		ne.setCaseId(cbp.getCaseId());
		ne.setCaseName(cbp.getCaseName());
		ne.setEmployeeId(employeeId);
		ne.setType(NoticeType.EMP_MILESTONE_PROC_RES);
		ne.setCreateDate(new Date());
		ne.setReaded(0);
		notificationEmployeeMapper.addOne(ne);
		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result custProcConfirmed(CaseBaseProc cbp) {
		// マイルストーン更新
		Milestone m = cbp.getMilestone();
		caseMilestoneMapper.updateOne(m);

		// 社員に通知
		Integer caseId = cbp.getCaseId();
		Result caRes = caseService.findCaseBindEmployeeId(caseId);
		String employeeId = (String) caRes.getData();
		NotificationEmp ne = new NotificationEmp();
		ne.setCaseId(cbp.getCaseId());
		ne.setCaseName(cbp.getCaseName());
		ne.setEmployeeId(employeeId);
		ne.setType(NoticeType.EMP_MILESTONE_PROC_RESOK);
		ne.setCreateDate(new Date());
		ne.setReaded(0);
		notificationEmployeeMapper.addOne(ne);
		return new Result(Code.UPDATE_OK, null);
	}

}
