package com.onestoit.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CaseBaseMapper;
import com.onestoit.mapper.CaseFunctionMapper;
import com.onestoit.model.Case;
import com.onestoit.model.CaseBase;
import com.onestoit.model.CaseFunction;
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
		System.out.println("saveFunctions");
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
		Integer totalCount = caseBaseMapper.getTotalCount((CaseBase)pcbq);
		PaginationCaseBaseRes pcbs = new PaginationCaseBaseRes();
		pcbs.setList(list);
		pcbs.setTotalCount(totalCount);
		System.out.println(pcbs);
		return new Result(Code.GET_OK, pcbs);
	}
	
	
}
