package com.onestoit.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.Case;
import com.onestoit.model.CaseApply;
import com.onestoit.model.CaseBase;
import com.onestoit.model.CaseFunction;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.PaginationCaseBaseReq;

@Transactional
public interface CaseService {
	/**
	 * 案件の基本情報保存
	 * @param cb
	 * @return
	 */
	Result saveBase(CaseBase cb);
	
	/**
	 * 案件の機能保存
	 * @param functions
	 * @return
	 */
	Result saveFunctions(ArrayList<CaseFunction> functions);
	
	/**
	 * 案件保存
	 * @param c
	 * @return
	 */
	Result saveCase(Case c);
	
	/**
	 * 案件基本検索
	 * @param c
	 * @return
	 */
	Result findCaseBase(CaseBase cb);
	
	/**
	 * ページングで案件基本検索
	 * @param pcbq
	 * @return
	 */
	Result findCaseBaseByPage(PaginationCaseBaseReq pcbq);
	
	/**
	 * 案件の詳細検索
	 * @param cb
	 * @return
	 */
	Result findOneCase(CaseBase cb);
	
	/**
	 * 新規応募
	 * @param ca
	 * @return
	 */
	Result apply(CaseApply ca);
	
	/**
	 * 応募検索
	 * @return
	 */
	Result findCaseApply(CaseApply ca);
	
	/**
	 * 応募歴史検索
	 * @param eb
	 * @return
	 */
	Result findApplyHistory(EmployeeBase eb);
}
