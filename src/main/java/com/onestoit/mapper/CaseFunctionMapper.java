package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.CaseFunction;

@Mapper
public interface CaseFunctionMapper {
	/**
	 * 案件機能リストを保存する
	 * @param functions
	 * @return
	 */
	int batchSave(ArrayList<CaseFunction> functions);
	
	/**
	 * 案件機能削除
	 * @param caseId
	 * @return
	 */
	int deleteByCaseId(Integer caseId);
	
	/**
	 * 案件機能検索
	 * @param caseId
	 * @return
	 */
	ArrayList<CaseFunction> findByCaseId(Integer caseId);
}
