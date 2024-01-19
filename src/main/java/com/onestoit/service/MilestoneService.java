package com.onestoit.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.Milestone;

@Transactional
public interface MilestoneService {
	/**
	 * 案件のマイルストーンリスト保存
	 * @param milestones
	 * @return
	 */
	Result caseMilestonesSave(ArrayList<Milestone> milestones);
	
	/**
	 * 案件のマイルストーンリスト検索
	 * @param caseId
	 * @return
	 */
	Result getCaseMilestones(Integer caseId);
	
	/**
	 * マイルストーンリストの作成について同意する
	 * @param milestones
	 * @return
	 */
	Result editConfirmed(ArrayList<Milestone> milestones);
	
	/**
	 * 一つのマイルストーンの更新
	 * @param m
	 * @return
	 */
	Result updateOne(Milestone m);
}
