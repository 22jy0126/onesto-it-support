package com.onestoit.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.model.WorkHistory;

@Transactional
public interface WorkHistoryService {
	/**
	 * 社員の職歴保存
	 * @param workHistorys
	 * @return
	 */
	int batchSave(ArrayList<WorkHistory> workHistorys);
}
