package com.onestoit.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.CaseBaseMilestones;
import com.onestoit.model.CaseBaseProc;
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
	Result editConfirmed(CaseBaseMilestones cbm);
	
	/**
	 * マイルストーンリストの作成について返信する
	 * @param cbm
	 * @return
	 */
	Result editRes(CaseBaseMilestones cbm);
	
	/**
	 * 一つのマイルストーンの更新
	 * @param m
	 * @return
	 */
	Result updateOne(Milestone m);
	
	/**
	 * 社員が案件のマイルストーンリストを編集完了
	 * @param milestones
	 * @return
	 */
	Result empEditFinish(CaseBaseMilestones cbm);
	
	/**
	 * 社員が案件のマイルストーン進捗更新
	 * @param cbm
	 * @return
	 */
	Result empProcUpdate(CaseBaseProc cbp);
	
	/**
	 * 顧客が案件のマイルストーン進捗返信
	 * @param cbm
	 * @return
	 */
	Result custProcRes(CaseBaseProc cbp);
	
	/**
	 * 顧客が案件のマイルストーン進捗確認
	 * @param cbm
	 * @return
	 */
	Result custProcConfirmed(CaseBaseProc cbp);
}
