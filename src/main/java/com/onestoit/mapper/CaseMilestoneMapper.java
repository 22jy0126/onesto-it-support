package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.Milestone;

@Mapper
public interface CaseMilestoneMapper {
	/**
	 * 案件マイルストンを保存
	 * @param m
	 * @return
	 */
	int saveOne(Milestone m);
	
	/**
	 * 案件マイルストーンを削除
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 案件マイルストーンを更新
	 * @param m
	 * @return
	 */
	int updateOne(Milestone m);
	
	/**
	 * 案件マイルストーンを検索
	 * @param caseId
	 * @return
	 */
	ArrayList<Milestone> findByCaseId(Integer caseId);
}
