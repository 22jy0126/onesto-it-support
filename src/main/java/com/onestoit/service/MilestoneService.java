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
}
