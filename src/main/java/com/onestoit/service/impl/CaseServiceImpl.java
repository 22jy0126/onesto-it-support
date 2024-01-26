package com.onestoit.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Code;
import com.onestoit.controller.NoticeType;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CaseApplyMapper;
import com.onestoit.mapper.CaseBaseMapper;
import com.onestoit.mapper.CaseFunctionMapper;
import com.onestoit.mapper.NotificationCustomerMapper;
import com.onestoit.mapper.NotificationEmployeeMapper;
import com.onestoit.model.Case;
import com.onestoit.model.CaseApply;
import com.onestoit.model.CaseApplyWithCaseName;
import com.onestoit.model.CaseBase;
import com.onestoit.model.CaseBind;
import com.onestoit.model.CaseFunction;
import com.onestoit.model.CaseWithCurrCust;
import com.onestoit.model.CaseWithEmp;
import com.onestoit.model.CaseWithEmpApy;
import com.onestoit.model.Customer;
import com.onestoit.model.EmpBindedCase;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.NotificationCust;
import com.onestoit.model.NotificationEmp;
import com.onestoit.model.PaginationCaseBaseReq;
import com.onestoit.model.PaginationCaseBaseRes;
import com.onestoit.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CaseServiceImpl.class);

	@Autowired
	CaseBaseMapper caseBaseMapper;

	@Autowired
	CaseFunctionMapper caseFunctionMapper;

	@Autowired
	CaseApplyMapper caseApplyMapper;

	@Autowired
	NotificationEmployeeMapper notificationEmployeeMapper;

	@Autowired
	NotificationCustomerMapper notificationCustomerMapper;

	@Override
	public Result saveBase(CaseBase cb) {
		int res;
		try {
			res = caseBaseMapper.save(cb);
		} catch (Exception e) {
			LOGGER.error("案件の基本情報保存のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null);
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result saveFunctions(ArrayList<CaseFunction> functions) {
		int res;
		try {
			res = caseFunctionMapper.batchSave(functions);
		} catch (Exception e) {
			LOGGER.error("案件の機能保存のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null);
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	@Transactional
	public Result saveCase(Case c) {
		Integer caseId = c.getCaseId();
		if (caseId != null) {
			caseFunctionMapper.deleteByCaseId(caseId);
			caseBaseMapper.deleteByCaseId(caseId);
		}
		CaseBase cb = (CaseBase) c;
		ArrayList<CaseFunction> functions = c.getFunctions();
		System.out.println(functions.size());

		Result res1 = saveBase(cb);
		if (functions.size() == 0) {
			return res1;
		}
		caseId = cb.getCaseId();
		for (CaseFunction caseFunction : functions) {
			caseFunction.setCaseId(caseId);
		}
		Result res2 = saveFunctions(functions);
		Integer resCode = (res1.getCode() == Code.SAVE_OK && res2.getCode() == Code.SAVE_OK) ? Code.SAVE_OK
				: Code.SAVE_ERROR;
		return new Result(resCode, res2.getData());
	}

	@Override
	public Result findCaseBase(CaseBase cb) {
		ArrayList<CaseBase> data = caseBaseMapper.find(cb);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result findOneCase(CaseBase cb) {
		ArrayList<CaseBase> data = caseBaseMapper.find(cb);
		if (data.size() == 0) {
			return new Result(Code.GET_OK, null);
		}
		CaseBase caseBase = data.get(0);
		Integer caseId = caseBase.getCaseId();
		ArrayList<CaseFunction> functions = caseFunctionMapper.findByCaseId(caseId);
		Case c = new Case();
		c.setCaseId(caseId);
		c.setCustomerId(caseBase.getCustomerId());
		c.setCaseName(caseBase.getCaseName());
		c.setDescription(caseBase.getDescription());
		c.setBonusMoney(caseBase.getBonusMoney());
		c.setBonusMoneyNegotiable(caseBase.isBonusMoneyNegotiable());
		c.setDeadline(caseBase.getDeadline());
		c.setDevelopTools(caseBase.getDevelopTools());
		c.setMilestoneStatus(caseBase.getMilestoneStatus());
		c.setStatus(caseBase.getStatus());
		c.setFunctions(functions);
		return new Result(Code.GET_OK, c);
	}

	@Override
	public Result findCaseBaseByPage(PaginationCaseBaseReq pcbq) {
		/*
		 * 結果リストをゲット
		 */
		ArrayList<CaseBase> list = caseBaseMapper.findByPage(pcbq);
		/*
		 * 結果の合計数をゲット
		 */
		Integer totalCount = caseBaseMapper.getTotalCount((CaseBase) pcbq);
		PaginationCaseBaseRes pcbs = new PaginationCaseBaseRes();
		pcbs.setList(list);
		pcbs.setTotalCount(totalCount);
		return new Result(Code.GET_OK, pcbs);
	}

	@Override
	public Result apply(CaseApplyWithCaseName can) {
		int res;
		CaseApply ca = (CaseApply) can;
		ca.setApplyDate(new Date());
		try {
			res = caseApplyMapper.apply(ca);

			// クライアントに通知
			String caseName = can.getCaseName();
			NotificationCust nc = new NotificationCust();
			nc.setCaseId(can.getCaseId());
			nc.setCaseName(caseName);
			nc.setCustomerId(can.getCustomerId());
			nc.setCreateDate(new Date());
			nc.setType(NoticeType.CUST_CASE_NEW_APPLY);
			nc.setReaded(0);
			notificationCustomerMapper.addOne(nc);
		} catch (Exception e) {
			LOGGER.error("新規案件応募のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null, "新規案件応募できませんでした");
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result findCaseApply(CaseApply ca) {
		ArrayList<CaseApply> data = caseApplyMapper.find(ca);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result findApplyHistory(EmployeeBase eb) {
		ArrayList<CaseWithEmpApy> data = caseApplyMapper.findApplyHistory(eb);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result findCaseWithCust(Customer c) {
		ArrayList<CaseWithEmp> list = caseApplyMapper.findCaseWithCust(c);
		ArrayList<CaseWithCurrCust> myCaseList = new ArrayList<>();
		for (CaseWithEmp caseWithEmp : list) {
			boolean has = false;
			Integer caseId = caseWithEmp.getCaseId();

			for (CaseWithCurrCust caseWithCurrCust : myCaseList) {
				CaseBase cb = caseWithCurrCust.getCb();
				Integer theCaseId = cb.getCaseId();
				if (caseId == theCaseId) {
					ArrayList<CaseWithEmp> apylist = caseWithCurrCust.getApylist();
//					EmployeeBase eb = new EmployeeBase();
//					eb.setEmployeeId(caseWithEmp.getEmployeeId());
//					eb.setName(caseWithEmp.getName());
//					eb.setGender(caseWithEmp.getGender());
//					eb.setBirthday(caseWithEmp.getBirthday());
//					eb.setSkill(caseWithEmp.getSkill());
					apylist.add(caseWithEmp);
					has = true;
					break;
				}
			}

			if (has == false) {
				CaseWithCurrCust caseWithCurrCust = new CaseWithCurrCust();
				caseWithCurrCust.setCb((CaseBase) caseWithEmp);
				ArrayList<CaseWithEmp> apylist = new ArrayList<>();
				if (caseWithEmp.getEmployeeId() != null) {
//					EmployeeBase eb = new EmployeeBase();
//					eb.setEmployeeId(caseWithEmp.getEmployeeId());
//					eb.setName(caseWithEmp.getName());
//					eb.setGender(caseWithEmp.getGender());
//					eb.setBirthday(caseWithEmp.getBirthday());
//					eb.setSkill(caseWithEmp.getSkill());
					apylist.add(caseWithEmp);
				}
				caseWithCurrCust.setApylist(apylist);
				myCaseList.add(caseWithCurrCust);
			}
		}

		return new Result(Code.GET_OK, myCaseList);
	}

	@Override
	@Transactional
	public Result caseToBind(CaseBind cb) {
		CaseBase c = (CaseBase) cb;
		c.setMilestoneStatus(0);
		CaseApply ca = cb.getCa();
		ca.setBindDate(new Date());
		int res;
		try {
			// 案件の報酬額と状態更新（案件開始状態に）
			res = caseBaseMapper.updateCaseStatusOrMoney(c);
			// 案件の応募歴史に更新する
			caseApplyMapper.applyBind(ca);
			// 社員に応募成功に通知する
			NotificationEmp ne = new NotificationEmp();
			ne.setEmployeeId(ca.getEmployeeId());
			ne.setCaseId(c.getCaseId());
			ne.setCaseName(c.getCaseName());
			ne.setType(NoticeType.EMP_CASE_START);
			ne.setCreateDate(new Date());
			ne.setReaded(0);
			notificationEmployeeMapper.addOne(ne);
		} catch (Exception e) {
			LOGGER.error("案件契約のデータベースのエラーです", e);
			return new Result(Code.UPDATE_ERROR, null, "案件契約できませんでした");
		}
		return new Result(Code.UPDATE_OK, res);
	}

	@Override
	public Result findCaseBindEmployeeId(Integer caseId) {
		CaseApply ca = new CaseApply();
		ca.setCaseId(caseId);
		ca.setBind(true);
		ArrayList<CaseApply> res = caseApplyMapper.find(ca);
		String employeeId = null;
		if (res.size() > 0) {
			CaseApply caseApply = res.get(0);
			employeeId = caseApply.getEmployeeId();
		}
		return new Result(Code.GET_OK, employeeId);
	}

	@Override
	public Result findBindedCasesByEmployeeId(String employeeId) {
		ArrayList<EmpBindedCase> data = caseApplyMapper.findEmpCase(employeeId);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result caseFinish(CaseBase cb) {
		// 案件状態更新
		cb.setStatus(3);
		caseBaseMapper.updateCaseStatusOrMoney(cb);

		// 社員に通知する
		Integer caseId = cb.getCaseId();
		Result caRes = findCaseBindEmployeeId(caseId);
		String employeeId = (String) caRes.getData();
		NotificationEmp ne = new NotificationEmp();
		ne.setCaseId(cb.getCaseId());
		ne.setCaseName(cb.getCaseName());
		ne.setEmployeeId(employeeId);
		ne.setType(NoticeType.EMP_CASE_FINISH);
		ne.setCreateDate(new Date());
		ne.setReaded(0);
		notificationEmployeeMapper.addOne(ne);

		// クライアントに通知
		NotificationCust nc = new NotificationCust();
		nc.setCaseId(cb.getCaseId());
		nc.setCaseName(cb.getCaseName());
		nc.setCustomerId(cb.getCustomerId());
		nc.setType(NoticeType.CUST_CASE_FINISH);
		nc.setCreateDate(new Date());
		nc.setReaded(0);
		notificationCustomerMapper.addOne(nc);

		return new Result(Code.UPDATE_OK, null);
	}

	@Override
	public Result deleteCase(Integer caseId) {
		caseFunctionMapper.deleteByCaseId(caseId);
		caseApplyMapper.deleteByCaseId(caseId);
		caseBaseMapper.deleteByCaseId(caseId);
		
		return new Result(Code.UPDATE_OK, null);
	}

}
