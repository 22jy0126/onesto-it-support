package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.CaseBase;
import com.onestoit.model.PaginationCaseBaseReq;

@Mapper
public interface CaseBaseMapper {
	/**
	 * 案件基本情報保存
	 * @param cb
	 * @return
	 */
	int save(CaseBase cb);
	
	/**
	 * 案件削除
	 * @param caseId
	 * @return
	 */
	int deleteByCaseId(Integer caseId);
	
	/**
	 * ページングで案件検索
	 * @param pcbq
	 * @return
	 */
	ArrayList<CaseBase> findByPage(PaginationCaseBaseReq pcbq);
	
	/**
	 * 案件検索
	 * @param cb
	 * @return
	 */
	ArrayList<CaseBase> find(CaseBase cb);
	
	/**
	 * 案件検索の結果の合計数
	 * @param cb
	 * @return
	 */
	Integer getTotalCount(CaseBase cb);
	
	/**
	 * 案件状態それとも報酬更新
	 * @param cb
	 * @return
	 */
	Integer updateCaseStatusOrMoney(CaseBase cb);
}
