package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.CaseApply;
import com.onestoit.model.CaseWithEmpApy;
import com.onestoit.model.EmployeeBase;

@Mapper
public interface CaseApplyMapper {
	/**
	 * 新規応募
	 * @param ca
	 * @return
	 */
	int apply(CaseApply ca);
	
	/**
	 * 案件開始
	 * @param ca
	 * @return
	 */
	int applyBind(CaseApply ca);
	
	/**
	 * 案件応募検索
	 * @param ca
	 * @return
	 */
	ArrayList<CaseApply> find(CaseApply ca);
	
	/**
	 * 応募歴史検索
	 * @param eb
	 * @return
	 */
	ArrayList<CaseWithEmpApy> findApplyHistory(EmployeeBase eb);
}
